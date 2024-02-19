package Duvera;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;



import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class Availableproduct {

	JFrame frame;
	private JLayeredPane layeredPane;
	 JPanel panel_1;
	private JTextField txtdeliveryprice;
	private JTextField txtsub;
	private JTextField txttotal;
	private JTextField txtplace;
	private JTextField txtdate;
	private JTextField txttime;
	private JTextField txtto;
	private JTextField txtproductnumber;
	private JTextField txtquantity;
	private JComboBox comboBoxx;
	private JTextField txtWeCurrentlyDeliver;
	private JTextField txtprice;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	
	public void fillCombobox() {
		 
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehuyefinder01","rooty","1234");
				String query="SELECT * FROM products  ";
			PreparedStatement stat = con.prepareStatement(query);
			ResultSet rs=stat.executeQuery();
			
			while(rs.next()){
				comboBoxx.addItem(rs.getString("Name"));
			}
		
	stat.close();
	con.close();
	
			
				
		
		
if(con!=null) {
	System.out.println("connected to database");
	con.close();
}
else {
	JOptionPane.showMessageDialog(null,"no connection with database!");
}
			  					
		}
		catch(Exception ev) {System.out.println(ev);
	}
	  
 }
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Availableproduct window = new Availableproduct();
					window.getFrame().setVisible(true);
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
	public Availableproduct() {
		initialize();
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
		panel.setBounds(0, 0, 104, 437);
		getFrame().getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\H_alinton54\\Downloads\\User.jfif"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBounds(10, 11, 30, 25);
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
		btnPanel_1_1.setBounds(5, 390, 89, 36);
		panel.add(btnPanel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\H_alinton54\\Downloads\\pass.png"));
		lblNewLabel_1.setBounds(50, 11, 44, 25);
		panel.add(lblNewLabel_1);
		
		 layeredPane = new JLayeredPane();
		layeredPane.setBounds(102, 30, 709, 396);
		getFrame().getContentPane().add(layeredPane);
		
		 panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 0));
		panel_1.setBounds(0, 0, 713, 396);
		layeredPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Brand name");
		lblNewLabel_2.setBounds(16, 11, 87, 23);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblNewLabel_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(363, 58, 9, 284);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		panel_1.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(16, 179, 309, 2);
		panel_1.add(separator);
		
		JLabel delivery = new JLabel("Delivery");
		delivery.setBounds(14, 198, 57, 14);
		panel_1.add(delivery);
		
		JLabel lblNewLabel_4 = new JLabel("Products Amount");
		lblNewLabel_4.setBounds(10, 234, 115, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Total");
		lblNewLabel_4_1.setBounds(10, 274, 61, 14);
		panel_1.add(lblNewLabel_4_1);
		
		txtdeliveryprice = new JTextField();
		txtdeliveryprice.setEditable(false);
		txtdeliveryprice.setBounds(145, 192, 187, 20);
		panel_1.add(txtdeliveryprice);
		txtdeliveryprice.setColumns(10);
		
		txtsub = new JTextField();
		txtsub.setEditable(false);
		txtsub.setBounds(145, 228, 187, 20);
		txtsub.setColumns(10);
		panel_1.add(txtsub);
		
		txttotal = new JTextField();
		txttotal.setEditable(false);
		txttotal.setBounds(145, 268, 187, 20);
		txttotal.setColumns(10);
		panel_1.add(txttotal);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(363, 11, 299, 2);
		panel_1.add(separator_3);
		
		JLabel lblNewLabel_6 = new JLabel("Place");
		lblNewLabel_6.setBounds(395, 72, 64, 14);
		lblNewLabel_6.setToolTipText("To be delivered at ");
		panel_1.add(lblNewLabel_6);
		
		JComboBox cmbdestination = new JComboBox();
		cmbdestination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cmbdestination.getSelectedIndex()==0) {
					double m1=Integer.parseInt(txtsub.getText());
					double responce=m1;
					 double price=200;
					txtdeliveryprice.setText(String.valueOf(price));
				}
				
			}
		});
		cmbdestination.setBounds(224, 146, 101, 22);
		cmbdestination.setToolTipText("Choose delivery Address");
		cmbdestination.setModel(new DefaultComboBoxModel(new String[] {"KAMINUZA"}));
		panel_1.add(cmbdestination);
		
		JButton btntotal = new JButton("View  Amount");
		btntotal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btntotal.setBounds(205, 351, 127, 23);
		btntotal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

