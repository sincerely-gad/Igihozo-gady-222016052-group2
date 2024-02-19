package Duvera;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class Home {

	private JFrame frame;
	private JTextField txtItsOurPleasure;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" E HUYE FINDER  0.1");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setBounds(119, 11, 325, 40);
		frame.getContentPane().add(lblNewLabel);
		
		
		JButton btnNewButton = new JButton("EMPLOYEE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Welcome back!");
				
				Emplogin sf= new Emplogin();
				sf.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Maiandra GD", Font.BOLD, 17));
		btnNewButton.setBackground(new Color(218, 165, 32));
		btnNewButton.setForeground(new Color(85, 107, 47));
		btnNewButton.setBounds(10, 122, 123, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CUSTOMER");
		btnNewButton_1.setBackground(new Color(244, 164, 96));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Our pleasure to have you!");
				
				Login sf= new Login();
				sf.contentPane.setVisible(true);
				Login.main(null);
				frame.dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Papyrus", Font.BOLD, 15));
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setBounds(10, 62, 159, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ADMIN");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Adminlogin sf= new Adminlogin();
				sf.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Berlin Sans FB", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(166, 280, 95, 34);
		frame.getContentPane().add(btnNewButton_2);
		
		txtItsOurPleasure = new JTextField();
		txtItsOurPleasure.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtItsOurPleasure.setEditable(false);
		txtItsOurPleasure.setBackground(new Color(255, 192, 203));
		txtItsOurPleasure.setForeground(Color.DARK_GRAY);
		txtItsOurPleasure.setText("It's our pleasure to serve you");
		txtItsOurPleasure.setBounds(337, 301, 180, 20);
		frame.getContentPane().add(txtItsOurPleasure);
		txtItsOurPleasure.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setIcon(new ImageIcon("C:\\Users\\H_alinton54\\Downloads\\images (8).jfif"));
		lblNewLabel_1_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_2.setBounds(265, 0, 275, 163);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("");
		lblNewLabel_1_2_1.setIcon(new ImageIcon("C:\\Users\\H_alinton54\\Downloads\\images (6).jfif"));
		lblNewLabel_1_2_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setBounds(271, 164, 259, 163);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("");
		lblNewLabel_1_2_1_1.setIcon(new ImageIcon("C:\\Users\\H_alinton54\\Downloads\\images (15).jfif"));
		lblNewLabel_1_2_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1_1.setBounds(0, 0, 267, 163);
		frame.getContentPane().add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("");
		lblNewLabel_1_2_1_2.setIcon(new ImageIcon("C:\\Users\\H_alinton54\\Downloads\\images (9).jfif"));
		lblNewLabel_1_2_1_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_2_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1_2.setBounds(0, 154, 315, 173);
		frame.getContentPane().add(lblNewLabel_1_2_1_2);
		frame.setBounds(100, 100, 540, 364);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
