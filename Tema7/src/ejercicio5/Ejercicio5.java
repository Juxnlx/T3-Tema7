package ejercicio5;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejercicio5 {

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
			// por parametro. En este caso hacemos varios insert de nuevas notas a distintos
			// alumnos para distintas asignaturas.
			st.executeUpdate(
					"INSERT INTO Calificaciones (id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion) "
							+ "VALUES (1, 1, 1, 'Examen', 9.25, '2025-04-01')");

			st.executeUpdate(
					"INSERT INTO Calificaciones (id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion) "
							+ "VALUES (2, 1, 1, 'Trabajo', 8.00, '2025-04-03')");

			st.executeUpdate(
					"INSERT INTO Calificaciones (id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion) "
							+ "VALUES (3, 2, 2, 'Examen', 9.75, '2025-04-05')");

			System.out.println("Nuevas calificaciones añadidas correctamente.");

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}
	}

}
