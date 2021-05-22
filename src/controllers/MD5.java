package controllers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//INFO https://www.geeksforgeeks.org/md5-hash-in-java/

public class MD5 {
	
	public String codificarPass(String pass) {
		
		try {
			
			//Instanciamos el metodo con el tipo de inpriptado
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			//Devuelve el array en Byte
			byte[] messageDigest = md.digest(pass.getBytes());
            
			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);
			
			// Convertimos contrasena
			String hashtext = no.toString(16);
			
			// Convertir el resumen del mensaje en valor hexadecimal
            while (hashtext.length() < 32) {
            
            	hashtext = "0" + hashtext;
            
            }
            
            return hashtext;
            
		} catch (NoSuchAlgorithmException e) {
            
			throw new RuntimeException(e);
		
		}
	
	}
	
}
