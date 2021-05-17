package controllers;

import java.awt.EventQueue;

import vista.Login;
import vista.Register;

public class Principal {

	public static void main(String[] args) {

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
