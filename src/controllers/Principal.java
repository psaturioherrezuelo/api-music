package controllers;

import java.awt.EventQueue;
import java.sql.SQLException;

import views.Login;
import views.ErrorConexion;
import models.Database;

public class Principal {
	
	
	public static void main(String[] args) {

		/* ********************************************************************************

						Llamada a la ventana Login y ejecucion del programa

		 ******************************************************************************** */
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				 Database bd = new Database();
				try {
					//Verificamos de que tenemos conexion con la base de datos
					bd.conexion();
					
					try {
						//Llamamos a la ventana de Login
						Login frame = new Login();
						frame.setVisible(true);
					} catch (Exception e) {
						
						e.printStackTrace();
					
					}
					bd.getConn().close();	        	
		        } catch (SQLException | ClassNotFoundException e) {
		        	//En caso de Error mostramos una ventana emergente de error y con el error en cuestion
					try {
																			//enviamos el mensaje a la vista emergente
						ErrorConexion frameErrorConexion = new ErrorConexion(e.getMessage());
						frameErrorConexion.setVisible(true);
						
					} catch (Exception ee) {
						
						ee.printStackTrace();
					
					}
					
		        	
		        }
				
			
			}
			
		});
		
	}

}
