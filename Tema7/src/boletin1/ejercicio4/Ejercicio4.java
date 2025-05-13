package boletin1.ejercicio4;

import java.sql.Statement;

import utiles.Constantes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejercicio4 {

	public static void main(String[] args) {

		// Creamos la conexión con el método DriverManager con la base de datos
		// InstitutoDB. Hacemos uso del método getConnection y les pasamos como
		// parametro las constantes necesarias para crear la conexión.
		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.PASSWORD)) {

			// Creamos el objeto de tipo Statement para ejecutar la sentencia.
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

			// Capturamos esta excepción para mostrar un error en caso de que no se pueda
			// establecer conexión con la base de datos.
		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}
	}

}
