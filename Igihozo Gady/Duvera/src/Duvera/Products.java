package Duvera;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.border.BevelBorder;

import Transfer.There;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Products {

	private JFrame frame;
	public static JTextField textprice;
	public static JTextField textquantity;
	public static JTextField textbname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Products window = new Products();
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
	public Products() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 224));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AVAILABLE PRODUCTS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Gadugi", Font.BOLD, 14));
		lblNewLabel.setBounds(87, 51, 181, 28);
		frame.getContentPane().add(lblNewLabel);
		
		textprice = new JTextField();
		textprice.setBounds(223, 251, 104, 28);
		frame.getContentPane().add(textprice);
		textprice.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Quantity");
		lblNewLabel_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(47, 194, 83, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
		lblNewLabel_2.setBounds(47, 258, 69, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		textquantity = new JTextField();
		textquantity.setColumns(10);
		textquantity.setBounds(223, 177, 98, 28);
		frame.getContentPane().add(textquantity);
		
		JButton btnNewButton = new JButton("Add to Cart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Products info=new Products();
				Order.main(null);
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(223, 328, 104, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Brand Name");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(47, 127, 104, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textbname = new JTextField();
		textbname.setBounds(224, 108, 98, 33);
		frame.getContentPane().add(textbname);
		textbname.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Availableproduct sf= new Availableproduct();				
				sf.frame.setVisible(true);
				frame.dispose();

			}
		});
		btnNewButton_1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		btnNewButton_1.setBounds(10, 17, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		frame.setBounds(100, 100, 371, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void setViible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
