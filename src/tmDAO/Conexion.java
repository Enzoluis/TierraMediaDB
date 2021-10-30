package tmDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static String url = "jdbc:sqlite:DataBase.db";
	private static Connection Conexion;

	public static Connection getConexion() throws SQLException {
		if (Conexion == null) {
			Conexion = DriverManager.getConnection(url);
		}
		return Conexion;
	}
}
