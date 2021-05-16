package vista;

import java.awt.EventQueue;

import controllers.ControllerWindows;
import controllers.ControllerApiMusic;

public class vacio {

	public static void main(String[] args) {
		
		ControllerApiMusic p = new ControllerApiMusic();
		ControllerWindows cv = new ControllerWindows();
		
		
		
		p.conexion();
		p.imprimir();
		
//		EventQueue.invokeLater(new Runnable() {
//			
//			public void run() {
//				try {
//					Login frame = new Login();
//					frame.setVisible(true);
//
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			
//		});
		
	}
	
}
