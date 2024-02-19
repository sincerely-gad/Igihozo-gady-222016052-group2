package Duvera;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Transfer.There;
import net.proteanit.sql.DbUtils;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JTable;

public class Rent {

	JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rent window = new Rent();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Rent() {
		initialize();
		Connect();
		table_loader();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table1;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnprint;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton_1;

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
			String query="SELECT * FROM rent_houses";
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
		setFrame(new JFrame());
		getFrame().getContentPane().setBackground(new Color(169, 169, 169));
		getFrame().getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 125, 437);
		getFrame().getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Add new");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Adding sf= new Adding();
				sf.frame.setVisible(true);
				frame.dispose();
				
				
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton.setBounds(10, 118, 89, 36);
		panel.add(btnNewButton);
		
		JButton btnPanel = new JButton("Rented");
		btnPanel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 12));
		btnPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewrented sf= new viewrented();
				sf.frame.setVisible(true);
				frame.dispose();
				
				
			}
		});
		btnPanel.setBounds(10, 173, 89, 36);
		panel.add(btnPanel);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setToolTipText("Go to products store");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\H_alinton54\\Downloads\\User.jfif"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminactivities sf= new Adminactivities();
				sf.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBounds(10, 11, 105, 25);
		panel.add(btnNewButton_1);
		
		JButton btnPanel_1_1 = new JButton("Sign out");
		btnPanel_1_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		btnPanel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnPanel_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPanel_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login sf= new Login();
				sf.contentPane.setVisible(true);
				Login.main(null);
				
				frame.dispose();
				
			}
		});
		btnPanel_1_1.setBounds(10, 376, 89, 36);
		panel.add(btnPanel_1_1);
		
		JLabel lblNewLabel = new JLabel("RENT HOUSE HERE");
		lblNewLabel.setBackground(new Color(143, 188, 143));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 26));
		lblNewLabel.setBounds(152, 11, 471, 42);
		getFrame().getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(146, 72, 519, 302);
		frame.getContentPane().add(scrollPane_2);
		
		table = new JTable();
		scrollPane_2.setViewportView(table);
		getFrame().setBounds(100, 100, 781, 476);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void Switch_screen(JPanel p) {
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
