
package Duvera;
import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class register {

    JFrame frame;
	private JTextField txtfname;
	private JTextField txttelephone;
	private JTextField txtaddress;
	private JTextField txtemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register window = new register();
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
	public register() {
		initialize();
		Connect();
			}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtlname;
	private JPasswordField txtpassword;

	
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
	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" EMPLOYEE REGISTRATION  FORM");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(68, 11, 320, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First name");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(25, 73, 93, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last name ");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(25, 126, 93, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tel");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(25, 166, 93, 27);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(25, 275, 93, 27);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Address");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(25, 220, 93, 27);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		txtfname = new JTextField();
		txtfname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtfname.setBounds(147, 78, 241, 22);
		frame.getContentPane().add(txtfname);
		txtfname.setColumns(10);
		
		txtlname = new JTextField();
		txtlname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtlname.setColumns(10);
		txtlname.setBounds(147, 125, 241, 22);
		frame.getContentPane().add(txtlname);
		
		txttelephone = new JTextField();
		txttelephone.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttelephone.setColumns(10);
		txttelephone.setBounds(147, 171, 241, 22);
		frame.getContentPane().add(txttelephone);
		
		txtaddress = new JTextField();
		txtaddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtaddress.setColumns(10);
		txtaddress.setBounds(147, 222, 241, 22);
		frame.getContentPane().add(txtaddress);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtemail.setColumns(10);
		txtemail.setBounds(147, 277, 241, 22);
		frame.getContentPane().add(txtemail);
		
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{

					Class.forName("com.mysql.jdbc.Driver"); 
					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehuyefinder01","rooty","1234");
						String query="INSERT INTO employees(Firstname,Lastname,Telephone,Address,Email,Password)"
								+ "values('" +txtfname.getText().toString()+"','" +txtlname.getText().toString()+"','" +txttelephone.getText().toString()+"',"
										+ "'"+txtaddress.getText().toString()+"','"+txtemail.getText().toString()+"','" +txtpassword.getText().toString()+"')";
					java.sql.Statement statement = con.createStatement();
					int rows=statement.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"account creation successful");
					
				
				
							
				}
				catch(Exception ea) {System.out.println(ea);
			}
		
				

				
			JOptionPane.showMessageDialog(null, "Register sucessful!");
			Emplogin sf= new Emplogin();
			sf.frame.setVisible(true);
			frame.dispose();
			
			
			}
		});
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		register.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		register.setBackground(new Color(205, 133, 63));
		register.setForeground(new Color(255, 255, 255));
		register.setBounds(299, 372, 89, 35);
		frame.getContentPane().add(register);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Password");
		lblNewLabel_1_4_1.setForeground(Color.WHITE);
		lblNewLabel_1_4_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_4_1.setBounds(25, 324, 93, 27);
		frame.getContentPane().add(lblNewLabel_1_4_1);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(147, 329, 235, 27);
		frame.getContentPane().add(txtpassword);
		frame.setBounds(100, 100, 478, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}
}
