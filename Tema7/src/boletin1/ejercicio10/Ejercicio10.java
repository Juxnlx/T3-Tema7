package boletin1.ejercicio10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utiles.Constantes;

public class Ejercicio10 {

	public static void main(String[] args) {

		// Creamos la variable nombreCurso como String para almacenar el nombre del
		// curso.
		String nombreCurso;

		// Creamos el objeto Scanner para leer por teclado
		Scanner sc = new Scanner(System.in);

		// Le pedimos al usuario que introduzca el nombre del curso y lo leemos.
		System.out.print("Introduce el nombre del curso: ");
		nombreCurso = sc.nextLine();

		// Creamos la variable consulta como String para almacenar la consulta con INNER
		// JOIN para unir Estudiantes, Matriculas y Cursos.
		String consulta = "SELECT e.nombre, e.fecha_nacimiento FROM Estudiantes e "
				+ "JOIN Matriculas m ON e.id_estudiante = m.id_estudiante "
				+ "JOIN Cursos c ON m.id_curso = c.id_curso WHERE c.nombre = ?";

		// Creamos la conexión con el método DriverManager con la base de datos
		// InstitutoDB.
		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.PASSWORD)) {

			// Creamos la variable hayResultados como boolean para mostrar si hay alumnos
			// matriculados en ese curso o no.
			boolean hayResultados = false;

			// Creamos la variable nombre como String para almacenar el nombre del alumno.
			String nombre;

			// Creamos la variable fechaNacimiento como String para almacenar la fecha de
			// nacimiento del alumno.
			String fechaNacimiento;

			// Creamos el objeto de tipo PreparedStatement para sustituir valores '?'.
			PreparedStatement ps = con.prepareStatement(consulta);

			// Llamamos al método setString para modificar el primer '?' por el nombre del
			// curso introducido por el usuario.
			ps.setString(1, nombreCurso);

			// Ejecutamos la consulta y obtenemos los resultados.
			ResultSet rs = ps.executeQuery();

			// Mostramos un mensaje de lo que vamos a mostrar a continuación.
			System.out.println("Estudiantes del curso '" + nombreCurso + "':");

			// Recorremos los resultados siempre y cuando haya.
			while (rs.next()) {
				// Almacenamos el nombre del estudiante que se encuentra en la columna nombre.
				nombre = rs.getString("nombre");
				// Almacenamos la fecha de nacimiento del estudiante que se encuentra en la
				// columna fechaNacimiento.
				fechaNacimiento = rs.getString("fecha_nacimiento");

				// Mostramos el nombre y la fecha de nacimiento del alumno que estamos
				// recorriendo en este momento.
				System.out.println("Nombre: " + nombre + " | Fecha de nacimiento: " + fechaNacimiento);
				hayResultados = true;
			}

			// Comprobamos si no hay resultados, si es así mostramos un mensaje de que no se
			// encontro ningun estudiante para ese curso.
			if (!hayResultados) {
				System.out.println("No se encontraron estudiantes para ese curso.");
			}

			// Capturamos esta excepción para mostrar un error en caso de que no se pueda
			// establecer conexión con la base de datos.
		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e.getMessage());
		}

		// Cierre de Scanner
		sc.close();
	}
}