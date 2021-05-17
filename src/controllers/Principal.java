package controllers;

import java.awt.EventQueue;

import vista.Login;

public class Principal {

	public static void main(String[] args) {

		/* ********************************************************************************

						Llamada a la ventana Login y ejecucion del programa

		 ******************************************************************************** */
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
			
				try {
				
					Login frame = new Login();
					frame.setVisible(true);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				
				}
			
			}
			
		});
		
	}

}
