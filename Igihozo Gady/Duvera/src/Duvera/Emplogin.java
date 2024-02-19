package Duvera;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class Emplogin {

	JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField txtClickHereTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emplogin window = new Emplogin();
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
	public Emplogin() {
		initialize();
		Connect();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	protected Object Emplogin;
	Statement St= null;

	
	public void Connect()
	{
		
		String Query= "select * from employee where Email= '" + textField.getText() + "' and password ='" + passwordField.getText()+ "'";
	try{ 
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost/ehuyefinder01", "rooty","1234");
	St=con.createStatement();
	rs= St.executeQuery(Query);   
	if(rs.next()) {
		
		
		JOptionPane.showMessageDialog(null, "Login Sucessful!");
		
		Delivery sf= new Delivery();
		sf.frame.setVisible(true);
		frame.dispose();
	}
	else {
		JOptionPane.showMessageDialog(null, "Error occured" + " Invalid Username or Password" , "Try again", JOptionPane.ERROR_MESSAGE);
//		passwordField.setText(null);
//		textField.setText(null);
		
	}

	
	}
	catch(ClassNotFoundException ex){}
	catch (SQLException ex)
	{}
	}
	

	private Delivery Delivery() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VALUED  EMPLOYEE ");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 48, 232, 55);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 13));
		lblNewLabel_1.setBounds(37, 164, 82, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(37, 227, 82, 24);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(127, 167, 209, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(127, 230, 209, 21);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setToolTipText("Click here to login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
if(textField.getText().isEmpty()||passwordField.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null,"Fill those fields first");
				}
				else {
					try{
						String query="SELECT * FROM employees WHERE Email=? and Password=?";
						 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehuyefinder01","rooty","1234");
						PreparedStatement pst = con.prepareStatement(query);
						pst.setString(1,textField.getText());
						pst.setString(2,passwordField.getText());
				
						ResultSet rs=pst.executeQuery();
						if(rs.next()) {
							JOptionPane.showMessageDialog(null,"login successfully.....");
							
							Delivery info=new Delivery();
							Delivery.main(null);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null,"username and password doesn't match");
						}
					}
					catch(Exception ee) {System.out.println(ee);}
					
					
				}
				
				
				
			}
			
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 11));
		btnNewButton.setBounds(135, 293, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnApply = new JButton("REGISTER");
		btnApply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnApply.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnApply.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), null));
		btnApply.setToolTipText("Click here to register ");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register sf= new register();
				sf.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		btnApply.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 11));
		btnApply.setBounds(256, 295, 82, 23);
		frame.getContentPane().add(btnApply);
		
		txtClickHereTo = new JTextField();
		txtClickHereTo.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		txtClickHereTo.setBounds(199, 351, 142, 20);
		frame.getContentPane().add(txtClickHereTo);
		txtClickHereTo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\H_alinton54\\Downloads\\images (13).jfif"));
		lblNewLabel_2.setBounds(2, 0, 370, 137);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setBounds(100, 100, 389, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
