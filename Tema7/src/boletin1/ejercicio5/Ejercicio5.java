package boletin1.ejercicio5;

import java.sql.Statement;
import utiles.Constantes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejercicio5 {

	public static void main(String[] args) {

		// Creamos la conexión con el método DriverManager con la base de datos
		// InstitutoDB. Hacemos uso del método getConnection y les pasamos como
		// parametro las constantes necesarias para crear la conexión.
		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.PASSWORD)) {

			// Creamos el objeto de tipo Statement para ejecutar la sentencia.
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

			// Mostramos un mensaje de que las calificaciones han sido añadido
			// correctamente.
			System.out.println("Nuevas calificaciones añadidas correctamente.");

			// Capturamos esta excepción para mostrar un error en caso de que no se pueda
			// establecer conexión con la base de datos.
		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}
	}

}
