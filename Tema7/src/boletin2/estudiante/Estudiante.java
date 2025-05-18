package boletin2.estudiante;

import java.util.Date;

public class Estudiante {

	// Creamos el atributo id como int para almacenar el id del estudiante.
	private int id;

	// Creamos el atributo nombre como String para almacenar el nombre del
	// estudiante.
	private String nombre;

	// Creamos el atributo fNacimiento como Date para almacenar la fecha de
	// nacimiento del estudiante.
	private Date fNacimiento;

	// Creamos el atributo notaMedia como double para almacenar la nota media del
	// estudiante.
	private double notaMedia;

	// Creamos el atributo curso como String para almacenar el curso del estudiante.
	private String curso;

	/**
	 * Creamos un constructor con el id, el nombre y la nota media, ya que son los
	 * parametros que necesito para realizar una actualización.
	 * 
	 * @param id        El id del estudiante.
	 * @param nombre    El nombre del estudiante.
	 * @param notaMedia La nota media del estudiante.
	 */
	public Estudiante(int id, String nombre, double notaMedia) {
		if (id >= 0) {
			this.id = id;
		}

		if (nombre != null && !nombre.isBlank()) {
			this.nombre = nombre;
		}

		if (notaMedia >= 0) {
			this.notaMedia = notaMedia;
		}
	}

	/**
	 * Creamos el constructor con todos los atributos de la clase Estudiante.
	 * 
	 * @param id          El id del estudiante.
	 * @param nombre      El nombre del estudiante.
	 * @param fNacimiento La fecha de nacimiento del estudiante.
	 * @param notaMedia   La nota media del estudiante.
	 * @param curso       El curso del estudiante.
	 */
	public Estudiante(int id, String nombre, Date fNacimiento, double notaMedia, String curso) {
		this(id, nombre, notaMedia);

		if (fNacimiento != null) {
			this.fNacimiento = fNacimiento;
		}

		if (curso != null && !curso.isBlank()) {
			this.curso = curso;
		}
	}

	/**
	 * Esta función se encarga de devolver el nombre del estudiante.
	 * 
	 * @return El nombre del estudiante.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Esta función se encarga de modificar el nombre del estudiante.
	 * 
	 * @param nombre El nuevo nombre del estudiante.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Esta función se encarga de devolver la nota media del estudiante.
	 * 
	 * @return La nota media del estudiante.
	 */
	public double getNotaMedia() {
		return notaMedia;
	}

	/**
	 * Esta función se encarga de modificar la nota media del estudiante.
	 * 
	 * @param notaMedia La nueva nota media del estudiante.
	 */
	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	/**
	 * Esta función se encarga de devolver el dni del estudiante.
	 * 
	 * @return El id del estudiante.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Esta función se encarga de devolver la fecha de nacimiento del estudiante.
	 * 
	 * @return La fecha de nacimiento del estudiante.
	 */
	public Date getfNacimiento() {
		return fNacimiento;
	}

	/**
	 * Esta función se encarga de devolver el curso escolar del estudiante.
	 * 
	 * @return El curso actual del estudiante.
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * Esta función se encarga de devolver si dos estudiantes son iguales o no,
	 * basandonos el el id del estudiante.
	 * 
	 * @param obj Objeto de tipo Objeto pasado como parametro.
	 * @return true si los objetos estudiantes son iguales, false si no lo son.
	 */
	@Override
	public boolean equals(Object obj) {
		// Creamos la variable esIgual como boolena para almacenar si el dni actual es
		// igual al pasado como parametro.
		boolean esIgual = false;

		// Hacemos un casteo a Estudiante.
		Estudiante e = (Estudiante) obj;

		// Comprobamos si el id actual y el pasado como parametro son iguales, si es así
		// indicamos la variable esIgual a true.
		if (this.id == e.id) {
			esIgual = true;
		}

		// Devolvemos la variable esIgual.
		return esIgual;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		// Creamos la variable infoEst como String para almacenar la información que
		// queremos mostrar del estudiante.
		String infoEst;

		// Vamos concatenando en la variable infoEst la información que queremos mostrar
		// del estudiante.
		infoEst = "id: " + this.id + " | ";
		infoEst += "Nombre: " + this.nombre + " | ";
		infoEst += "Fecha de nacimiento: " + this.fNacimiento + " | ";
		infoEst += "Nota media: " + this.notaMedia + " | ";
		infoEst += "Curso: " + this.curso;

		// Devolvemos la variable con todo la información del estudiante.
		return infoEst;
	}

}
