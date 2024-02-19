package Duvera;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Adding {

	JFrame frame;
	private JTextField Nametxt;
	private JTextField txtamount;
	private JTextField txtperiod;
	private JTextField txtaddress;
	private JTextField txtrooms;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adding window = new Adding();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Adding() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(100, 100, 404, 431);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Contentlbl = new JLabel("ADDING NEW HOUSE");
		Contentlbl.setHorizontalAlignment(SwingConstants.CENTER);
		Contentlbl.setFont(new Font("Times New Roman", Font.BOLD, 17));
		Contentlbl.setBounds(120, 11, 235, 24);
		frame.getContentPane().add(Contentlbl);
		
		JLabel Carnmelbl = new JLabel("House Id");
		Carnmelbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Carnmelbl.setBounds(28, 80, 93, 14);
		frame.getContentPane().add(Carnmelbl);
		
		Nametxt = new JTextField();
		Nametxt.setBounds(144, 78, 211, 20);
		frame.getContentPane().add(Nametxt);
		Nametxt.setColumns(10);
		
		JLabel Pricelbl = new JLabel("Rent amount");
		Pricelbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Pricelbl.setBounds(28, 181, 99, 18);
		frame.getContentPane().add(Pricelbl);
		
		txtamount = new JTextField();
		txtamount.setBounds(144, 181, 211, 20);
		frame.getContentPane().add(txtamount);
		txtamount.setColumns(10);
		
		JButton ADDbtn = new JButton("ADD NEW");
		ADDbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		ADDbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ADDbtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		ADDbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try{
				 
					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehuyefinder01","root","");
						String query="INSERT INTO rent_houses(House_id,Address,Rooms,Amount,Periodavailable)"
								+ "values('" +Nametxt.getText().toString()+"','" +txtaddress.getText().toString()+"','" +txtrooms.getText().toString()+"','"+txtamount.getText().toString()+"','"+txtperiod.getText().toString()+"')";
					Statement statement = con.createStatement();
					int rows=statement.executeUpdate(query);
					//car_id,
		
	
					if(rows>0) {
						JOptionPane.showMessageDialog(null,"House added!");
					}
				
		if(con!=null) {
			System.out.println("connected to database");
			con.close();
		}
					   //upDateDB();
							
				}
				catch(Exception ea) {System.out.println(ea);
			}
				
			}
		});
		ADDbtn.setFont(new Font("Times New Roman", Font.BOLD, 13));
		ADDbtn.setBackground(new Color(0, 100, 0));
		ADDbtn.setBounds(262, 330, 93, 24);
		frame.getContentPane().add(ADDbtn);
		
		JButton Resetbtn = new JButton("RESET");
		Resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtrooms.setText("");
				txtaddress.setText("");
				Nametxt.setText("");
				txtamount.setText(null);
				txtperiod.setText(null);
				
			}
		});
		Resetbtn.setBackground(new Color(0, 128, 128));
		Resetbtn.setFont(new Font("Times New Roman", Font.BOLD, 13));
		Resetbtn.setBounds(144, 330, 89, 24);
		frame.getContentPane().add(Resetbtn);
		
		JLabel snumlbl = new JLabel("Period in (Months)");
		snumlbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		snumlbl.setBounds(28, 209, 140, 31);
		frame.getContentPane().add(snumlbl);
		
		txtperiod = new JTextField();
		txtperiod.setBounds(223, 215, 132, 20);
		frame.getContentPane().add(txtperiod);
		txtperiod.setColumns(10);
		
		txtaddress = new JTextField();
		txtaddress.setBounds(144, 109, 211, 22);
		frame.getContentPane().add(txtaddress);
		txtaddress.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAddress.setBounds(28, 110, 99, 18);
		frame.getContentPane().add(lblAddress);
		
		JLabel Romms = new JLabel("Rooms");
		Romms.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Romms.setBounds(32, 139, 89, 31);
		frame.getContentPane().add(Romms);
		
		txtrooms = new JTextField();
		txtrooms.setColumns(10);
		txtrooms.setBounds(144, 148, 211, 22);
		frame.getContentPane().add(txtrooms);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Rent sf= new Rent();
					sf.frame.setVisible(true);
					frame.dispose();
				
				
				
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
