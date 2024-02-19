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
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.SwingConstants;

public class viewemployees {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewemployees window = new viewemployees();
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
	public viewemployees() {
		initialize();
		Connect();
		table_loader();
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnprint;
	private JButton btnNewButton_1;
	private JTextField txttelephone;
	private JTextField txtaddress;
	private JTextField txtlname;
	private JTextField txtfname;
	private JTextField txtemail;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JPasswordField txtpassword;
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
			String query="SELECT * FROM employees";
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
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(100, 100, 874, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(336, 61, 469, 341);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE MANAGEMENT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		lblNewLabel.setBounds(253, 11, 280, 39);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton = new JButton("Add");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Firstname,Lastname,Telephone,Email,Address,Password,bid;
				Firstname=txtfname.getText();
				Lastname= txtlname.getText();
				Telephone=txttelephone.getText();
				Email=txtemail.getText();
				Address=txtaddress.getText();
				Password=txtpassword.getText();
				
				try{
					pst=con.prepareStatement("insert into employees (Firstname,Lastname,Telephone,Email,Address,Password)values(?,?,?,?,?,?)");
					pst.setString(1,Firstname);
					pst.setString(2, Lastname);
					pst.setString(3, Telephone);
					pst.setString(4, Email);
					pst.setString(5, Address);
					pst.setString(6, Password);
					if(Firstname.equals("")) {
						JOptionPane.showMessageDialog(null, "Input Your First Name Please!");
						
					}
					else  if(Lastname.equals("")) {
						JOptionPane.showMessageDialog(null, "Input Your Last Name Please!");						
					}
					else  if(Email.equals("")) {
						JOptionPane.showMessageDialog(null, "Enter your email as Username Please!");	
					}
					else  if(Password.equals("")) {
							JOptionPane.showMessageDialog(null, "Fill password Field Please!");					
						}
					
					else {
						JOptionPane.showMessageDialog(null, "Account Added Sucesfully!");
					
					}
					pst.executeUpdate();
					table_loader();
					
					txtfname.setText("");
					txtlname.setText("");
					txttelephone.setText("");
					txtemail.setText("");
					txtaddress.setText("");
					txtpassword.setText("");

					txtfname.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
				
				
	
				
				
				
				
				
				
				
			}}		);
		btnNewButton.setBounds(346, 413, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnDelete.setFont(new Font("SimSun", Font.BOLD, 12));
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
					
					txtfname.setText("");
					txtlname.setText("");
					txttelephone.setText("");
					txtemail.setText("");
					txtaddress.setText("");
					txtpassword.setText("");
					txtfname.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
			
				
							
				
			}
		});
		btnDelete.setBounds(458, 413, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnUpdate.setFont(new Font("Segoe Print", Font.PLAIN, 13));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String Firstname,Lastname,Telephone,Email,Address,Password,bid;
				Firstname=txtfname.getText();
				Lastname= txtlname.getText();
				Telephone=txttelephone.getText();
				Email=txtemail.getText();
				Address= txtaddress.getText();
				Password=txtpassword.getText();			
				bid=txtid.getText();
				
				try{
					pst=con.prepareStatement("update employees  set Firstname=?,Lastname=?,Telephone=?,Email=?,Address=?,Password=? where id=?");
					pst.setString(1,Firstname);
					pst.setString(2, Lastname);
					pst.setString(3, Telephone);
					pst.setString(4,Email);
					pst.setString(5, Address);
					pst.setString(6, Password);
					pst.setString(7,bid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record updated!");
					table_loader();
					
					txtfname.setText("");
					txtlname.setText("");
					txttelephone.setText("");
					txtemail.setText("");
					txtaddress.setText("");
					txtpassword.setText("");
					txtfname.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
			
				
			}
			
		});
		btnUpdate.setBounds(569, 413, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		btnprint = new JButton("Print");
		btnprint.setBackground(new Color(0, 128, 128));
		btnprint.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
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
		btnprint.setBounds(759, 413, 89, 23);
		frame.getContentPane().add(btnprint);
		
		btnNewButton_1 = new JButton("Back");
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
		txttelephone.setBounds(163, 173, 146, 23);
		frame.getContentPane().add(txttelephone);
		txttelephone.setColumns(10);
		
		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBounds(163, 261, 146, 23);
		frame.getContentPane().add(txtaddress);
		
		txtlname = new JTextField();
		txtlname.setColumns(10);
		txtlname.setBounds(163, 135, 146, 23);
		frame.getContentPane().add(txtlname);
		
		txtfname = new JTextField();
		txtfname.setColumns(10);
		txtfname.setBounds(163, 92, 146, 23);
		frame.getContentPane().add(txtfname);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(163, 217, 146, 23);
		frame.getContentPane().add(txtemail);
		
		lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(24, 94, 75, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(24, 139, 75, 19);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Telephone");
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(24, 177, 75, 19);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(24, 221, 75, 19);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(24, 265, 75, 19);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(24, 307, 75, 19);
		frame.getContentPane().add(lblNewLabel_6);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(163, 295, 146, 23);
		frame.getContentPane().add(txtpassword);
		
		txtid = new JTextField();
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try{
					String id=txtid.getText();
					pst=con.prepareStatement("select Firstname,Lastname,Telephone,Email,Address,Password from employees where id=?");
					pst.setString(1,id);
					ResultSet rs=pst.executeQuery();


					if(rs.next()==true){

					String Firstname=rs.getString(1);
					String Lastname=rs.getString(2);
					String Telephone=rs.getString(3);
					String Email=rs.getString(4);
					String Address=rs.getString(5);
					String Password=rs.getString(6);
				
					txtfname.setText(Firstname);
					txtlname.setText(Lastname);
					txttelephone.setText(Telephone);
					txtemail.setText(Email);
					txtaddress.setText(Address);
					txtpassword.setText(Password);
					}
					else
					{
					txtfname.setText("");
					txtlname.setText("");
					txttelephone.setText("");
					txtemail.setText("");
					txtaddress.setText("");
					txtpassword.setText("");
					}
					}
					catch(SQLException ex){
					}
				
				
			}
		});
		txtid.setBounds(213, 385, 96, 23);
		frame.getContentPane().add(txtid);
		txtid.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Search");
		lblNewLabel_7.setFont(new Font("Poor Richard", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(140, 382, 75, 28);
		frame.getContentPane().add(lblNewLabel_7);
	}
}
