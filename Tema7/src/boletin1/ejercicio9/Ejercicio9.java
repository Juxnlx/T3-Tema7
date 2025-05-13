package boletin1.ejercicio9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utiles.Constantes;

public class Ejercicio9 {

	public static void main(String[] args) {

		// Creamos la conexión con el método DriverManager con la base de datos
		// InstitutoDB. Hacemos uso del método getConnection y les pasamos como
		// parametro las constantes necesarias para crear la conexión.
		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.PASSWORD)) {

			// Creamos el objeto de tipo Statement para ejecutar la sentencia.
			Statement st = con.createStatement();

			// Creamos la variable consulta como String para almacenar la instrucción de la
			// consulta que queremos mostrar, en este caso el nombre y la fecha de
			// nacimiento de cada estudiante.
			String consulta = "SELECT nombre, fecha_nacimiento FROM Estudiantes";

			// Creamos la variable nombre como String para almacenar el nombre del alumno.
			String nombre;

			// Creamos la variable fechaNacimiento como String para almacenar la fecha de
			// nacimiento del alumno.
			String fechaNacimiento;

			// Creamos un objeto de tipo ResultSet, para ejecutar nuestra consulta.
			ResultSet rs = st.executeQuery(consulta);

			// Mostramos el titulo de lo que vamos a mostrar a continuación.
			System.out.println("Listado de estudiantes:");
			System.out.println("------------------------");

			// Comprobamos si hay mas estudiantes que leer.
			while (rs.next()) {
				// Almacenamos el nombre del estudiante que se encuentra en la columna nombre.
				nombre = rs.getString("nombre");
				// Almacenamos la fecha de nacimiento del estudiante que se encuentra en la
				// columna fechaNacimiento.
				fechaNacimiento = rs.getString("fecha_nacimiento");

				// Mostramso el nombre y la fecha de nacimiento del alumno que estamos
				// recorriendo en este momento.
				System.out.println("Nombre: " + nombre + " | Fecha de nacimiento: " + fechaNacimiento);
			}

			// Capturamos esta excepción para mostrar un error en caso de que no se pueda
			// establecer conexión con la base de datos.
		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}

	}

}
