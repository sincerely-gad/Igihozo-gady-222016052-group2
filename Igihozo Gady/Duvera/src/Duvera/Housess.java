package Duvera;

import java.awt.EventQueue;




import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollBar;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class Housess {

	JFrame frame;
	public static JTextField txtid;
	public static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Housess window = new Housess();
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
	public Housess() {
		initialize();
		Connect();
		table_load();
	}

	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtaddress;
	private JTextField txtrooms;
	private JTextField txtamount;
	private JTextField txtperiody;

	
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
	pst=con.prepareStatement("select* from rent_houses");
	rs=pst.executeQuery();
	table.setModel(DbUtils.resultSetToTableModel(rs));
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
		frame.setBounds(100, 100, 859, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AVAILABLE  HOUSES");
		lblNewLabel.setBounds(274, 11, 218, 31);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 53, 351, 273);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "New life", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("House ID");
		lblNewLabel_1_2.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(10, 28, 81, 16);
		panel.add(lblNewLabel_1_2);
		
		txtid = new JTextField();
		txtid.setColumns(10);
		txtid.setBounds(120, 27, 183, 20);
		panel.add(txtid);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Rooms");
		lblNewLabel_1_2_2.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		lblNewLabel_1_2_2.setBounds(10, 115, 81, 16);
		panel.add(lblNewLabel_1_2_2);
		
		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBounds(120, 69, 183, 20);
		panel.add(txtaddress);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Address");
		lblNewLabel_1_2_2_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		lblNewLabel_1_2_2_1.setBounds(10, 70, 81, 16);
		panel.add(lblNewLabel_1_2_2_1);
		
		txtrooms = new JTextField();
		txtrooms.setColumns(10);
		txtrooms.setBounds(120, 114, 183, 20);
		panel.add(txtrooms);
		
		JLabel lblNewLabel_1_2_2_1_1 = new JLabel("Amount");
		lblNewLabel_1_2_2_1_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		lblNewLabel_1_2_2_1_1.setBounds(10, 162, 81, 16);
		panel.add(lblNewLabel_1_2_2_1_1);
		
		txtamount = new JTextField();
		txtamount.setColumns(10);
		txtamount.setBounds(120, 161, 183, 20);
		panel.add(txtamount);
		
		JLabel lblNewLabel_1_2_2_1_2 = new JLabel("Period");
		lblNewLabel_1_2_2_1_2.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		lblNewLabel_1_2_2_1_2.setBounds(10, 206, 81, 16);
		panel.add(lblNewLabel_1_2_2_1_2);
		
		txtperiody = new JTextField();
		txtperiody.setColumns(10);
		txtperiody.setBounds(120, 205, 183, 20);
		panel.add(txtperiody);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(10, 329, 93, 23);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frame,"Confirm if you want to exit","E HUYE FINDER 0.1",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
						System.exit(0);
						}
			}
		});
		btnExit.setVerticalAlignment(SwingConstants.TOP);
		btnExit.setFont(new Font("Cambria", Font.PLAIN, 12));
		frame.getContentPane().add(btnExit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(258, 329, 93, 23);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtaddress.setText("");
				txtid.setText("");
				txtrooms.setText("");
			
				
				
				
			}
		});
		btnClear.setVerticalAlignment(SwingConstants.TOP);
		btnClear.setFont(new Font("Cambria", Font.PLAIN, 12));
		frame.getContentPane().add(btnClear);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(383, 53, 435, 224);
		frame.getContentPane().add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnUpdate = new JButton("Rent");
		btnUpdate.setBounds(734, 329, 93, 23);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//----------amount-------
				String inputText1=txtamount.getText();
				housepay sf= new housepay();
				sf.txtpaymenty.setText(inputText1);
				//-------------id-----------
				String inputText=txtid.getText();
				housepay s0f= new housepay();
				sf.txtpurchasenumber.setText(inputText);
				//------------period-------
				
				String inputTex=txtperiody.getText();
				housepay sf3= new housepay();
				sf.txtperiodpaid.setText(inputText);
				sf.frame.setVisible(true);
				frame.dispose();
				
				
				
				
				
				
				
				
				
				
		
				try{

					Class.forName("com.mysql.jdbc.Driver"); 
					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehuyefinder01","rooty","1234");
						String query="INSERT INTO rented(House_id,Address,Rooms,Amount,Periodrentedfor)"
								+ "values('" +txtid.getText().toString()+"','" +txtaddress.getText().toString()+"','" +txtrooms.getText().toString()+"',"
										+ "'"+txtamount.getText().toString()+"','" +txtperiody.getText().toString()+"')";
					java.sql.Statement statement = con.createStatement();
					int rows=statement.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Wait for call approval");
	
					
					Payment sf1= new Payment();
					sf.frame.setVisible(true);
					frame.dispose();
							
				}
				catch(Exception ea) {System.out.println(ea);
			}
							
				
			}
						
		});
		btnUpdate.setVerticalAlignment(SwingConstants.TOP);
		btnUpdate.setFont(new Font("Cambria", Font.PLAIN, 12));
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Signout");
		btnDelete.setBounds(734, 10, 99, 23);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				Housess sf= new Housess();
				sf.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnDelete.setVerticalAlignment(SwingConstants.TOP);
		btnDelete.setFont(new Font("Cambria", Font.PLAIN, 12));
		frame.getContentPane().add(btnDelete);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				Login sf= new Login();
//				sf.frame.setVisible(true);
//				frame.dispose();
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(383, 300, 311, 46);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Please choose only on the above available houses");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 291, 24);
		panel_1.add(lblNewLabel_1);
	}
}
