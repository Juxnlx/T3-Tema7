package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejemplo {
	public static void main(String[] args) {
		String conexion = "jdbc:mysql://Desktop/InstitutoDB";
		String usuario = "root";
		String password = "1234";

		try (Connection con = DriverManager.getConnection(conexion, usuario, password)) {
			System.out.println("La conexión ha debido ir bien.");
		} catch (SQLException e) {
			System.out.println("Error al establecer la conexión con la base de datos: " + e);
		}
	}
}
