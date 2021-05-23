package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
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
	private JButton btnInsert,btnDelete;
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
		
		contentPane.setLayout(null);
		
		table = new JTable(new DefaultTableModel(datos,columnas));
		
		try {
			
			tabla(consulta);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		btnInsert.setBounds(833, 110, 89, 23);
		btnInsert.addActionListener(this);
		contentPane.add(btnInsert);
		
		btnDelete = new JButton("Borrar");
		btnDelete.setBounds(833, 144, 89, 23);
		btnDelete.addActionListener(this);
		contentPane.add(btnDelete);
		
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
				
				tabla(consulta);
				
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
		} else if(e.getSource() == btnInsert) {
			
			Insertar ins = new Insertar();
			ins.setVisible(true);
			
		} else if(e.getSource() == btnDelete) {
			
			int id;
			
			try {
				
				consulta = selector.getSelectedItem().toString();
				id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				
				System.out.println(consulta);
				System.out.println(id);
				
				cm.delete(consulta, id);
				tabla(consulta);
				
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException e1) {
				System.out.println("Seleccione un elemento");
			}
			
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
	
	public void tabla(String consulta) throws ClassNotFoundException, SQLException {
		
		table.setModel(cm.tabla(consulta));
		
	}
	
}