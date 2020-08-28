import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Roulette extends JFrame{

	//Deceleration of the integers,arrays,randoms and strings used
	private JFrame frame;
	Random Die = new Random();
	public int roll;
	int spin = 0;
	int prespin = 32;
	int[] check = new int[1];
	static Image img;
	String test = " ";
	String t;
	int bet;
	
	static int score = Casino.score;
	/**
	 * Launch the application.
	 */
	public void Rstart() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Roulette window = new Roulette();
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
	public Roulette() {
		
		initialize();
		
	}

	
	public void paint(Graphics g) {
		super.paint(g);	
		img = Toolkit.getDefaultToolkit().getImage("RouletteTable.jpg");
		g.drawImage(img, 400, 0, 1000, 1000, null);
		//All drawing until next comment are to make the wheel
		g.drawOval(200, 200, 200, 200);
		g.drawLine(230, 230, 370, 370);
		g.drawLine(300, 200, 300, 400);
		g.drawLine(370, 230, 230, 370);
		g.drawLine(200, 300, 400, 300);
		g.drawLine(260, 200, 337, 390);
		g.drawLine(345, 200, 260, 390);
		g.drawLine(200, 340, 400, 260);
		g.drawLine(200, 260, 400, 340);
		g.setFont(new Font("Verdana", Font.BOLD, 10));
		g.drawString("1", 205, 290);
		g.drawString("2", 310, 385);
		g.drawString("3", 315, 215);
		g.drawString("4", 385, 290);
		g.drawString("5", 225, 350);
		g.drawString("6", 345, 230);
		g.drawString("7", 350, 380);
		g.drawString("8", 250, 230);
		g.drawString("9", 250, 375);
		g.drawString("10", 370, 260);
		g.drawString("11", 280, 215);
		g.drawString("12", 280, 385);
		g.drawString("13", 220, 260);
		g.drawString("14", 365, 350);
		g.drawString("15", 205, 320);
		g.drawString("16", 375, 320);
		//Initial wheel drawing done next the slot in each segment drawing
		g.setColor(Color.RED);
		//ball position 1
		g.drawOval(215, 280, 10, 10);
		//ball position 2
		g.setColor(Color.BLACK);
		g.drawOval(310, 365, 10, 10);
		//ball position 3
		g.setColor(Color.RED);
		g.drawOval(310, 220, 10, 10);
		//ball position 4
		g.setColor(Color.BLACK);
		g.drawOval(370, 280, 10, 10);
		//ball position 5
		g.setColor(Color.RED);
		g.drawOval(235, 335, 10, 10);
		//ball position 6
		g.setColor(Color.BLACK);
		g.drawOval(335, 235, 10, 10);
		//ball position 7
		g.setColor(Color.RED);
		g.drawOval(340, 360, 10, 10);
		//ball position 8
		g.setColor(Color.RED);
		g.drawOval(255, 235, 10, 10);
		//ball position 9
		g.setColor(Color.BLACK);
		g.drawOval(255, 355, 10, 10);
		//ball position 10
		g.setColor(Color.RED);
		g.drawOval(355, 250, 10, 10);
		//ball position 11
		g.setColor(Color.BLACK);
		g.drawOval(280, 220, 10, 10);
		//ball position 12
		g.setColor(Color.RED);
		g.drawOval(280, 365, 10, 10);
		//ball position 13
		g.setColor(Color.BLACK);
		g.drawOval(235, 250, 10, 10);
		//ball position 14
		g.setColor(Color.BLACK);
		g.drawOval(355, 340, 10, 10);
		//ball position 15
		g.setColor(Color.BLACK);
		g.drawOval(225, 310, 10, 10);
		//ball position 16
		g.setColor(Color.RED);
		g.drawOval(365, 310, 10, 10);
		
		//Changes color to gray for the "ball"
		g.setColor(Color.GRAY);
		
		//Checks if the user is rolling or its set up
		if (prespin == 0) {
		
		
		
		//Spin(roll);
			
		//Makes spin start at the first point
		spin = 0;
		
		//For the makes the "ball" go around until it is at the spot to stop
		for (int i = 0; i <= roll; i++) {
			spin++;
			
			if (spin == 0) {
				g.fillOval(215, 280, 10, 10);
			}
			else if (spin == 1) {
				g.fillOval(215, 280, 10, 10);
			}
			else if (spin == 2) {
				g.fillOval(235, 250, 10, 10);
			}
			else if (spin == 3) {
				g.fillOval(255, 235, 10, 10);
			}
			else if (spin == 4) {
				g.fillOval(280, 220, 10, 10);
			}
			else if (spin == 5) {
				g.fillOval(310, 220, 10, 10);
			}
			else if (spin == 6) {
				g.fillOval(335, 235, 10, 10);
			}
			else if (spin == 7) {
				g.fillOval(355, 250, 10, 10);
			}
			else if (spin == 8) {
				g.fillOval(370, 280, 10, 10);
			}
			else if (spin == 9) {
				g.fillOval(365, 310, 10, 10);
			}
			else if (spin == 10) {
				g.fillOval(355, 340, 10, 10);
			}
			else if (spin == 11) {
				g.fillOval(340, 360, 10, 10);
			}
			else if (spin == 12) {
				g.fillOval(310, 365, 10, 10);
			}
			else if (spin == 13) {
				g.fillOval(280, 365, 10, 10);
			}
			else if (spin == 14) {
				g.fillOval(255, 355, 10, 10);
			}
			else if (spin == 15) {
				g.fillOval(235, 335, 10, 10);
			}
			else if (spin == 16) {
				g.fillOval(225, 310, 10, 10);
			}
		
			//Time dealy to add to the ball moving affect
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		
			
		
		}
		}
			
		
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/*
		 * Desc:Class the makes everything in the frame
		 * pre: A blank frame
		 * post: A frame with things in it
		 */
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Labels that tell the user things like amount of points and if they won or lost
		JLabel lblWin = new JLabel("");
		lblWin.setBounds(253, 23, 133, 32);
		getContentPane().add(lblWin);
		
		JLabel lblPoints = new JLabel("Points:");
		lblPoints.setBounds(232, 76, 99, 32);
		getContentPane().add(lblPoints);
		
		//Combo box for  what the user wants to bet on, on the wheel
		getContentPane().setLayout(null);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"The first four", "The second four", "The third four", "The fourth four", "The colour will be red", "The colour will be black", "The number will be odd", "The number will be even"}));
		comboBox.setBounds(10, 29, 208, 38);
		getContentPane().add(comboBox);
		
		//Button that the user hits to make the "ball" roll in the roulette wheel
		JButton btnRoll = new JButton("Roll");
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Resets labels
				lblWin.setText("");
				//score = Casino.score;
				lblPoints.setText("Points: " + score);
				//Pop up message to take the bet and try to "banana" proof it
				t = JOptionPane.showInputDialog("Please enter bet:");
				try {
					bet = Integer.parseInt(t);
				}
				catch (Exception e) {
					t = JOptionPane.showInputDialog("Please enter a number for the bet:");
				}
				int bet = Integer.parseInt(t);
				score = score - bet;
				lblPoints.setText("Points: " + score);
				//If user runs out of points makes them not be able to play anymore
				if (score <= 0) {
					btnRoll.setEnabled(false);
				}
				//Mehtod that spins the ball and tells it where to land
				Spin();
				
				//Rest for a 100 milliseconds to allow the paint to catch up
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Switch to see what the user bet on
				switch (comboBox.getSelectedIndex()) {
				//Each if statement in each case checks if the user won their bet based on their choice
				case 0:
					//checks first four
					if (roll < 4) {
						lblWin.setText("You win");
						score = score + bet*2;
					}
					break;
				case 1:
					//checks second four
					if (roll >3 && roll <8) {
						lblWin.setText("You win");
						score = score + bet*2;
					}
					break;
				case 2:
					//checks third four
					if (roll >7 && roll <12) {
						lblWin.setText("You win");
						score = score + bet*2;
					}
					break;
				case 3:
					//checks fourth four
					if (roll >11 && roll <16) {
						lblWin.setText("You win");
						score = score + bet*2;
					}
					break;
				case 4:
					//checks the color red
					if (roll == 0 || roll == 2 || roll == 4 || roll == 6 || roll == 8 || roll == 10 || roll == 12 || roll == 14) {
						lblWin.setText("You win");
						score = score + bet*2;
					}
					break;
				case 5:
					//checks the color black
					if (roll == 1 || roll == 3 || roll == 5 || roll == 7 || roll == 9 || roll == 11 || roll == 13 || roll == 15){
						lblWin.setText("You win");
						score = score + bet*2;
					}
					break;
				case 6:
					//checks odd numbers
					if (roll == 0 || roll == 1 || roll == 3 || roll == 4 || roll == 10 || roll == 13 || roll == 14 || roll == 15) {
						lblWin.setText("You win");
						score = score + bet*2;
					}
					break;
				case 7:
					//checks even numbers
					if (roll == 2 || roll == 5 || roll == 6 || roll == 7 || roll == 8 || roll == 9 || roll == 11 || roll == 12) {
						lblWin.setText("You win");
						score = score + bet*2;
					}
					break;
				}
				//says points to user
				lblPoints.setText("Points: " + score);
				Casino.score = Casino.score + score;
				
				//else {
				//	lblWin.setText("You lose");
				//}
				
			}
		});
		btnRoll.setBounds(10, 227, 99, 23);
		getContentPane().add(btnRoll);
		
		
		
		
	}
	
	
	public void Spin() {
		/*
		 * desc:Uses a random to place the ball somewhere on the wheel
		 * pre:A wheel
		 * post: a wheel with a ball
		 */
		//prespin to clear set up and then the roll and repaint
		prespin = 0;
		roll = Die.nextInt(16);
		repaint();
		
	}
	
	
	
			
			
	
	
	
	
}
