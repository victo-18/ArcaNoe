/*Codigo estudiante: 201943758
 * Victor Alomia
 * Programa: 2711
 * Programacion interactiva
 */
package arcadenoe;

import java.awt.Color;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**
 * The Class Carta.
 */
public class Carta extends JLabel {
	
	/** The rota 1. */
	private int rota1;// animal
	
	/** The imagen frontal. */
	private ImageIcon imagenFrontal;
	
	/** The imagen reverso. */
	private ImageIcon imagenReverso;
	
	/** The me volteo. */
	private boolean meVolteo = false;
	
	/** The posicion. */
	private int posicion = -1;

	/**
	 * Instantiates a new carta.Constructor de la clase donde se le dan los atributos a la carta
	 *
	 * @param rota the rota
	 */
	public Carta(int rota) {
		this.rota1 = rota;
		this.imagenFrontal = new ImageIcon("src/imagenes/" + rota1 + ".jpg");// carga la imagen
		this.imagenReverso = new ImageIcon("src/imagenes/0s.jpg");// se carga imagen de reverso

	}

	/**
	 * Gets the rota 1.
	 *
	 * @return the rota 1
	 */
	public int getRota1() {
		return rota1;
	}

	/**
	 * Gets the imagen frontal.
	 *
	 * @return the imagen frontal
	 */
	public ImageIcon getImagenFrontal() {
		return imagenFrontal;
	}

	/**
	 * Gets the imagen reverso.
	 *
	 * @return the imagen reverso
	 */
	public ImageIcon getImagenReverso() {
		return imagenReverso;
	}

	/**
	 * Checks if is me volteo.
	 *
	 * @return true, if is me volteo
	 */
	public boolean isMeVolteo() {
		return meVolteo;
	}

	/**
	 * Sets the me volteo.
	 */
	public void setMeVolteo() {

		this.meVolteo = true;
	}

	/**
	 * Gets the posicion.
	 *
	 * @return the posicion
	 */
	public int getPosicion() {
		return posicion;
	}

	/**
	 * Sets the posicion.
	 *
	 * @param posicion the new posicion
	 */
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

}
