package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Register extends JDialog implements WindowListener, ActionListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnReg, btnCancel;
	private JLabel lblUser;
	private JTextField textUser;
	private JLabel lbNombre;
	private JTextField textNombre;
	private JLabel lblDireccion;
	private JTextField textDireccion;
	private JLabel lblPass;
	private JTextField textPass;
	private JLabel lblApellidos;
	private JTextField textApellidos;
	private JLabel lblEmail;
	private JTextField textEmail;
	private JLabel lblLogoImg;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Register dialog = new Register();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Register() {
		
		setResizable(false);
		setTitle("Api Music - Register");
		
		setBounds(100, 100, 450, 435);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(85, 100, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblUser = new JLabel("Usuario");
			lblUser.setHorizontalAlignment(SwingConstants.CENTER);
			lblUser.setBounds(82, 13, 46, 14);
			contentPanel.add(lblUser);
		}
		{
			textUser = new JTextField();
			textUser.setBounds(10, 38, 185, 20);
			contentPanel.add(textUser);
			textUser.setColumns(10);
		}
		{
			lbNombre = new JLabel("Nombre");
			lbNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lbNombre.setBounds(82, 125, 46, 14);
			contentPanel.add(lbNombre);
		}
		{
			textNombre = new JTextField();
			textNombre.setBounds(10, 150, 185, 20);
			contentPanel.add(textNombre);
			textNombre.setColumns(10);
		}
		{
			lblDireccion = new JLabel("Direccion");
			lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
			lblDireccion.setBounds(72, 237, 60, 14);
			contentPanel.add(lblDireccion);
		}
		{
			textDireccion = new JTextField();
			textDireccion.setBounds(10, 262, 185, 20);
			contentPanel.add(textDireccion);
			textDireccion.setColumns(10);
		}
		{
			lblPass = new JLabel("Contrase\u00F1a");
			lblPass.setHorizontalAlignment(SwingConstants.CENTER);
			lblPass.setBounds(72, 69, 67, 14);
			contentPanel.add(lblPass);
		}
		{
			textPass = new JTextField();
			textPass.setBounds(10, 94, 185, 20);
			contentPanel.add(textPass);
			textPass.setColumns(10);
		}
		{
			lblApellidos = new JLabel("Apellidos");
			lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
			lblApellidos.setBounds(72, 181, 60, 14);
			contentPanel.add(lblApellidos);
		}
		{
			textApellidos = new JTextField();
			textApellidos.setColumns(10);
			textApellidos.setBounds(10, 206, 185, 20);
			contentPanel.add(textApellidos);
		}
		{
			lblEmail = new JLabel("Email");
			lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmail.setBounds(82, 293, 46, 14);
			contentPanel.add(lblEmail);
		}
		{
			textEmail = new JTextField();
			textEmail.setColumns(10);
			textEmail.setBounds(10, 318, 185, 20);
			contentPanel.add(textEmail);
		}
		{
			lblLogoImg = new JLabel("");
			lblLogoImg.setIcon(new ImageIcon(Register.class.getResource("/img/logotipo-letter.png")));
			lblLogoImg.setBounds(82, 106, 480, 176);
			contentPanel.add(lblLogoImg);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			buttonPane.setBackground(new Color(85, 100, 235));
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
		// TODO Auto-generated method stub
		
		String tocar="";
		String consulta="";
		
		if (e.getSource() == btnReg) {
			
			if(textUser.getText().isEmpty()) {
				
				tocar = "usuario vacio";
				
			} else if (textPass.getText().isEmpty()) {
				
				tocar ="pass vacia";
				
			} else if(textEmail.getText().isEmpty()) {
				
				tocar = "email vacio";
				
			} else {
				
				tocar = "campos importantes ok!";
				consulta = "INSERT INTO usuarios VALUES ()";
				
			}
			
			System.out.println(tocar);
			
		} else if(e.getSource() == btnCancel) {
			
			this.setVisible(false);
			dispose();
			new Login().setVisible(true);
			
		}
		
	}
	
	public String cons(String user, String pass, String nombre, String apellidos, String email, String direccion, LocalDate fregistro, boolean admin) {
		
		String a="INSERT INTO usuarios VALUES(?,?,?,?,?,?,?,?)";
		
		
		return a;
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
