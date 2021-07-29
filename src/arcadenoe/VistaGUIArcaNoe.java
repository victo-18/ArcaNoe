package arcadenoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.Timer;
import javax.swing.border.TitledBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class VistaGUIArcaNoe.
 */
public class VistaGUIArcaNoe extends JFrame {
	
	/** The reiniciar. */
	
	private JButton salir, jugar, reiniciar;
	
	/** The image. */
	private Carta[] image;
	
	/** The zona juego. */
	private JPanel zonaJuego;
	
	/** The botones. */
	private JPanel lienzo, botones;
	
	/** The ventana. */
	private JFrame ventana = this;
	
	/** The aciertos. */
	private JLabel puntaje, aciertos;
	
	/** The escucha. */
	private Escucha escucha;
	
	/** The control arca noe. */
	
	private ControlArcaNoe controlArcaNoe;
	
	/** The timer. */
	private Timer timer;
	
	/** The contador cartas. */
	private int contadorCartas;
	
	/** The limite clik.Valida el numero de click */
	private boolean limiteClik = false;
	

	/**
	 * Instantiates a new vista GUI arca noe.Constructor de la clase vista para inicializar la ventana y darle 
	 * sus atributos
	 */
	// constructor
	public VistaGUIArcaNoe() {

		initGUI();

		// congifuracion ventana
		
		pack();
		this.setVisible(true);//visibilidad 
		this.setLocationRelativeTo(null);//ubicacion
		this.setBackground(getForeground());//fondo de la ventana
		this.setResizable(false);//no permitir el cambio de tamaño
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//cerrado
		
	}

