import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ChuckALuck extends JFrame{
	
	
	//Declaration of all integers, randoms and strings used
	private JFrame frame;
	String text = " ";
	int betcheck;
	int roll;
	int sort = 0;
	int[] rollV = new int[3];
	static Image img;
	int bet;
	Random Die = new Random();
	int sum = 0;
	int found;
	static int score = Casino.score;
	/**
	 * Launch the application.
	 */
	public void Cstart() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChuckALuck window = new ChuckALuck();
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
	public ChuckALuck() {
		getContentPane().setLayout(null);
		
		//Sets labels for the user info
		JLabel lblPoints = new JLabel("1000");
		lblPoints.setBounds(176, 11, 110, 21);
		getContentPane().add(lblPoints);
		
		JLabel lblTitle = new JLabel("");
		lblTitle.setBounds(171, 37, 60, 14);
		getContentPane().add(lblTitle);
		//Decleration of one button is here to be called on by other buttons
		JButton btnBetOnThree = new JButton("Bet on three dice");
		JButton btnSUM = new JButton("Bet on the sum of three dice");
		//Button for if the user picks to bet on one die
		JButton btnBetOnOne = new JButton("Bet on one die");
		btnBetOnOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Pop up message to get the bet amount and try to banana proof it
				text = JOptionPane.showInputDialog("Input Bet:");
				try {
					bet = Integer.parseInt(text);
				}
				catch (Exception e) {
					text = JOptionPane.showInputDialog("Please enter a number for the number on the dice:");
				}
				bet = Integer.parseInt(text);
				score = score - bet;
				//if the user has no more points stops them from playing
				if (score <= 0) {
					btnBetOnOne.setEnabled(false);
					btnBetOnThree.setEnabled(false);
					btnSUM.setEnabled(false);
				}
				
				//Pop up message to get the number the user is betting on with try for banana testing
				text = JOptionPane.showInputDialog("Input Number:");
				try {
					bet = Integer.parseInt(text);
				}
				catch (Exception e4) {
					text = JOptionPane.showInputDialog("Please enter a number for the number on the dice:");
				}
				sort = 0;
				//Method to roll dice and then draw the roll out
				diceroll();
				repaint();
				//Betcheck makes it so only one dice is counted
				betcheck = 0;
				//Checks if the user got their number or not and adds score or does not add score
				if (rollV[0] == Integer.parseInt(text)) {
					score = score + bet*3;
					lblPoints.setText("Points: " + score);
					lblTitle.setText("You Win");
					Casino.score = Casino.score + score;
				}
				else {
					lblTitle.setText("You Lose");
					lblPoints.setText("Points: " + score);
					Casino.score = Casino.score + score;
					
				}
			}
		});
		btnBetOnOne.setBounds(10, 11, 156, 40);
		getContentPane().add(btnBetOnOne);
		
		//Button for if the user wants to bet on three dice
		
		btnBetOnThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Pop up message for the bet amount with try for banana
				text = JOptionPane.showInputDialog("Input Bet:");
				try {
					bet = Integer.parseInt(text);
				}
				catch (Exception e1) {
					text = JOptionPane.showInputDialog("Please enter a number for the number on the dice:");
				}
				bet = Integer.parseInt(text);
				
				
				score = score - bet;
				//Pop up message for the number their betting on with try for banana testing
				text = JOptionPane.showInputDialog("Input Number:");
				try {
					bet = Integer.parseInt(text);
				}
				catch (Exception e4) {
					text = JOptionPane.showInputDialog("Please enter a number for the bet:");
				}
				//if the user has no more points stops them from playing
				if (score <= 0) {
					btnBetOnOne.setEnabled(false);
					btnBetOnThree.setEnabled(false);
					btnSUM.setEnabled(false);
				}
				//sort is made to equal one to make the values be sorted
				sort = 1;
				//rolls dice and draws them out for user
				diceroll();
				repaint();
				//betcheck makes it so three are made
				betcheck = 1;
				found = 0;
				
				//Linear search to look at the three dice for the number the user bet on
				for (int l = 0; l < rollV.length; l++) {
					
					if (rollV[l] == Integer.parseInt(text)) {
						found =1;
					}
				}
				
				//Checks if the number was found or not and adds the points accordingly
				if (found == 1) {
					score = score + (bet*2);
					lblPoints.setText("Points: " + score);
					lblTitle.setText("You Win");
					Casino.score = Casino.score + score;
				}
				else {
					lblTitle.setText("You Lose");
					Casino.score = Casino.score + score;
					lblPoints.setText("Points: " + score);
				}
					
				}
			
		});
		btnBetOnThree.setBounds(10, 53, 156, 40);
		getContentPane().add(btnBetOnThree);
		//Button for if the user wants to bet on what the sum of the three dice will be
		
		btnSUM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Pop up message for how much the user bets
				text = JOptionPane.showInputDialog("Input Bet:");
				try {
					bet = Integer.parseInt(text);
				}
				catch (Exception e2) {
					text = JOptionPane.showInputDialog("Please enter a number for the bet:");
				}
				bet = Integer.parseInt(text);
				score = score - bet;
				lblTitle.setText(" ");
				//if the user has no more points stops them from playing
				if (score <= 0) {
					btnBetOnOne.setEnabled(false);
					btnBetOnThree.setEnabled(false);
					btnSUM.setEnabled(false);
				}
				//Pop up message for the number they think the sum of the three die will be
				text = JOptionPane.showInputDialog("Input Number:");
				try {
					bet = Integer.parseInt(text);
				}
				catch (Exception e3) {
					text = JOptionPane.showInputDialog("Please enter a number for the bet:");
				}
				//Resets the sum value and makes it so it gets sorted
				sum = 0;
				sort = 1;
				//Rolls the dice then paints them for the user
				diceroll();
				repaint();
				//Betcheck for how many dice there needs to be
				betcheck = 2;
				
				//Checks if the sum is the same as the guess and gives out points accordingly
				if (sum == Integer.parseInt(text)) {
					score = score + bet*4;
					lblPoints.setText("Points: " + score);
					lblTitle.setText("You Win");
					Casino.score = Casino.score + score;
				}
				else {
					lblTitle.setText("You Lose");
					//p.Points = p.Points - bet;
					lblPoints.setText("Points: " + score);
				}
				
			}
		});
		btnSUM.setBounds(10, 96, 156, 40);
		getContentPane().add(btnSUM);
		
		
		
		
		
		initialize();
	}

	public void diceroll() {
		/*
		 * Desc: A method that rolls the three dice as well as sorts them if needed
		 * 
		 * 
		 */
		//gets the amount of die
		int n = rollV.length;
		//Makes all three dice rolls and adds it to the sum of the dice
		roll = Die.nextInt(6)+ 1;
		rollV[0] = roll;
		sum = sum + roll;
		roll = Die.nextInt(6)+ 1;
		sum = sum + roll;
		rollV[1] = roll;
		roll = Die.nextInt(6)+ 1;
		sum = sum + roll;
		rollV[2] = roll;
		
		//Sorts the dice from smallest to biggest with a bubble sort
		if (sort == 1) {
		for (int i = 0; i < n-1; i++) { 
            for (int j = 0; j < n-i-1; j++) 
                if (rollV[j] > rollV[j+1]) 
                { 
                    
                    int temp = rollV[j]; 
                    rollV[j] = rollV[j+1]; 
                    rollV[j+1] = temp; 
               }
		}
		}
	}
	
	
	
	public void paint(Graphics g) {
		super.paint(g);	
		img = Toolkit.getDefaultToolkit().getImage("ChuckTable.jpg");
		//Paints the outline of the three dice
		g.drawRect(100, 200, 100, 100);
		g.drawRect(230, 200, 100, 100);
		g.drawRect(360, 200, 100, 100);
		g.drawImage(img, 500, 0, 900, 800, null);
		//if that checks if its one dice
		if (betcheck == 0) {
			// if its one dice gets the roll value and then draws it out for the user using the switch
			roll = rollV[0];
			switch (roll) {
			case 1:
				g.drawOval(140, 240, 20, 20);
				break;
			case 2:
				g.drawOval(115, 215, 20, 20);
				g.drawOval(165, 265, 20, 20);
				break;
			case 3:
				g.drawOval(115, 215, 20, 20);
				g.drawOval(140, 240, 20, 20);
				g.drawOval(165, 265, 20, 20);
				break;
			case 4:
				g.drawOval(115, 215, 20, 20);
				g.drawOval(115, 265, 20, 20);
				g.drawOval(165, 265, 20, 20);
				g.drawOval(165, 215, 20, 20);
				break;
			case 5:
				g.drawOval(115, 215, 20, 20);
				g.drawOval(115, 265, 20, 20);
				g.drawOval(140, 240, 20, 20);
				g.drawOval(165, 265, 20, 20);
				g.drawOval(165, 215, 20, 20);
				break;
			case 6:
				g.drawOval(115, 215, 20, 20);
				g.drawOval(115, 265, 20, 20);
				g.drawOval(115, 240, 20, 20);
				g.drawOval(165, 240, 20, 20);
				g.drawOval(165, 265, 20, 20);
				g.drawOval(165, 215, 20, 20);
				break;
			}
			
		}//If the checks if three dice need to be drawn out
		else if (betcheck == 1 || betcheck ==2) {
			//gets the value for the first die and uses the switch to draw it
			roll = rollV[0];
			switch (roll) {
			case 1:
				g.drawOval(140, 240, 20, 20);
				break;
			case 2:
				g.drawOval(115, 215, 20, 20);
				g.drawOval(165, 265, 20, 20);
				break;
			case 3:
				g.drawOval(115, 215, 20, 20);
				g.drawOval(140, 240, 20, 20);
				g.drawOval(165, 265, 20, 20);
				break;
			case 4:
				g.drawOval(115, 215, 20, 20);
				g.drawOval(115, 265, 20, 20);
				g.drawOval(165, 265, 20, 20);
				g.drawOval(165, 215, 20, 20);
				break;
			case 5:
				g.drawOval(115, 215, 20, 20);
				g.drawOval(115, 265, 20, 20);
				g.drawOval(140, 240, 20, 20);
				g.drawOval(165, 265, 20, 20);
				g.drawOval(165, 215, 20, 20);
				break;
			case 6:
				g.drawOval(115, 215, 20, 20);
				g.drawOval(115, 265, 20, 20);
				g.drawOval(115, 240, 20, 20);
				g.drawOval(165, 240, 20, 20);
				g.drawOval(165, 265, 20, 20);
				g.drawOval(165, 215, 20, 20);
				break;
			}
			
			
			//gets the value for the second die and uses the switch to draw it
			roll = rollV[1];
			switch (roll) {
			case 1:
				g.drawOval(270, 240, 20, 20);
				break;
			case 2:
				g.drawOval(245, 215, 20, 20);
				g.drawOval(295, 265, 20, 20);
				break;
			case 3:
				g.drawOval(245, 215, 20, 20);
				g.drawOval(270, 240, 20, 20);
				g.drawOval(295, 265, 20, 20);
				break;
			case 4:
				g.drawOval(245, 215, 20, 20);
				g.drawOval(245, 265, 20, 20);
				g.drawOval(295, 265, 20, 20);
				g.drawOval(295, 215, 20, 20);
				break;
			case 5:
				g.drawOval(245, 215, 20, 20);
				g.drawOval(245, 265, 20, 20);
				g.drawOval(270, 240, 20, 20);
				g.drawOval(295, 265, 20, 20);
				g.drawOval(295, 215, 20, 20);
				break;
			case 6:
				g.drawOval(245, 215, 20, 20);
				g.drawOval(245, 265, 20, 20);
				g.drawOval(245, 240, 20, 20);
				g.drawOval(295, 240, 20, 20);
				g.drawOval(295, 265, 20, 20);
				g.drawOval(295, 215, 20, 20);
				break;
			}
			
			//gets the value for the third die and uses the switch to draw it
			roll = rollV[2];
			switch (roll) {
			case 1:
				g.drawOval(400, 240, 20, 20);
				break;
			case 2:
				g.drawOval(375, 215, 20, 20);
				g.drawOval(425, 265, 20, 20);
				break;
			case 3:
				g.drawOval(375, 215, 20, 20);
				g.drawOval(400, 240, 20, 20);
				g.drawOval(425, 265, 20, 20);
				break;
			case 4:
				g.drawOval(375, 215, 20, 20);
				g.drawOval(375, 265, 20, 20);
				g.drawOval(425, 265, 20, 20);
				g.drawOval(425, 215, 20, 20);
				break;
			case 5:
				g.drawOval(375, 215, 20, 20);
				g.drawOval(375, 265, 20, 20);
				g.drawOval(400, 240, 20, 20);
				g.drawOval(425, 265, 20, 20);
				g.drawOval(425, 215, 20, 20);
				break;
			case 6:
				g.drawOval(375, 215, 20, 20);
				g.drawOval(375, 265, 20, 20);
				g.drawOval(375, 240, 20, 20);
				g.drawOval(425, 240, 20, 20);
				g.drawOval(425, 265, 20, 20);
				g.drawOval(425, 215, 20, 20);
				break;
			}
			
		}
		
	}
	
	private void initialize() {
		//Makes frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