//				------------13-------------------
				
				
				
			}
		});
		btntotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double qty=Integer.parseInt(txtquantity.getText());
				double price=Integer.parseInt(txtsub.getText());
				double result=qty*price;
				
				txttotal.setText(String.valueOf(result));
				ResultSet rs = null;
				
				String inputText1=txttotal.getText();
				Availableproduct sf1= new Availableproduct();
				sf1.txtprice.setText(inputText1);
//				sf.Payment.setVisible(true);
//				MainFrame.dispose();		
								
				//-----------Timer---------
				Calendar timer= Calendar.getInstance();
				timer.getTime();
				SimpleDateFormat tTime= new SimpleDateFormat("HH:mm:ss");
				txttime.setText(tTime.format(timer.getTime()));
				//----------------------Date-----------------------------
				SimpleDateFormat Tdate=new SimpleDateFormat("dd-MMM-yyy");
				txtdate.setText(Tdate.format(timer.getTime()));
				txtplace.setText("MUKONI *");
				txtto.setText((String) cmbdestination.getSelectedItem()+"*");
				//------- number selection----------
				int num1;
				String q1="";
				num1=1325+(int)(Math.random()*4938);
				q1+=num1+1325;
				txtproductnumber.setText(q1);
			}
		});
		btntotal.setToolTipText("View total amount that you will pay");
		panel_1.add(btntotal);
		
		JButton btnreset = new JButton("Reset");
		btnreset.setBounds(106, 351, 73, 23);
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtdeliveryprice.setText(null);
				txtsub.setText(null);
				txttotal.setText(null);
				txtquantity.setText(null);
				
				cmbdestination.setSelectedItem("Address");
				txtplace.setText(null);
				txtdate.setText(null);
				txttime.setText(null);
				txtto.setText(null);
				txtproductnumber.setText(null);
				
				
				
			}
		});
		btnreset.setToolTipText("Select again");
		panel_1.add(btnreset);
		
		JButton btnexit = new JButton("Exit");
		btnexit.setBounds(10, 351, 73, 23);
		btnexit.setToolTipText("close all activities");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frame,"Confirm if you want to exit","E HUYE FINDER 0.1",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
						System.exit(0);
						}
			}
		});
		panel_1.add(btnexit);
		
		JLabel lblNewLabel_6_1 = new JLabel("Date");
		lblNewLabel_6_1.setBounds(395, 153, 64, 14);
		lblNewLabel_6_1.setToolTipText("Date issued");
		panel_1.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Time");
		lblNewLabel_6_1_1.setBounds(395, 200, 64, 14);
		lblNewLabel_6_1_1.setToolTipText("Time issued");
		panel_1.add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_7 = new JLabel("Price");
		lblNewLabel_7.setBounds(395, 249, 46, 14);
		lblNewLabel_7.setToolTipText("Product amounts");
		panel_1.add(lblNewLabel_7);
		
		txtplace = new JTextField();
		txtplace.setEditable(false);
		txtplace.setBounds(469, 72, 186, 20);
		txtplace.setColumns(10);
		panel_1.add(txtplace);
		
		txtdate = new JTextField();
		txtdate.setEditable(false);
		txtdate.setBounds(469, 150, 186, 20);
		txtdate.setColumns(10);
		panel_1.add(txtdate);
		
		txttime = new JTextField();
		txttime.setEditable(false);
		txttime.setBounds(469, 200, 186, 20);
		txttime.setColumns(10);
		panel_1.add(txttime);
		
		JLabel textto = new JLabel("To");
		textto.setBounds(395, 111, 64, 14);
		textto.setToolTipText("To be delivered at ");
		panel_1.add(textto);
		
		txtto = new JTextField();
		txtto.setEditable(false);
		txtto.setBounds(469, 111, 186, 20);
		txtto.setColumns(10);
		panel_1.add(txtto);
		
		JLabel textproductnumber = new JLabel("Purchase No");
		textproductnumber.setBounds(395, 32, 87, 14);
		textproductnumber.setToolTipText("To be delivered at ");
		panel_1.add(textproductnumber);
		
		txtproductnumber = new JTextField();
		txtproductnumber.setEditable(false);
		txtproductnumber.setBounds(568, 32, 86, 20);
		txtproductnumber.setColumns(10);
		panel_1.add(txtproductnumber);
		
		JButton btnPanel_1 = new JButton("Pay");
		btnPanel_1.setBounds(585, 344, 78, 36);
		panel_1.add(btnPanel_1);
		btnPanel_1.setFont(new Font("SimSun", Font.BOLD, 12));
		btnPanel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel lblNewLabel_3 = new JLabel("Picture");
		lblNewLabel_3.setBounds(147, 11, 178, 88);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\H_alinton54\\Downloads\\images (16).jfif"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);
		
		comboBoxx = new JComboBox();
		comboBoxx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					Class.forName("com.mysql.jdbc.Driver"); 
					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehuyefinder01","rooty","1234");
						String query="SELECT * FROM products where Name=? ";
					PreparedStatement stat = con.prepareStatement(query);
					stat.setString(1, (String)comboBoxx.getSelectedItem());
					ResultSet rs=stat.executeQuery();
					
					while(rs.next()) {
//						txtqnty.setText(rs.getString("Quantity"));
						txtsub.setText(rs.getString("Price"));
//						txtquantity.setText(rs.getString("Quantity"));
						
						
					}
				
		      
			
			stat.close();
			con.close();
			
							
		if(con!=null) {
			System.out.println("connected to database");
			con.close();
		}
					  
							
				}
				catch(Exception ev) {System.out.println(ev);
			}
			}
		});
		comboBoxx.setBounds(16, 45, 115, 22);
		panel_1.add(comboBoxx);
		
		JLabel lblNewLabel_2_2 = new JLabel("Quantity");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2.setBounds(16, 82, 87, 23);
		panel_1.add(lblNewLabel_2_2);
		
		txtquantity = new JTextField();
		txtquantity.setBounds(16, 108, 73, 20);
		panel_1.add(txtquantity);
		txtquantity.setColumns(10);
		
		txtWeCurrentlyDeliver = new JTextField();
		txtWeCurrentlyDeliver.setForeground(new Color(255, 255, 255));
		txtWeCurrentlyDeliver.setBackground(new Color(128, 128, 0));
		txtWeCurrentlyDeliver.setEditable(false);
		txtWeCurrentlyDeliver.setText(" We currently deliver our products near UR  ");
		txtWeCurrentlyDeliver.setBounds(106, 105, 247, 20);
		panel_1.add(txtWeCurrentlyDeliver);
		txtWeCurrentlyDeliver.setColumns(10);
		
		txtprice = new JTextField();
		txtprice.setEditable(false);
		txtprice.setBounds(469, 246, 190, 20);
		panel_1.add(txtprice);
		txtprice.setColumns(10);
		
		textField = new JTextField();
		textField.setText(" We currently deliver our products near UR  ");
		textField.setForeground(Color.WHITE);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(128, 128, 0));
		textField.setBounds(106, 127, 247, 20);
		panel_1.add(textField);
		btnPanel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String inputText1=txttotal.getText() +"  +200 frw delivery";
				Payment sf= new Payment();
				sf.txtpaymenty.setText(inputText1);
				
				String inputText=txtproductnumber.getText();
				Payment s0f= new Payment();
				sf.txtpurchasenumber.setText(inputText);
				
				
				
				sf.frame.setVisible(true);
				frame.dispose();
				
			
//				sf0.frame.setVisible(true);
//				frame.dispose();
//

		
			}
		});
		
		JLabel lblNewLabel = new JLabel("OUR  PRODUCTS HERE");
		lblNewLabel.setBackground(new Color(143, 188, 143));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 26));
		lblNewLabel.setBounds(185, 0, 471, 31);
		getFrame().getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Rent");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Housess sf= new Housess();
				sf.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Rent sf= new Rent();
				sf.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("SimSun", Font.PLAIN, 11));
		btnNewButton.setToolTipText("click here to rent house");
		btnNewButton.setBounds(742, 7, 67, 19);
		frame.getContentPane().add(btnNewButton);
		getFrame().setBounds(100, 100, 837, 476);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fillCombobox();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	
	}
}
