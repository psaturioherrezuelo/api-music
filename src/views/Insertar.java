package views;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControllerFiles;
import controllers.ControllerModels;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class Insertar extends JFrame implements WindowListener, ActionListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private ControllerModels cm = new ControllerModels();
	private ControllerFiles cf = new ControllerFiles();
	
	/*Panel Canciones*/
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
	private JLabel lblArtista;
	private JTextField textArtista;
	private JLabel lblDiscografica;
	private JTextField textDiscografica;
	
	/*Panel Botones*/
	private JPanel buttonPane;
	private JButton insertButton;
	private JButton cancelarButton;
	
	public Insertar() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 578, 299);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 564, 230);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(16, 155, 197));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource(cf.getIconoBlue())));
		setResizable(false);
		setTitle("Insertar datos en Api Music");	
		setLocationRelativeTo(null);
		setVisible(true);
		
		{
			{
				
				textCancion = new JTextField();
				textCancion.setBounds(34, 59, 150, 20);
				contentPanel.add(textCancion);
				textCancion.setColumns(10);
				
				textGenero = new JTextField();
				textGenero.setBounds(34, 115, 150, 20);
				contentPanel.add(textGenero);
				textGenero.setColumns(10);
				
				lblCancion = new JLabel("Canci\u00F3n");
				lblCancion.setForeground(Color.WHITE);
				lblCancion.setHorizontalAlignment(SwingConstants.CENTER);
				lblCancion.setBounds(80, 34, 47, 14);
				contentPanel.add(lblCancion);
				
				lblGenero = new JLabel("G\u00E9nero");
				lblGenero.setForeground(Color.WHITE);
				lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
				lblGenero.setBounds(80, 90, 47, 14);
				contentPanel.add(lblGenero);
				
				textLanzamiento = new JTextField();
				textLanzamiento.setBounds(34, 171, 150, 20);
				contentPanel.add(textLanzamiento);
				textLanzamiento.setColumns(10);
				
				lblLanzamiento = new JLabel("Lanzamiento");
				lblLanzamiento.setForeground(Color.WHITE);
				lblLanzamiento.setHorizontalAlignment(SwingConstants.CENTER);
				lblLanzamiento.setBounds(68, 146, 77, 14);
				contentPanel.add(lblLanzamiento);
				
				textVisualizaciones = new JTextField();
				textVisualizaciones.setBounds(232, 115, 96, 20);
				contentPanel.add(textVisualizaciones);
				textVisualizaciones.setColumns(10);
				
				lblVisualizaciones = new JLabel("Visualizaciones");
				lblVisualizaciones.setForeground(Color.WHITE);
				lblVisualizaciones.setHorizontalAlignment(SwingConstants.CENTER);
				lblVisualizaciones.setBounds(242, 90, 77, 14);
				contentPanel.add(lblVisualizaciones);
				
				lblPrecio = new JLabel("Precio");
				lblPrecio.setForeground(Color.WHITE);
				lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
				lblPrecio.setBounds(253, 34, 47, 14);
				contentPanel.add(lblPrecio);
				
				textPrecio = new JTextField();
				textPrecio.setBounds(232, 59, 96, 20);
				contentPanel.add(textPrecio);
				textPrecio.setColumns(10);
				
				chckbxExplicito = new JCheckBox("Explicito");
				chckbxExplicito.setForeground(Color.WHITE);
				chckbxExplicito.setBackground(new Color(70, 130, 180));
				chckbxExplicito.setBounds(232, 170, 97, 23);
				contentPanel.add(chckbxExplicito);
				
				lblArtista = new JLabel("Artista");
				lblArtista.setForeground(Color.WHITE);
				lblArtista.setHorizontalAlignment(SwingConstants.CENTER);
				lblArtista.setBounds(409, 34, 72, 14);
				contentPanel.add(lblArtista);
				
				textArtista = new JTextField();
				textArtista.setColumns(10);
				textArtista.setBounds(373, 59, 150, 20);
				contentPanel.add(textArtista);
				
				lblDiscografica = new JLabel("Discogr\u00E1fica");
				lblDiscografica.setForeground(Color.WHITE);
				lblDiscografica.setHorizontalAlignment(SwingConstants.CENTER);
				lblDiscografica.setBounds(409, 90, 72, 14);
				contentPanel.add(lblDiscografica);
				
				textDiscografica = new JTextField();
				textDiscografica.setColumns(10);
				textDiscografica.setBounds(373, 115, 150, 20);
				contentPanel.add(textDiscografica);
				
				JLabel lblImg = new JLabel("");
				lblImg.setIcon(new ImageIcon(Register.class.getResource(cf.getBackground())));
				lblImg.setBounds(-769, -188, 1333, 418);
				contentPanel.add(lblImg);
				
				
			}
			
		}
		{
			buttonPane = new JPanel();
			buttonPane.setBounds(0, 230, 564, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			buttonPane.setBackground(Color.black);
			getContentPane().add(buttonPane);
			{
				insertButton = new JButton("Insertar");
				insertButton.setActionCommand("OK");
				buttonPane.add(insertButton);
				insertButton.addActionListener(this);
				getRootPane().setDefaultButton(insertButton);
			}
			{
				cancelarButton = new JButton("Cancelar");
				cancelarButton.setActionCommand("Cancel");
				cancelarButton.addActionListener(this);
				buttonPane.add(cancelarButton);
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
		
		String artistas[], discograficas[];
		
		
		if(e.getSource() == cancelarButton) {
			dispose();
			Aplicacion app = new Aplicacion("Canciones");
			app.setVisible(true);
		} else if (e.getSource() == insertButton) {
		
			LocalDate fech = null;
			String fs[] = new String[3];
			long visualizaciones = 0;
			float pr = 0;
			boolean expl = false;
			
			if(textCancion.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "¡El campo canción esta vacio!", "Error", JOptionPane.ERROR_MESSAGE);
				
			} else if(textLanzamiento.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "¡El campo lanzamiento esta vacio!", "Error", JOptionPane.ERROR_MESSAGE);
				
			} else {
				
					try {
					
					if(textLanzamiento.getText().contains("-")) {
						
						fs = textLanzamiento.getText().split("-");
						fech = LocalDate.of(Integer.parseInt(fs[2]), Integer.parseInt(fs[1]), Integer.parseInt(fs[0]));
						
					} else if(textLanzamiento.getText().contains("/")) {
						
						fs = textLanzamiento.getText().split("/");
						fech = LocalDate.of(Integer.parseInt(fs[2]), Integer.parseInt(fs[1]), Integer.parseInt(fs[0]));
					
					} else {
						
						JOptionPane.showMessageDialog(null, "Introduzca una fecha valida (DIA-MES-AÑO) o (DIA/MES/AÑO)", "Error", JOptionPane.ERROR_MESSAGE);
						
					}
					
				} catch(Exception ex) {
					
					JOptionPane.showMessageDialog(null, "Introduzca una fecha valida (DIA-MES-AÑO) o (DIA/MES/AÑO)", "Error", JOptionPane.ERROR_MESSAGE);
					
				}
				
				if(!textVisualizaciones.getText().isEmpty()) {
					try {
						
						visualizaciones = Long.parseLong(textVisualizaciones.getText());
						
					} catch(Exception ex) {
						
						JOptionPane.showMessageDialog(null, "Introduzca solo numeros en las visualizaciones", "Error", JOptionPane.ERROR_MESSAGE);
						
					}
				}
				
				if(!textPrecio.getText().isEmpty()) {
					
					try {
						
						if(textPrecio.getText().contains(",")) {
							
							textPrecio.setText(textPrecio.getText().replace(',', '.'));
							
						}
						
						pr = Float.parseFloat(textPrecio.getText());
						
					} catch(Exception ex) {
						
						JOptionPane.showMessageDialog(null, "Introduzca solo numeros separados por . o , para el precio", "Error", JOptionPane.ERROR_MESSAGE);
						
					}
					
				}
				
				if(chckbxExplicito.isSelected()) {

					expl = true;
					
				}
				
				try {
					artistas =  textArtista.getText().split(",");
					discograficas = textDiscografica.getText().split(",");
					cm.insert(textCancion.getText(), textGenero.getText(), fech, visualizaciones, pr, expl, artistas, discograficas);
					JOptionPane.showMessageDialog(null, "¡Campos insertados!", "Exito", JOptionPane.INFORMATION_MESSAGE);
					textArtista.setText("");
					textDiscografica.setText("");
					textCancion.setText("");
					textGenero.setText("");
					textLanzamiento.setText("");
					textPrecio.setText("");
					textVisualizaciones.setText("");
					chckbxExplicito.setSelected(false);
					
				} catch (ClassNotFoundException e1) {
					System.out.println("error clase");
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "¡Campos Duplicados!", "Error", JOptionPane.ERROR_MESSAGE);
					System.out.println("error sql");
				}
				
			}
			
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
