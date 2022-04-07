/**
 @author Jinsu Kwak <a href="mailto:jinsu.kwak@ucalgary.ca">
 jinsu.kwak@ucalgary.ca</a>
 @UCID 30097737
 @version 1.0
 @since 1.0
 */
package edu.ucalgary.ensf409;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JScrollBar;

public class GUISuccess {

	private JFrame frame;
	private static boolean on;
	/**
	 * Launch the application.
	 */
	public static boolean success(Order order) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUISuccess window = new GUISuccess();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return on;
	}

	/**
	 * Create the application.
	 */
	public GUISuccess() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 240, 230));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 660, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ORDER SUCCESSFUL!");
		lblNewLabel_1.setFont(new Font("Helvetica", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(214, 38, 228, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("FoodBank 409");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lantinghei TC", Font.PLAIN, 20));
		lblNewLabel.setBounds(6, 6, 141, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(6, 32, 648, 2);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Order Summary:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(16, 66, 122, 40);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnTryAgain = new JButton("Try Again");
		btnTryAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTryAgain.setFont(new Font("Lantinghei TC", Font.BOLD, 13));
		btnTryAgain.setBackground(Color.LIGHT_GRAY);
		btnTryAgain.setBounds(449, 224, 91, 62);
		frame.getContentPane().add(btnTryAgain);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Lantinghei TC", Font.BOLD, 13));
		btnExit.setBackground(Color.LIGHT_GRAY);
		btnExit.setBounds(542, 224, 91, 62);
		frame.getContentPane().add(btnExit);
		
		JList list = new JList();
		list.setBounds(20, 105, 405, 181);
		frame.getContentPane().add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(427, 105, 15, 181);
		frame.getContentPane().add(scrollBar);
	}
}
