/*Codigo estudiante: 201943758
 * Programa: 2711
 * Victor Alomia
 * Programacion interactiva
 * 
 */
package arcadenoe;

import java.util.Random;
import java.util.Vector;

// TODO: Auto-generated Javadoc
/**
 * The Class ControlArcaNoe.
 */
public class ControlArcaNoe {

	/** The estado ronda. */
	private static int estadoRonda = 1;

	/** The encontro. */
	private static boolean encontro = false;

	/** The fin. */
	private boolean fin = false;

	/** The vector. */
	private Vector<Carta> vector = new Vector<Carta>(2);

	/** The carta. */
	private Carta[] carta;

	/** The aciertos. */
	private int puntaje, aciertos;

	/**
	 * Instantiates a new control arca noe. Constructor de la clase control donde se
	 * inicializa los espacios del vector para lamacenar los valores
	 */
	public ControlArcaNoe() {
		// inicializa el espacio de las caratas
		carta = new Carta[(estadoRonda * 2) + 2];
		iniciarVector();
		mezclaCarta();

	}

	/**
	 * Iniciar vector.Esta funcion es la encargada de inicializar las cartas en el
	 * vector dando su numero identificador
	 */
// iniciamos las carats en el arreglo 
	public void iniciarVector() {
		carta = new Carta[(estadoRonda * 2) + 2];
		for (int i = 0; i < (estadoRonda + 1); i++) {
			carta[i] = new Carta(i + 1);
			carta[i + estadoRonda + 1] = new Carta(i + 1);

		}
	}

	/**
	 * Mezcla carta.Esta funcion es la encargada de desordenar las cartas en el
	 * vector o mezclarlas
	 */
	public void mezclaCarta() {
		Carta carta1;
		Carta carta2;

		Random ran = new Random();

		int valoRan;
		int verificaRan;

		for (int i = 0; i < carta.length * carta.length; i++) {

			valoRan = ran.nextInt(carta.length);
			verificaRan = ran.nextInt(carta.length);

			while (valoRan == verificaRan) {
				valoRan = ran.nextInt(carta.length);
				verificaRan = ran.nextInt(carta.length);
			}

			if (carta[valoRan].getRota1() != carta[verificaRan].getRota1()) {

				carta1 = carta[valoRan];
				carta2 = carta[verificaRan];

				carta[valoRan] = carta2;
				carta[verificaRan] = carta1;

				carta[verificaRan].setPosicion(verificaRan);
				carta[valoRan].setPosicion(valoRan);

			} else {
				i--;
			}

		}

	}

	/**
	 * Ver array.Imprime el vector en consola
	 */
	private void verArray() {
		// TODO Auto-generated method stub
		for (int i = 0; i < carta.length; i++) {
			System.out.println("Index " + i + " Carta " + carta[i].getRota1() + " Posicion " + carta[i].getPosicion());
		}
	}

	/**
	 * Validar cartas.
	 * Esta funcion es la encargada de validar si dos cartas pintadas son iguales
	 *
	 * @param cart the cart
	 */
// valida si dos cartas pintadas en el tablero son iguales 
	public void ValidarCartas(Carta cart) {

		if (cart.getIcon() == cart.getImagenReverso()) {

			cart.setIcon(cart.getImagenFrontal());

			vector.addElement(cart);
		}
		if (vector.size() == 2) {
			if (vector.elementAt(0).getRota1() == vector.elementAt(1).getRota1()) {
				encontro = true;
			}

		} else {
			encontro = false;
		}

	}

	/**
	 * Aumento ronda.
	 * Esta funcion es la encargada de aumentar la ronda en cada partida del juego
	 */
	// umentando el estado de la ronda
	public void aumentoRonda() {
		if (estadoRonda < 5) {
			estadoRonda++;
		}

	}

	/**
	 * Limpiar vector.
	 * Borra los elementos del vector
	 */
	// limpiando el vector
	public void limpiarVector() {
		vector.removeAllElements();
	}

	// metodo para sumar el puntaje

	/**
	 * Suma puntaje.
	 * Esta funcion es la encargada de sumar el puntaje y los aciertos del juego
	 */
	public void sumaPuntaje() {
		if (encontro) {
			puntaje += 50;
			aciertos += 1;
			encontro = false;

		} else if (vector.size() == 2 && (vector.elementAt(0).isMeVolteo() || vector.elementAt(1).isMeVolteo())
				&& puntaje > 0) {
			puntaje -= 50;
		}
		if (vector.size() == 2 && (vector.elementAt(0).isMeVolteo() || vector.elementAt(1).isMeVolteo())
				&& puntaje == 0) {
			fin = true;
		}

	}

	/**
	 * Reiniciar juego.
	 * esta funcion permite reiniciar el jugo restableciendo el estado inicial del juego
	 */
	public void reiniciarJuego() {
		puntaje = 0;
		aciertos = 0;
		encontro = false;
		fin = false;
		estadoRonda = 1;
		vector.removeAllElements();
		iniciarVector();
		mezclaCarta();
	}

	/**
	 * Checks if is fin.
	 *
	 * @return true, if is fin
	 */
	public boolean isFin() {
		return fin;
	}

	// getter and setter

	/**
	 * Gets the estado ronda.
	 *
	 * @return the estado ronda
	 */
	public static int getEstadoRonda() {
		return estadoRonda;
	}

	/**
	 * Gets the vector.
	 *
	 * @return the vector
	 */
	public Vector<Carta> getVector() {
		return vector;
	}

	/**
	 * Gets the puntaje.
	 *
	 * @return the puntaje
	 */
	public int getPuntaje() {
		return puntaje;
	}

	/**
	 * Gets the aciertos.
	 *
	 * @return the aciertos
	 */
	public int getAciertos() {
		return aciertos;
	}

	/**
	 * Gets the carta.
	 *
	 * @return the carta
	 */
	public Carta[] getCarta() {
		return carta;
	}

}