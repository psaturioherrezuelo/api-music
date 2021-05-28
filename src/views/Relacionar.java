package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerFiles;
import controllers.ControllerModels;

import javax.swing.ComboBoxEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Relacionar extends JFrame implements ActionListener, WindowListener {

	
	private ControllerModels cm = new ControllerModels();
	private ControllerFiles cf = new ControllerFiles();
	private JPanel contentPane;
	private JComboBox cbCanciones,cbArtistas, cbCanciones2;
	private JButton btnInsertarLanzamientos, btnInsertarContratos;
	private JComboBox cbDiscograficas;

	public Relacionar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource(cf.getIconoBlue())));
		setResizable(false);
		addWindowListener(this);
		setTitle("Relacionar datos Api Music");
		
		setBounds(100, 100, 377, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbCanciones = new JComboBox();
		cbCanciones.setBounds(187, 88, 133, 22);
		contentPane.add(cbCanciones);
		
		cbArtistas = new JComboBox();
		cbArtistas.setBounds(44, 88, 133, 22);
		contentPane.add(cbArtistas);
		
		btnInsertarLanzamientos = new JButton("Insertar Lanzamiento");
		btnInsertarLanzamientos.setBounds(110, 121, 156, 23);
		btnInsertarLanzamientos.addActionListener(this);
		contentPane.add(btnInsertarLanzamientos);
		
		JLabel lblNewLabel = new JLabel("Artista");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(92, 63, 47, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cancion");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(227, 63, 47, 14);
		contentPane.add(lblNewLabel_1);
		
		cbCanciones2 = new JComboBox();
		cbCanciones2.setBounds(187, 247, 133, 22);
		contentPane.add(cbCanciones2);
		
		cbDiscograficas = new JComboBox();
		cbDiscograficas.setBounds(44, 247, 133, 22);
		contentPane.add(cbDiscograficas);
		
		btnInsertarContratos = new JButton("Insertar Contrato");
		btnInsertarContratos.setBounds(110, 280, 156, 23);
		btnInsertarContratos.addActionListener(this);
		contentPane.add(btnInsertarContratos);
		
		JLabel lblNewLabel_2 = new JLabel("CONTRATOS");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(137, 196, 93, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cancion");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(227, 222, 47, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Discografica");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(64, 221, 91, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("LANZAMIENTOS");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(137, 38, 93, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(Login.class.getResource(cf.getBackground())));
		bg.setBounds(-929, -734, 1302, 1150);
		contentPane.add(bg);
		
		try {
			leer();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void leer() throws ClassNotFoundException, SQLException {
		
		String canc[] = cm.cancs();
		String arts[] = cm.arts();
		String disc[] = cm.discs();
		
		for(String c : canc) {
			cbCanciones.addItem(c);
			cbCanciones2.addItem(c);
		}
		
		for(String a : arts) {
			cbArtistas.addItem(a);
		}
		
		for(String d : disc) {
			cbDiscograficas.addItem(d);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnInsertarLanzamientos) {
			
			try {
				cm.relacion("lanzamientos", cbCanciones.getSelectedItem().toString(), cbArtistas.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null, "¡Lanzamiento insertado con exito!", "Exito", JOptionPane.INFORMATION_MESSAGE);
			} catch (ClassNotFoundException e1) {
				error();
				e1.printStackTrace();
			} catch (SQLException e1) {
				error();
				e1.printStackTrace();
			}
			
		} else if(e.getSource() == btnInsertarContratos) {
			
			try {
				cm.relacion("contratos", cbCanciones.getSelectedItem().toString(), cbDiscograficas.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null, "¡Contrato insertado con exito!", "Exito", JOptionPane.INFORMATION_MESSAGE);
			} catch (ClassNotFoundException e1) {
				error();
				e1.printStackTrace();
			} catch (SQLException e1) {
				error();
				e1.printStackTrace();
			}
			
		}
		
	}
	
	public void error() {
		JOptionPane.showMessageDialog(null, "¡Error al insertar los datos!", "Error", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		Aplicacion a = new Aplicacion("canciones");
		a.setVisible(true);
		
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
