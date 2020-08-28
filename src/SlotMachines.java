import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class SlotMachines extends JFrame{

	//Declaration of the integers and random used
	private JFrame frame;
	Random Die = new Random();
	int roll;
	int s1;
	int s2;
	int s3;
	int s4;
	static Image img1;
	static Image img2;
	static Image img3;
	static Image img4;
	static Image img5;
	static int score  = Casino.score;
	//MainMenu m = new MainMenu();
	/**
	 * Launch the application.
	 */
	public void Sstart() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SlotMachines window = new SlotMachines();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void paint(Graphics g) {
		super.paint(g);	
		//Draws the frame of the slot machine and sets the size of the numbers inside
		img1 = Toolkit.getDefaultToolkit().getImage("SlotBack.jpg");
		g.drawImage(img1, 600, 0, 1000, 1000, null);
		//img2 = Toolkit.getDefaultToolkit().getImage("SlotOrange.jpg");
		//g.drawImage(img2, 0, 0, 1000, 1000, null);
		g.setFont(new Font("Verdana", Font.BOLD, 120));
		//g.setColor(Color.white);
		g.drawRect(30, 50, 550, 500);
		g.drawRect(80, 55, 100, 200);
		g.drawRect(180, 55, 100, 200);
		g.drawRect(280, 55, 100, 200);
		g.drawRect(380, 55, 100, 200);
		img2 = Toolkit.getDefaultToolkit().getImage("SlotCherry.png");
		img3 = Toolkit.getDefaultToolkit().getImage("SlotOrange.png");
		img4 = Toolkit.getDefaultToolkit().getImage("SlotClover.png");
		img5 = Toolkit.getDefaultToolkit().getImage("SlotSeven.png");
		//g.drawImage(img2, 0, 0, 1000, 1000, null);
		//Switch for Slot one of the machine
		switch (s1) {
		case 0:
			//g.drawString("1", 90, 250);
			g.drawImage(img2, 90, 150, 100, 100, null);
			break;
		case 1:
			g.drawImage(img3, 90, 150, 60, 60, null);
			break;
		case 2:
			g.drawImage(img4, 90, 150, 60, 60, null);
			break;
		case 3:
			g.drawImage(img5, 90, 150, 60, 60, null);
			break;
		}
		//Switch for Slot two of the machine
		switch (s2) {
		case 0:
			//g.drawString("1", 190, 250);
			g.drawImage(img2, 190, 150, 100, 100, null);
			break;
		case 1:
			g.drawImage(img3, 190, 150, 60, 60, null);
			break;
		case 2:
			g.drawImage(img4, 190, 150, 60, 60, null);
			break;
		case 3:
			g.drawImage(img5, 190, 150, 60, 60, null);
			break;
		}
		//Switch for Slot three of the machine
		switch (s3) {
		case 0:
			//g.drawString("1", 290, 250);
			g.drawImage(img2, 290, 150, 100, 100, null);
			break;
		case 1:
			g.drawImage(img3, 290, 150, 60, 60, null);
			break;
		case 2:
			g.drawImage(img4, 290, 150, 60, 60, null);
			break;
		case 3:
			g.drawImage(img5, 290, 150, 60, 60, null);
			break;
		}
		//Switch for Slot four of the machine
		switch (s4) {
		case 0:
			//g.drawString("1", 390, 250);
			g.drawImage(img2, 390, 150, 100, 100, null);
			break;
		case 1:
			g.drawImage(img3, 390, 150, 60, 60, null);
			break;
		case 2:
			g.drawImage(img4, 390, 150, 60, 60, null);
			break;
		case 3:
			g.drawImage(img5, 390, 150, 60, 60, null);
			break;
		}
		
		
	}
	
	/**
	 * Create the application.
	 */
	public SlotMachines() {
		/*
		 * Desc: A method that makes the things in the frames
		 * pre: A empty frame
		 * post: A frame with things in it
		 */
		getContentPane().setLayout(null);
		//Labels for letting the user know whats happening
		JLabel lblYouWin = new JLabel("");
		lblYouWin.setBounds(64, 309, 120, 37);
		getContentPane().add(lblYouWin);
		
		JLabel lblPoints = new JLabel("");
		lblPoints.setBounds(218, 357, 101, 42);
		getContentPane().add(lblPoints);
		
		//Button that allows the user to play the game
		JButton btnSlot = new JButton("Roll Slots");
		btnSlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//score = Casino.score;
				//Takes off the price to play from the score
				score = score - 50;
				//If the user runs out of points stops them from playing
				if (score <= 0) {
					btnSlot.setVisible(false);
				}
				
				lblPoints.setText("Points: " + score);
				//Makes a roll for each slot and then paints it
				roll = Die.nextInt(4);
				s1 = roll;
				roll = Die.nextInt(4);
				s2 = roll;
				roll = Die.nextInt(4);
				s3 = roll;
				roll = Die.nextInt(4);
				s4 = roll;
				repaint();
				
				//If that checks each condition to see if the user won or lost
				if (s1 == s2 && s1 == s3 && s1 == s4) {
					lblYouWin.setText("You Win (All same)");
					score = score + 600;
				}
				else if (s1 == s2 && s3 == s4) {
					lblYouWin.setText("You Win (2 pairs)");
					score = score + 300;
				}
				else if (s1 == s3 && s2 == s4) {
					lblYouWin.setText("You Win (2 pairs)");
					score = score + 300;
				}
				else if (s1 == s4 && s2 == s3) {
					lblYouWin.setText("You Win (2 pairs)");
					score = score + 300;
				}
				else if (s1 == 0 && s2 == 1 && s3 == 2 && s4 == 3) {
					lblYouWin.setText("You Win (straight count)");
					score = score + squareNum(100);
				}
				else {
					lblYouWin.setText("You Lose");
					
				}
				lblPoints.setText("Points: " + score);
				
				Casino.score = Casino.score + score;
				
			}
		});
		btnSlot.setBounds(208, 309, 120, 37);
		getContentPane().add(btnSlot);
		
		//Button to save score to file
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Code has no error but does not work
				try {
					File points = new File("save.txt");
					PrintWriter output = new PrintWriter(points);
					
					output.print(score);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSave.setBounds(21, 356, 62, 43);
		getContentPane().add(btnSave);
		
		
		initialize();
	}
	
	public static int squareNum(int bet) {
		/*
		 * Desc: A program that method a number
		 * pre: A number
		 * post: A number squared 
		 */
		
		//if that runs the recursive
		if (bet == 1) {
			
			return 1;
			
		}
		else if (bet > 0) {
			//return that keeps the recursive going until you get to num == 1
			return bet =  squareNum(bet -1) + (2*bet) - 1;
		}
		else {
			
			return bet = squareNum(bet+1) - (2*bet) -1;
			
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Makes frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
