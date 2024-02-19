package Duvera;
import java.awt.Window;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	 JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JButton btnLogin;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;
	protected Window frame;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		JLabel background;
	setBackground(new Color(0, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(205, 100, 687, 471);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		
		ImageIcon img= new ImageIcon("images(12)");
		background =new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,1200,700);
		getContentPane().add (background);
		
		
		
		this.setLocationRelativeTo(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(268, 111, 283, 30);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(270, 183, 283, 30);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(passwordField);
		
		btnNewButton = new JButton("REGISTER");
		btnNewButton.setToolTipText("Click here to Register");
		btnNewButton.setBounds(449, 251, 102, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signup rg=new Signup();
				rg.frame.setVisible(true);
				rg.dispose();		
				
			}
		});
		btnNewButton.setBackground(new Color(218, 165, 32));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.add(btnNewButton);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(268, 251, 102, 30);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().isEmpty()||passwordField.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null,"Fill the fields first");
				}
				else {
					try{
						String query="SELECT * FROM customer WHERE Email=? and Password=?";
						 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Igihozogady_222016052","rooty","1234");
						PreparedStatement pst = con.prepareStatement(query);
						pst.setString(1,textField.getText());
						pst.setString(2,passwordField.getText());
				
						ResultSet rs=pst.executeQuery();
						if(rs.next()) {
							JOptionPane.showMessageDialog(null,"login successfully.....");
							
							Homepage info=new Homepage();
							Availableproduct.main(null);
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
		btnLogin.setBackground(new Color(0, 139, 139));
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			
		});
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setBounds(125, 111, 102, 23);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setBounds(125, 183, 102, 23);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setBackground(new Color(144, 238, 144));
		lblNewLabel_2.setBounds(125, 31, 428, 53);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(lblNewLabel_2);
		
		btnNewButton_1 = new JButton("Forget password, reset here");
		btnNewButton_1.setToolTipText("Retrieve your password");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Resetpassword sf= new Resetpassword();
				sf.frame.setVisible(true);
				Resetpassword.main(null);
				frame.dispose();
				
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBounds(369, 308, 182, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\H_alinton54\\Downloads\\download.png"));
		lblNewLabel_3.setBounds(61, 101, 37, 41);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\H_alinton54\\Downloads\\pass.png"));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(61, 165, 46, 59);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home info=new Home();
				Home.main(null);
				dispose();
				
			}
		});
		btnNewButton_2.setBackground(new Color(211, 211, 211));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(10, 11, 64, 23);
		contentPane.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(461, 342, 200, 79);
		contentPane.add(panel);
		panel.setLayout(null);
		
	
	}
}
