package ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio2 {

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

			// Creamos la variable actualizarEstudiante como String para almacenar la
			// sentencia que ejecutaremos para actualizar el nombre.
			String actualizarEstudiante = "UPDATE estudiantes SET nombre = 'María' WHERE id_estudiante = 4";

			// Creamos la variable actualizarProfesor como String para almacenar la
			// sentencia que ejecutaremos para actualizar el nombre.
			String actualizarProfesor = "UPDATE profesores SET especialidad = 'Física' WHERE id_profesor = 4";

			// Creamos la variable filasEstudiante como int para almacenar el número de
			// filas que se han actualizado.
			int filasEstudiante = st.executeUpdate(actualizarEstudiante);

			// Creamos la variable filasProfesor como int para almacenar el número de filas
			// que se han actualizado.
			int filasProfesor = st.executeUpdate(actualizarProfesor);

			System.out.println("Alumnos actualizados: " + filasEstudiante);
			System.out.println("Profesores actualizados: " + filasProfesor);

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}

	}

}
