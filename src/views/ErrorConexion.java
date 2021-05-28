package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import controllers.ControllerFiles;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;

public class ErrorConexion extends JFrame {

	private JPanel contentPane;
	private ControllerFiles cf = new ControllerFiles();

	public ErrorConexion(String Error) {
		setBackground(new Color(0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource(cf.getIconoBlue())));
		setResizable(false);
		setTitle("Login Api Music Error Base de datos");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 226);
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(217, 37, 17));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel(Error);
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(94, 46, 610, 142);
		contentPane.add(lblUser);
		
		JLabel lblNewLabel = new JLabel("Error de conexi\u00F3n con la Base de Datos");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(276, 30, 250, 14);
		contentPane.add(lblNewLabel);
		
		this.setLocationRelativeTo(null);
		
	}
	
}
