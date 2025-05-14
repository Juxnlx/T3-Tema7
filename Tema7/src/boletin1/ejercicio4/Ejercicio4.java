package boletin1.ejercicio4;

import utiles.Constantes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejercicio4 {

	public static void main(String[] args) {

		// Creamos la conexión con el método DriverManager con la base de datos
		// InstitutoDB. Hacemos uso del método getConnection y les pasamos como
		// parametro las constantes necesarias para crear la conexión.
		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.PASSWORD)) {

			// Creamos el array res como un array unidimensional para almacenar el número de
			// filas modificadas.
			int res[];

			// Creamos la variable insert como String para almacenar la instrucción insert
			// sql.
			String insert = "INSERT INTO cursos (nombre, descripcion, año_escolar) VALUES (?, ?, ?)";

			// Creamos el objeto de tipo PreparedStatement para sustituir valores '?'.
			PreparedStatement ps = con.prepareStatement(insert);

			// Establecemos el primer parámetro ? con el nuevo nombre de la asignatura
			// Historia 1º.
			ps.setString(1, "Historia 1º");
			// Establecemos el segundo parámetro ? con la descripción de la asignatura
			// Historia 1º.
			ps.setString(2, "Historia para primer año");
			// Establecemos el tercer parámetro ? con el año escolar de la asignatura
			// Historia 1º.
			ps.setInt(3, 2025);
			// Vamos añadiendo la asignatura para luego ser ejecutada.
			ps.addBatch();

			// Establecemos el primer parámetro ? con el nuevo nombre de la asignatura
			// Biología 1º.
			ps.setString(1, "Biología 1º");
			// Establecemos el segundo parámetro ? con la descripción de la asignatura
			// Biología 1º.
			ps.setString(2, "Biología para primer año");
			// Establecemos el tercer parámetro ? con el año escolar de la asignatura
			// Biología 1º.
			ps.setInt(3, 2025);
			// Vamos añadiendo la asignatura para luego ser ejecutada.
			ps.addBatch();

			// Establecemos el primer parámetro ? con el nuevo nombre de la asignatura
			// Educación Física 1º.
			ps.setString(1, "Educación Física 1º");
			// Establecemos el segundo parámetro ? con la descripción de la asignatura
			// Educación Física 1º.
			ps.setString(2, "Educación Física para primer año");
			// Establecemos el tercer parámetro ? con el año escolar de la asignatura
			// Educación Física 1º.
			ps.setInt(3, 2025);
			// Vamos añadiendo la asignatura para luego ser ejecutada.
			ps.addBatch();

			// Establecemos el primer parámetro ? con el nuevo nombre de la asignatura
			// Música 1º.
			ps.setString(1, "Música 1º");
			// Establecemos el segundo parámetro ? con la descripción de la asignatura
			// Música 1º.
			ps.setString(2, "Música para primer año");
			// Establecemos el tercer parámetro ? con el año escolar de la asignatura
			// Música 1º.
			ps.setInt(3, 2025);
			// Vamos añadiendo la asignatura para luego ser ejecutada.
			ps.addBatch();

			// Establecemos el primer parámetro ? con el nuevo nombre de la asignatura
			// Tecnología 1º.
			ps.setString(1, "Tecnología 1º");
			// Establecemos el segundo parámetro ? con la descripción de la asignatura
			// Tecnología 1º.
			ps.setString(2, "Tecnología para primer año");
			// Establecemos el tercer parámetro ? con el año escolar de la asignatura
			// Tecnología 1º.
			ps.setInt(3, 2025);
			// Vamos añadiendo la asignatura para luego ser ejecutada.
			ps.addBatch();

			// Ejecutamos todas las instrucciones que hemos ido almacenando. Almacenamos en
			// nuestro array res el número de filas que se han modificado.
			res = ps.executeBatch();

			// Imprimimos un mensaje mostrando que las inserciones se han añadido
			// correctamente.
			System.out.println("Inserciones realizadas correctamente. Número de filas: " + res.length);

			// Capturamos esta excepción para mostrar un error en caso de que no se pueda
			// establecer conexión con la base de datos.
		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}
	}

}
