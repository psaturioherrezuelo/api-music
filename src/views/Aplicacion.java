package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controllers.ControllerDDBB;
import controllers.ControllerFiles;
import controllers.ControllerModels;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import javax.swing.JSlider;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;
import javax.swing.JButton;

public class Aplicacion extends JFrame implements WindowListener, ActionListener, MouseListener {

	private JPanel contentPane;
	
	private JScrollPane scrollPane;
	private JTable table;
	private JComboBox selector;
	private JLabel imgBackground1;
	private JLabel imgBackground2;
	private JButton btnInsert;
	private String columnas[], datos[][],consulta = "canciones";;
	
	ControllerModels cm = new ControllerModels();
	ControllerFiles cf = new ControllerFiles();

	public Aplicacion(String consulta) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 948, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource(cf.getIconoBlack())));
		setResizable(false);
		setTitle("Api Music");	
		setLocationRelativeTo(null);
		
		try {
			columnas = cm.cargaColumnas(consulta);
			datos = cm.cargaTablas(columnas,consulta);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane.setLayout(null);
		
		table = new JTable(datos, columnas);
		table.setBounds(10, 10, 400, 400);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 211, 932, 251);
		contentPane.add(scrollPane);
		
		selector = new JComboBox();
		selector.setBounds(833, 178, 89, 22);
		selector.addItem("Canciones");
		selector.addItem("Artistas");
		selector.addItem("Discograficas");
		selector.addItem("Ceos");
		selector.addItem("Lanzamientos");
		selector.addItem("Contratos");
		selector.addActionListener(this);
		contentPane.add(selector);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 932, 46);
		panel.setBackground(Color.black);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 46, 364, 166);
		contentPane.add(panel_1);
		
		imgBackground1 = new JLabel("");
		imgBackground1.setIcon(new ImageIcon(Login.class.getResource(cf.getBackground())));
		imgBackground1.setBounds(0, 0, 932, 462);
		panel_1.add(imgBackground1);
		
		btnInsert = new JButton("Insertar");
		btnInsert.setBounds(833, 144, 89, 23);
		btnInsert.addActionListener(this);
		contentPane.add(btnInsert);
		
		JLabel imgBackground2 = new JLabel("");
		imgBackground2.setIcon(new ImageIcon(Login.class.getResource(cf.getBackground())));
		imgBackground2.setBounds(0, 0, 932, 462);
		contentPane.add(imgBackground2);
		
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
	
		if(e.getSource() == selector) {
			consulta = selector.getSelectedItem().toString();
			try {
				
				tablas(consulta);
//				this.dispose();
//				Aplicacion programa = new Aplicacion(consulta);
//				programa.setVisible(true);
//				programa.setLocationRelativeTo(null);
				table.tableChanged(null);
				table.getValueAt(1, 1);
//				table = new JTable(datos, columnas);
//				table.setVisible(true);
//				scrollPane.
				
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
		} else if(e.getSource() == btnInsert) {
			
			Insertar ins = new Insertar();
			ins.setVisible(true);
			
		}
		
		System.out.println(selector.getSelectedItem());
		System.out.println(consulta);
		
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
	
	public void tablas(String consulta) throws ClassNotFoundException, SQLException {
		
		columnas = cm.cargaColumnas(consulta);
		datos = cm.cargaTablas(columnas,consulta);
		
	}
}