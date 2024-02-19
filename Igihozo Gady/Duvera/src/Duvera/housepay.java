package Duvera;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class housepay {

	JFrame frame;
	private JTextField textField;
	private JTextField txttelephone;
	protected Object s;
	 JTextField txtpaymethod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					housepay window = new housepay();
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
	public housepay() {
		initialize();
		Connect();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtlname;
	private JPasswordField txtpassword;
	JTextField txtpurchasenumber;
	JTextField txtpaymenty;
	private JTextField txtpayment;
	JTextField txtperiodpaid;

	
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
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PAYMENT");
		lblNewLabel.setFont(new Font("Ink Free", Font.BOLD, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(132, 11, 158, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Telephone");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(48, 92, 92, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Available payment methods");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(48, 130, 152, 19);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Amount to pay");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_2.setBounds(48, 194, 92, 19);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("(250)");
		textField.setBounds(166, 92, 34, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		txttelephone = new JTextField();
		txttelephone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txttelephone.setBounds(251, 92, 128, 20);
		frame.getContentPane().add(txttelephone);
		txttelephone.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "MTN", "AIRTEL/TIGO"}));
		comboBox_1.setBounds(210, 128, 106, 22);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnNewButton = new JButton("Pay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String Tel,Amount_paid,Payment_method;
					Tel=txttelephone.getText();
					Payment_method=txtpaymethod.getText();

					Class.forName("com.mysql.jdbc.Driver"); 
					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehuyefinder01","rooty","1234");
						String query="INSERT INTO payment(product_id,Tel,Amount_paid,Payment_method)"
								+ "values('"+txtpurchasenumber.getText().toString()+"','" +txttelephone.getText().toString()+"','" +txtpayment.getText().toString()+"','" +txtpaymethod.getText().toString()+"')";
					java.sql.Statement statement = con.createStatement();
					int rows=statement.executeUpdate(query);
					
					
					if(Tel.equals("")) {
						JOptionPane.showMessageDialog(null, "input Your telephone number please!");
						
					}
					else  if(Payment_method.equals("")) {
						JOptionPane.showMessageDialog(null, "input payment method please!");						
					}
					
					
					JOptionPane.showMessageDialog(null,"Payment recorded");		
				}
				catch(Exception ea) {System.out.println(ea);
			}
		
				

				
				JOptionPane.showMessageDialog(null, "Payment Sucessful, Products will be delivered   "
						+ "to your address soon, You are going to be directed "
						+ "to our products again !!");
				Login sf= new Login();
				sf.contentPane.setVisible(true);
				Login.main(null);
				
				frame.dispose();
				
				
			}
		});
		btnNewButton.setBackground(new Color(205, 133, 63));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(329, 396, 89, 28);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Pament method");
		lblNewLabel_3.setBounds(48, 225, 128, 19);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtpaymethod = new JTextField();
		txtpaymethod.setToolTipText("Enter payment method again please");
		txtpaymethod.setColumns(10);
		txtpaymethod.setBounds(210, 224, 169, 20);
		frame.getContentPane().add(txtpaymethod);
		
		txtpurchasenumber = new JTextField();
		txtpurchasenumber.setEditable(false);
		txtpurchasenumber.setBounds(252, 61, 113, 20);
		frame.getContentPane().add(txtpurchasenumber);
		txtpurchasenumber.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Payment no");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(51, 64, 92, 19);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtpaymenty = new JTextField();
		txtpaymenty.setEditable(false);
		txtpaymenty.setBounds(210, 164, 169, 20);
		frame.getContentPane().add(txtpaymenty);
		txtpaymenty.setColumns(10);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Calculated Amount");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_2_1.setBounds(48, 160, 128, 19);
		frame.getContentPane().add(lblNewLabel_1_1_2_1);
		
		txtpayment = new JTextField();
		txtpayment.setColumns(10);
		txtpayment.setBounds(210, 194, 169, 20);
		frame.getContentPane().add(txtpayment);
		
		JLabel lblNewLabel_3_1 = new JLabel("Period paid for");
		lblNewLabel_3_1.setBounds(48, 255, 128, 19);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		txtperiodpaid = new JTextField();
		txtperiodpaid.setToolTipText("Enter payment method again please");
		txtperiodpaid.setColumns(10);
		txtperiodpaid.setBounds(210, 255, 169, 20);
		frame.getContentPane().add(txtperiodpaid);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\H_alinton54\\Downloads\\download (5).jfif"));
		lblNewLabel_2.setBounds(153, 281, 275, 174);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setBounds(100, 100, 444, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
