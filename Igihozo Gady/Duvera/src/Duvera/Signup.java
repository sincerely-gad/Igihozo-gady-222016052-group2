package Duvera;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Signup {

	JFrame frame;
	private JTextField txtfname;
	private JTextField txtlname;
	private JTextField txtgender;
	private JTextField txttelephone;
	private JTextField txtaddress;
	private JTextField txtemail;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
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
	public Signup() {
		initialize();
		
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
//	public void Connect()
//	{
//	try{ 
//	Class.forName("com.mysql.jdbc.Driver");
//	con=DriverManager.getConnection("jdbc:mysql://localhost/ehuyefinder01", "rooty","1234");
//	}
//	catch(ClassNotFoundException ex){}
//	catch (SQLException ex)
//	{}
//	}
	
	
	
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 448, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER REGISTRATION");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 16));
		lblNewLabel.setBounds(67, 10, 289, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		lblNewLabel_1.setBounds(29, 64, 86, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last name");
		lblNewLabel_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(263, 63, 86, 26);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Gender M/F");
		lblNewLabel_1_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(29, 243, 86, 26);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		txtfname = new JTextField();
		txtfname.setBounds(29, 101, 154, 20);
		frame.getContentPane().add(txtfname);
		txtfname.setColumns(10);
		
		txtlname = new JTextField();
		txtlname.setColumns(10);
		txtlname.setBounds(263, 100, 154, 20);
		frame.getContentPane().add(txtlname);
		
		txtgender = new JTextField();
		txtgender.setColumns(10);
		txtgender.setBounds(29, 299, 154, 20);
		frame.getContentPane().add(txtgender);
		
		txttelephone = new JTextField();
		txttelephone.setColumns(10);
		txttelephone.setBounds(29, 194, 154, 20);
		frame.getContentPane().add(txttelephone);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Address");
		lblNewLabel_1_1_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		lblNewLabel_1_1_2.setBounds(263, 145, 86, 26);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBounds(263, 194, 154, 20);
		frame.getContentPane().add(txtaddress);
		
		JLabel lblNewLabel_1_2 = new JLabel("Telephone");
		lblNewLabel_1_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(29, 145, 86, 26);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(263, 246, 86, 26);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(263, 298, 154, 20);
		frame.getContentPane().add(txtemail);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1.setBounds(29, 330, 86, 26);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(33, 371, 153, 29);
		frame.getContentPane().add(txtpassword);
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				String Firstname,Lastname,Gender,Telephone,Address,Email,Password;
				Firstname=txtfname.getText();
				Lastname=txtlname.getText();
				Gender=txtgender.getText();
				Telephone=txttelephone.getText();
				Address= txtaddress.getText();
				Email=txtemail.getText();
				Password=txtpassword.getText();
				
*/
				
try{

							Class.forName("com.mysql.jdbc.Driver"); 
							 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehuyefinder01","rooty","1234");
								String query="INSERT INTO customer(Firstname,Lastname,Gender,Telephone,Address,Email,Password)"
										+ "values('" +txtfname.getText().toString()+"','" +txtlname.getText().toString()+"','" +txtgender.getText().toString()+"',"
												+ "'"+txttelephone.getText().toString()+"','" +txtaddress.getText().toString()+"','"+txtemail.getText().toString()+"','" +txtpassword.getText().toString()+"')";
							java.sql.Statement statement = con.createStatement();
							int rows=statement.executeUpdate(query);
							JOptionPane.showMessageDialog(null,"account creation successful");
							
							
							Login sf= new Login();
							sf.contentPane.setVisible(true);
							Login.main(null);
							frame.dispose();
							
						
						
									
						}
						catch(Exception ea) {System.out.println(ea);
					}				
			}
		});
		btnNewButton.setBounds(328, 396, 89, 30);
		frame.getContentPane().add(btnNewButton);
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
