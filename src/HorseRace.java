import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class HorseRace extends JFrame{

	//Decleration of all the integers,arrays,randoms and strings used
	private JFrame frame;
	int race =7;
	int sx = 100;
	int lx = 100;
	int rx = 100;
	int hx = 100;
	int gx = 100;
	int cx = 100;
	int speed = 10;
	int[] run = new int[4];
	int type;
	int bet;
	int check = 0;
	static Image img;
	static Image img1;
	static Image img2;
	static Image img3;
	static Image img4;
	static Image img5;
	static Timer timer;
	int sxspeed = 1000;
	//Attempted global points
	static int score = Casino.score;
	String t;
	Random event = new Random();
	
	;
	/**
	 * Launch the application.
	 */
	public void Hstart(){
		//Method that starts it all
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HorseRace window = new HorseRace();
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
	public HorseRace() {
		/*
		 * Desc: Where everything added to the frame is added
		 * pre: a blank frame
		 * post: a full frame
		 * 
		 */
		getContentPane().setLayout(null);
		
		//Labels to let people know things and one button so that other buttons can access it
		JLabel lblWin = new JLabel("");
		JButton btnPlayAgain = new JButton("Play Again");
		JLabel lblPoints = new JLabel("Points:");
		lblPoints.setBounds(132, 42, 129, 20);
		getContentPane().add(lblPoints);
		
		//Combobox to pick which horse to bet on
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Speedy", "Lucky", "Roger", "Hyper", "Gouda", "Crow"}));
		comboBox.setBounds(10, 11, 104, 20);
		getContentPane().add(comboBox);
		
		//Button that makes the horses move and makes the calculations of the winner
		JButton btnRace = new JButton("Race");
		btnRace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					//score = Casino.score;
					//Pop up message that takes bet
					//ReminderBeep(1);
					t = JOptionPane.showInputDialog("Input Bet:");
					try {
						bet = Integer.parseInt(t);
					}
					catch (Exception e) {
						t = JOptionPane.showInputDialog("Please enter a number for the bet:");
					}
					
					score = score - bet;
					lblPoints.setText("Points: " + score);
					//Stops the user from playing with no points
					if (score <= 0) {
						btnRace.setEnabled(false);
					}
					//Makes the race move
					
					move(race);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//Checks for winners based on x location
					if (comboBox.getSelectedIndex()== 0 && sx >= lx && sx >= rx && sx >= hx && sx >= gx && sx >= cx) {
						lblWin.setText("You win");
						score = score + (bet*3);
					}
					else if (comboBox.getSelectedIndex()== 1 && lx >= sx && lx >= rx && lx >= hx && lx >= gx && lx >= cx) {
						lblWin.setText("You win");
						score = score + (bet*3);
					}
					else if (comboBox.getSelectedIndex()== 2 && rx >= sx && rx >= lx && rx >= hx && rx >= gx && rx >= cx) {
						lblWin.setText("You win");
						score = score + (bet*3);
					}
					else if (comboBox.getSelectedIndex()== 3 && hx >= sx && hx >= lx && hx >= rx && hx >= gx && hx >= cx) {
						lblWin.setText("You win");
						score = score + (bet*3);
					}
					else if (comboBox.getSelectedIndex()== 4 && gx >= sx && gx >= lx && gx >= hx && gx >= rx && gx >= cx) {
						lblWin.setText("You win");
						score = score + (bet*3);
					}
					else if (comboBox.getSelectedIndex()== 5 && cx >= sx && cx >= lx && cx >= hx && cx >= gx && cx >= rx) {
						lblWin.setText("You win");
						score = score + (bet*3);
					}
					else {
						lblWin.setText("You lose");
						
					}
					//Puts up scores and shows play again button
					lblPoints.setText("Points: " + score);
					Casino.score = Casino.score + score;
					btnPlayAgain.setVisible(true);
					 btnRace.setVisible(false);
					 //Attempt at file read
					 try {
							PrintWriter output = new PrintWriter(Casino.points);
							
							output.write(score);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			}
		});
		btnRace.setBounds(10, 42, 104, 29);
		getContentPane().add(btnRace);
		
		
		lblWin.setBounds(142, 11, 119, 20);
		getContentPane().add(lblWin);
		
		//The button for play again that resets the horses positions and paints them there and allows for another race
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 sx = 100;
				 lx = 100;
				 rx = 100;
				 hx = 100;
				 gx = 100;
				 cx = 100;
				 speed = 10;
				 btnPlayAgain.setVisible(false);
				 btnRace.setVisible(true);
				 repaint();
			}
		});
		btnPlayAgain.setBounds(10, 82, 104, 29);
		btnPlayAgain.setVisible(false);
		getContentPane().add(btnPlayAgain);
		
		
		
		initialize();
	}
	
	public int move(int race) {
		/*
		 * Desc: Method that is somewhat recursive and controls the race movement and what things happen to each horse
		 * pre: Horses at starting line
		 * post: A race now completed
		 */
		repaint();
		check = 1;
		if (race == 1) {
			return 1;
		}
		else {
			
			//Moves the horses a bit before checking if anything happens to them
			//sx = sx + speed;
			//lx = lx + speed;
			//rx = rx + speed;
			//hx = hx + speed;
			//gx = gx + speed;
			//cx = cx + speed;
			
			//Random that picks an event
			type = event.nextInt(4) + 1;
			
			//Switch that controls the events with 1 and 4 moving the horse back and 2 and 3 moving the horse up
			switch (type) {
				case 1:
					type = event.nextInt(6);
					switch (type) {
					case 1:
						sx = sx - 100;
						break;
					case 2:
						lx = lx - 100;
						break;
					case 3:
						rx = rx - 100;
						break;
					case 4:
						hx = hx - 100;
						break;
					case 5:
						gx = gx - 100;
						break;
					case 6:
						cx = cx - 100;
						break;
					}
				break;
				case 2:
					type = event.nextInt(6);
					switch (type) {
					case 1:
						sx = sx + 100;
						break;
					case 2:
						lx = lx + 100;
						break;
					case 3:
						rx = rx + 100;
						break;
					case 4:
						hx = hx + 100;
						break;
					case 5:
						gx = gx + 100;
						break;
					case 6:
						cx = cx + 100;
						break;
					}
				break;
				case 3:
					type = event.nextInt(6);
					switch (type) {
					case 1:
						sx = sx + 200;
						break;
					case 2:
						lx = lx + 200;
						break;
					case 3:
						rx = rx + 200;
						break;
					case 4:
						hx = hx + 200;
						break;
					case 5:
						gx = gx + 200;
						break;
					case 6:
						cx = cx + 200;
						break;
					}
				break;
				case 4:
					type = event.nextInt(6);
					switch (type) {
					case 1:
						sx = sx - 200;
						break;
					case 2:
						lx = lx - 200;
						break;
					case 3:
						rx = rx - 200;
						break;
					case 4:
						hx = hx - 200;
						break;
					case 5:
						gx = gx - 200;
						break;
					case 6:
						cx = cx - 200;
						break;
					}
				break;
			}
			
			
			
			//
			//Makes them move
			repaint();
			
			return move(race - 1);
	}
		
		
	}
	
	public void ReminderBeep(int seconds) {

		timer = new Timer();
		timer.schedule(new RemindTask(), seconds);
		
		}

		//Class to control moving objects

		class RemindTask extends TimerTask {
		public void run() {

		/*while (sxspeed > sx) {
		sx = sx + speed;
		lx = lx + speed;
		rx = rx + speed;
		hx = hx + speed;
		gx = gx + speed;
		cx = cx + speed;
		}
		*/
		if (sx > 1000) {
			sx = 0;
			lx=0;
			rx=0;
			hx=0;
			gx=0;
			cx=0;
		}
		sx++;
		lx++;
		rx++;
		hx++;
		gx++;
		cx++;

		repaint();
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
	
	public void paint(Graphics g) {
		//Paint method that paints the horse where ever it is
		super.paint(g);
		img = Toolkit.getDefaultToolkit().getImage("Horse1.jpg");
		img1 = Toolkit.getDefaultToolkit().getImage("Horse2.jpg");
		img2 = Toolkit.getDefaultToolkit().getImage("Horse3.jpg");
		img3 = Toolkit.getDefaultToolkit().getImage("Horse4.jpg");
		img4 = Toolkit.getDefaultToolkit().getImage("Horse5.jpg");
		img5 = Toolkit.getDefaultToolkit().getImage("Horse6.jpg");
		g.setFont(new Font("Verdana", Font.BOLD, 20));
		g.drawImage(img, sx, 200, 40, 30, null);
		//g.drawRect(sx, 200, 40, 30);
	    g.drawString("S", 100, 220);
	    g.drawImage(img1, lx, 250, 40, 30, null);
		g.drawString("L", 100, 270);
		g.drawImage(img2, rx, 300, 40, 30, null);
		g.drawString("R", 100, 320);
		g.drawImage(img3, hx, 350, 40, 30, null);
		g.drawString("H", 100, 370);
		g.drawImage(img4, gx, 400, 40, 30, null);
		g.drawString("G", 100, 420);
		g.drawImage(img5, cx, 450, 40, 30, null);
		g.drawString("C", 100, 470);
		//if (check == 1) {
		//ReminderBeep(1);
		//}
		ReminderBeep(1);
		
		
	}
}
