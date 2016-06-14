
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Component extends JFrame{
	private static final long serialVersionUID = 1L;
	JButton gameStart = new JButton();
	JButton rank = new JButton();
	JButton single = new JButton();
	JButton battle = new JButton();
	JLabel showLose = new JLabel();
	JLabel title = new JLabel();
	ImageIcon iconLose = new ImageIcon("lose.jpg");
	ImageIcon iconTitle = new ImageIcon("title.jpg");
	//static JTextArea[] scoreLabel = new JTextArea[2];
	public Component(){
			setSize(500, 800);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			gameStart.setText("Start");
			gameStart.setSize(gameStart.getPreferredSize());
			gameStart.setLocation(500, 550);
			gameStart.addActionListener(new ButtonControl());
			
			single.setText("Single");
			single.setSize(single.getPreferredSize());
			single.setLocation(getSize().width / 2 - single.getSize().width / 2, 550);
			single.addActionListener(new ButtonControl());
			
			battle.setText("Battle");
			battle.setSize(single.getPreferredSize());
			battle.setLocation(getSize().width / 2 - battle.getSize().width / 2, 600);
			battle.addActionListener(new ButtonControl());
			
			rank.setText("Rank");
			rank.setSize(single.getPreferredSize());
			rank.setLocation(getSize().width / 2 - rank.getSize().width / 2, 650);
			rank.addActionListener(new ButtonControl());
			
			showLose.setIcon(iconLose);
			showLose.setSize(showLose.getPreferredSize());
			showLose.setVisible(false);
			
			title.setIcon(iconTitle);
			title.setSize(title.getPreferredSize());
			title.setLocation(getSize().width / 2 - title.getSize().width / 2, 300);
			/*
			scoreLabel[0] = new JTextArea();
			scoreLabel[0].setBackground(SystemColor.control);
			scoreLabel[0].setEditable(false);
			scoreLabel[0].setFont(new Font(scoreLabel[0].getFont().getName(), scoreLabel[0].getFont().getStyle(), 40));
			scoreLabel[0].setText("Score:\n" + Main.score[0]);
			scoreLabel[0].setSize(scoreLabel[0].getPreferredSize());
			scoreLabel[0].setLocation(500, 400);
			scoreLabel[0].setFocusable(false);
			
			if(Main.mod.equals("battle") == true){
				scoreLabel[1] = new JTextArea();
				scoreLabel[1].setBackground(SystemColor.control);
				scoreLabel[1].setEditable(false);
				scoreLabel[1].setFont(new Font(scoreLabel[1].getFont().getName(), scoreLabel[1].getFont().getStyle(), 40));
				scoreLabel[1].setText("Score:\n" + Main.score[1]);
				scoreLabel[1].setSize(scoreLabel[1].getPreferredSize());
				scoreLabel[1].setLocation(1200, 400);
				add(scoreLabel[1]);
				scoreLabel[1].setFocusable(false);
			}
			*/
			add(gameStart);
			add(rank);
			add(single);
			add(battle);
			add(showLose);
			add(title);
			//add(scoreLabel[0]);
			//////////////////////////////////////////////////////
			setLayout(null);
			setVisible(true);
			gameStart.setFocusable(false);
			rank.setFocusable(false);
			single.setFocusable(false);
			battle.setFocusable(false);
			
	}
	
	public void setting(){
		gameStart.setVisible(true);
		rank.setVisible(false);
		single.setVisible(false);
		battle.setVisible(false);
		title.setVisible(false);
	}
	

}
