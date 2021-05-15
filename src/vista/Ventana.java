package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controllers.ControllerApiMusic;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Ventana extends JFrame implements WindowListener, ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField txtUser;
	private JLabel lblNewLabel_1;
	private JTextField txtPassword;
	private JButton registrar,iniciar,salir;
	private static ControllerApiMusic p = new ControllerApiMusic();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		p.conexion();
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setResizable(false);
		setTitle("Api Music - Login");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(85, 100, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(191, 109, 89, 14);
		contentPane.add(lblNewLabel);
		
		txtUser = new JTextField();
		txtUser.setToolTipText("textuser");
		txtUser.setBounds(70, 134, 328, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(191, 198, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		txtPassword = new JTextField();
		txtPassword.setToolTipText("textpassword");
		txtPassword.setBounds(70, 223, 328, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		registrar = new JButton("Registrarse");
		registrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		registrar.setBounds(70, 280, 95, 23);
		registrar.addActionListener(this);
		contentPane.add(registrar);
		
		iniciar = new JButton("Iniciar");
		iniciar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		iniciar.setBounds(191, 280, 89, 23);
		iniciar.addActionListener(this);
		contentPane.add(iniciar);
		
		salir = new JButton("Salir");
		salir.setFont(new Font("Tahoma", Font.PLAIN, 11));
		salir.setBounds(309, 280, 89, 23);
		salir.addActionListener(this);
		contentPane.add(salir);
		
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
		// TODO Auto-generated method stub
	
		
		if (e.getSource() == registrar) {
			
			p.register(txtUser.getText(), txtPassword.getText());
			
		} else if (e.getSource() == iniciar) {
			
			boolean cnd = p.login(txtUser.getText(),txtPassword.getText());
			
			if(cnd==true) {
				System.out.println("bien");
			}else {
				System.out.println("mal");
			}
			
		} else if (e.getSource() == salir) {
			
			System.exit(0);
			
		} 
		
		System.out.println(e.getActionCommand());
		
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
