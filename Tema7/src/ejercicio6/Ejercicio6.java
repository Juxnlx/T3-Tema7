package ejercicio6;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejercicio6 {

	public static void main(String[] args) {

		// Creamos la variable url como String para almacenar la ruta donde se encuentra
		// la base de datos.
		String url = "jdbc:mysql://localhost/InstitutoDB";

		// Creamos la variable usuario como String para almacenar el nombre de usuario
		String usuario = "root";

		// Creamos la variable password como String para almacenar la contraseña del
		// usuario.
		String password = "Juanl2004";

		// Creamos una conexión con la base de datos usando el método estático
		// DriverManager.
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {

			// Creamos el objeto de tipo Statement
			Statement st = con.createStatement();

			// Creamos la variable sql como String para almacenar la instrucción para
			// altualizar la nota con un punto mas de la alumna Ana González en Matemáticas
			// 1º.
			String sql = "UPDATE Calificaciones SET nota = nota + 1 WHERE id_estudiante = 1 AND id_curso = 1";
			int filasActualizadas = st.executeUpdate(sql);

			// Imprimimos un mensaje mostrando que la nota de Ana se ha modificado
			// correctamente, porque imprimimos el número de filas modificadas.
			System.out.println("Filas actualizadas: " + filasActualizadas);

		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}
	}

}
