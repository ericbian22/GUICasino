import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;

public class Rules extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void Rstart() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rules window = new Rules();
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
	public Rules() {
		/*
		 * Desc: This makes all of the labels and the words inside of them
		 * pre: A blank form
		 * post: A form with labels
		 */
		
		getContentPane().setLayout(null);
	
		//Label for rules on Blackjack
		JLabel lblBlackJackRules = new JLabel("New label");
		lblBlackJackRules.setBounds(10, 11, 268, 104);
		getContentPane().add(lblBlackJackRules);
		
		lblBlackJackRules.setText("<html>The Rules of BlackJack is that you have to get the closet to 21 as possible and beat the dealer.<br/> You are dealt two cards and then can chose to hit or stand, with hit you draw another card and with stand you end the game and check who has won.");
		
		//Label for rules on Slot Machines
		JLabel lblSlotMachineRules = new JLabel("<html>The Rules for the slot machine are very simple <br/> You press the roll button and the slot machine rolls. You can roll a 1,2,3 or 4. If they are all the same number you get 600 points, 300 points for two pairs and 100 squared if you get 1,2,3,4 in order");
		lblSlotMachineRules.setBounds(10, 126, 268, 112);
		getContentPane().add(lblSlotMachineRules);
		
		//Label for rules on Roulette
		JLabel lblRouletteRules = new JLabel("<html>The Rules for Roulette <br/> You select the thing you want to bet on from the drop down menu and then hit roll after you hit roll you will bet a amount you chose and if your bet wins you get double your bet.");
		lblRouletteRules.setBounds(288, 4, 268, 97);
		getContentPane().add(lblRouletteRules);
		
		//Label for rules on Chuck-A-Luck
		JLabel lblChuckALuckRules = new JLabel("<html>The Rules for ChuckALuck<br/> This dice based game allows you to chose to bet on one die, three dice or the sum of the three dice. If you bet on one or three then you pick a number to see if you get it. If you do then for the one die you get three times you bet and for the three you get double, if you guess the sum and bet on it you get 4 times your bet");
		lblChuckALuckRules.setBounds(288, 106, 268, 165);
		getContentPane().add(lblChuckALuckRules);
		
		//Label for rules on Horse Races
		JLabel lblHorseRaceRules = new JLabel("<html>The Rules for the horse race <br/> You pick a horse to bet on and if that horse gets the farthest then you get triple their bet.");
		lblHorseRaceRules.setBounds(10, 257, 268, 112);
		getContentPane().add(lblHorseRaceRules);
		
		//Label for rules on baccarat
		JLabel lblBaccaratRules = new JLabel("<html>The Rules for Baccarat(dice version) <br/> You roll the dice and select an amount to bet then you pick if your dice or the dealers dice will get closer to 9, then another dice is rolled to be added on to each. If you get it right then you get double you bet.");
		lblBaccaratRules.setBounds(288, 257, 268, 112);
		getContentPane().add(lblBaccaratRules);
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 618, 445);
		
		
		
	}
}
