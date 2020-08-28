import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BlackJack extends JFrame{

	//Declaration of all integers,arrays and strings used
	private JFrame frame;
	Random Draw = new Random();
	int card;
	int deal = 0;
	int hit = -1;
	int Chit = 0;
	int Ace;
	static int[][]h = new int[2][2];
	int[] dealt = new int[4];
	int Csum;
	int Psum;
	int bet;
	static Image img;
	String t;
	int PA = 0;
	static int score = 1000;
	
	
	/**
	 * Launch the application.
	 */
	public void Bstart() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlackJack window = new BlackJack();
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
	public BlackJack() {
		/*
		 * Desc: Method that makes everything in the frame
		 * pre: a empty frame
		 * post: a frame with things in it
		 */
		getContentPane().setLayout(null);
		
		//Label that lets the player know if they won
		JLabel lblWin = new JLabel("");
		lblWin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWin.setBounds(10, 210, 94, 31);
		getContentPane().add(lblWin);
		
		//Buttons that have different affects declared here to be accessed by other things
		JButton btnPlayAgain = new JButton("Play Again");
		JButton btnMakeAce11 = new JButton("Make Ace 11");
		JButton btnMakeAce1 = new JButton("Make Ace 1");
		//Label points that is declared here to get accessed by different things
		JLabel lblPoints = new JLabel("Points:");
		
		//Button for the user to hit and draw a card
		JButton btnHit = new JButton("HIT");
		btnHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Setting chit to 0 for good measure
				Chit = 0;
				
				//Moves the time the user has hit up then draws the card for them
				hit++;
				if (hit == 0) {
					card = Draw.nextInt(14) + 1;
					h[0][0] = card;
				}
				else if (hit == 1) {
					card = Draw.nextInt(14) + 1;
					h[0][1] = card;
					
				}
				
				
				//Repaints to show what user got
				repaint();
				
				//Checks for ace and allows user to select what it will be
				for (int j = 0; j < 2; j++) {
					if (h[0][j] == 14) {
						Ace = j;
						btnMakeAce1.setVisible(true);
						btnMakeAce11.setVisible(true);
					}
				}
				
				//Allows the user to hit twice
				if (hit == 1) {
					btnHit.setVisible(false);
				}
				else {
					btnHit.setVisible(true);
				}
				
			}
		});
		btnHit.setBounds(10, 140, 94, 40);
		getContentPane().add(btnHit);
		
		//Button for when the player is done and then checks if they won
		JButton btnStand = new JButton("STAND");
		btnStand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//Adds up the cards of both sides without any hits
				Psum = dealt[1] + dealt[0];
				Csum = dealt[2] + dealt[3];
				
				//checks if the user hit and if so adds it to score
				if (hit == 0) {
					Psum = Psum + h[0][0];
				}
				else if (hit == 1) {
					Psum = Psum + h[0][0] + h[0][1];
				}
				
				//This controls if the computer hits
				if (Psum > Csum && Psum < 22) {
					
					//Checks computers side for aces
					for (int j = 2; j < 4; j++) {
						if (dealt[j] == 14) {
							int hold = Csum - 11;
							if (hold < 21) {
								dealt[j] = 11;
							}
							else {
								dealt[j] =1;
							}
						}
					}
						//Hits for the computer and adds it to the final score
						Chit = 1;
						repaint();
						Csum = dealt[2] + dealt[3] + h[1][0];
						
						if (Csum < Psum && Csum < 21) {
							Csum = Csum + h[1][1];
						}
				}
				
				//Checks all of the win loss conditions
				if (Psum > 21) {
					lblWin.setText("You Lose");
					lblPoints.setText("Points: " + score);
					Casino.score = Casino.score + score;
				}
				else if (Psum == 21) {
					lblWin.setText("You Win");
					score = score + (bet*2);
					lblPoints.setText("Points: " + score);
					Casino.score = Casino.score + score;
				}
				else if (Psum > Csum && Psum < 22) {
					lblWin.setText("You Win");
					score = score + (bet*2);
					lblPoints.setText("Points: " + score);
					Casino.score = Casino.score + score;
				}
				else if (Csum > 21) {
					lblWin.setText("You Win");
					score = score + (bet*2);
					lblPoints.setText("Points: " + score);
					Casino.score = Casino.score + score;
					
				}
				else {
					lblWin.setText("You Lose");
					lblPoints.setText("Points: " + score);
					Casino.score = Casino.score + score;
				}
				//resets hit counters
				hit = -1;
				
				Chit = -1;
				
				//Allows the player to play again
				btnPlayAgain.setVisible(true);
				Casino.score = Casino.score + score;
				
			}
		});
		btnStand.setBounds(333, 140, 101, 40);
		getContentPane().add(btnStand);
		
		
		//Button that makes an ace equal 11 for the user
		btnMakeAce11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dealt[Ace] = 11;
				btnMakeAce11.setVisible(false);
				btnMakeAce1.setVisible(false);
			}
		});
		btnMakeAce11.setBounds(294, 191, 130, 40);
		btnMakeAce11.setVisible(false);
		getContentPane().add(btnMakeAce11);
		
		//Button that makes the ace equal one for the player
		btnMakeAce1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dealt[Ace] = 1;
				btnMakeAce11.setVisible(false);
				btnMakeAce1.setVisible(false);
			}
		});
		btnMakeAce1.setBounds(294, 242, 130, 40);
		btnMakeAce1.setVisible(false);
		getContentPane().add(btnMakeAce1);
		
		//Button for the initial deal of cards
		JButton btnDeal = new JButton("DEAL");
		btnDeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Resets values
				PA = 0;
				Chit = 0;
				
				//score = Casino.score;
				//Sends a pop message for the bet with try for banana proofing and allows access for the hit button
				btnHit.setVisible(true);
				t = JOptionPane.showInputDialog("Input Bet: ");
				try {
					bet = Integer.parseInt(t);
				}
				catch (Exception e1) {
					t = JOptionPane.showInputDialog("Please enter a number for the bet:");
				}
				bet = Integer.parseInt(t);
				score = score - bet;
				lblPoints.setText("Points: " + score);
				//if the user has no more points stops them from playing
				if (score <= 0) {
					btnDeal.setEnabled(false);
					btnHit.setEnabled(false);
					btnStand.setEnabled(false);
				}
				deal = 1;
				//For that checks for an ace
				for (int i = 0; i < 4; i++) {
					card = Draw.nextInt(14) + 1;
					if (card >= 10 && card != 14) {
						card = 10;
					}
					dealt[i] = card;
				}
				//Shows the user the painted out cards
				repaint();
				
				//Checks for an ace and allows for the player to call out if its 11 or 1
				for (int j = 0; j < 2; j++) {
					if (dealt[j] == 14) {
						Ace = j;
						btnMakeAce1.setVisible(true);
						btnMakeAce11.setVisible(true);
					}
				}
				
				btnDeal.setVisible(false);
			}
		});
		btnDeal.setBounds(140, 210, 144, 40);
		getContentPane().add(btnDeal);
		
		
		lblPoints.setBounds(10, 254, 118, 31);
		getContentPane().add(lblPoints);
		
		//PLay again button
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//These commands just reset everything the game needs to play again
				btnDeal.setVisible(true);
				lblWin.setText(" ");
				PA++;
				Chit = 0;
				h[0][0] = 0;
				h[0][1] = 0;
				h[1][0] = 0;
				h[1][1] = 0;
				lblPoints.setText("Points: " + score);
				repaint();
				
			}
		});
		btnPlayAgain.setBounds(140, 251, 144, 34);
		btnPlayAgain.setVisible(false);
		getContentPane().add(btnPlayAgain);
		
		
		
		
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
	
	public void test() {
		//Method that draws the cards for the AI's hits
		card = Draw.nextInt(14) + 1;
		h[1][0] = card;
		
		card = Draw.nextInt(14) + 1;
		h[1][1] = card;
	}
	
	public void paint(Graphics g) {
		super.paint(g);	
		img = Toolkit.getDefaultToolkit().getImage("BlackJackTable.jpg");
		g.drawImage(img, 450, 0, 1000, 1000, null);
		//Start of the paint that draws some words and the inital two card outlines
		g.drawRect(150, 500, 200, 300);
		g.drawRect(50, 500, 100, 300);
		g.setFont(new Font("Verdana", Font.BOLD, 40));
		g.drawString("Your Hand", 100, 500);
		g.drawRect(200, 20, 200, 150);
		g.drawRect(120, 20, 80, 150);
		g.setFont(new Font("Verdana", Font.BOLD, 25));
		g.drawString("Dealer's Hand", 120, 200);
		g.setFont(new Font("Verdana", Font.BOLD, 40));
		
		//this if Checks if the user has hit yet
		if (PA ==0) {
			
			//if the user has hit, how many times
		if (hit == 0 || hit == 1) {
			
			//gets the hit value
			card = h[0][0];
			
			//draws new card and adds hit value
			g.drawRect(220, 500, 200, 300);
			switch (card) {
				
			case 1:
				g.drawString("1", 220, 545);
				break;
			case 2:
				g.drawString("2", 220, 545);
				break;
			case 3:
				g.drawString("3", 220, 545);
				break;
			case 4:
				g.drawString("4", 220, 545);
				break;
			case 5:
				g.drawString("5", 220, 545);
				break;
			case 6:
				g.drawString("6", 220, 545);
				break;
			case 7:
				g.drawString("7", 220, 545);
				break;
			case 8:
				g.drawString("8", 220, 545);
				break;
			case 9:
				g.drawString("9", 220, 545);
				break;
			case 10:
				g.drawString("10", 220, 545);
				break;
			case 11:
				g.drawString("10", 220, 545);
				break;
			case 12:
				g.drawString("10", 220, 545);
				break;
			case 13:
				g.drawString("10", 220, 545);
				break;
			case 14:
				g.drawString("A", 220, 545);
				break;
			
				
			}
			//checks if second hit
			if (hit == 1) {
				//gets the second hit value and then draws the card and it
				card = h[0][1];
				
				g.drawRect(300, 500, 200, 300);
				switch (card) {
					
				case 1:
					g.drawString("1", 320, 545);
					break;
				case 2:
					g.drawString("2", 320, 545);
					break;
				case 3:
					g.drawString("3", 320, 545);
					break;
				case 4:
					g.drawString("4", 320, 545);
					break;
				case 5:
					g.drawString("5", 320, 545);
					break;
				case 6:
					g.drawString("6", 320, 545);
					break;
				case 7:
					g.drawString("7", 320, 545);
					break;
				case 8:
					g.drawString("8", 320, 545);
					break;
				case 9:
					g.drawString("9", 320, 545);
					break;
				case 10:
					g.drawString("10",320, 545);
					break;
				case 11:
					g.drawString("10", 320, 545);
					break;
				case 12:
					g.drawString("10", 320, 545);
					break;
				case 13:
					g.drawString("10", 320, 545);
					break;
				case 14:
					g.drawString("A", 320, 545);
					break;
			}
			}
			
		}
		
		
		//This checks if the computer is hitting or not
		if (Chit != 0) {
			
			//if it is it gets the two card values and then draws the first card and value
			test();
			card = h[1][0];
			g.drawRect(250, 20, 200, 150);
			switch (card) {
				
			case 1:
				g.drawString("1", 260, 170);
				break;
			case 2:
				g.drawString("2", 260, 170);
				break;
			case 3:
				g.drawString("3", 260, 170);
				break;
			case 4:
				g.drawString("4", 260, 170);
				break;
			case 5:
				g.drawString("5", 260, 170);
				break;
			case 6:
				g.drawString("6", 260, 170);
				break;
			case 7:
				g.drawString("7", 260, 170);
				break;
			case 8:
				g.drawString("8", 260, 170);
				break;
			case 9:
				g.drawString("9", 260, 170);
				break;
			case 10:
				g.drawString("10", 260, 170);
				break;
			case 11:
				g.drawString("10", 260, 170);
				break;
			case 12:
				g.drawString("10", 260, 170);
				break;
			case 13:
				g.drawString("10", 260, 170);
				break;
			case 14:
				g.drawString("A", 260, 170);
				break;
			
				
			}
			//gets the second test value and then draws the card and it
			test();
			card = h[1][1];
				g.drawRect(300, 20, 200, 150);
				switch (card) {
					
				case 1:
					g.drawString("1", 320, 170);
					break;
				case 2:
					g.drawString("2", 320, 170);
					break;
				case 3:
					g.drawString("3", 320, 170);
					break;
				case 4:
					g.drawString("4", 320, 170);
					break;
				case 5:
					g.drawString("5", 320, 170);
					break;
				case 6:
					g.drawString("6", 320, 170);
					break;
				case 7:
					g.drawString("7", 320, 170);
					break;
				case 8:
					g.drawString("8", 320, 170);
					break;
				case 9:
					g.drawString("9", 320, 1700);
					break;
				case 10:
					g.drawString("10",320, 170);
					break;
				case 11:
					g.drawString("10", 320, 170);
					break;
				case 12:
					g.drawString("10", 320, 170);
					break;
				case 13:
					g.drawString("10", 320, 170);
					break;
				case 14:
					g.drawString("A", 320, 170);
					break;
			}	
		}
		
		
		//This draws the normal dealt cards to each four pre drawn card outlines
		for (int i = 0; i <4; i++) {
			card = dealt[i];
			
			//This is in account for face cards making them equal 10
			if (card >= 10 && card != 14 && card != 11) {
				dealt[i] = 10;
			}
			
			//checks the card value then the if in the switch determine which card it goes to
			switch (card) {
			
			case 1:
				if (deal == 1 && i == 0) {
					g.drawString("1", 50, 545);
				}
				else if (deal == 1 && i == 1) {
					g.drawString("1", 150, 545);
				}
				else if (deal == 1 && i == 2) {
					g.drawString("1", 200, 170);
				}
				else if (deal == 1 && i == 3) {
					g.drawString("1", 120, 170);
				}
				
				break;
			case 2:
				if (deal == 1 && i == 0) {
					g.drawString("2", 50, 545);
				}
				else if (deal == 1 && i == 1) {
					g.drawString("2", 150, 545);
				}
				else if (deal == 1 && i == 2) {
					g.drawString("2", 200, 170);
				}
				else if (deal == 1 && i == 3) {
					g.drawString("2", 120, 170);
				}
				break;
			case 3:
				if (deal == 1 && i == 0) {
					g.drawString("3", 50, 545);
				}
				else if (deal == 1 && i == 1) {
					g.drawString("3", 150, 545);
				}
				else if (deal == 1 && i == 2) {
					g.drawString("3", 200, 170);
				}
				else if (deal == 1 && i == 3) {
					g.drawString("3", 120, 170);
				}
				break;
			case 4:
				if (deal == 1 && i == 0) {
					g.drawString("4", 50, 545);
				}
				else if (deal == 1 && i == 1) {
					g.drawString("4", 150, 545);
				}
				else if (deal == 1 && i == 2) {
					g.drawString("4", 200, 170);
				}
				else if (deal == 1 && i == 3) {
					g.drawString("4", 120, 170);
				}
				break;
			case 5:
				if (deal == 1 && i == 0) {
					g.drawString("5", 50, 545);
				}
				else if (deal == 1 && i == 1) {
					g.drawString("5", 150, 545);
				}
				else if (deal == 1 && i == 2) {
					g.drawString("5", 200, 170);
				}
				else if (deal == 1 && i == 3) {
					g.drawString("5", 120, 170);
				}
				break;
			case 6:
				if (deal == 1 && i == 0) {
					g.drawString("6", 50, 545);
				}
				else if (deal == 1 && i == 1) {
					g.drawString("6", 150, 545);
				}
				else if (deal == 1 && i == 2) {
					g.drawString("6", 200, 170);
				}
				else if (deal == 1 && i == 3) {
					g.drawString("6", 120, 170);
				}
				break;
			case 7:
				if (deal == 1 && i == 0) {
					g.drawString("7", 50, 545);
				}
				else if (deal == 1 && i == 1) {
					g.drawString("7", 150, 545);
				}
				else if (deal == 1 && i == 2) {
					g.drawString("7", 200, 170);
				}
				else if (deal == 1 && i == 3) {
					g.drawString("7", 120, 170);
				}
				break;
			case 8:
				if (deal == 1 && i == 0) {
					g.drawString("8", 50, 545);
				}
				else if (deal == 1 && i == 1) {
					g.drawString("8", 150, 545);
				}
				else if (deal == 1 && i == 2) {
					g.drawString("8", 200, 170);
				}
				else if (deal == 1 && i == 3) {
					g.drawString("8", 120, 170);
				}
				break;
			case 9:
				if (deal == 1 && i == 0) {
					g.drawString("9", 50, 545);
				}
				else if (deal == 1 && i == 1) {
					g.drawString("9", 150, 545);
				}
				else if (deal == 1 && i == 2) {
					g.drawString("9", 200, 170);
				}
				else if (deal == 1 && i == 3) {
					g.drawString("9", 120, 170);
				}
				break;
			case 10:
				if (deal == 1 && i == 0) {
					g.drawString("10", 50, 545);
				}
				else if (deal == 1 && i == 1) {
					g.drawString("10", 150, 545);
				}
				else if (deal == 1 && i == 2) {
					g.drawString("10", 200, 170);
				}
				else if (deal == 1 && i == 3) {
					g.drawString("10", 120, 170);
				}
				break;
			case 11:
				
				if (dealt[Ace] == 11) {
					
					if (deal == 1 && i == 0) {
						g.drawString("11", 50, 545);
					}
					else if (deal == 1 && i == 1) {
						g.drawString("11", 150, 545);
					}
					else if (deal == 1 && i == 2) {
						g.drawString("11", 200, 170);
					}
					else if (deal == 1 && i == 3) {
						g.drawString("11", 120, 170);
					}
					break;
				}
				
				if (deal == 1 && i == 0) {
					g.drawString("10", 50, 545);
				}
				else if (deal == 1 && i == 1) {
					g.drawString("10", 150, 545);
				}
				else if (deal == 1 && i == 2) {
					g.drawString("10", 200, 170);
				}
				else if (deal == 1 && i == 3) {
					g.drawString("10", 120, 170);
				}
				break;
			case 12:
				if (deal == 1 && i == 0) {
					g.drawString("10", 50, 545);
				}
				else if (deal == 1 && i == 1) {
					g.drawString("10", 150, 545);
				}
				else if (deal == 1 && i == 2) {
					g.drawString("10", 200, 170);
				}
				else if (deal == 1 && i == 3) {
					g.drawString("10", 120, 170);
				}
				break;
			case 13:
				if (deal == 1 && i == 0) {
					g.drawString("10", 50, 545);
				}
				else if (deal == 1 && i == 1) {
					g.drawString("10", 150, 545);
				}
				else if (deal == 1 && i == 2) {
					g.drawString("10", 200, 170);
				}
				else if (deal == 1 && i == 3) {
					g.drawString("10", 120, 170);
				}
				break;
			case 14:
				if (deal == 1 && i == 0) {
					g.drawString("A", 50, 545);
				}
				else if (deal == 1 && i == 1) {
					g.drawString("A", 150, 545);
				}
				else if (deal == 1 && i == 2) {
					g.drawString("A", 200, 170);
				}
				else if (deal == 1 && i == 3) {
					g.drawString("A", 120, 170);
				}
				break;
			}
			
		}
		
		}
	}
}
