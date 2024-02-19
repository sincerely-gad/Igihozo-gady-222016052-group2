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

public class InsertProducts {

	JFrame frame;
	public static JTextField txtbname;
	public static JTextField txtquantity;
	public static JTextField txtprice;
	public static JTable table;
	private JTextField txtbid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertProducts window = new InsertProducts();
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
	public InsertProducts() {
		initialize();
		Connect();
		table_load();
	}

	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	
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
	pst=con.prepareStatement("select* from products");
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
		
		JLabel lblNewLabel = new JLabel("AVAILABLE  PRODUCTS");
		lblNewLabel.setBounds(274, 11, 218, 31);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 53, 351, 190);
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Brand Name");
		lblNewLabel_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 36, 81, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 89, 81, 16);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Price");
		lblNewLabel_1_2.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(10, 144, 81, 16);
		panel.add(lblNewLabel_1_2);
		
		txtbname = new JTextField();
		txtbname.setBounds(120, 35, 183, 20);
		panel.add(txtbname);
		txtbname.setColumns(10);
		
		txtquantity = new JTextField();
		txtquantity.setColumns(10);
		txtquantity.setBounds(120, 88, 183, 20);
		panel.add(txtquantity);
		
		txtprice = new JTextField();
		txtprice.setColumns(10);
		txtprice.setBounds(120, 143, 183, 20);
		panel.add(txtprice);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(10, 254, 93, 23);
		btnNewButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Products x=new Products();   
				Products.textbname.setText(InsertProducts.txtbname.getText());
				Products.textquantity.setText(InsertProducts.txtquantity.getText());
				Products.textprice.setText(InsertProducts.txtprice.getText());
				x.setViible(true);
				
			String Brandname,Quantity,Price;
				Brandname=txtbname.getText();
				Quantity= txtquantity.getText();
				Price=txtprice.getText();
				
				try{
					pst=con.prepareStatement("insert into products(Name,Quantity,Price) values(?,?,?)");
					pst.setString(1,Brandname);
					pst.setString(2, Quantity);
					pst.setString(3, Price);
					if(Brandname.equals("")) {
						JOptionPane.showMessageDialog(null, "input product name please!");
						
					}
					else  if(Quantity.equals("")) {
						JOptionPane.showMessageDialog(null, "input Quantity please!");						
					}
					else  if(Price.equals("")) {
						JOptionPane.showMessageDialog(null, "input price please!");					
					}
					else {
						JOptionPane.showMessageDialog(null, "product added successfully!");
					
					}
					pst.executeUpdate();
					table_load();
					
					txtbname.setText("");
					txtquantity.setText("");
					txtprice.setText("");

					txtbname.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
				
				
	
				
				
			}
		});
		btnNewButton.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(139, 254, 93, 23);
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
		btnClear.setBounds(268, 254, 93, 23);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtbname.setText("");
				txtquantity.setText("");
				txtprice.setText("");
				txtbname.requestFocus();
				
				
				
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 288, 367, 72);
		panel_1.setBorder(new TitledBorder(null, "Serch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Product ID");
		lblNewLabel_1_2_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 12));
		lblNewLabel_1_2_1.setBounds(23, 32, 84, 19);
		panel_1.add(lblNewLabel_1_2_1);
		
		txtbid = new JTextField();
		txtbid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					String id=txtbid.getText();
					pst=con.prepareStatement("select Name,Quantity,Price from products where id=?");
					pst.setString(1,id);
					ResultSet rs=pst.executeQuery();


					if(rs.next()==true){

					String Name=rs.getString(1);
					String Quantity=rs.getString(2);
					String Price=rs.getString(3);

					txtbname.setText(Name);
					txtquantity.setText(Quantity);
					txtprice.setText(Price);
					}
					else
					{
					txtbname.setText("");
					txtquantity.setText("");
					txtprice.setText("");
					}
					}
					catch(SQLException ex){
					}
			}
		});
		txtbid.setColumns(10);
		txtbid.setBounds(117, 32, 206, 20);
		panel_1.add(txtbid);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(399, 302, 93, 23);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				String Brandname,Quantity,Price,bid;
				Brandname=txtbname.getText();
				Quantity= txtquantity.getText();
				Price=txtprice.getText();
				bid=txtbid.getText();
				
				try{
					pst=con.prepareStatement("update products  set Name=?,Quantity=?,Price=? where id=?");
					pst.setString(1,Brandname);
					pst.setString(2, Quantity);
					pst.setString(3, Price);
					pst.setString(4,bid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record updated!");
					table_load();
					
					txtbname.setText("");
					txtquantity.setText("");
					txtprice.setText("");

					txtbname.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
			
				
							
				
			}
						
		});
		btnUpdate.setVerticalAlignment(SwingConstants.TOP);
		btnUpdate.setFont(new Font("Cambria", Font.PLAIN, 12));
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(567, 302, 99, 23);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bid;
				
				bid=txtbid.getText();
				
				try{
					pst=con.prepareStatement("delete from products where id=?");
					pst.setString(1,bid);
					pst.executeUpdate();
					if(bid.equals("")) {
						JOptionPane.showMessageDialog(null, "in put product id first!");
					}
					else {
						
						JOptionPane.showMessageDialog(null, "Record deleted!");
						table_load();
						
					}
					
					
					
					txtbname.setText("");
					txtquantity.setText("");
					txtprice.setText("");

					txtbname.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
			
				
				
				
				
				
				
			}
		});
		btnDelete.setVerticalAlignment(SwingConstants.TOP);
		btnDelete.setFont(new Font("Cambria", Font.PLAIN, 12));
		frame.getContentPane().add(btnDelete);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String Brandname,Quantity,Price,bid;
				Brandname=txtbname.getText();
				Quantity= txtquantity.getText();
				Price=txtprice.getText();
				bid=txtbid.getText();
				
				try{
					pst=con.prepareStatement("update products  set Name=?,Quantity=?,Price=? where id=?");
					pst.setString(1,Brandname);
					pst.setString(2, Quantity);
					pst.setString(3, Price);
					pst.setString(4,bid);
					pst.executeUpdate();
					table_load();
					
					txtbname.setText("");
					txtquantity.setText("");
					txtprice.setText("");

					txtbname.requestFocus();
					}
					catch(SQLException e1){
					e1.printStackTrace();
					}
			
				
			}
		});
		btnView.setVerticalAlignment(SwingConstants.TOP);
		btnView.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnView.setBounds(725, 303, 93, 23);
		frame.getContentPane().add(btnView);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Adminactivities sf= new Adminactivities();
				sf.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(10, 17, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
