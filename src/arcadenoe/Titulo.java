package arcadenoe;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**Codigo estudiante:201943758
 * Programa: 2711
 * Programacion interactiva
 * The Class Titulo.
 */
public class Titulo extends JLabel {
	
	/**
	 * Instantiates a new titulo.Esta clase se encarga de crear el titulo de la ventana
	 *
	 * @param texto the texto
	 * @param tamano the tamano
	 * @param colorfondo the colorfondo
	 */
	public Titulo(String texto, int tamano, Color colorfondo) {
		this.setText(texto);//modifica el texto
		Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, tamano);//tamaño y tipo de letra y color
		this.setFont(font);//para modoficar las letras
		this.setBackground(colorfondo);//dandole color de fondo
		this.setForeground(Color.WHITE);//modificando el color de fondo
		this.setHorizontalAlignment(CENTER);//posicion del titulo 
		this.setOpaque(true);

	}

}
