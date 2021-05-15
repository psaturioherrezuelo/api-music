package vista;

import java.awt.EventQueue;

import controllers.ControllerApiMusic;

public class vacio {

	public static void main(String[] args) {
		
		ControllerApiMusic p = new ControllerApiMusic();
		
		p.conexion();
		p.imprimir();
		
//		EventQueue.invokeLater(new Runnable() {
//			
//			public void run() {
//				try {
//					Ventana frame = new Ventana();
//					frame.setVisible(true);
//					p.login(null, null)
//					frame.login(null, null);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			
//		});
		
	}
	
}
