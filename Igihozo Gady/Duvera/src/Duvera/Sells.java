package Duvera;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollBar;

public class Sells {

	private JFrame frame;
	private JTextField txtbname;
	private JTextField txtquantity;
	private JTextField txtprice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sells window = new Sells();
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
	public Sells() {
		initialize();
		Connect();
		table_load();
	}

	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;

	
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
	
	public void table_load()
	{
	try{
	pst=con.prepareStatement("select* from sells");
	rs=pst.executeQuery();
//	table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	catch (SQLException e){
	e.printStackTrace();
	}
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 696, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Products");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(383, 11, 276, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Brand name");
		lblNewLabel_1.setBounds(45, 63, 88, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1.setBounds(45, 130, 88, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Price");
		lblNewLabel_1_2.setBounds(45, 203, 88, 25);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		txtbname = new JTextField();
		txtbname.setBounds(163, 66, 144, 20);
		frame.getContentPane().add(txtbname);
		txtbname.setColumns(10);
		
		txtquantity = new JTextField();
		txtquantity.setColumns(10);
		txtquantity.setBounds(163, 135, 144, 20);
		frame.getContentPane().add(txtquantity);
		
		txtprice = new JTextField();
		txtprice.setColumns(10);
		txtprice.setBounds(163, 208, 144, 20);
		frame.getContentPane().add(txtprice);
		
		JButton btnpay = new JButton("Pay");
		btnpay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Brandname,Quantity,Price;
				Brandname=txtbname.getText();
				Quantity= txtquantity.getText();
				Price=txtprice.getText();
				 table_load();
				
				
//				try{
//					pst=con.prepareStatement("insert into sells(Name,Quantity,Price) values(?,?,?)");
//					pst.setString(1,Brandname);
//					pst.setString(2, Quantity);
//					pst.setString(3, Price);
//					pst.executeUpdate();
//					JOptionPane.showMessageDialog(null, "Record Added!");
//					table_load();
//					
//					txtbname.setText("");
//					txtquantity.setText("");
//					txtprice.setText("");
//
//					txtbname.requestFocus();
//					}
//					catch(SQLException e1){
//					e1.printStackTrace();
//					}
				
				
				
				
				
				
			}
			public void table_load()
			{
			try{
			pst=con.prepareStatement("select* from products");
			rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch (SQLException e){
			e.printStackTrace();
			}
			}
			
		});
		btnpay.setBounds(45, 367, 89, 23);
		frame.getContentPane().add(btnpay);
		
		JPanel panel = new JPanel();
		panel.setBounds(364, 83, 306, 307);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 272, 285);
		panel.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(279, 11, 17, 285);
		panel.add(scrollBar);
	}
}
