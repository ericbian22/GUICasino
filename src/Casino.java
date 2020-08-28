import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.Font;

public class Casino {

	private JFrame frame;
	//Attempts at making global score and file output
	public static int score = 1000;
	static File points = new File("points.txt");
	//Call to the main menu
	MainMenu m = new MainMenu();
	
	public static void main(String[] args) {
		//Main method that starts everything
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Casino window = new Casino();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		}

	
	public Casino() {
		//Just calls the initialize
		initialize();
		
	}
	
	private void initialize() {
		/*
		 * Desc: Where the frame,buttons and labels of the class are made and given something to do
		 * pre: Nothing
		 * post: A frame full of things
		 */
		frame = new JFrame();
		frame.setBounds(100, 100, 470, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JLabel lblMain = new JLabel("HI");
		lblMain.setBounds(10, 11, 414, 88);
		frame.getContentPane().add(lblMain);
		//Label that gives top opening message
		lblMain.setText("<html>Welcome to Casino Bian <br/> To start you will be given 1000 points to play with <br/> Your Welcome to play any game however some have a minimum point requirment but better rewards <br/> Please select yes if you understand </html>");
		
		
		
		JLabel lblResponse = new JLabel("");
		lblResponse.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblResponse.setBounds(10, 124, 414, 126);
		frame.getContentPane().add(lblResponse);
		
		JButton btnMoveOn = new JButton("Move on");
		btnMoveOn.setVisible(false);
		//Button you press to move on the main menu and games
		btnMoveOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				m.setVisible(true);
				//Trying to get something to send the file with no outcome
				try {
					PrintWriter output = new PrintWriter(Casino.points);
					
					output.write("test");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnMoveOn.setBounds(355, 227, 89, 23);
		frame.getContentPane().add(btnMoveOn);
		
		//Button that opens general rules to the casino
		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblResponse.setText("<html> Before You Start Playing There is Somethings We Gotta Go Over Some Rules and Terms<br/>" + "Rules and Terms:<br/>" +
						"1:No Actual Money or Currency is used in this program<br/>" + 
						"2:All Games are pure chance<br/>" + 
						"3:No betting more points then you have<br/>" + 
						"4:Once out of points you will be forced to leave the casino<br/>" + 
						"Have Fun and enjoy your time at Casino Kelly<html>");
				
				btnMoveOn.setVisible(true);
			}
		});
		btnYes.setBounds(51, 125, 89, 23);
		frame.getContentPane().add(btnYes);
		
		
		JButton btnNo = new JButton("No");
		//Button for general rules and starting opening in more detail
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblResponse.setText("<html>To help clarify You will have 1000 points and <br/> can play lots of different games that you get to bet those points on<br/> " + 
						"Some games require you to have a minium amount of points however the rewards at those games are much higher<br/>" + 
						"Now to move on here is the Rules and Terms:<br/>" + 
						"1:No Actual Money or Currency is used in this program<br/>" + 
						"2:All Games are pure chance<br/>" + 
						"3:No betting more points then you have<br/>" + 
						"4:Once out of points you will be forced to leave the casino<br/>" + 
						"Have Fun and enjoy your time at Casino Kelly<html>");
				btnMoveOn.setVisible(true);
			}
		});
		btnNo.setBounds(266, 125, 89, 23);
		frame.getContentPane().add(btnNo);
		
		
	}
}
