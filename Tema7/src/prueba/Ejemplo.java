package prueba;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejemplo {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost/InstitutoDB";
		String usuario = "root";
		String contraseña = "Juanl2004";

		try (Connection con = DriverManager.getConnection(url, usuario, contraseña)) {
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from estudiantes");
			
			while (!rs.next()) {
				
			}
			
			st.executeUpdate("insert...");
			
		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}
	}
}
