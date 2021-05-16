package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controllers.ControllerApiMusic;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Login extends JFrame implements WindowListener, ActionListener, MouseListener {

	protected JPanel contentPane;
	protected JTextField textUser;
	protected JLabel lblPassword;
	protected JTextField textPassword;
	protected JButton btnRegistrar,btnIniciar,btnSalir;
	
	private static ControllerApiMusic controlador = new ControllerApiMusic();

	/**
	 * Launch the application.
	 */
	
//	public static void main(String[] args) {
//		
//		
//		p.conexion();
//		
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login frame = new Login();
//					frame.setVisible(true);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/logo-icon-64px.png")));
		setResizable(false);
		setTitle("Login Api Music");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(85, 100, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(191, 109, 89, 14);
		contentPane.add(lblUser);
		
		textUser = new JTextField();
		textUser.setToolTipText("textuser");
		textUser.setBounds(70, 134, 328, 20);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		lblPassword = new JLabel("Contrase\u00F1a");
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
		lblImgLogo.setIcon(new ImageIcon(Login.class.getResource("/img/logotipo-letter.png")));
		lblImgLogo.setBounds(337, 21, 413, 322);
		contentPane.add(lblImgLogo);
		
		this.setLocationRelativeTo(null); //REVISAR PARA NO CARGAR EL PROGRAMA 200 VECES
		
//		controlador.conexion();
//		controlador.imprimir();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == btnRegistrar) {
			
			try {
				
				Register dialog = new Register();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				dialog.setLocationRelativeTo(null);
				
				this.setVisible(false);
				this.dispose();
				
			
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
//			controlador.register(textUser.getText(), textPassword.getText());
			
		} else if (e.getSource() == btnIniciar) {
			
//			boolean cnd = false;
			
			if(textUser.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "¡El usuario esta vacio!", "Error", JOptionPane.ERROR_MESSAGE);
				
			} else if(textPassword.getText().isEmpty()) {
				 
				JOptionPane.showMessageDialog(null, "¡La contraseña esta vacia!", "Error", JOptionPane.ERROR_MESSAGE);
				
			} else {
				
				boolean cnd = controlador.login(textUser.getText(),textPassword.getText());
				
				if(cnd==true) {
					
//					JOptionPane.showMessageDialog(null, "Inicio de sesion correcto.");
					JOptionPane.showMessageDialog(null, "Bienvenido", "Inicio de sesion correcto", JOptionPane.YES_OPTION);
					this.dispose();
					Register r = new Register();
					r.setVisible(true);
					controlador.conexion();
					controlador.imprimir();
					
					
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
