package boletin1.ejercicio7;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {

		// Creamos la variable url como String para almacenar la ruta donde se encuentra
		// la base de datos.
		String url = "jdbc:mysql://localhost/InstitutoDB";

		// Creamos la variable usuario como String para almacenar el nombre de usuario
		String usuario = "root";

		// Creamos la variable password como String para almacenar la contraseña del
		// usuario.
		String password = "Juanl2004";

		// Creamos la variable nombre como String para almacenar el nombre del alumno.
		String nombre;

		// Creamos la variable apellido como String para almacenar el apellido del
		// alumno.
		String apellido;

		// Creamos la variable fechaNacimiento como String para almacenar la fecha de
		// nacimiento del alumno.
		String fechaNacimiento;

		// Creamos la variable email como String para almacenar el correo electronico
		// del alumno.
		String email;

		// Creamos la variable telefono como int para almacenar el número de telefono
		// del alumno.
		int telefono;

		// Creamos el Scanner para solicitar al usuario todos los datos para añadirlo
		// como alumno a la base de datos.
		Scanner sc = new Scanner(System.in);

		try (Connection con = DriverManager.getConnection(url, usuario, password)) {

			// Creamos el objeto de tipo Statement
			Statement st = con.createStatement();

			// Creamos la variable nuevoAlumno como String para almacenar la instrucción en
			// sql que nos añadira al nuevo alumno.
			String nuevoAlumno;

			// Creamos la variable filas como int para almacenar la cantidad de filas
			// modificadas tras realizar la instrucción.
			int filas;

			// Le pedimos al usuario que introduzca el nombre del nuevo alumno y lo leemos.
			System.out.println("Introduce el nombre: ");
			nombre = sc.nextLine();

			// Le pedimos al usuario que introduzca el apellido del nuevo alumno y lo
			// leemos.
			System.out.println("Introduce el apellido: ");
			apellido = sc.nextLine();

			// Le pedimos al usuario que introduzca la fecha de nacimiento del nuevo alumno
			// y lo leemos.
			System.out.println("Fecha de nacimiento (YYYY-MM-DD): ");
			fechaNacimiento = sc.nextLine();

			// Le pedimos al usuario que introduzca el email del nuevo alumno y lo leemos.
			System.out.println("Introduce el email: ");
			email = sc.nextLine();

			// Le pedimos al usuario que introduzca el teléfono del nuevo alumno y lo
			// leemos.
			System.out.println("Introduce el teléfono: ");
			telefono = sc.nextInt();

			// Almacenamos en la variable nuevoAlumno la instrucción INSERT con los datos
			// del nuevo alumno solicitados al usuario.
			nuevoAlumno = "INSERT INTO Estudiantes (nombre, apellido, fecha_nacimiento, email, telefono) " + "VALUES ('"
					+ nombre + "', '" + apellido + "', '" + fechaNacimiento + "', '" + email + "', " + telefono + ")";

			// Disponemos del método executeUpdate para ejecutar al instrucción que se le
			// pasa por parametro, en este caso añadimos un nuevo alumno.
			filas = st.executeUpdate(nuevoAlumno);

			// Imprimimos un mensaje mostrando si el estudiante se ha añadido correctamente
			// y mostramos cuantas filas han sido modificadas.
			System.out.println("Estudiante insertado correctamente. Filas afectadas: " + filas);

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}

		//Cierre Scanner
		sc.close();
	}

}
