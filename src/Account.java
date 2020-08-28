import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Account extends JFrame{

	private JFrame frame;
	
	static int score = Casino.score;
	/**
	 * Launch the application.
	 */
	public void Astart() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account window = new Account();
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
	public Account() {
		/*
		 * Desc: Place where the buttons and labels were made to let you know information about you score and such
		 * pre: A blank form
		 * post: A form with stuff in it
		 */
		getContentPane().setLayout(null);
		
		JLabel lblPoints = new JLabel("Points:");
		lblPoints.setBounds(115, 11, 134, 22);
		getContentPane().add(lblPoints);
		
		JLabel lblWinloss = new JLabel("Win/Loss:");
		lblWinloss.setBounds(115, 60, 134, 22);
		getContentPane().add(lblWinloss);
		
		JButton btnCheckAccount = new JButton("Check Account");
		btnCheckAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblPoints.setText("Points: " + score);
			}
		});
		btnCheckAccount.setBounds(112, 105, 165, 71);
		getContentPane().add(btnCheckAccount);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
