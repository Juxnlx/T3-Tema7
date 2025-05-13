package boletin1.ejercicio1;

import java.sql.Statement;

import utiles.Constantes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejercicio1 {

	public static void main(String[] args) {

		// Creamos la conexión con el método DriverManager con la base de datos
		// InstitutoDB. Hacemos uso del método getConnection y les pasamos como
		// parametro las constantes necesarias para crear la conexión.
		try (Connection con = DriverManager.getConnection(Constantes.URL, Constantes.USUARIO, Constantes.PASSWORD)) {

			// Creamos la variable insertarAlumno como String para almacenar la instrucción
			// para añadir el nuevo alumno con los datos de ese alumno.
			String insertarAlumno = "INSERT INTO estudiantes (id_estudiante, nombre, apellido, fecha_nacimiento, email) VALUES (?, ?, ?, ?, ?)";

			 // Preparamos la consulta para añadir un nuevo estudiante.
            PreparedStatement psAlumno = con.prepareStatement(insertarAlumno);

            // Asignamos valores a cada parámetro ? (en orden).
            psAlumno.setInt(1, 4); // id_estudiante
            psAlumno.setString(2, "Lucía"); // nombre
            psAlumno.setString(3, "Barrionuevo"); // apellido
            psAlumno.setString(4, "2006-03-15"); // fecha_nacimiento (formato YYYY-MM-DD)
            psAlumno.setString(5, "luciiibarri@gmail.com"); // email
			
            
			// Creamos la variable insertarProfesor como String para almacenar la
			// instrucción para añadir el nuevo profesor con los datos de ese profesor.
			String insertarProfesor = "INSERT INTO profesores (id_profesor, nombre, apellido, especialidad, email) VALUES (?, ?, ?, ?, ?)";

			// Preparamos la consulta para añadir un nuevo profesor.
            PreparedStatement psProfesor = con.prepareStatement(insertarProfesor);

            // Asignamos valores a cada parámetro ? (en orden).
            psProfesor.setInt(1, 4); // id_profesor
            psProfesor.setString(2, "Carlos"); // nombre
            psProfesor.setString(3, "López"); // apellido
            psProfesor.setString(4, "Matemáticas"); // especialidad
            psProfesor.setString(5, "carloslopez@gmail.com"); // email
            
			// Inserción 1: Alumno
			psAlumno.executeUpdate();
			// Inserción 2: Profesor
			psProfesor.executeUpdate();

			// Imprimimos un mensaje mostrando que las inserciones se han añadido
			// correctamente.
			System.out.println("Inserciones realizadas correctamente.");

			// Capturamos esta excepción para mostrar un error en caso de que no se pueda
			// establecer conexión con la base de datos.
		} catch (SQLException e) {
			System.out.println("Error con la base de datos: " + e);
		}

	}

}
