package boletin1.ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utiles.Constantes;

public class Ejercicio2 {

	public static void main(String[] args) {

		// Creamos la conexión con el método DriverManager con la base de datos
		// InstitutoDB. Hacemos uso del método getConnection y les pasamos como
		// parametro las constantes necesarias para crear la conexión.
		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.PASSWORD)) {

			// Creamos la variable actualizarEstudiante como String para almacenar la
			// sentencia que ejecutaremos para actualizar el nombre.
			String actualizarEstudiante = "UPDATE estudiantes SET nombre = ? WHERE id_estudiante = ?";

			// Preparamos la sentencia SQL.
			PreparedStatement psAlumno = con.prepareStatement(actualizarEstudiante);

			// Establecemos el primer parámetro ? con el nuevo nombre del alumno.
			psAlumno.setString(1, "Ana María");

			// Establecemos el segundo parámetro ? con el ID del alumno que queremos
			// actualizar.
			psAlumno.setInt(2, 1);

			// Creamos la variable actualizarProfesor como String para almacenar la
			// sentencia que ejecutaremos para actualizar el nombre.
			String actualizarProfesor = "UPDATE profesores SET especialidad = ? WHERE id_profesor = ?";

			// Preparamos la sentencia SQL.
			PreparedStatement psProfesor = con.prepareStatement(actualizarProfesor);

			// Establecemos el primer parámetro ? con la nueva especialidad.
			psProfesor.setString(1, "Física");

			// Establecemos el segundo parámetro ? con el ID del profesor que queremos
			// actualizar.
			psProfesor.setInt(2, 1);

			// Creamos la variable filasEstudiante como int para almacenar el número de
			// filas que se han actualizado.
			int filasEstudiante = psAlumno.executeUpdate();

			// Creamos la variable filasProfesor como int para almacenar el número de filas
			// que se han actualizado.
			int filasProfesor = psProfesor.executeUpdate();

			// Mostramos por pantalla cuántas filas fueron modificadas en cada tabla.
			System.out.println("Alumnos actualizados: " + filasEstudiante);
			System.out.println("Profesores actualizados: " + filasProfesor);

			// Capturamos esta excepción para mostrar un error en caso de que no se pueda
			// establecer conexión con la base de datos.
		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}

	}

}
