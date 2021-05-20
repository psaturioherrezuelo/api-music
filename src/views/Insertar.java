package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerFiles;
import controllers.ControllerModels;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;

public class Insertar extends JDialog implements WindowListener, ActionListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private ControllerModels cm = new ControllerModels();
	private ControllerFiles cf = new ControllerFiles();
	
	private JTabbedPane tabbedPane;
	
	/*Panel Canciones*/
	private JPanel panelCanciones;
	private JLabel lblCancion;
	private JTextField textCancion;
	private JLabel lblGenero;
	private JTextField textGenero;
	private JLabel lblLanzamiento;
	private JTextField textLanzamiento;
	private JLabel lblVisualizaciones;
	private JTextField textVisualizaciones;
	private JLabel lblPrecio;
	private JTextField textPrecio;
	private JCheckBox chckbxExplicito;
	private JComboBox comboBoxArtista;
	private JComboBox comboBoxDiscografica;
	
	/*Panel Artistas*/
	private JPanel panelArtistas;
	private JLabel lblArtista;
	private JLabel lblArtista_1;
	private JTextField textArtista;
	
	/*Panel Discograficas*/
	private JPanel panelDiscograficas;
	private JLabel lblDiscografica;
	private JLabel lblDiscografica_1;
	private JTextField textDiscografica;
	
	/*Panel Ceos*/
	private JPanel panelCeos;
	private JLabel lblCeo;
	private JTextField textCeo;
	private JLabel lblDiscograficaCeos;
	private JComboBox comboBoxDiscograficaCeo;
	
	/*Panel Botones*/
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	private JLabel lblNewLabel;
	
	public Insertar() {
		setBounds(100, 100, 578, 299);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 564, 230);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(16, 155, 197));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource(cf.getIconoBlack())));
		setResizable(false);
		setTitle("Insertar datos en Api Music");	
		setLocationRelativeTo(null);
		
		{
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(0, 0, 563, 230);
			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbedPane.setBackground(new Color(16, 155, 197));
			contentPanel.add(tabbedPane);
			{
				panelCanciones = new JPanel();
				panelCanciones.setBounds(100, 100, 450, 300);
				tabbedPane.addTab("Canciones", null, panelCanciones, null);
				panelCanciones.setLayout(null);
				
				textCancion = new JTextField();
				textCancion.setBounds(10, 48, 150, 20);
				panelCanciones.add(textCancion);
				textCancion.setColumns(10);
				
				textGenero = new JTextField();
				textGenero.setBounds(10, 104, 150, 20);
				panelCanciones.add(textGenero);
				textGenero.setColumns(10);
				
				lblCancion = new JLabel("Canci\u00F3n");
				lblCancion.setForeground(Color.WHITE);
				lblCancion.setHorizontalAlignment(SwingConstants.CENTER);
				lblCancion.setBounds(56, 23, 47, 14);
				panelCanciones.add(lblCancion);
				
				lblGenero = new JLabel("G\u00E9nero");
				lblGenero.setForeground(Color.WHITE);
				lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
				lblGenero.setBounds(56, 79, 47, 14);
				panelCanciones.add(lblGenero);
				
				textLanzamiento = new JTextField();
				textLanzamiento.setBounds(10, 160, 150, 20);
				panelCanciones.add(textLanzamiento);
				textLanzamiento.setColumns(10);
				
				lblLanzamiento = new JLabel("Lanzamiento");
				lblLanzamiento.setForeground(Color.WHITE);
				lblLanzamiento.setHorizontalAlignment(SwingConstants.CENTER);
				lblLanzamiento.setBounds(44, 135, 77, 14);
				panelCanciones.add(lblLanzamiento);
				
				textVisualizaciones = new JTextField();
				textVisualizaciones.setBounds(208, 104, 96, 20);
				panelCanciones.add(textVisualizaciones);
				textVisualizaciones.setColumns(10);
				
				lblVisualizaciones = new JLabel("Visualizaciones");
				lblVisualizaciones.setForeground(Color.WHITE);
				lblVisualizaciones.setHorizontalAlignment(SwingConstants.CENTER);
				lblVisualizaciones.setBounds(218, 79, 77, 14);
				panelCanciones.add(lblVisualizaciones);
				
				lblPrecio = new JLabel("Precio");
				lblPrecio.setForeground(Color.WHITE);
				lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
				lblPrecio.setBounds(229, 23, 47, 14);
				panelCanciones.add(lblPrecio);
				
				textPrecio = new JTextField();
				textPrecio.setBounds(208, 48, 96, 20);
				panelCanciones.add(textPrecio);
				textPrecio.setColumns(10);
				
				chckbxExplicito = new JCheckBox("Explicito");
				chckbxExplicito.setForeground(Color.WHITE);
				chckbxExplicito.setBackground(Color.black);
				chckbxExplicito.setBounds(208, 159, 97, 23);
				panelCanciones.add(chckbxExplicito);
				
				comboBoxArtista = new JComboBox();
				comboBoxArtista.setBounds(377, 72, 128, 22);
				panelCanciones.add(comboBoxArtista);
				
				comboBoxDiscografica = new JComboBox();
				comboBoxDiscografica.setBounds(377, 128, 128, 22);
				panelCanciones.add(comboBoxDiscografica);
				
				lblArtista = new JLabel("Artista");
				lblArtista.setForeground(Color.WHITE);
				lblArtista.setHorizontalAlignment(SwingConstants.CENTER);
				lblArtista.setBounds(401, 48, 72, 14);
				panelCanciones.add(lblArtista);
				
				lblDiscografica = new JLabel("Discogr\u00E1fica");
				lblDiscografica.setForeground(Color.WHITE);
				lblDiscografica.setHorizontalAlignment(SwingConstants.CENTER);
				lblDiscografica.setBounds(401, 107, 72, 14);
				panelCanciones.add(lblDiscografica);
				
				panelCanciones.setBackground(Color.black);
				
				
			}
			
			panelArtistas = new JPanel();
			panelArtistas.setLayout(null);
			panelArtistas.setBackground(Color.black);
			tabbedPane.addTab("Artistas", null, panelArtistas, null);
			
			textArtista = new JTextField();
			textArtista.setColumns(10);
			textArtista.setBounds(203, 97, 150, 20);
			panelArtistas.add(textArtista);
			
			lblArtista_1 = new JLabel("Artista");
			lblArtista_1.setForeground(Color.WHITE);
			lblArtista_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblArtista_1.setBounds(249, 72, 47, 14);
			panelArtistas.add(lblArtista_1);
			
			panelDiscograficas = new JPanel();
			panelDiscograficas.setForeground(Color.WHITE);
			panelDiscograficas.setBackground(Color.BLACK);
			panelDiscograficas.setLayout(null);
			tabbedPane.addTab("Discograficas", null, panelDiscograficas, null);
			
			textDiscografica = new JTextField();
			textDiscografica.setColumns(10);
			textDiscografica.setBounds(198, 99, 150, 20);
			panelDiscograficas.add(textDiscografica);
			
			lblDiscografica_1 = new JLabel("Discografica");
			lblDiscografica_1.setForeground(Color.WHITE);
			lblDiscografica_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblDiscografica_1.setBounds(233, 74, 74, 14);
			panelDiscograficas.add(lblDiscografica_1);
			
			panelCeos = new JPanel();
			panelCeos.setBackground(Color.BLACK);
			panelCeos.setLayout(null);
			tabbedPane.addTab("Ceos", null, panelCeos, null);
			
			comboBoxDiscograficaCeo = new JComboBox();
			comboBoxDiscograficaCeo.setBounds(201, 123, 128, 22);
			panelCeos.add(comboBoxDiscograficaCeo);
			
			lblDiscograficaCeos = new JLabel("Discogr\u00E1fica");
			lblDiscograficaCeos.setForeground(Color.WHITE);
			lblDiscograficaCeos.setHorizontalAlignment(SwingConstants.CENTER);
			lblDiscograficaCeos.setBounds(225, 99, 72, 14);
			panelCeos.add(lblDiscograficaCeos);
			
			lblCeo = new JLabel("Ceo");
			lblCeo.setForeground(Color.WHITE);
			lblCeo.setHorizontalAlignment(SwingConstants.CENTER);
			lblCeo.setBounds(236, 30, 47, 14);
			panelCeos.add(lblCeo);
			
			textCeo = new JTextField();
			textCeo.setBounds(201, 55, 128, 20);
			panelCeos.add(textCeo);
			textCeo.setColumns(10);
			
		}
		{
			buttonPane = new JPanel();
			buttonPane.setBounds(0, 230, 564, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			buttonPane.setBackground(new Color(16, 155, 197));
			getContentPane().add(buttonPane);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(this);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
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
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == cancelButton) {
			dispose();
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
}
