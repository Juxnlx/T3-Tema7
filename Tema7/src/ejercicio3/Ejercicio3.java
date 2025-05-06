package ejercicio3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio3 {

	public static void main(String[] args) {
		// Creamos la variable url como String para almacenar la ruta donde se encuentra
		// la base de datos.
		String url = "jdbc:mysql://localhost/InstitutoDB";

		// Creamos la variable usuario como String para almacenar el nombre de usuario
		String usuario = "root";

		// Creamos la variable password como String para almacenar la contraseña del
		// usuario.
		String password = "Juanl2004";

		try (Connection con = DriverManager.getConnection(url, usuario, password)) {

			// Creamos el objeto de tipo Statement.
			Statement st = con.createStatement();
			
			// Creamos la variable eliminarEstudiante como String para almacenar la
			// sentencia que ejecutaremos para eliminar un estudiante.
			String eliminarEstudiante = "DELETE FROM estudiantes WHERE id_estudiante = 4";

			// Creamos la variable eliminarProfesor como String para almacenar la
			// sentencia que ejecutaremos para eliminar un profesor.
			String eliminarProfesor = "DELETE FROM profesores WHERE id_profesor = 4";

			// Creamos la variable filasEstudiante como int para almacenar el número de
			// filas que se han eliminado.
			int filasEstudiante = st.executeUpdate(eliminarEstudiante);

			// Creamos la variable filasProfesor como int para almacenar el número de filas
			// que se han eliminado.
			int filasProfesor = st.executeUpdate(eliminarProfesor);

			//Imprimimos la cantidad de alumnos y profesores que se han eliminado
			System.out.println("Alumnos eliminados: " + filasEstudiante);
			System.out.println("Profesores eliminados: " + filasProfesor);

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}

	}

}
