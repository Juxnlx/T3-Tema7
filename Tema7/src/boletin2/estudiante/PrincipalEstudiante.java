package boletin2.estudiante;

import java.sql.Date;
import java.util.Scanner;

public class PrincipalEstudiante {

	// Creamos el Scanner a nivel de clase para solicitar información al usuario en
	// las funciones que se requiera.
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Declaramos un objeto de tipo estudiante para almacenar un estudiante.
		Estudiante est;

		// Creamos la variable id como int para almacenar el id del estudiante.
		int id;

		// Creamos la variable opc como int para almacenar la opción del menú
		// introducida por el usuario.
		int opc;

		do {
			// Llamamos a la función menu para que nos muestre todas las opción del menú y
			// nos pregunte cual es la seleccionada.
			menu();
			// Leemos la opción seleccionada por el usuario.
			opc = sc.nextInt();
			// Limpiamos el buffer
			sc.nextLine();

			switch (opc) {
			case 1 -> {
				// Llamamos a la función nuevoEstudiante para que nos devuelva el nuevo
				// estudiante que acabamos de crear y lo almacenamos en la variable est.
				est = nuevoEstudiante();

				// Llamamos a la función create para añadir el estudiante que acabamos de crear
				// a la base de datos el nuevo estudiante lo pasamos como parametro.
				EstudianteDAO.create(est);
			}
			case 2 -> {
				// Llamamos a la función pedirId para almacenar el id que nos devuelve en la
				// variable id.
				id = pedirId();

				// Llamamos a la función read para que nos devuelva el estudiante con el id
				// pasado como parametro y lo almacenamos en el objeto est.
				est = EstudianteDAO.read(id);

				// Croprobamos si el objeto es distinto de null, si es así...
				if (est != null) {
					// Mostramos todos los datos del estudiante.
					System.out.println("¡ESTUDIANTE ENCONTRADO!");
					System.out.println(est);
				} else {
					// En caso de no encontrar un estudiante, mostramos un mensaje indicando que el
					// estudiante con ese ID no existe en la base de datos.
					System.out.println("No existe un estudiante con ese ID.");
				}
			}
			case 3 -> {
				// Llamamos a la función pedirId para que nos devuelva el id que acaba de
				// solicitar al usuario y lo almacenamos en la variable id.
				id = pedirId();

				// Llamamos a la función actualizarEst para que nos devuelva un objeto de tipo
				// Estudiante con el valor que nosotros hayamos elegido modificar.
				est = actualizarEst();

				// Llamamos a la función update para actualizar los datos de un estudiante por
				// los del estudiante pasado como parametro.
				EstudianteDAO.update(est);
			}
			case 4 -> {
				// Llamamos a la función pedirId para almacenar el id que nos devuelve en la
				// variable id.
				id = pedirId();

				// Llamamos a la función read para que nos devuelva el estudiante con el id
				// pasado como parametro y lo almacenamos en el objeto est.
				est = EstudianteDAO.read(id);

				// Croprobamos si el objeto es distinto de null, si es así...
				if (est != null) {
					// Llamamos a la función delete para eliminar al estudiante con el id pasado por
					// parametro.
					EstudianteDAO.delete(id);
				} else {
					// En caso de no encontrar un estudiante, mostramos un mensaje indicando que el
					// estudiante con ese ID no existe en la base de datos.
					System.out.println("No existe un estudiante con ese ID.");
				}
			}
			case 0 -> {
				System.out.println("Saliendo...");
			}
			default -> {
				System.out.println("La opción introducida es incorrecta.");
			}
			}

			// Mientras la opción introducida por el usuario sea distinta de 0, seguiremos
			// ejecutando el bucle do-while.
		} while (opc != 0);
	}

	/*
	 * Esta función se encarga de imprimir por consola las opciones del menú y
	 * solicitar una al usuario.
	 */
	public static void menu() {
		System.out.println("\n--- Menú de Estudiantes ---");
		System.out.println("1. Crear estudiante");
		System.out.println("2. Leer estudiante por ID");
		System.out.println("3. Actualizar estudiante");
		System.out.println("4. Eliminar estudiante");
		System.out.println("0. Salir");
		System.out.print("Elige una opción: ");
	}

	/**
	 * Esta función se encarga de solicitar todos los datos necesarios al usuario
	 * para crear un objeto de tipo Estudiante.
	 * 
	 * @return El objeto Estudiante que acabamos de crear con los datos que acabamos
	 *         de solicitar.
	 */
	public static Estudiante nuevoEstudiante() {
		// Declaramos un objeto de tipo estudiante que sera el nuevo alumno que luego
		// devolveremos.
		Estudiante est;

		// Creamos la variable id como int para almacenar el id del estudiante.
		int id;

		// Creamos la variable nombre como String para almacenar el nombre del
		// estudiante.
		String nombre;

		// Creamos la variable fNacimiento como Date para almacenar la fecha de
		// nacimiento del estudiante.
		Date fNacimiento;

		// Creamos la variable notaMedia como double para almacenar la nota media del
		// estudiante.
		double notaMedia;

		// Creamos la variable curso como String para almacenar el curso del estudiante.
		String curso;

		// Llamamos a la función pedirId para que nos devuelva un id introducido por el
		// usuario y lo almacenamos en la variable id.
		id = pedirId();

		// Llamamos a la función pedirNombre para almacenar en la variable nombre el
		// nombre introducido por el usuario.
		nombre = pedirNombre();

		// Le pedimos al usuario que introduzca la fecha de nacimiento del alumno y la
		// leemos en forma de String y luego hacemos usu del valueOf para pasar la fecha
		// a tipo Date
		System.out.print("Introduce la fecha de nacimiento (yyyy-mm-dd): ");
		String fecha = sc.nextLine();
		fNacimiento = Date.valueOf(fecha);

		// Llamamos a la función pedirNotaMedia para que nos devuelva la nota media
		// introducida por el usuario y lo almacenamos en la variable notaMedia.
		notaMedia = pedirNotaMedia();

		// Le pedimos al usuario que introduzca el curso en el que se esta matriculando
		// el nuevo alumno y lo leemos.
		System.out.print("Introduce el curso: ");
		curso = sc.nextLine();

		// Creamos el objeto de tipo estudiante con los datos que acabamos de leer.
		est = new Estudiante(id, nombre, fNacimiento, notaMedia, curso);

		// Devolvemos el estudiante que acabamos de crear
		return est;
	}

	/**
	 * Esta función se encarga de pedir al usuario que desea modificar de un
	 * estudiante y crea un objeto de ese estudiante con ese valor modificado.
	 * 
	 * @return El estudiante con alguna caracteristica cambiada.
	 */
	public static Estudiante actualizarEst() {
		// Declaramos un objeto de tipo estudiante que sera el nuevo alumno que luego
		// devolveremos.
		Estudiante est;

		// Creamos la variable id como int para almacenar el id del estudiante.
		int id;

		// Creamos la variable nombre como String para almacenar el nombre del
		// estudiante.
		String nombre = "";

		// Creamos la variable notaMedia como double para almacenar la nota media del
		// estudiante.
		double notaMedia = 0;

		// Creamos la variable opc como int para almacenar la opción de este submenú
		// introducida por el usuario.
		int opc;

		do {
			// Llamamos a la función menuActualizacion para que nos muestre todas las
			// opciones posible y nos pide que introduzcamos una.
			menuActualizacion();
			opc = sc.nextInt();
			// Leemos el buffer.
			sc.nextLine();

			do {
				// Llamamos a la función pedirId para que nos devuelva un id introducido por el
				// usuario y lo almacenamos en la variable id.
				id = pedirId();

				// Comprobamos si el estudiante con el id solicitado que vamos a modificar
				// existe, si no es así volvemos a preguntar el id de nuevo.
				est = EstudianteDAO.read(id);
			} while (est == null);

			switch (opc) {
			case 1 -> {
				// Llamamos a la función pedirNombre para almacenar en la variable nombre el
				// nombre introducido por el usuario.
				nombre = pedirNombre();

				// A la variable nota media le asignamos la misma nota ya que solo estamos
				// modificando el nombre.
				notaMedia = est.getNotaMedia();

			}
			case 2 -> {
				// Llamamos a la función pedirNotaMedia para que nos devuelva la nota media
				// introducida por el usuario y lo almacenamos en la variable notaMedia.
				notaMedia = pedirNotaMedia();

				// A la variable nombre le asignamos el mismo nombre de antes ya que solo
				// estamos modificando la nota media.
				nombre = est.getNombre();
			}
			default -> {
				System.out.println("La opción introducida es incorrecta.");
			}
			}

			// Comprobamos si la opc es distinta de 1 o 2, si es así volvemos a ejecutar el
			// bucle.
		} while (opc != 1 || opc != 2);

		// Creamos el objeto de tipo estudiante con el valor elegido actualizado.
		est = new Estudiante(id, nombre, notaMedia);

		// Devolvemos el estudiante que acabamos de crear
		return est;
	}

	/**
	 * Esta función se encarga de mostrar un menú con las opciones que podemos
	 * modificar de un estudiante.
	 */
	public static void menuActualizacion() {
		// Mostramos el menú con las distintas opciones de actualización y leemos la
		// opción seleccionada por el usuario.
		System.out.println("\n--- ¿Que deseas actualizar? ---");
		System.out.println("1. Nombre");
		System.out.println("2. Nota media");
		System.out.print("Elige una opción: ");
	}

	/**
	 * Le pedimos al usuario el id de un alumno y devolvemos el id que introduce por
	 * teclado.
	 * 
	 * @return El id introducido por el usuario.
	 */
	public static int pedirId() {
		// Creamos la variable id como int para almacenar el id del estudiante.
		int id;

		// Le pedimos al usuario que introduzca el id del nuevo alumno y lo leemos.
		System.out.print("Introduce el ID: ");
		id = sc.nextInt();
		// Limpiamos el buffer.
		sc.nextLine();

		// Devolvemos el id del estudiante.
		return id;
	}

	/**
	 * Esta función se encarga de pedir al usuario el nombre de un estudiante.
	 * 
	 * @return El nombre introducido por el usuario.
	 */
	public static String pedirNombre() {
		// Creamos la variable nombre como String para almacenar el nombre del
		// estudiante.
		String nombre;

		// Le pedimos al usuario que introduzca el nombre del nuevo alumno y lo leemos.
		System.out.print("Introduce el nombre: ");
		nombre = sc.nextLine();

		// Devolvemos el nombre que le acabamos de solicitar al usuario.
		return nombre;
	}

	/**
	 * Esta función se encarga de pedir al usuario la nota media de un estudiante.
	 * 
	 * @return La nota media introducida por el usuario.
	 */
	public static double pedirNotaMedia() {
		// Creamos la variable notaMedia como double para almacenar la nota media del
		// estudiante.
		double notaMedia;

		// Le pedimos al usuario que introduzca la nota media del nuevo alumno y la
		// leemos.
		System.out.print("Introduce la nota media: ");
		notaMedia = sc.nextDouble();
		// Limpiamos el buffer.
		sc.nextLine();

		// Devolvemos la nota media que le acabamos de solicitar al usuario.
		return notaMedia;
	}
}
