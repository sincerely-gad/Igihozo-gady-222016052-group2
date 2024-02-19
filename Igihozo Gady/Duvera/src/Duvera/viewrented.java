package Duvera;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class viewrented {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewrented window = new viewrented();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public viewrented() {
		initialize();
		Connect();
		table_loader();
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnprint;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton_1;

	public void Connect()
	{
	try{ 
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost/ehuyefinder01", "rooty","1234");
	}
	catch(ClassNotFoundException ex){}
	catch (SQLException ex)
	{}
	}
	
	public void table_loader()
    {
     try
     {
    	 Class.forName("com.mysql.jdbc.Driver"); 
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehuyefinder01","rooty","1234");
			String query="SELECT * FROM rented";
		Statement statement = con.createStatement();
		ResultSet rs=statement.executeQuery(query);
		table.setModel(DbUtils.resultSetToTableModel(rs));
}
     catch(Exception ea) {System.out.println(ea);
		}
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(211, 211, 211));
		frame.setBounds(100, 100, 716, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RENTED HOUSES");
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblNewLabel.setBounds(253, 11, 225, 39);
		frame.getContentPane().add(lblNewLabel);
		
		btnprint = new JButton("Print");
		btnprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnprint.setBounds(590, 419, 89, 23);
		frame.getContentPane().add(btnprint);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 40, 657, 368);
		frame.getContentPane().add(scrollPane_1);
		
		scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rent sf= new Rent();
				sf.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		btnNewButton_1.setBounds(22, 11, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
