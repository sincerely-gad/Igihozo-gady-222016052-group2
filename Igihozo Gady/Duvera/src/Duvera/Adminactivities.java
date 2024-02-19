package Duvera;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Adminactivities {

	JFrame frame;
	private JTextField txtAllRightReserved;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminactivities window = new Adminactivities();
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
	public Adminactivities() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 102));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("E HUYE FINDER");
		lblNewLabel.setBounds(77, 11, 266, 47);
		lblNewLabel.setForeground(new Color(51, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 24));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Products");
		btnNewButton.setBounds(87, 78, 103, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertProducts info=new InsertProducts();
				info.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRent = new JButton("Rent");
		btnRent.setBounds(87, 124, 103, 23);
		btnRent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    Rent sf= new Rent();
				sf.frame.setVisible(true);
				frame.dispose();
				
				
		
			}
		});
		btnRent.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnRent.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(btnRent);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(63, 56, 288, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(195, 77, 2, 143);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		frame.getContentPane().add(separator_1);
		
		txtAllRightReserved = new JTextField();
		txtAllRightReserved.setBounds(200, 350, 186, 20);
		txtAllRightReserved.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtAllRightReserved.setHorizontalAlignment(SwingConstants.CENTER);
		txtAllRightReserved.setText("All right reserved  Duvera @2022");
		frame.getContentPane().add(txtAllRightReserved);
		txtAllRightReserved.setColumns(10);
		
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewcustomers sf= new viewcustomers();
				sf.frame.setVisible(true);
				frame.dispose();
				
				
			}
			
		});
		btnCustomers.setBounds(216, 126, 103, 23);
		frame.getContentPane().add(btnCustomers);
		
		JButton btnEmployees = new JButton("Employees");
		btnEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewemployees sf= new viewemployees();
				sf.frame.setVisible(true);
				frame.dispose();
				
				
				
			}
		});
		btnEmployees.setBounds(216, 163, 103, 23);
		frame.getContentPane().add(btnEmployees);
		
		JButton button_1_1 = new JButton("Products");
		button_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewproducts sf= new viewproducts();
				sf.getFrame().setVisible(true);
				frame.dispose();
				
				
				
			}
		});
		button_1_1.setBounds(216, 197, 103, 23);
		frame.getContentPane().add(button_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("VIEW ALL HERE");
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblNewLabel_2.setBounds(200, 69, 125, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnPayments = new JButton("Payments");
		btnPayments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewpayments sf= new viewpayments();
				sf.frame.setVisible(true);
				frame.dispose();
				
				
			}
		});
		btnPayments.setBounds(216, 91, 103, 23);
		frame.getContentPane().add(btnPayments);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(54, 56, 302, 208);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\H_alinton54\\Downloads\\images (8).jfif"));
		frame.getContentPane().add(lblNewLabel_1);
		frame.setBounds(100, 100, 402, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
