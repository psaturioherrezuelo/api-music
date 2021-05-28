package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controllers.ControllerFiles;
import controllers.ControllerModels;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Register extends JFrame implements WindowListener, ActionListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnReg, btnCancel;
	private JLabel lblUser;
	private JTextField textUser;
	private JLabel lblNombre;
	private JTextField textNombre;
	private JLabel lblDireccion;
	private JTextField textDireccion;
	private JLabel lblPass;
	private JPasswordField textPass;
	private JLabel lblPass2;
	private JPasswordField textPass2;
	private JLabel lblApellidos;
	private JTextField textApellidos;
	private JLabel lblEmail;
	private JTextField textEmail;
	private JLabel lblLogoImg;
	
	private ControllerModels cm = new ControllerModels();
	private ControllerFiles cf = new ControllerFiles();
	
	public Register() {
		setBackground(Color.BLACK);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource(cf.getIconoBlue())));
		setResizable(false);
		addWindowListener(this);
		setTitle("Register Api Music");
		
		setBounds(100, 100, 800, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(85, 100, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblUser = new JLabel("Usuario");
			lblUser.setForeground(Color.WHITE);
			lblUser.setHorizontalAlignment(SwingConstants.CENTER);
			lblUser.setBounds(197, 21, 46, 14);
			contentPanel.add(lblUser);
		}
		{
			textUser = new JTextField();
			textUser.setBounds(52, 46, 328, 20);
			contentPanel.add(textUser);
			textUser.setColumns(10);
		}
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombre.setBounds(195, 171, 46, 14);
			contentPanel.add(lblNombre);
		}
		{
			textNombre = new JTextField();
			textNombre.setBounds(51, 190, 328, 20);
			contentPanel.add(textNombre);
			textNombre.setColumns(10);
		}
		{
			lblDireccion = new JLabel("Direccion");
			lblDireccion.setForeground(Color.WHITE);
			lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
			lblDireccion.setBounds(186, 269, 70, 14);
			contentPanel.add(lblDireccion);
		}
		{
			textDireccion = new JTextField();
			textDireccion.setBounds(50, 289, 328, 20);
			contentPanel.add(textDireccion);
			textDireccion.setColumns(10);
		}
		{
			lblPass = new JLabel("Contrase\u00F1a");
			lblPass.setForeground(Color.WHITE);
			lblPass.setHorizontalAlignment(SwingConstants.CENTER);
			lblPass.setBounds(186, 72, 67, 14);
			contentPanel.add(lblPass);
		}
		{

			textPass = new JPasswordField();
			textPass.setBounds(51, 92, 328, 20);
			contentPanel.add(textPass);
			textPass.setColumns(10);
		}
		{
			lblPass2 = new JLabel("Confirmar contrase\u00F1a");
			lblPass2.setForeground(Color.WHITE);
			lblPass2.setHorizontalAlignment(SwingConstants.CENTER);
			lblPass2.setBounds(154, 122, 127, 14);
			contentPanel.add(lblPass2);
		}
		{

			textPass2 = new JPasswordField();
			textPass2.setBounds(52, 144, 328, 20);
			contentPanel.add(textPass2);
			textPass2.setColumns(10);
		}
		{
			lblApellidos = new JLabel("Apellidos");
			lblApellidos.setForeground(Color.WHITE);
			lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
			lblApellidos.setBounds(182, 219, 73, 14);
			contentPanel.add(lblApellidos);
		}
		{
			textApellidos = new JTextField();
			textApellidos.setColumns(10);
			textApellidos.setBounds(51, 241, 328, 20);
			contentPanel.add(textApellidos);
		}
		{
			lblEmail = new JLabel("Email");
			lblEmail.setForeground(Color.WHITE);
			lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmail.setBounds(197, 317, 51, 14);
			contentPanel.add(lblEmail);
		}
		{
			textEmail = new JTextField();
			textEmail.setColumns(10);
			textEmail.setBounds(52, 339, 328, 20);
			contentPanel.add(textEmail);
		}
		{
			lblLogoImg = new JLabel("");
			lblLogoImg.setIcon(new ImageIcon(Register.class.getResource(cf.getLogoWhite())));
			lblLogoImg.setBounds(475, 83, 250, 235);
			contentPanel.add(lblLogoImg);
		}
		
		JLabel imgBackground = new JLabel("");
		imgBackground.setIcon(new ImageIcon(Register.class.getResource(cf.getBackground())));
		imgBackground.setBounds(-532, -340, 1328, 763);
		contentPanel.add(imgBackground);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			buttonPane.setBackground(Color.BLACK);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnReg = new JButton("Registrarse");
				btnReg.setActionCommand("Registrar");
				btnReg.addActionListener(this);
				buttonPane.add(btnReg);
				getRootPane().setDefaultButton(btnReg);
			}
			{
				btnCancel = new JButton("Cancelar");
				btnCancel.setActionCommand("Cancelar");
				btnCancel.addActionListener(this);
				buttonPane.add(btnCancel);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String tocar="";
		
		if (e.getSource() == btnReg) {
			
			if(textUser.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "¡El usuario esta vacio!", "Introduzca usuario", JOptionPane.ERROR_MESSAGE);
				
			} else if (textPass.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "¡La contraseña esta vacia!", "Introduzca contraseña", JOptionPane.ERROR_MESSAGE);
				
			} else if (textPass2.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "¡La comprobacion de contraseña esta vacia!", "Vuelva a introducir la contraseña", JOptionPane.ERROR_MESSAGE);
				
			} else if(textEmail.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "¡El Email esta vacio!", "Introduzca Email", JOptionPane.ERROR_MESSAGE);
				
			} else {
				
				if(textPass.getText().equals(textPass2.getText())) {
					
					try {
						
						cm.register(textUser.getText(),textPass.getText(),textNombre.getText(),textApellidos.getText(),textEmail.getText(),textDireccion.getText());
						JOptionPane.showMessageDialog(null, "¡Registro completado con exito!", "¡Completado!", JOptionPane.INFORMATION_MESSAGE);
						pasarCampos();
						dispose();
						
						
					} catch (ClassNotFoundException e1) {
						
						e1.printStackTrace();
					
					} catch (SQLException e1) {
					
						e1.printStackTrace();
					
					}
					
				} else {
					
					JOptionPane.showMessageDialog(null, "¡Las contraseñas no coinciden!", "Error", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
			
			System.out.println(tocar);
			
		} else if(e.getSource() == btnCancel) {
			
			dispose();
			new Login().setVisible(true); //REVISAR PARA NO CARGAR EL PROGRAMA 200 VECES
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		Login log = new Login();
		log.setVisible(true);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}
	
	public void pasarCampos() { // Pasar los parametros si llega a ser necesario
		
		String campos [] = new String[2];
		
		campos[0] = textUser.getText();
		campos[1] = textPass.getText();
		
		Login frame = new Login();
		frame.set(campos);
		frame.setVisible(true);
		
	}
	
}
