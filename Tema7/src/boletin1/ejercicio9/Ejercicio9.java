package boletin1.ejercicio9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio9 {

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

			// Creamos el objeto de tipo Statement
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

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}

	}

}
