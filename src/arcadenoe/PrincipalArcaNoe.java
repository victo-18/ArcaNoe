package arcadenoe;

import java.awt.EventQueue;



public class PrincipalArcaNoe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				VistaGUIArcaNoe  myVista = new VistaGUIArcaNoe();
			}
		});

	}

}
