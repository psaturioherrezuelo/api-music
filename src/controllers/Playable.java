package controllers;

import java.awt.EventQueue;

import vista.Login;

public class Playable {
	
	public static void play() {
		
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
