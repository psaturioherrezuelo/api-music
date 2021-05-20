package controllers;

import java.awt.EventQueue;

import models.Database;
import views.Insertar;
import views.Login;

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
					
//					Insertar a = new Insertar();
//					a.setVisible(true);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				
				}
			
			}
			
		});
		
	}

}
