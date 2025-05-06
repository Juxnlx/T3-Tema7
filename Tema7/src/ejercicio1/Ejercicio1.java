package ejercicio1;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejercicio1 {

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

			// Creamos la variable insertarAlumno como String para almacenar la instrucción
			// para añadir el nuevo alumno con los datos de ese alumno.
			String insertarAlumno = "INSERT INTO estudiantes (id_estudiante, nombre, apellido, fecha_nacimiento, email) "
					+ "VALUES (4, 'Lucía', 'Barrionuevo', '2006-03-15', 'luciiibarri@gmail.com')";

			// Creamos la variable insertarProfesor como String para almacenar la
			// instrucción para añadir el nuevo profesor con los datos de ese profesor.
			String insertarProfesor = "INSERT INTO profesores (id_profesor, nombre, apellido, especialidad, email) "
					+ "VALUES (4, 'Carlos', 'López', 'Matemáticas', 'carloslopez@gmail.com')";

			// Creamos el objeto de tipo Statement.
			Statement st = con.createStatement();

			// Inserción 1: Alumno
			st.executeUpdate(insertarAlumno);
			// Inserción 2: Profesor
			st.executeUpdate(insertarProfesor);

			// Imprimimos un mensaje mostrando que las inserciones se han añadido
			// correctamente.
			System.out.println("Inserciones realizadas correctamente.");

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}

	}

}
