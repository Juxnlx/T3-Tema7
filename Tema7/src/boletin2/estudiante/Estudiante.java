package boletin2.estudiante;

import java.util.Date;

public class Estudiante {

	// Creamos el atributo id como int para almacenar el id del estudiante.
	private int id;

	// Creamos el atributo nombre como String para almacenar el nombre del
	// estudiante.
	private String nombre;

	// Creamos la variable fNacimiento como Date para almacenar la fecha de
	// nacimiento del estudiante.
	private Date fNacimiento;

	// Creamos la variable notaMedia como double para almacenar la nota media del
	// estudiante.
	private double notaMedia;

	// Creamos la variable curso como String para almacenar el curso del estudiante.
	private String curso;

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
		this.id = id;
		this.nombre = nombre;
		this.fNacimiento = fNacimiento;
		this.notaMedia = notaMedia;
		this.curso = curso;
	}

}
