package delistation.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* 
 * Classe utils pour la base de données
 * A modifier en fonction de votre configuration
 */
public class DatabaseUtils {
	public static final String url = "jdbc:mysql://localhost:3306/";
	public static final String dbname = "delistation";
	public static final String user = "corba";
	public static final String password = "corba";

	public static final String table_adherents = "adherents";
	public static final String table_transporteurs = "transporteurs";
	public static final String table_comptes = "comptes";
	public static final String table_utilisateurs = "utilisateurs";
	
	private Connection connection;

	public DatabaseUtils() {
	}

	public Connection openConnection() throws SQLException {
		if (this.connection == null) {
			this.connection = DriverManager.getConnection(DatabaseUtils.url
					+ DatabaseUtils.dbname, DatabaseUtils.user,
					DatabaseUtils.password);
		} else {
			if (this.connection.isClosed())
				this.connection = DriverManager.getConnection(DatabaseUtils.url
						+ DatabaseUtils.dbname, DatabaseUtils.user,
						DatabaseUtils.password);
		}
		return this.connection;
	}
}
