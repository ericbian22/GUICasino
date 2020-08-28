import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;



public class MainMenu extends JFrame{
	//Decleration of each class with a game or rules/account info
	BlackJack b = new BlackJack();
	HorseRace h = new HorseRace();
	Baccarat ba = new Baccarat();
	ChuckALuck c = new ChuckALuck();
	SlotMachines s = new SlotMachines();
	Account a = new Account();
	Roulette r = new Roulette();
	Rules u = new Rules();
	static Image img;
	private JFrame frame;
	
	public void Main() {
		//Makes frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public MainMenu() {
		getContentPane().setBackground(Color.WHITE);
		repaint();
		/*
		 * Desc: Where all of the buttons are made and given the commands to take you to each class
		 * pre: a blank form
		 * post: a form full of stuff
		 */
		getContentPane().setLayout(null);
		
		JLabel lblIntro = new JLabel("Please select a game to play");
		lblIntro.setBounds(128, 11, 188, 28);
		getContentPane().add(lblIntro);
		
		JButton btnBlackJack = new JButton("BlackJack");
		btnBlackJack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Button that opens BlackJack
				//b.Bstart();
				b.setVisible(true);
				repaint();
				
			}
		});
		btnBlackJack.setBounds(24, 50, 113, 35);
		getContentPane().add(btnBlackJack);
		
		JButton btnRoulette = new JButton("Roulette");
		btnRoulette.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Button that opens Roulette
				//r.Rstart();
				r.setVisible(true);
				repaint();
			}
		});
		btnRoulette.setBounds(154, 50, 113, 35);
		getContentPane().add(btnRoulette);
		
		JButton btnHorseRace = new JButton("Horse Race");
		btnHorseRace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Button that opens horse race
				//h.Hstart();
				h.setVisible(true);
				repaint();
			}
		});
		btnHorseRace.setBounds(296, 50, 113, 35);
		getContentPane().add(btnHorseRace);
		
		JButton btnBaccarat = new JButton("Baccarat");
		btnBaccarat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Button that opens Baccarat
				//ba.BAStart();
				ba.setVisible(true);
				repaint();
			}
		});
		btnBaccarat.setBounds(24, 96, 113, 35);
		getContentPane().add(btnBaccarat);
		
		JButton btnChuckALuck = new JButton("Chuck-A-Luck");
		btnChuckALuck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Button that opens Chuck-A-Luck
				//c.Cstart();
				c.setVisible(true);
				repaint();
			}
		});
		btnChuckALuck.setBounds(154, 96, 113, 35);
		getContentPane().add(btnChuckALuck);
		
		JButton btnSlotMachines = new JButton("Slot Machines");
		btnSlotMachines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Button that opens Slot Machines
				//s.Sstart();
				s.setVisible(true);
				repaint();
			}
		});
		btnSlotMachines.setBounds(296, 96, 113, 35);
		getContentPane().add(btnSlotMachines);
		
		JButton btnAccount = new JButton("Check your Account");
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Button that would have opened an account page
				//a.Astart();
				a.setVisible(true);
				repaint();
			}
		});
		btnAccount.setBounds(128, 143, 162, 35);
		getContentPane().add(btnAccount);
		
		JButton btnRules = new JButton("Rules");
		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Button that opens Rules
				//u.Rstart();
				u.setVisible(true);
				repaint();
			}
			
		});
		btnRules.setBounds(29, 142, 89, 35);
		getContentPane().add(btnRules);
	}
	
	public void paint(Graphics g) {
		super.paint(g);	
		img = Toolkit.getDefaultToolkit().getImage("CasinoMain.jpg");
		g.drawImage(img, 100, 500, 100, 100, null);
		
	}
}
