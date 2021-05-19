package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;

import controllers.ControllerFiles;
import controllers.ControllerModels;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Login extends JFrame implements WindowListener, ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField textUser;
	private JLabel lblPassword;
	private JTextField textPassword;
	private JButton btnRegistrar,btnIniciar,btnSalir;
	
	private ControllerModels controlador = new ControllerModels();
	private ControllerFiles cf = new ControllerFiles();

	public Login() {
		setBackground(new Color(0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource(cf.getIconoBlack())));
		setResizable(false);
		setTitle("Login Api Music");		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(100, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(191, 109, 89, 14);
		contentPane.add(lblUser);
		
		textUser = new JTextField();
		textUser.setToolTipText("textuser");
		textUser.setBounds(70, 134, 328, 20);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(191, 198, 89, 14);
		contentPane.add(lblPassword);
		
		textPassword = new JTextField();
		textPassword.setToolTipText("textpassword");
		textPassword.setBounds(70, 223, 328, 20);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		btnRegistrar = new JButton("Registrarse");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRegistrar.setBounds(70, 280, 95, 23);
		btnRegistrar.addActionListener(this);
		contentPane.add(btnRegistrar);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnIniciar.setBounds(191, 280, 89, 23);
		btnIniciar.addActionListener(this);
		contentPane.add(btnIniciar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSalir.setBounds(309, 280, 89, 23);
		btnSalir.addActionListener(this);
		contentPane.add(btnSalir);
		
		JLabel lblImgLogo = new JLabel("");
		lblImgLogo.setIcon(new ImageIcon(Login.class.getResource(cf.getLogoWhite())));
		lblImgLogo.setBounds(468, 93, 250, 217);
		contentPane.add(lblImgLogo);
		
		JLabel imgBackground = new JLabel("");
		imgBackground.setIcon(new ImageIcon(Login.class.getResource(cf.getBackground())));
		imgBackground.setBounds(-532, -340, 1328, 763);
		contentPane.add(imgBackground);
		
		this.setLocationRelativeTo(null);
		
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
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == btnRegistrar) {
			
			try {
				
				this.dispose();
				
				Register dialog = new Register();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				dialog.setLocationRelativeTo(null);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		} else if (e.getSource() == btnIniciar) {
			
			boolean cnd = false;
			
			if(textUser.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "¡El usuario esta vacio!", "Error", JOptionPane.ERROR_MESSAGE);
				
			} else if(textPassword.getText().isEmpty()) {
				 
				JOptionPane.showMessageDialog(null, "¡La contraseña esta vacia!", "Error", JOptionPane.ERROR_MESSAGE);
				
			} else {
				
				
					try {
						
						cnd = controlador.login(textUser.getText(),textPassword.getText());
					
					} catch (ClassNotFoundException e1) {
					
						e1.printStackTrace();
					
					} catch (SQLException e1) {
					
						e1.printStackTrace();
					
					}
				
				
				if(cnd==true) {
					
//					JOptionPane.showMessageDialog(null, "Inicio de sesion correcto.");
					JOptionPane.showMessageDialog(null, "Bienvenido", "Inicio de sesion correcto", JOptionPane.YES_OPTION);
					this.dispose();
//					Aplicacion ventana = new Aplicacion();
//					ventana.setVisible(true);
					
				}else {
					
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
			
		} else if (e.getSource() == btnSalir) {
			
			System.exit(0);
			
		} 
		
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
	
	public void set(String campos[]) {
		
		textUser.setText(campos[0]);
		textPassword.setText(campos[1]);
		
	}
}
