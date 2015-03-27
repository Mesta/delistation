package delistation.g_adherents.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import delistation.datatypes.Adherent;
import delistation.datatypes.Adresse;
import delistation.datatypes.CompteMode;
import delistation.datatypes.Zone;
import delistation.exceptions.ExceptionAdherentInconnu;
import delistation.exceptions.ExceptionAdresseDejaPrise;
import delistation.exceptions.ExceptionDestinataireInconnue;
import delistation.utils.DatabaseUtils;

public class G_AdherentsDBHelper {

	private DatabaseUtils dbUtils = null;

	public G_AdherentsDBHelper() {
		this.dbUtils = new DatabaseUtils();
	}

	/**
	 * Retourne l'adhérent dont le numéro est paramètre.
	 * 
	 * @param noAdh
	 *            Numéro de l'adhérent.
	 * @return Objet Adherent contenant les informations stockées en base de
	 *         données.
	 * @throws ExceptionAdherentInconnu
	 *             Si le numéro d'adhérent ne fait référence à aucun adhérent en
	 *             base de données.
	 */
	public Adherent selectAdherent(short noAdh) throws ExceptionAdherentInconnu {
		Statement st = null;
		ResultSet rs_count = null;
		ResultSet rs_select = null;
		Adherent retour = new Adherent();
		Connection co = null;

		try {
			// Ouverture de la connection
			co = this.dbUtils.openConnection();

			// Creation de la requete
			st = co.createStatement();
			String sql = "select * from " + DatabaseUtils.table_adherents
					+ " where noAdh = " + noAdh + ";";
			G_AdherentsServeur.lgr.log(Level.INFO, sql);

			// Execution
			rs_count = st.executeQuery(sql);

			// Si l'adherent existe
			if (rs_count.first()) {
				// Recuperation de ses informations
				sql = "SELECT a.noAdh, prenomAdh, nomAdh, adrAdh, RIB, MdPAdh, IORAdh FROM "
						+ DatabaseUtils.table_adherents
						+ " a, "
						+ DatabaseUtils.table_utilisateurs
						+ " u"
						+ " WHERE a.noAdh = u.noAdh"
						+ " AND a.noAdh = "
						+ noAdh + ";";
				rs_select = st.executeQuery(sql);
				G_AdherentsServeur.lgr.log(Level.INFO, sql);

				rs_select.first();
				
				Short no = rs_select.getShort("noAdh");
				String prenom = rs_select.getString("prenomAdh");
				String nom = rs_select.getString("nomAdh");
				String[] adr = rs_select.getString("adrAdh").split(";");
				Adresse adresse = new Adresse(adr[0],
						new Short(adr[1]),
						adr[2], 
						new Zone(new Short(adr[3]),
								new Short(adr[4])));
				String RIB = rs_select.getString("RIB");
				String MdP = rs_select.getString("MdPAdh");
				String IOR = rs_select.getString("IORAdh");

				retour = new Adherent(no, nom, prenom, adresse, RIB, MdP, IOR);
			} else
				// Adherent inconnu ou retour multiple
				throw new ExceptionAdherentInconnu();

		} catch (Exception ex) {
			G_AdherentsServeur.lgr.log(Level.WARNING, ex.getMessage(), ex);
			throw new ExceptionAdherentInconnu();
		} finally {
			try {
				if (rs_count != null) {
					rs_count.close();

					if (rs_select != null) {
						rs_select.close();
					}
				}
				if (st != null) {
					st.close();
				}
				if (co != null) {
					co.close();
				}

			} catch (SQLException ex) {
				G_AdherentsServeur.lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return retour;
	}

	/**
	 * Verifie que le numéro et le mot de passe passés en paramètre sont bons.
	 * 
	 * @param noAdh
	 *            Numéro saisie par l'adhérent.
	 * @param mdp
	 *            Mot de passe saisie par l'adhérent.
	 * @return Booléen indiquant la validité du test d'authentification.
	 */
	public boolean authentifierAdherent(short noAdh, String mdp) {
		Statement st = null;
		ResultSet rs_count = null;
		ResultSet rs_select = null;
		boolean retour = false;
		Connection co = null;

		try {
			// Ouverture de la connection
			co = this.dbUtils.openConnection();

			// Creation de la requete
			st = co.createStatement();
			String sql = "SELECT count(noAdh) as adhExiste FROM " + DatabaseUtils.table_adherents
					+ " WHERE noAdh = " + noAdh + " and MdPAdh = '" + mdp
					+ "';";
			G_AdherentsServeur.lgr.log(Level.INFO, sql);

			// Execution
			rs_count = st.executeQuery(sql);

			// Si l'adherent existe
			rs_count.first();
			int res = rs_count.getInt("adhExiste");
			if (res == 1) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException ex) {
			G_AdherentsServeur.lgr.log(Level.WARNING, ex.getMessage(), ex);

		} finally {
			try {
				if (rs_count != null) {
					rs_count.close();

					if (rs_select != null) {
						rs_select.close();
					}
				}
				if (st != null) {
					st.close();
				}
				if (co != null) {
					co.close();
				}

			} catch (SQLException ex) {
				G_AdherentsServeur.lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return retour;
	}

	/**
	 * Retourne les information de l'adhérent dont l'adresse est passée en
	 * paramètre.
	 * 
	 * @param p_adresse
	 *            Adresse de l'adhérent recherché.
	 * @return Adherent Objet Adherent contenant les informations stockées en
	 *         base de données.
	 * @throws ExceptionDestinataireInconnue
	 *             Si l'adresse ne fait référence à aucune adresse enregistrée
	 *             par le système.
	 */
	public Adherent rechercheDestinataire(String p_adresse)
			throws ExceptionDestinataireInconnue {
		Statement st = null;
		ResultSet rs = null;
		Connection co = null;
		Adherent retour = null;

		try {
			// Ouverture de la connection
			co = this.dbUtils.openConnection();

			// Creation de la requete
			st = co.createStatement();
			String sql = "SELECT a.noAdh, prenomAdh, nomAdh, adrAdh, MdPAdh, IORAdh, RIB"
					+ " FROM adherents a, utilisateurs u"
					+ " WHERE a.noAdh = u.noAdh"
					+ " AND lcase(adrAdh) like lcase('" + p_adresse + "%');";
			G_AdherentsServeur.lgr.log(Level.INFO, sql);
			
			// Execution
			rs = st.executeQuery(sql);
			// Si l'adherent existe
			if (rs.first()) {
				retour = new Adherent();
				
				retour.no = rs.getShort("noAdh");
				retour.nom = rs.getString("nomAdh");
				retour.prenom = rs.getString("prenomAdh");
				retour.MdP = rs.getString("MdPAdh");
				retour.RIB = rs.getString("RIB");
				retour.IORAppliCliente = rs.getString("IORAdh");
				String[] splitted = rs.getString("adrAdh").split(";");
				retour.adresse = new Adresse(splitted[0],
						new Short(splitted[1]).shortValue(), splitted[2],
						new Zone(new Short(splitted[3]).shortValue(),
								new Short(splitted[4]).shortValue()));

			} else { // Adherent inconnu ou retour multiple
				G_AdherentsServeur.lgr.log(Level.SEVERE, "Erreur lors de la recherche de destinataire. Paramètre : " + p_adresse);
				throw new ExceptionDestinataireInconnue();
			}

		} catch (SQLException ex) {
			G_AdherentsServeur.lgr.log(Level.WARNING, ex.getMessage(), ex);

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (co != null) {
					co.close();
				}

			} catch (SQLException ex) {
				G_AdherentsServeur.lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return retour;
	}

	/**
	 * Permet l'ajout d'un adhérent au sein de la base de données.
	 * 
	 * @param nom
	 *            Nom de l'adhérent à insérer en base de données.
	 * @param prenom
	 *            Prénom de l'adhérent à insérer en base de données.
	 * @param adresse
	 *            Adresse de l'adhérent à insérer en base de données.
	 * @param RIB
	 *            RIB de l'adhérent à insérer en base de données.
	 * @param mdp
	 *            Mot de passe de l'adhérent à insérer en base de données.
	 * @return Booléen de confirmation de l'opération d'insertion.
	 * @throws ExceptionAdresseDejaPrise
	 *             Si l'adresse spécifiée en paramètre est déjà utilisée par un
	 *             autre adhérent.
	 */
	public int insertAdherent(String nom, String prenom, String adresse,
			String RIB, String mdp) throws ExceptionAdresseDejaPrise {
		Statement st_insert = null;
		PreparedStatement st_insert_utilisateur = null;
		Statement co_select = null;
		Connection co = null;
		int retour = -1;

		try {
			// Ouverture de la connection
			co = this.dbUtils.openConnection();

			// On verifie que l'adresse n'est pas deja prise
			String sql_select = "SELECT noAdh FROM "
					+ DatabaseUtils.table_adherents + " WHERE adrAdh LIKE '"
					+ adresse + "';";
			G_AdherentsServeur.lgr.log(Level.INFO, sql_select);
			co_select = co.createStatement();
			ResultSet rs = co_select.executeQuery(sql_select);
			if (rs.first()) {
				throw new ExceptionAdresseDejaPrise();
			} else {
				// Creation de la requete
				String sql_insert = "INSERT INTO "
						+ DatabaseUtils.table_adherents + " VALUES(null ,'"
						+ prenom + "','" 
						+ nom + "','" 
						+ adresse + "','" 
						+ mdp + "', '');";
				G_AdherentsServeur.lgr.log(Level.INFO, sql_insert);
				st_insert = co.createStatement();

				// Execution
				st_insert.executeUpdate(sql_insert, Statement.RETURN_GENERATED_KEYS);
				ResultSet keys = st_insert.getGeneratedKeys();    
				keys.next();  
				retour = keys.getInt(1);
				// Creation de la requete d'insertion dans la table utilisateur
				sql_insert = "INSERT INTO "
						+ DatabaseUtils.table_utilisateurs + " VALUES(null, " + retour + ", null, " + RIB + ");";
				G_AdherentsServeur.lgr.log(Level.INFO, sql_insert);
				st_insert_utilisateur = co.prepareStatement(sql_insert);
				int res = st_insert_utilisateur.executeUpdate();
			}

		} catch (SQLException ex) {
			G_AdherentsServeur.lgr.log(Level.SEVERE, ex.getMessage());

		} finally {
			try {
				if (st_insert != null) {
					st_insert.close();
					if(st_insert_utilisateur != null)
						st_insert_utilisateur.close();
				}
				if (co != null) {
					co.close();
				}

			} catch (SQLException ex) {
				G_AdherentsServeur.lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return retour;
	}

	/**
	 * Recherche et retourne le RIB d'un utilisateur inscrit au système.
	 * 
	 * @param noAdh Numéro de utilisateur
	 * @return Chaine de caractère contenant le RIB de l'adhérent souhaité.
	 * @throws ExceptionAdherentInconnu
	 *             Si le numéro d'adhérent ne fait référence à aucun adhérent en
	 *             base de données.
	 */
	public String getRIB(short no) throws ExceptionAdherentInconnu {
		Statement st = null;
		ResultSet rs = null;
		Connection co = null;
		String retour = "";

		try {
			// Ouverture de la connection
			co = this.dbUtils.openConnection();

			// Creation de la requete
			st = co.createStatement();
			String sql;
			sql = "SELECT RIB from " + DatabaseUtils.table_utilisateurs
				+ " WHERE noAdh = " + no + ";";

			// Execution
			rs = st.executeQuery(sql);
			
			if (rs.first()) {
				retour = rs.getString("RIB");
			} else { // Adherent inconnu ou retour multiple
				throw new ExceptionAdherentInconnu();
			}

		} catch (SQLException ex) {
			G_AdherentsServeur.lgr.log(Level.WARNING, ex.getMessage(), ex);

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (co != null) {
					co.close();
				}

			} catch (SQLException ex) {
				G_AdherentsServeur.lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return retour;
	}

	public boolean updateIOR(short noAdh, short IOR) {
		Statement st_update = null;
		Connection co = null;
		boolean retour = false;

		try {
			// Ouverture de la connection
			co = this.dbUtils.openConnection();
			st_update = co.createStatement();
			// On verifie que l'adresse n'est pas deja prise
			String sql_update = "UPDATE "
					+ DatabaseUtils.table_adherents 
					+ " SET IORAdh = " + IOR
					+ " WHERE noAdh = " + noAdh + ";";
			G_AdherentsServeur.lgr.log(Level.INFO, sql_update);
			
			// Execution
			st_update.executeUpdate(sql_update, Statement.RETURN_GENERATED_KEYS);	
			retour = true;
			

		} catch (SQLException ex) {
			G_AdherentsServeur.lgr.log(Level.SEVERE, ex.getMessage());

		} finally {
			try {
				if (st_update != null) {
					st_update.close();
				}
				if (co != null) {
					co.close();
				}

			} catch (SQLException ex) {
				G_AdherentsServeur.lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return retour;
	}
}
