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

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

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
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

public class Aplicacion extends JFrame implements WindowListener, ActionListener, MouseListener {

	private JPanel contentPane;
	
	private JScrollPane scrollPane;
	private JTable table;
	private JComboBox selector;
	private JLabel imgBackground2;
	private JButton btnInsert,btnDelete,btnUpdate;
	private String columnas[], datos[][],consulta = "canciones";
	
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
		
		table = new JTable(new DefaultTableModel(datos,columnas))//{

//	        public boolean isCellEditable(int row, int column) { //Comprobar el bloquear ciertas columnas       
//	                
//	        	boolean cnd;
//	        	if(consulta.equalsIgnoreCase("lanzamientos") || consulta.equalsIgnoreCase("Contratos")) {
//	        		
//	        		if(column == 0) {
//	        			cnd = false;
//	        		} else if(column == 2) {
//	        			cnd = false;
//	        		} else {
//	        			cnd = true;
//	        		}
//	        		
//	        	} else if(consulta.equalsIgnoreCase("artistas") || consulta.equalsIgnoreCase("Discograficas")) {
//	        		
//	        		if(column==1) {
//	        			cnd = true;
//	        		} else {
//	        			cnd = false;
//	        		}
//	        		
//	        	} else {
//	        		
//	        		if(column == 0) {
//		        		cnd = false;
//		        	} else {
//		        		cnd = true;
//		        	}
//	        		
//	        	}
//	        	return cnd;
//	        };
	    /*}*/;
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		
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
		
		btnInsert = new JButton("Insertar");
		btnInsert.setBounds(367, 177, 89, 23);
		btnInsert.addActionListener(this);
		contentPane.add(btnInsert);
		
		btnUpdate = new JButton("Actualizar");
		btnUpdate.setBounds(466, 177, 89, 23);
		btnUpdate.addActionListener(this);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Borrar");
		btnDelete.setBounds(565, 178, 89, 23);
		btnDelete.addActionListener(this);
		contentPane.add(btnDelete);
		
		JLabel imgBackground2 = new JLabel("");
		imgBackground2.setIcon(new ImageIcon(Login.class.getResource(cf.getBackground())));
		imgBackground2.setBounds(-514, -257, 1458, 673);
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
			
			dispose();
			Insertar ins = new Insertar();
			ins.setVisible(true);
			
		} else if(e.getSource() == btnDelete) {
			
			int id1,id2=0;
			
			try {
				
				consulta = selector.getSelectedItem().toString();
				id1 = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				
				if(consulta.equalsIgnoreCase("Lanzamientos") || consulta.equalsIgnoreCase("Contratos")) {
					
					id2 = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 2).toString());
					
				}
				
				cm.delete(consulta, id1,id2);
				JOptionPane.showMessageDialog(null, "¡Campos eliminados!", "Exito", JOptionPane.INFORMATION_MESSAGE);
				tabla(consulta);
				
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException e1) {
				JOptionPane.showMessageDialog(null, "¡Ningun elemento seleccionado!", "Seleccione un elemento", JOptionPane.ERROR_MESSAGE);
			}
			
		} else if(e.getSource() == btnUpdate) {
			int id1,id2=0;
			String fila[] = new String[table.getColumnCount()];
			
			try {
				
				consulta = selector.getSelectedItem().toString();
				id1 = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				
				if(consulta.equalsIgnoreCase("Lanzamientos") || consulta.equalsIgnoreCase("Contratos")) {
					
					id2 = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 2).toString());
					
				} else if(consulta.equalsIgnoreCase("Canciones")) {
					
					if(table.getValueAt(table.getSelectedRow(), fila.length-1).equals("0") || table.getValueAt(table.getSelectedRow(), fila.length-1).equals("1")) {
						
					} else {
						
						throw new NullPointerException();
						
					}
					
				}
				
				for(int i=0; i<table.getColumnCount(); i++) {
					
					fila[i]=table.getValueAt(table.getSelectedRow(), i).toString();
					
				}
				
				
				
				cm.update(consulta, id1,id2,fila);
				JOptionPane.showMessageDialog(null, "¡Campos actualizados!", "Exito", JOptionPane.INFORMATION_MESSAGE);
				tabla(consulta);
				
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "¡Introduzca una fecha valida!", "Error", JOptionPane.ERROR_MESSAGE);
			} catch (ArrayIndexOutOfBoundsException e1) {
				JOptionPane.showMessageDialog(null, "¡Ningun elemento seleccionado!", "Seleccione un elemento", JOptionPane.ERROR_MESSAGE);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "¡Introduzca solo numeros en los campos visualizaciones y precio (este ultimo separados los decimales por .)!", "Error", JOptionPane.ERROR_MESSAGE);
			} catch (NullPointerException e1) {
				JOptionPane.showMessageDialog(null, "¡Introduzca unicamente 0 para no o 1 para si en explicito!", "Error", JOptionPane.ERROR_MESSAGE);
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
		table.isCellEditable(1, 1);
		
		
	}
	
	public boolean isCellEditable(String consulta, int row, int column) { //Comprobar el bloquear ciertas columnas       
        
    	boolean cnd;
    	if(consulta.equalsIgnoreCase("lanzamientos") || consulta.equalsIgnoreCase("Contratos")) {
    		
    		if(column == 0) {
    			cnd = false;
    		} else if(column == 2) {
    			cnd = false;
    		} else {
    			cnd = true;
    		}
    		
    	} else if(consulta.equalsIgnoreCase("artistas") || consulta.equalsIgnoreCase("Discograficas")) {
    		
    		if(column==1) {
    			cnd = true;
    		} else {
    			cnd = false;
    		}
    		
    	} else {
    		
    		if(column == 0) {
        		cnd = false;
        	} else {
        		cnd = true;
        	}
    		
    	}
    	return cnd;
    }
	
}