package boletin1.ejercicio6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utiles.Constantes;

public class Ejercicio6 {

	public static void main(String[] args) {

		// Creamos la conexión con el método DriverManager con la base de datos
		// InstitutoDB. Hacemos uso del método getConnection y les pasamos como
		// parametro las constantes necesarias para crear la conexión.
		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.PASSWORD)) {

			// Creamos la variable sql como String para almacenar la instrucción para
			// altualizar la nota con un punto mas de la alumna Ana González en Matemáticas
			// 1º.
			String sql = "UPDATE Calificaciones SET nota = nota + 1 WHERE id_estudiante = ? AND id_curso = ?";

			// Creamos el objeto de tipo PreparedStatement para sustituir valores '?'.
			PreparedStatement ps = con.prepareStatement(sql);

			// Establecemos el primer parámetro id_estudiante = 1, que es Ana González.
			ps.setInt(1, 1);

			// Establecemos el segundo parámetro id_curso = 1, que es Matematicas 1º.
			ps.setInt(2, 1);

			// Ejecutamos la actualización y almacenamos el número de filas afectadas.
			int filasActualizadas = ps.executeUpdate(sql);

			// Mostramos el resultado según si se modificó alguna fila o no.
			if (filasActualizadas > 0) {
				System.out.println("Se sumo 1 punto a la nota de Ana en Matemáticas.");
			} else {
				System.out.println("No se encontro ninguna calificación para actualizar.");
			}

			// Capturamos esta excepción para mostrar un error en caso de que no se pueda
			// establecer conexión con la base de datos.
		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}
	}

}
