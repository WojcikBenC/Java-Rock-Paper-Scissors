import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RockPaperScissors extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	static String in;
	static String opIn;
	static int wins = 0;; static int losses = 0; static int draws = 0;;
	JRadioButton rock = new JRadioButton("Rock");
	JRadioButton paper = new JRadioButton("Paper");
	JRadioButton scissors = new JRadioButton("Scissors");
	ButtonGroup input = new ButtonGroup();
	JLabel inputHelp = new JLabel("Select an option:");
	JPanel inputPanel = new JPanel();
	JLabel opponent = new JLabel("", JLabel.CENTER);
	JLabel opponentHelp = new JLabel("The computer put up:", JLabel.CENTER);
	JPanel opponentPanel = new JPanel();
	JLabel title = new JLabel("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws, JLabel.CENTER);
	JPanel titlePanel = new JPanel();
	JButton confirm = new JButton("Confirm");
	JLabel confirmHelp = new JLabel("Then confirm: ");
	JPanel confirmPanel = new JPanel();
	JLabel result = new JLabel("Welcome!", JLabel.CENTER);
	JPanel resultPanel = new JPanel();
	
	public RockPaperScissors() {
		createContents();
	}
	
	public void createContents() {
		setSize(512, 175);
		setTitle("Rock, Paper, Scissors!");
		setResizable(false);
		setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		inputPanel.setLayout(new BoxLayout(inputPanel,BoxLayout.PAGE_AXIS));
		confirmPanel.setLayout(new BoxLayout(confirmPanel,BoxLayout.PAGE_AXIS));
		title.setForeground(Color.white);
		titlePanel.setBackground(Color.darkGray);
		resultPanel.setBackground(Color.lightGray);
		rock.addActionListener(this);
		paper.addActionListener(this);
		scissors.addActionListener(this);
		confirm.addActionListener(this);
		input.add(rock);
		input.add(paper);
		input.add(scissors);
		inputPanel.add(inputHelp);
		inputPanel.add(rock);
		inputPanel.add(paper);
		inputPanel.add(scissors);
		titlePanel.add(title);
		confirmPanel.add(confirmHelp);
		confirmPanel.add(confirm);
		resultPanel.add(result);
		opponentPanel.add(opponentHelp);
		opponentPanel.add(opponent);
		opponentPanel.setVisible(false);
		add(titlePanel, BorderLayout.PAGE_START);
		add(inputPanel, BorderLayout.LINE_START);
		add(confirmPanel, BorderLayout.LINE_END);
		add(resultPanel, BorderLayout.PAGE_END);
		add(opponentPanel);
		setVisible(true);
	}
	
	public void play() {
		int rand = (int)((Math.random() * 3) + 1);
		if(rand == 1) {
			opIn = "Rock";
		} else if(rand == 2) {
			opIn = "Paper";
		} else {
			opIn = "Scissors";
		}
		opponent.setText(opIn);
		if(opponentPanel.isVisible() != true) {
			opponentPanel.setVisible(true);
		}
		if(in.equals(opIn)) {
			result.setText("Draw.");
			resultPanel.setBackground(Color.lightGray);
			draws++;
		} else if(in.equals("Paper") && opIn.equals("Rock")) {
			result.setText("You Win!");
			resultPanel.setBackground(Color.green);
			wins++;
		} else if(in.equals("Scissors") && opIn.equals("Paper")) {
			result.setText("You Win!");
			resultPanel.setBackground(Color.green);
			wins++;
		} else if(in.equals("Rock") && opIn.equals("Scissors")) {
			result.setText("You Win!");
			resultPanel.setBackground(Color.green);
			wins++;
		} else {
			result.setText("You Lose.");
			resultPanel.setBackground(Color.red);
			losses++;
		}
		title.setText("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws);
	}
	
	public static void main(String[] args) {
		new RockPaperScissors();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource() == rock) {
				in = "Rock";
			} else if(e.getSource() == paper) {
				in = "Paper";
			} else if(e.getSource() == scissors) {
				in = "Scissors";
			} else {
				if(in != null) {
				play();
				} else {
					result.setText("Choose an option first!");
				}
			}
	}
}
