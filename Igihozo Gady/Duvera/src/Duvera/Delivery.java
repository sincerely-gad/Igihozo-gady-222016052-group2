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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Delivery {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delivery window = new Delivery();
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
	public Delivery() {
		initialize();
		Connect();
		table_loader();
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnprint;
	private JButton btnNewButton_1;
	private JTextField txttelephone;
	private JTextField txtpayment;
	private JTextField txtbid;
	private JTextField txtamount;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtid;
	private JLabel lblNewLabel_7;

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
			String query="SELECT * FROM payment";
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
		frame.setBounds(100, 100, 874, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(336, 61, 498, 341);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("DELIVERY PORTAL");
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblNewLabel.setBounds(316, 11, 225, 39);
		frame.getContentPane().add(lblNewLabel);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 11));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bid;		
				bid=txtid.getText();
				
				try{
					pst=con.prepareStatement("delete from employees where id=?");
					pst.setString(1,bid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Ddeleted!");
					table_loader();
					
					txtid.setText("");
					txttelephone.setText("");
					txtamount.setText("");
					txtpayment.setText("");
					txtbid.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
			
				
							
				
			}
		});
		btnDelete.setBounds(383, 413, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 11));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Product_id,Telephone,Amount,Payment_method,bid;
				Product_id=txtbid.getText();
				Telephone= txttelephone.getText();
				Payment_method=txtpayment.getText();
				Amount=txtamount.getText();	
				bid=txtid.getText();
				
				try{
					pst=con.prepareStatement("update payment  set Product_id=?,Telephone=?,Amount=?,Payment_method=? where id=?");
					pst.setString(1,Product_id);
					pst.setString(2, Telephone);
					pst.setString(3,Amount);
					pst.setString(4, Payment_method);
					pst.setString(5,bid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record updated!");
					table_loader();
					
					txtbid.setText("");
					txtid.setText("");
					txtamount.setText("");
					txtamount.setText("");
					txtpayment.setText("");
					txtbid.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
			
				
			}
			
		});
		btnUpdate.setBounds(529, 413, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		btnprint = new JButton("Print");
		btnprint.setForeground(new Color(255, 255, 255));
		btnprint.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 11));
		btnprint.setBackground(new Color(0, 128, 128));
		btnprint.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
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
		btnprint.setBounds(745, 413, 89, 29);
		frame.getContentPane().add(btnprint);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 11));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminactivities sf= new Adminactivities();
				sf.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		txttelephone = new JTextField();
		txttelephone.setBounds(163, 138, 146, 23);
		frame.getContentPane().add(txttelephone);
		txttelephone.setColumns(10);
		
		txtpayment = new JTextField();
		txtpayment.setColumns(10);
		txtpayment.setBounds(194, 244, 115, 23);
		frame.getContentPane().add(txtpayment);
		
		txtbid = new JTextField();
		txtbid.setColumns(10);
		txtbid.setBounds(163, 92, 146, 23);
		frame.getContentPane().add(txtbid);
		
		txtamount = new JTextField();
		txtamount.setColumns(10);
		txtamount.setBounds(163, 186, 146, 23);
		frame.getContentPane().add(txtamount);
		
		lblNewLabel_1 = new JLabel("Delivery ID");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(24, 94, 89, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_3 = new JLabel("Telephone");
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(24, 142, 89, 19);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Amount Paid");
		lblNewLabel_4.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(24, 188, 103, 19);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Payment Method used");
		lblNewLabel_5.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(24, 246, 129, 19);
		frame.getContentPane().add(lblNewLabel_5);
		
		txtid = new JTextField();
		txtid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try
			     {
					String id=txtid.getText();
			    	 Class.forName("com.mysql.jdbc.Driver"); 
					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehuyefinder01","rooty","1234");
					 String query="SELECT * FROM payment where Id='"+txtid+"'";
					Statement stat = con.createStatement();
					ResultSet rs=stat.executeQuery(query);
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			     catch(Exception ea) {System.out.println(ea);
					}
				
				
				
				
				
			}
		});
		txtid.setBounds(213, 385, 96, 23);
		frame.getContentPane().add(txtid);
		txtid.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Search");
		lblNewLabel_7.setFont(new Font("Castellar", Font.BOLD, 13));
		lblNewLabel_7.setBounds(126, 382, 89, 28);
		frame.getContentPane().add(lblNewLabel_7);
	}
}