	/**
	 * Inits the GUI.Constructor de la de la vista se crean e inicializan los 
	 * objectos para ser añadidos a la ventana
	 */
	public void initGUI() {
		// definir contenedor
		Container contenedor = this.getContentPane();
		contenedor.setLayout(new GridBagLayout());
		GridBagConstraints limit = new GridBagConstraints();

		// crear la GUI
		//
		// crear el escucha
		escucha = new Escucha();
		controlArcaNoe = new ControlArcaNoe();
		timer = new Timer(1000, escucha);

		// crear titulo
		Titulo titulo = new Titulo("Arca de noe", 20, new Color(84, 110, 122));
		limit.gridx = 0;
		limit.gridy = 0;
		limit.gridwidth = 1;
		limit.gridheight = 1;
		limit.fill = GridBagConstraints.HORIZONTAL;
		limit.anchor = GridBagConstraints.CENTER;
		add(titulo, limit);

		// creando espacio puntaje
		lienzo = new JPanel();
		puntaje = new JLabel("0");
		TitledBorder puntajeBorde = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),
				"Puntaje");
		puntaje.setBorder(puntajeBorde);
		puntaje.setPreferredSize(new Dimension(80, 35));
		lienzo.add(puntaje);

		// casilla acierto
		aciertos = new JLabel("0");
		TitledBorder aciertoBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),
				"aciertos");
		aciertos.setBorder(aciertoBorder);
		aciertos.setPreferredSize(new Dimension(80, 35));
		lienzo.add(aciertos);
		limit.gridx = 0;
		limit.gridy = 1;
		limit.gridwidth = 1;
		limit.gridheight = 1;
		limit.fill = GridBagConstraints.NONE;
		limit.anchor = GridBagConstraints.CENTER;
		add(lienzo, limit);

		// creando Jpanel para imagenes
		zonaJuego = new JPanel();//
		// tamaño de la pantalla
		zonaJuego.setPreferredSize(new Dimension(500, 330));

		// pintarBotones en la ventana();
		limit.gridx = 0;
		limit.gridy = 2;
		limit.gridwidth = 1;
		limit.gridheight = 1;
		limit.fill = GridBagConstraints.NONE;
		limit.anchor = GridBagConstraints.CENTER;
		add(zonaJuego, limit);

		// botonoes Reiniciar
		botones = new JPanel();
		reiniciar = new JButton("reiniciar");
		reiniciar.setEnabled(false);
		reiniciar.addActionListener(escucha);

		// boton jugar
		jugar = new JButton("jugar");
		jugar.addActionListener(escucha);

		// boton salir
		salir = new JButton("salir");
		salir.addActionListener(escucha);
		salir.addActionListener(escucha);
		botones.add(reiniciar);
		botones.add(jugar);
		botones.add(salir);
		limit.gridx = 0;
		limit.gridy = 3;
		limit.gridwidth = 1;
		limit.gridheight = 1;
		limit.fill = GridBagConstraints.NONE;
		limit.anchor = GridBagConstraints.CENTER;
		add(botones, limit);

	}

	/**
	 * Sube cartas tablero.Carga las cartas al tablero y cambia sus propiedades 
	 */
	private void subeCartasTablero() {

		Carta[] cartV = controlArcaNoe.getCarta();
		image = cartV;

		for (int i = 0; i < cartV.length; i++) {
			image[i].setIcon(cartV[i].getImagenReverso());
			image[i].addMouseListener(escucha);
			image[i].setVisible(false);
			zonaJuego.add(image[i]);
		}
	}

	/**
	 * The Class Escucha.implementa los eventos del maouse permitiendo la interacion del jugador con el programa
	 */
	private class Escucha extends MouseAdapter  implements ActionListener, MouseListener {

		/**
		 * Action performed.Evento del mouse que permite la utilizacion e 
		 * implementacion de los botones de la intefaz
		 *
		 * @param event the event
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			if (event.getSource() == salir) {//verifica si el objeto generador es el boton salir
				System.exit(0);//cierra el programa
			} else if (event.getSource() == jugar) {
				subeCartasTablero();
				for (int i = 0; i < image.length; i++) {
					image[i].setVisible(true);
				}

				jugar.setEnabled(false);//se le quita la visibilidad al boton
				
				controlArcaNoe.sumaPuntaje();
				puntaje.setText(String.valueOf(controlArcaNoe.getPuntaje()));//muestra el puntaje en la pantalla
				aciertos.setText(String.valueOf(controlArcaNoe.getAciertos()));//muestra los aciertos en la pantalla
				pack();
				ventana.setLocationRelativeTo(null);
			} else if (event.getSource() == reiniciar) {
				zonaJuego.setVisible(false);
				reiniciar.setEnabled(false);
				zonaJuego.removeAll();
				controlArcaNoe.reiniciarJuego();
				zonaJuego.setVisible(true);
				jugar.setEnabled(true);

			} else if (event.getSource() == timer) {
				timer.stop();
				controlArcaNoe.sumaPuntaje();
				Vector<Carta> vandera = controlArcaNoe.getVector();

				if (vandera.elementAt(0).getRota1() == vandera.elementAt(1).getRota1()) {

					image[vandera.elementAt(0).getPosicion()].setEnabled(false);
					image[vandera.elementAt(1).getPosicion()].setEnabled(false);
					contadorCartas += 2;

				} else {
					image[vandera.elementAt(0).getPosicion()]
							.setIcon(image[vandera.elementAt(0).getPosicion()].getImagenReverso());

					image[vandera.elementAt(1).getPosicion()]
							.setIcon(image[vandera.elementAt(1).getPosicion()].getImagenReverso());
					image[vandera.elementAt(0).getPosicion()].setMeVolteo();
					image[vandera.elementAt(1).getPosicion()].setMeVolteo();
				}

				controlArcaNoe.limpiarVector();
				limiteClik = false;
				puntaje.setText(String.valueOf(controlArcaNoe.getPuntaje()));
				aciertos.setText(String.valueOf(controlArcaNoe.getAciertos()));
				if (contadorCartas == image.length) {
					contadorCartas = 0;
					zonaJuego.setVisible(false);
					zonaJuego.removeAll();
					zonaJuego.setVisible(true);
					controlArcaNoe.aumentoRonda();
					controlArcaNoe.iniciarVector();
					controlArcaNoe.mezclaCarta();
					subeCartasTablero();
					jugar.setEnabled(true);
					JOptionPane.showMessageDialog(null, "Nuevo ronda pulsa jugar para continuar");

				}
				if (controlArcaNoe.isFin()) {
					reiniciar.setEnabled(true);
					zonaJuego.setVisible(false);
					zonaJuego.removeAll();
					zonaJuego.setVisible(true);
					pack();
					ventana.setLocationRelativeTo(null);
					JOptionPane.showMessageDialog(null, "Has perdido!! te quedaste sin puntos");
				}

			}

		}

		/**
		 * Mouse clicked.
		 *
		 * @param event the event
		 */
		@Override
		public void mouseClicked(MouseEvent event) {
			// TODO Auto-generated method stub
			if (!limiteClik) {
				Carta clik = (Carta) event.getSource();
				controlArcaNoe.ValidarCartas(clik);

				Vector<Carta> vandera = controlArcaNoe.getVector();

				if (vandera.size() == 2) {
					timer.start();
					limiteClik = true;

				}
			}
		}
	}

}