package boletin1.ejercicio8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		// Creamos la variable url como String para almacenar la ruta donde se encuentra
		// la base de datos.
		String url = "jdbc:mysql://localhost/InstitutoDB";

		// Creamos la variable usuario como String para almacenar el nombre de usuario
		String usuario = "root";

		// Creamos la variable password como String para almacenar la contraseña del
		// usuario.
		String password = "Juanl2004";

		// Creamos la variable idEstudiante como int para almacenar el id del
		// estudiante.
		int idEstudiante;

		// Creamos el Scanner para solicitar al usuario todos los datos para añadirlo
		// como alumno a la base de datos.
		Scanner sc = new Scanner(System.in);

		try (Connection con = DriverManager.getConnection(url, usuario, password)) {

			// Creamos el objeto de tipo Statement
			Statement st = con.createStatement();

			// Creamos la variable borrarCalificaciones como String para almacenar la
			// instrucción para eliminar el id_estudiante de la tabla.
			String borrarCalificaciones;

			// Creamos la variable borrarMatriculas como String para almacenar la
			// instrucción para eliminar el id_estudiante de la tabla.
			String borrarMatriculas;

			// Creamos la variable borrarEstudiante como String para almacenar la
			// instrucción para eliminar el estudiante de la tabla.
			String borrarEstudiante;

			// Creamos la variable filas como int para almacenar la cantidad de filas
			// modificadas tras realizar la instrucción.
			int filas;

			// Le pedimos al usuario que introduzca el id del estudiante a eliminar.
			System.out.println("Introduce el teléfono: ");
			idEstudiante = sc.nextInt();

			// Almacenamos en la variable borrarCalificaciones la instrucción DELETE para
			// eliminar el id_estudiante de la tabla Calificaciones.
			borrarCalificaciones = "DELETE FROM Calificaciones WHERE id_estudiante = " + idEstudiante;
			// Disponemos del método executeUpdate para ejecutar la instrucción que se le
			// pasa por parametro, en este caso eliminamos el id de un estudiante de la
			// tabla Calificaciones.
			st.executeUpdate(borrarCalificaciones);

			// Almacenamos en la variable borrarMatriculas la instrucción DELETE para
			// eliminar el id_estudiante de la tabla Matriculas.
			borrarMatriculas = "DELETE FROM Matriculas WHERE id_estudiante = " + idEstudiante;
			// Disponemos del método executeUpdate para ejecutar la instrucción que se le
			// pasa por parametro, en este caso eliminamos el id de un estudiante de la
			// tabla Matriculas.
			st.executeUpdate(borrarMatriculas);

			// Almacenamos en la variable borrarEstudiante la instrucción DELETE para
			// eliminar el id_estudiante de la tabla Estudiantes.
			borrarEstudiante = "DELETE FROM Estudiantes WHERE id_estudiante = " + idEstudiante;
			// Disponemos del método executeUpdate para ejecutar la instrucción que se le
			// pasa por parametro, en este caso eliminamos el id de un estudiante de la
			// tabla Estudiantes.
			filas = st.executeUpdate(borrarEstudiante);

			// Comprobamos si el número de filas modificadas es mayor que 0, si es así
			// mostramos un mensaje de que el estudiante ha sido eliminado, en caso
			// contrario mostramos un mensaje indicando que no se ha eliminado.
			if (filas > 0) {
				System.out.println("Estudiante eliminado correctamente.");
			} else {
				System.out.println("No se encontró ningún estudiante con ese ID.");
			}

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}

		// Cierre Scanner
		sc.close();
	}

}
