import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Baccarat extends JFrame{
	
	private JFrame frame;
	//Decleration of random,integers,arrays and string used in the code
	Random Die = new Random();
	int roll;
	int check = 0;
	int[] saveroll = new int[4];
	int bet = 0;
	int Pscore = 0;
	int Cscore = 0;
	int Pdiff;
	int Cdiff;
	static Image img;
	String text;
	//Attempt at global score
	static int score = Casino.score;
	
	public void BAStart() {
		//Method that starts it all off
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Baccarat window = new Baccarat();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void paint(Graphics g) {
		//Paint that draws all dice and things
		super.paint(g);	
		
		img = Toolkit.getDefaultToolkit().getImage("BaccaratTable.jpeg");
		g.drawImage(img, 450, 0, 1000, 1000, null);
		//Outline of first two dice and the first dice roll
		g.drawRect(100, 100, 100, 100);
		g.drawRect(230, 100, 100, 100);
		//roll = Die.nextInt(6)+ 1;
		//Roll is made when the roll button is called and transfered in
		roll = saveroll[0];
		
		//Switch that handles the first dice and all of the locations for the circles in the dice
		switch (roll) {
		case 1:
			g.drawOval(140, 140, 20, 20);
			break;
		case 2:
			g.drawOval(115, 115, 20, 20);
			g.drawOval(165, 165, 20, 20);
			break;
		case 3:
			g.drawOval(115, 115, 20, 20);
			g.drawOval(140, 140, 20, 20);
			g.drawOval(165, 165, 20, 20);
			break;
		case 4:
			g.drawOval(115, 115, 20, 20);
			g.drawOval(115, 165, 20, 20);
			g.drawOval(165, 165, 20, 20);
			g.drawOval(165, 115, 20, 20);
			break;
		case 5:
			g.drawOval(115, 115, 20, 20);
			g.drawOval(115, 165, 20, 20);
			g.drawOval(140, 140, 20, 20);
			g.drawOval(165, 165, 20, 20);
			g.drawOval(165, 115, 20, 20);
			break;
		case 6:
			g.drawOval(115, 115, 20, 20);
			g.drawOval(115, 165, 20, 20);
			g.drawOval(115, 140, 20, 20);
			g.drawOval(165, 140, 20, 20);
			g.drawOval(165, 165, 20, 20);
			g.drawOval(165, 115, 20, 20);
			break;
		}
		
		//Roll is made when the roll button is called and transfered in
		roll = saveroll[1];
		
		//Switch that handles the second dice and all of the locations for the circles in the dice
		switch (roll) {
		case 1:
			g.drawOval(270, 140, 20, 20);
			break;
		case 2:
			g.drawOval(245, 115, 20, 20);
			g.drawOval(295, 165, 20, 20);
			break;
		case 3:
			g.drawOval(245, 115, 20, 20);
			g.drawOval(270, 140, 20, 20);
			g.drawOval(295, 165, 20, 20);
			break;
		case 4:
			g.drawOval(245, 115, 20, 20);
			g.drawOval(245, 165, 20, 20);
			g.drawOval(295, 165, 20, 20);
			g.drawOval(295, 115, 20, 20);
			break;
		case 5:
			g.drawOval(245, 115, 20, 20);
			g.drawOval(245, 165, 20, 20);
			g.drawOval(270, 140, 20, 20);
			g.drawOval(295, 165, 20, 20);
			g.drawOval(295, 115, 20, 20);
			break;
		case 6:
			g.drawOval(245, 115, 20, 20);
			g.drawOval(245, 165, 20, 20);
			g.drawOval(245, 140, 20, 20);
			g.drawOval(295, 140, 20, 20);
			g.drawOval(295, 165, 20, 20);
			g.drawOval(295, 115, 20, 20);
			break;
		}
		
		//This if checks if you have made initial roll
		if (check == 1){
			//Draws the die outlines
			g.drawRect(100, 270, 100, 100);
			g.drawRect(230, 270, 100, 100);
			//Gets the roll and adds it to the score of the combined dice
			roll = Die.nextInt(6)+ 1;
			saveroll[2] = roll;
			
			//Switch that handles the third dice and all of the locations for the circles in the dice
			switch (roll) {
			case 1:
				g.drawOval(140, 310, 20, 20);
				break;
			case 2:
				g.drawOval(115, 285, 20, 20);
				g.drawOval(165, 335, 20, 20);
				break;
			case 3:
				g.drawOval(115, 285, 20, 20);
				g.drawOval(140, 310, 20, 20);
				g.drawOval(165, 335, 20, 20);
				break;
			case 4:
				g.drawOval(115, 285, 20, 20);
				g.drawOval(115, 335, 20, 20);
				g.drawOval(165, 335, 20, 20);
				g.drawOval(165, 285, 20, 20);
				break;
			case 5:
				g.drawOval(115, 285, 20, 20);
				g.drawOval(115, 335, 20, 20);
				g.drawOval(140, 310, 20, 20);
				g.drawOval(165, 335, 20, 20);
				g.drawOval(165, 285, 20, 20);
				break;
			case 6:
				g.drawOval(115, 285, 20, 20);
				g.drawOval(115, 335, 20, 20);
				g.drawOval(115, 310, 20, 20);
				g.drawOval(165, 310, 20, 20);
				g.drawOval(165, 335, 20, 20);
				g.drawOval(165, 285, 20, 20);
				break;
			}
			
			//Gets the roll and adds it to the score of the combined dice
			roll = Die.nextInt(6)+ 1;
			saveroll[3] = roll;
			
			//Switch that handles the fourth dice and all of the locations for the circles in the dice
			switch (roll) {
			case 1:
				g.drawOval(270, 310, 20, 20);
				break;
			case 2:
				g.drawOval(245, 285, 20, 20);
				g.drawOval(295, 335, 20, 20);
				break;
			case 3:
				g.drawOval(245, 285, 20, 20);
				g.drawOval(270, 310, 20, 20);
				g.drawOval(295, 335, 20, 20);
				break;
			case 4:
				g.drawOval(245, 285, 20, 20);
				g.drawOval(245, 335, 20, 20);
				g.drawOval(295, 335, 20, 20);
				g.drawOval(295, 285, 20, 20);
				break;
			case 5:
				g.drawOval(245, 285, 20, 20);
				g.drawOval(245, 335, 20, 20);
				g.drawOval(270, 310, 20, 20);
				g.drawOval(295, 335, 20, 20);
				g.drawOval(295, 285, 20, 20);
				break;
			case 6:
				g.drawOval(245, 285, 20, 20);
				g.drawOval(245, 335, 20, 20);
				g.drawOval(245, 310, 20, 20);
				g.drawOval(295, 310, 20, 20);
				g.drawOval(295, 335, 20, 20);
				g.drawOval(295, 285, 20, 20);
				break;
			}
		}
	}
		
	
	public Baccarat() {
		/*
		 * Desc: Where everything added to the frame is added
		 * pre: a blank frame
		 * post: a full frame
		 * 
		 */
		getContentPane().setLayout(null);
		
		//Labels for some output
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setBounds(358, 11, 105, 22);
		getContentPane().add(lblPoints);
		
		JLabel lblWin = new JLabel("");
		lblWin.setBounds(358, 40, 105, 18);
		getContentPane().add(lblWin);
		
		//Button that asks if you want to bet on your own dice getting closer to 9
		JButton btnYourDice = new JButton("Your Dice");
		btnYourDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//shows the player the roll and then checks if they won or lost
				check++;
				repaint();
				Pscore = Pscore + saveroll[2];
				Cscore = Cscore + saveroll[3];
				if (Pscore > Cscore && Pscore < 9 && Cscore < 9) {
					 score = score + bet*2;
					lblPoints.setText("Points: " + score);
					lblWin.setText("You win");
					Casino.score = Casino.score + score;
				 }
				 else if (Pscore < Cscore && Pscore > 9 && Cscore > 9) {
					 score = score + bet*2;
					lblPoints.setText("Points: " + score);
					lblWin.setText("You win");
					Casino.score = Casino.score + score;
				 }
				 else if (Pscore == 9) {
					 score = score + bet*2;
					lblPoints.setText("Points: " + score);
					lblWin.setText("You win");
					Casino.score = Casino.score + score;
				 }
				 else {
					lblPoints.setText("Points: " + score);
					lblWin.setText("You lose");
					//Casino.score is for the global score that does not work
					Casino.score = Casino.score + score;
				 }
				}
		});
		btnYourDice.setBounds(19, 200, 120, 32);
		btnYourDice.setVisible(false);
		getContentPane().add(btnYourDice);
		
		//Button that asks if you want to bet on your "dealers" dice getting closer to 9
		JButton btnDealersDice = new JButton("Dealer's Dice\r\n");
		btnDealersDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//shows the player the roll and then checks if they won or lost
				check++;
				repaint();
				Pscore = Pscore + saveroll[2];
				Cscore = Cscore + saveroll[3];
				
				 if (Cscore > Pscore && Cscore < 9 && Pscore < 9) {
					 score = score + bet*2;
					lblPoints.setText("Points: " + score);
					lblWin.setText("You win");
					Casino.score = Casino.score + score;
				 }
				 else if (Cscore < Pscore && Cscore > 9 && Pscore > 9) {
					 score = score + bet*2;
					lblPoints.setText("Points: " + score);
					lblWin.setText("You win");
					Casino.score = Casino.score + score;
				 }
				 else if (Cscore == 9) {
					 score = score + bet*2;
					lblPoints.setText("Points: " + score);
					lblWin.setText("You win");
					Casino.score = Casino.score + score;
				 }
				 else {
					lblPoints.setText("Points: " + score);
					lblWin.setText("You lose");
					Casino.score = Casino.score + score;
				 }
				
			}
		});
		btnDealersDice.setBounds(184, 200, 120, 32);
		btnDealersDice.setVisible(false);
		getContentPane().add(btnDealersDice);
		
		//This button is for the initial roll the player makes for the first two dice
		JButton btnRoll = new JButton("Roll");
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//score = Casino.score;
				//Sends a pop up message getting the bet your willing to place with try for banana proofing
				lblPoints.setText("Points: " + score);
				text = JOptionPane.showInputDialog("Input Bet:");
				try {
					bet = Integer.parseInt(text);
				}
				catch (Exception e) {
					text = JOptionPane.showInputDialog("Please enter a number for the bet:");
				}
				bet = Integer.parseInt(text);
				score = score - bet;
				//if the user has no more points stops them from playing
				if (score <= 0) {
					btnRoll.setEnabled(false);
				}
				check = 0;
				//Makes rolls for the first two dice
				saveroll[0] = Die.nextInt(6)+ 1;
				saveroll[1] = Die.nextInt(6)+ 1;
				//sets scores to first to rolls for now
				Pscore = saveroll[0];
				Cscore = saveroll[1];
				//repaints to show rolls
				repaint();
				//btnRoll.setEnabled(false);
				btnYourDice.setVisible(true);
				btnDealersDice.setVisible(true);
			}
		});
		btnRoll.setBounds(10, 11, 98, 32);
		getContentPane().add(btnRoll);
		
		//Labels for general information
		JLabel lblComDice = new JLabel("Dealers Dice");
		lblComDice.setBounds(220, 36, 84, 22);
		getContentPane().add(lblComDice);
		
		JLabel label = new JLabel("Your Dice");
		label.setBounds(118, 36, 55, 22);
		getContentPane().add(label);
		
		JLabel lblWhichDiceDo = new JLabel("Which dice do you think is going to get closer to 9 (It can go over 9)");
		lblWhichDiceDo.setBounds(10, 169, 414, 32);
		getContentPane().add(lblWhichDiceDo);
		
		
		
		
		
		//Makes the frame fully complete
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
