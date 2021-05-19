package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controllers.ControllerDDBB;
import controllers.ControllerFiles;
import controllers.ControllerModels;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Aplicacion extends JFrame {

	private JPanel contentPane;
	
	private JTable table;
	
	ControllerModels cm = new ControllerModels();
	ControllerFiles cf = new ControllerFiles();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		String columnas[] = null;
		String datos[][] = null;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplicacion frame = new Aplicacion(columnas,datos);
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
	public Aplicacion(String columnas[],String datos[][]) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		try {
			cm.cargaTablas(columnas, datos);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table = new JTable(datos, columnas);
		table.setBounds(10, 10, 400, 400);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 666, 443);
		contentPane.add(scrollPane);
		
	}

}
