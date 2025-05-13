package boletin1.ejercicio7;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import utiles.Constantes;

public class Ejercicio7 {

	public static void main(String[] args) {

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

		// Creamos la conexión con el método DriverManager con la base de datos
		// InstitutoDB. Hacemos uso del método getConnection y les pasamos como
		// parametro las constantes necesarias para crear la conexión.
		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.PASSWORD)) {

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
			nuevoAlumno = "INSERT INTO Estudiantes (nombre, apellido, fecha_nacimiento, email, telefono) VALUES (?, ?, ?, ?, ?)";

			// Creamos el objeto de tipo PreparedStatement para sustituir valores '?'.
			PreparedStatement ps = con.prepareStatement(nuevoAlumno);

			// Asignamos el nombre introducido por el usuario al primer parametro, que
			// corresponde con el primer '?'.
			ps.setString(1, nombre);
			// Asignamos el apellido introducido por el usuario al segundo parametro, que
			// corresponde con el primer '?'.
			ps.setString(2, apellido);
			// Comprobamos si el campo de fecha de nacimiento está vacío:
			// - Si está vacío, se inserta NULL en la base de datos.
			// - Si tiene valor, se convierte el String al tipo Date y se inserta.
			ps.setDate(3, fechaNacimiento.isEmpty() ? null : Date.valueOf(fechaNacimiento));
			// Comprobamos si el email está vacío:
			// - Si está vacío, se inserta NULL.
			// - Si tiene valor, se inserta como está.
			ps.setString(4, email.isEmpty() ? null : email);
			// Comprobamos si el teléfono está vacío:
			// - Si está vacío, se inserta NULL.
			// - Si tiene valor, se inserta como está.
			ps.setString(5, telefono >= 100000000 && telefono <= 999999999 ? null : String.valueOf(telefono));

			// Disponemos del método executeUpdate para ejecutar la instrucción, en este
			// caso añadimos un nuevo alumno.
			filas = ps.executeUpdate();

			// Imprimimos un mensaje mostrando si el estudiante se ha añadido correctamente
			// y mostramos cuantas filas han sido modificadas.
			System.out.println("Estudiante insertado correctamente. Filas afectadas: " + filas);

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}

		// Cierre Scanner
		sc.close();
	}

}
