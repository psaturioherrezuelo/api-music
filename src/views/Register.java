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
import javax.swing.JDialog;
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

public class Register extends JDialog implements WindowListener, ActionListener, MouseListener {

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
	private JLabel lblApellidos;
	private JTextField textApellidos;
	private JLabel lblEmail;
	private JTextField textEmail;
	private JLabel lblLogoImg;
	
	private ControllerModels cm = new ControllerModels();
	private ControllerFiles cf = new ControllerFiles();
	
	public Register() {
		setBackground(Color.BLACK);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource(cf.getIconoBlack())));
		setResizable(false);
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
			lblUser.setBounds(196, 33, 46, 14);
			contentPanel.add(lblUser);
		}
		{
			textUser = new JTextField();
			textUser.setBounds(51, 58, 328, 20);
			contentPanel.add(textUser);
			textUser.setColumns(10);
		}
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombre.setBounds(196, 145, 46, 14);
			contentPanel.add(lblNombre);
		}
		{
			textNombre = new JTextField();
			textNombre.setBounds(51, 170, 328, 20);
			contentPanel.add(textNombre);
			textNombre.setColumns(10);
		}
		{
			lblDireccion = new JLabel("Direccion");
			lblDireccion.setForeground(Color.WHITE);
			lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
			lblDireccion.setBounds(186, 257, 70, 14);
			contentPanel.add(lblDireccion);
		}
		{
			textDireccion = new JTextField();
			textDireccion.setBounds(51, 282, 328, 20);
			contentPanel.add(textDireccion);
			textDireccion.setColumns(10);
		}
		{
			lblPass = new JLabel("Contrase\u00F1a");
			lblPass.setForeground(Color.WHITE);
			lblPass.setHorizontalAlignment(SwingConstants.CENTER);
			lblPass.setBounds(186, 89, 67, 14);
			contentPanel.add(lblPass);
		}
		{

			textPass = new JPasswordField();
			textPass.setBounds(51, 114, 328, 20);
			contentPanel.add(textPass);
			textPass.setColumns(10);
		}
		{
			lblApellidos = new JLabel("Apellidos");
			lblApellidos.setForeground(Color.WHITE);
			lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
			lblApellidos.setBounds(183, 201, 73, 14);
			contentPanel.add(lblApellidos);
		}
		{
			textApellidos = new JTextField();
			textApellidos.setColumns(10);
			textApellidos.setBounds(51, 226, 328, 20);
			contentPanel.add(textApellidos);
		}
		{
			lblEmail = new JLabel("Email");
			lblEmail.setForeground(Color.WHITE);
			lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmail.setBounds(196, 313, 51, 14);
			contentPanel.add(lblEmail);
		}
		{
			textEmail = new JTextField();
			textEmail.setColumns(10);
			textEmail.setBounds(51, 338, 328, 20);
			contentPanel.add(textEmail);
		}
		{
			lblLogoImg = new JLabel("");
			lblLogoImg.setIcon(new ImageIcon(Register.class.getResource(cf.getLogoWhite())));
			lblLogoImg.setBounds(450, 69, 250, 235);
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
				
			} else if(textEmail.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "¡El Email esta vacio!", "Introduzca Email", JOptionPane.ERROR_MESSAGE);
				
			} else {
				
				try {
					
					cm.register(textUser.getText(),textPass.getText(),textNombre.getText(),textApellidos.getText(),textEmail.getText(),textDireccion.getText());
					JOptionPane.showMessageDialog(null, "¡Registro completado con exito!", "¡Completado!", JOptionPane.ERROR_MESSAGE);
					pasarCampos();
					dispose();
					
					
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				
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
		frame.setVisible(true); //REVISAR PARA NO CARGAR EL PROGRAMA 200 VECES
		
	}
	
}
