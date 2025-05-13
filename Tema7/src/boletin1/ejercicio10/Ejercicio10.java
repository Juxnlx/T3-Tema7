package boletin1.ejercicio10;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {

		// Creamos la variable url como String para almacenar la ruta donde se encuentra
		// la base de datos.
		String url = "jdbc:mysql://localhost/InstitutoDB";

		// Creamos la variable usuario como String para almacenar el nombre de usuario
		String usuario = "root";

		// Creamos la variable password como String para almacenar la contraseña del
		// usuario.
		String password = "Juanl2004";

		// Creamos el objeto Scanner para leer por teclado
		Scanner sc = new Scanner(System.in);

		// Pedimos al usuario el nombre del curso
		System.out.print("Introduce el nombre del curso (por ejemplo: Matemáticas 1º): ");
		String nombreCurso = sc.nextLine();

		// Consulta SQL con INNER JOIN para unir Estudiantes, Matriculas y Cursos
		String sql = "SELECT e.nombre, e.fecha_nacimiento " + "FROM Estudiantes e "
				+ "JOIN Matriculas m ON e.id_estudiante = m.id_estudiante "
				+ "JOIN Cursos c ON m.id_curso = c.id_curso " + "WHERE c.nombre = ?";

		// Intentamos conectar y ejecutar la consulta
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {

			// Creamos el objeto de tipo Statement
			Statement st = con.createStatement();

			// Ejecutamos la consulta y obtenemos los resultados
			ResultSet rs = st.executeQuery(sql);

			System.out.println("Estudiantes del curso '" + nombreCurso + "':");

			boolean hayResultados = false;

			// Recorremos los resultados
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String fechaNacimiento = rs.getString("fecha_nacimiento");
				System.out.println("Nombre: " + nombre + " | Fecha de nacimiento: " + fechaNacimiento);
				hayResultados = true;
			}

			if (!hayResultados) {
				System.out.println("No se encontraron estudiantes para ese curso.");
			}

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e.getMessage());
		}
	}
}