package delistation.g_transporteur.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import delistation.datatypes.Transporteur;
import delistation.exceptions.ExceptionTransporteurInconnu;
import delistation.utils.DatabaseUtils;

public class G_TransporteurDBHelper {

	private DatabaseUtils dbUtils = null;

	public G_TransporteurDBHelper() {
		this.dbUtils = new DatabaseUtils();
	}

	public Transporteur selectTransporteur(short noTransp){
		Statement st 		= null;
		Connection co 		= null;
		ResultSet rs_count 	= null;
		ResultSet rs_select = null;
		Transporteur retour = new Transporteur();
		

		try {
			// Ouverture de la connection
			co = this.dbUtils.openConnection();

			// Creation de la requete
			st = co.createStatement();
			String sql = "SELECT * FROM " + DatabaseUtils.table_transporteurs
					+ " WHERE noTransp = " + noTransp + ";";
			G_TransporteurServeur.lgr.log(Level.INFO, sql);

			// Execution
			rs_count = st.executeQuery(sql);

			// Si l'adherent existe
			if (rs_count.first()) {
				// Recuperation de ses informations
				sql = "SELECT a.noTransp, raisonSocialeTransp, MdPTransp FROM "
						+ DatabaseUtils.table_transporteurs
						+ " a, "
						+ DatabaseUtils.table_utilisateurs
						+ " u"
						+ " WHERE a.noTransp = u.noTransp"
						+ " AND a.noTransp = "
						+ noTransp + ";";
				rs_select = st.executeQuery(sql);
				G_TransporteurServeur.lgr.log(Level.INFO, sql);

				rs_select.first();
				retour.noTransporteur 	= rs_select.getShort("noTransp");
				retour.raisonSociale 	= rs_select.getString("raisonSocialeTransp");
				retour.MdP 				= rs_select.getString("MdPTransp");
				
			} else // Adherent inconnu ou retour multiple
				throw new ExceptionTransporteurInconnu();

		} catch (Exception ex) {
			G_TransporteurServeur.lgr.log(Level.WARNING, ex.getMessage(), ex);
		} finally {
			try {
				if (rs_count != null) 	rs_count.close();
				if (rs_select != null) 	rs_select.close();
				if (st != null) st.close();
				if (co != null)	co.close();

			} catch (SQLException ex){ 
				G_TransporteurServeur.lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return retour;
	}

	public boolean authentifierTransporteur(short noTransp, String mdp) {
		Statement st 		= null;
		Connection co 		= null;
		boolean retour 		= false;
		ResultSet rs_count 	= null;

		try {
			// Ouverture de la connection
			co = this.dbUtils.openConnection();

			// Creation de la requete
			st = co.createStatement();
			String sql = "SELECT count(noTransp) as transpExiste FROM " + DatabaseUtils.table_transporteurs
					+ " WHERE noTransp = " + noTransp + " and MdPTransp = '" + mdp
					+ "';";
			G_TransporteurServeur.lgr.log(Level.INFO, sql);

			// Execution
			rs_count = st.executeQuery(sql);

			// Si le transporteur existe
			rs_count.first();
			int res = rs_count.getInt("transpExiste");
			if (res == 1) return true;
			else return false;

		} catch (SQLException ex) {
			G_TransporteurServeur.lgr.log(Level.WARNING, ex.getMessage(), ex);

		} finally {
			try {
				if (rs_count != null) 	rs_count.close();
				if (st != null) st.close();
				if (co != null) co.close();
			} catch (SQLException ex) {
				G_TransporteurServeur.lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return retour;
	}

	public String getRIB(short no) throws ExceptionTransporteurInconnu {
		Statement st 	= null;
		ResultSet rs 	= null;
		Connection co 	= null;
		String retour 	= "";

		try {
			// Ouverture de la connection
			co = this.dbUtils.openConnection();

			// Creation de la requete
			st = co.createStatement();
			String sql;
			
			sql = "SELECT RIB FROM " + DatabaseUtils.table_utilisateurs
					+ " WHERE noTransp = " + no + ";";

			// Execution
			rs = st.executeQuery(sql);
			
			if (rs.first()) {
				retour = rs.getString("RIB");
			} else { // Transporteur inconnu ou retour multiple
				throw new ExceptionTransporteurInconnu();
			}

		} catch (SQLException ex) {
			G_TransporteurServeur.lgr.log(Level.WARNING, ex.getMessage(), ex);

		} finally {
			try {
				if (rs != null) rs.close();
				if (st != null) st.close();
				if (co != null) co.close();
			} catch (SQLException ex) {
				G_TransporteurServeur.lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return retour;
	}
}
