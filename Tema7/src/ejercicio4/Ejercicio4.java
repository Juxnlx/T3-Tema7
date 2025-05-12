package ejercicio4;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejercicio4 {

	public static void main(String[] args) {

		// Creamos la variable url como String para almacenar la ruta donde se encuentra
		// la base de datos.
		String url = "jdbc:mysql://localhost/InstitutoDB";

		// Creamos la variable usuario como String para almacenar el nombre de usuario
		String usuario = "root";

		// Creamos la variable password como String para almacenar la contraseña del
		// usuario.
		String password = "Juanl2004";

		// Creamos una conexión con la base de datos usando el método estático
		// DriverManager.
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {

			// Creamos el objeto de tipo Statement
			Statement st = con.createStatement();

			// Disponemos del método executeUpdate para hacer la intrucción que se le pase
			// por parametro. En este caso hacemos varios insert de nuevas asignaturas en la
			// tabla cursos.
			st.executeUpdate("INSERT INTO cursos (nombre, descripcion, año_escolar) "
					+ "VALUES ('Historia 1º', 'Historia para primer año', 2025)");

			st.executeUpdate("INSERT INTO cursos (nombre, descripcion, año_escolar) "
					+ "VALUES ('Biología 1º', 'Biología para primer año', 2025)");

			st.executeUpdate("INSERT INTO cursos (nombre, descripcion, año_escolar) "
					+ "VALUES ('Educación Física 1º', 'Educación Física para primer año', 2025)");

			st.executeUpdate("INSERT INTO cursos (nombre, descripcion, año_escolar) "
					+ "VALUES ('Música 1º', 'Música para primer año', 2025)");

			st.executeUpdate("INSERT INTO cursos (nombre, descripcion, año_escolar) "
					+ "VALUES ('Tecnología 1º', 'Tecnología para primer año', 2025)");

			// Imprimimos un mensaje mostrando que las inserciones se han añadido
			// correctamente.
			System.out.println("Inserciones realizadas correctamente.");

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}
	}

}
