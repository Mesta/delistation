package delistation.g_facturation.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import delistation.datatypes.CompteMode;
import delistation.utils.DatabaseUtils;

public class G_FacturationDBHelper {

	private DatabaseUtils dbUtils = null;
	
	/**
	 * Constructeur par défaut de l'objet {@link G_FacturationDBHelper}
	 */
	public G_FacturationDBHelper() {
		this.dbUtils = new DatabaseUtils();
	}

	/**
	 * Débite un compte de la somme indiquée en paramètre.
	 * 
	 * @param RIB
	 *            Informations bancaires du compte nécessaire.
	 * @param somme
	 *            Somme à débiter.
	 * @return Booléen de confirmation de l'opération débit.
	 */
	public boolean debiter(String RIB, float somme) {
		PreparedStatement st = null;
		Connection co = null;
		boolean retour = false;

		try {
			// Ouverture de la connection
			co = this.dbUtils.openConnection();

			// Creation de la requete
			String sql = "UPDATE "
					+ DatabaseUtils.table_comptes
					+ " SET solde = solde - "
					+ somme
					+ " WHERE noUtilisateur = (SELECT noUtilisateur FROM utilisateurs WHERE RIB LIKE '"
					+ RIB + "')";
			G_FacturationServeur.lgr.log(Level.INFO, sql);

			st = co.prepareStatement(sql);

			// Execution
			int res = st.executeUpdate();

			if (res > 0)
				retour = true;
			if (res == 0)
				retour = false;

		} catch (SQLException ex) {
			G_FacturationServeur.lgr.log(Level.WARNING, ex.getMessage());

		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (co != null) {
					co.close();
				}

			} catch (SQLException ex) {
				G_FacturationServeur.lgr
						.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return retour;
	}

	/**
	 * Crédit un compte de la somme indiquée en paramètre.
	 * 
	 * @param RIB
	 *            Informations bancaires nécessaires.
	 * @param somme
	 *            Somme à créditer.
	 * @return Booléen de confirmation de l'opération crédit.
	 */
	public boolean crediter(String RIB, int somme) {
		PreparedStatement st = null;
		Connection co = null;
		boolean retour = false;

		try {
			// Ouverture de la connection
			co = this.dbUtils.openConnection();

			// Creation de la requete
			String sql = "UPDATE "
					+ DatabaseUtils.table_comptes
					+ " SET solde = solde + "
					+ somme
					+ " WHERE noUtilisateur = (SELECT noUtilisateur FROM utilisateurs WHERE RIB LIKE '"
					+ RIB + "')";
			G_FacturationServeur.lgr.log(Level.INFO, sql);
			st = co.prepareStatement(sql);

			// Execution
			int res = st.executeUpdate();

			if (res > 0)
				retour = true;
			else
				retour = false;

		} catch (SQLException ex) {
			G_FacturationServeur.lgr.log(Level.WARNING, ex.getMessage());

		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (co != null) {
					co.close();
				}

			} catch (SQLException ex) {
				G_FacturationServeur.lgr
						.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return retour;
	}

	/**
	 * Retourne la somme disponible sur un compte.
	 * 
	 * @param RIB
	 *            Informations bancaires nécessaires.
	 * @return Somme disponible sur le compte
	 */
	public float getSolde(String RIB) {
		Statement st = null;
		ResultSet rs = null;
		Connection co = null;
		float retour = 0;

		try {
			// Ouverture de la connection
			co = this.dbUtils.openConnection();

			// Creation de la requete
			st = co.createStatement();
			String sql = "SELECT solde FROM "
					+ DatabaseUtils.table_comptes
					+ " c, "
					+ DatabaseUtils.table_utilisateurs
					+ " u WHERE u.noUtilisateur = c.noUtilisateur AND u.RIB = '"
					+ RIB + "';";
			G_FacturationServeur.lgr.log(Level.INFO, sql);

			// Execution
			rs = st.executeQuery(sql);
			// Si l'adherent existe
			if (rs.first()) {
				retour = rs.getFloat("solde");
			}

		} catch (SQLException ex) {
			G_FacturationServeur.lgr.log(Level.WARNING, ex.getMessage(), ex);

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
				G_FacturationServeur.lgr
						.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return retour;
	}

	/**
	 * Met à jour l'argent disponible sur un compte.
	 * 
	 * @param somme
	 *            Somme disponible sur le compte.
	 * @param RIB
	 *            Informations bancaires nécessaires.
	 * @return Booléen de confirmation de l'opération de mise à jour.
	 */
	public boolean setSolde(float somme, String RIB) {
		PreparedStatement st = null;
		Connection co = null;
		boolean retour = false;

		try {
			// Ouverture de la connection
			co = this.dbUtils.openConnection();

			// Creation de la requete
			String sql = "UPDATE "
					+ DatabaseUtils.table_comptes
					+ " SET solde = "
					+ somme
					+ " WHERE noUtilisateur = (SELECT noUtilisateur FROM utilisateurs WHERE RIB LIKE '"
					+ RIB + "')";
			G_FacturationServeur.lgr.log(Level.INFO, sql);

			st = co.prepareStatement(sql);

			// Execution
			int res = st.executeUpdate();

			if (res > 0)
				retour = true;
			if (res == 0)
				retour = false;

		} catch (SQLException ex) {
			G_FacturationServeur.lgr.log(Level.WARNING, ex.getMessage());

		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (co != null) {
					co.close();
				}

			} catch (SQLException ex) {
				G_FacturationServeur.lgr
						.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return retour;
	}

	/**
	 * Créé un compte bancaire à un adhérent ou à un transporteur.
	 * 
	 * @param no
	 *            Numéro de l'adhérent pour lequel on créé un compte bancaire.
	 * @return Booléen de confirmation de la création du compte.
	 */
	public boolean creerCompte(short no, CompteMode mode) {
		
		PreparedStatement st_insert = null;
		Connection co = null;
		boolean retour = false;
		try {
			// Ouverture de la connection
			co = this.dbUtils.openConnection();

			// Creation de la requete
			String sql_update = new String("");
			if(mode == CompteMode.Adherent)
				 sql_update = "INSERT INTO comptes VALUES (null, (SELECT noUtilisateur from utilisateurs WHERE noAdh = " + no + "), 0);";
			else
				sql_update = "INSERT INTO comptes VALUES (null, (SELECT noUtilisateur from utilisateurs WHERE noTransp = " + no + "), 0);";
				
			G_FacturationServeur.lgr.log(Level.INFO, sql_update);
			st_insert = co.prepareStatement(sql_update);

			// Execution
			int res = st_insert.executeUpdate();

			if (res == 1)
				retour = true;
			if (res == 0)
				retour = false;
		} catch (SQLException ex) {
			G_FacturationServeur.lgr.log(Level.WARNING, ex.getMessage());

		} finally {
			try {
				if (st_insert != null) {
					st_insert.close();
				}
				if (co != null) {
					co.close();
				}
			} catch (SQLException ex) {
				G_FacturationServeur.lgr
						.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return retour;
	}
}
