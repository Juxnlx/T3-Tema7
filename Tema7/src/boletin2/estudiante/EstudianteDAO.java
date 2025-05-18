package boletin2.estudiante;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstudianteDAO {

	// Creamos la constante URL como String para almacenar la ruta donde se
	// encuentra la base de datos.
	private static final String URL = "jdbc:mysql://localhost/InstitutoDB";

	// Creamos la constante USUARIO como String para almacenar el nombre de usuario
	private static final String USUARIO = "root";

	// Creamos la constante PASSWORD como String para almacenar la contraseña del
	// usuario.
	private static final String PASSWORD = "Juanl2004";

	/**
	 * Esta función se encarga de llevar a cabo la conexión de nuestro programa con
	 * la base de datos.
	 * 
	 * @return Un obejto de tipo Connection con el metodo DriverManager si la base
	 *         de datos se ha conectado correctamente, en caso contrario devolvemos
	 *         null.
	 */
	public static Connection conectar() {
		// Declaramos la variable conn para almacenar la conexión.
		Connection conn = null;

		try {
			// Intentamos establecer la conexión con la base de datos usando URL, usuario y
			// contraseña.
			conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
		} catch (SQLException e) {
			// Si ocurre un error con la conexión, mostramos un mensaje comunicandolo.
			System.out.println("Error con la base de datos: " + e);
		}

		// Devolvemos la conexión (puede ser una conexión válida o null si hay un
		// error).
		return conn;
	}

	/**
	 * Esta función se encarga de insertar el estudiante pasado por parametro a la
	 * base de datos.
	 * 
	 * @param estudiante El nuevo estudiante pasada por parametro que hay que añadir
	 *                   a la base de datos.
	 */
	public static void create(Estudiante estudiante) {
		// Creamos la variable filas como int para almacenar el numero de filas
		// afectadas al ejecutar una instrucción.
		int filas;

		// Creamos la variable sql como String para almacenar la instrucción de insert
		// para añadir al nuevo usuario pasado como parametro.
		String sql = "INSERT INTO Estudiantes (id_estudiante, nombre, fecha_nacimiento, notaMedia, curso) VALUES (?, ?, ?, ?, ?)";

		// Creamos una variable Connection donde almacenar la conexión que nos devuelve
		// la función conectar, que es la que nos permite establecer una conexión con la
		// base de datos.
		try (Connection conn = conectar()) {

			// Creamos el objeto de tipo PreparedStatement para sustituir valores '?'.
			PreparedStatement stmt = conn.prepareStatement(sql);

			// Sustituimos los interrogantes de la instrucción insert por los valores
			// correspondientes del objeto pasado por parametro haciendo uso de los get.
			stmt.setInt(1, estudiante.getId());
			stmt.setString(2, estudiante.getNombre());
			stmt.setDate(3, (Date) estudiante.getfNacimiento());
			stmt.setDouble(4, estudiante.getNotaMedia());
			stmt.setString(5, estudiante.getCurso());

			// Ejecutamos la instrucción en este caso el insert.
			filas = stmt.executeUpdate();

			// Imprimos un mensaje mostrando que el nuevo alumno se ha añadido correctamente
			// y mostramos el número de filas modificadas.
			System.out.println("Nuevo alumno matriculado con existo  | Filas afectadas: " + filas);

			// Capturamos esta excepción para mostrar un error en caso de que no se pueda
			// establecer conexión con la base de datos.
		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e.getMessage());
		}
	}

	/**
	 * Esta función se encarga de buscar en la tabla estudiante el estudiante con el
	 * id pasado como parametro. Realizando una consulta de tipo Select.
	 * 
	 * @param id El id del estudiante que queremos encontrar en la base de datos.
	 * @return Un objeto de tipo Estudiante en caso de encontar el estudiante en
	 *         caso contrario, null.
	 */
	public static Estudiante read(int id) {
		// Declaramos un objeto de tipo estudiante para almacenar un estudiante.
		Estudiante est = null;

		// Creamos la variable sql como String para almacenar la instrucción de select
		// para devolver ese estudiante con el id pasado como parametro.
		String sql = "SELECT * FROM Estudiantes WHERE id_estudiante = ?";

		// Creamos una variable Connection donde almacenar la conexión que nos devuelve
		// la función conectar, que es la que nos permite establecer una conexión con la
		// base de datos.
		try (Connection conn = conectar()) {

			// Creamos el objeto de tipo PreparedStatement para sustituir valores '?'.
			PreparedStatement ps = conn.prepareStatement(sql);

			// Sustituimos el valor interrogante de la consulta select por el id pasado por
			// parametro.
			ps.setInt(1, id);

			// Ejecutamos la consulta y obtenemos los resultados.
			ResultSet rs = ps.executeQuery();

			// Vamos recorriendo todos los estudiantes matriculados hasta escontrar al que
			// tiene el id pasado como parametro.
			if (rs.next()) {
				// Si lo encuentra creamos el objeto de tipo Estudiante que estamos buscando
				// creamos un objeto con esos datos y lo devolvemos.
				est = new Estudiante(rs.getInt("id_estudiante"), rs.getString("nombre"), rs.getDate("fecha_nacimiento"),
						rs.getDouble("notaMedia"), rs.getString("curso"));
			}

			// Capturamos esta excepción para mostrar un error en caso de que no se pueda
			// establecer conexión con la base de datos.
		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e.getMessage());
		}

		// Devolvemos el objeto de tipo Estudiante.
		return est;
	}

	/**
	 * Esta función se encarga de actualizar el estudiante con el id del estudiante
	 * pasado por parametro con esos nuevos datos del objeto pasado por parametro.
	 * 
	 * @param estudiante El estudiante que hay que actualizar.
	 */
	public static void update(Estudiante estudiante) {
		// Creamos la variable sql como String para almacenar la instrucción Update con
		// la que vamos a actualizar los campos nombre, notaMedia o curso del estudiante
		// con el id introducido.
		String sql = "UPDATE Estudiantes SET nombre = ?, notaMedia = ? WHERE id = ?";

		// Creamos la variable filas como int para almacenar el numero de filas
		// afectadas al ejecutar una instrucción.
		int filas;

		// Creamos una variable Connection donde almacenar la conexión que nos devuelve
		// la función conectar, que es la que nos permite establecer una conexión con la
		// base de datos.
		try (Connection conn = conectar()) {

			// Creamos el objeto de tipo PreparedStatement para sustituir valores '?'.
			PreparedStatement ps = conn.prepareStatement(sql);

			// Sustituimos los valores interrogantes por
			ps.setString(1, estudiante.getNombre());
			ps.setDouble(2, estudiante.getNotaMedia());
			ps.setInt(3, estudiante.getId());

			// Ejecutamos la instrucción sql para realizar el Update de un estudiante.
			filas = ps.executeUpdate();

			// Mostramos un mensaje indicando que los datos del estudiante han sido
			// modificados con existo.
			System.out.println("El estudiante ha sido modificado con existo | Filas afectadas: " + filas);

			// Capturamos esta excepción para mostrar un error en caso de que no se pueda
			// establecer conexión con la base de datos.
		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e.getMessage());
		}
	}

	/**
	 * Esta función se encaraga de eliminar el estudiante con el id pasado por
	 * parametro.
	 * 
	 * @param id El id del estudiante a eliminar.
	 */
	public static void delete(int id) {
		// Creamos la variable sql como String para almacenar la instrucción delete con
		// la que vamos a eliminar al estudiante con el id pasado por parametro.
		String sql = "DELETE FROM Estudiantes WHERE id = ?";

		// Creamos una variable Connection donde almacenar la conexión que nos devuelve
		// la función conectar, que es la que nos permite establecer una conexión con la
		// base de datos.
		try (Connection conn = conectar()) {

			// Creamos el objeto de tipo PreparedStatement para sustituir valores '?'.
			PreparedStatement ps = conn.prepareStatement(sql);

			// Sustituimos el valor interrogante de la consulta select por el id pasado por
			// parametro.
			ps.setInt(1, id);

			// Ejecutamos la instrucción delete.
			ps.executeUpdate();

			// Mostramos un mensaje indicando que el estudiante ha sido añadido
			// correctamente.
			System.out.println("Estudiante eliminado correctamente.");

			// Capturamos esta excepción para mostrar un error en caso de que no se pueda
			// establecer conexión con la base de datos.
		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e.getMessage());
		}
	}
}