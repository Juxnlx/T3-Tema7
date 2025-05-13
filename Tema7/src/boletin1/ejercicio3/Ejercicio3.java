package boletin1.ejercicio3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import utiles.Constantes;

public class Ejercicio3 {

	public static void main(String[] args) {

		// Creamos la conexión con el método DriverManager con la base de datos
		// InstitutoDB. Hacemos uso del método getConnection y les pasamos como
		// parametro las constantes necesarias para crear la conexión.
		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.PASSWORD)) {

			// Creamos el objeto de tipo Statement para ejecutar la sentencia.
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

			// Imprimimos la cantidad de alumnos y profesores que se han eliminado
			System.out.println("Alumnos eliminados: " + filasEstudiante);
			System.out.println("Profesores eliminados: " + filasProfesor);

			// Capturamos esta excepción para mostrar un error en caso de que no se pueda
			// establecer conexión con la base de datos.
		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}

	}

}
