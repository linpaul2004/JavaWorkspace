
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Component extends JFrame {
	private static final long serialVersionUID = 1L;
	JButton gameStart = new JButton();
	JButton rank = new JButton();
	JButton single = new JButton();
	JButton battle = new JButton();
	JButton pause = new JButton();
	JLabel showLose = new JLabel();
	JLabel title = new JLabel();
	ImageIcon iconLose = new ImageIcon("lose.jpg");
	ImageIcon iconTitle = new ImageIcon("title.jpg");

	public Component() {
		setSize(500, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		gameStart.setText("Start");
		gameStart.setSize(gameStart.getPreferredSize());
		gameStart.setLocation(500, 550);
		gameStart.addActionListener(new ButtonControl());

		pause.setText("Pause");
		pause.setSize(pause.getPreferredSize());
		pause.setLocation(500, 580);
		pause.addActionListener(new ButtonControl());

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
		title.setLocation(getSize().width / 2 - title.getSize().width / 2, -200);
		add(gameStart);
		add(rank);
		add(single);
		add(battle);
		add(showLose);
		add(title);
		add(pause);
		//////////////////////////////////////////////////////
		setLayout(null);
		setVisible(true);
		gameStart.setFocusable(false);
		rank.setFocusable(false);
		single.setFocusable(false);
		battle.setFocusable(false);
		pause.setFocusable(false);
		for(int i = -200; i<300; i++)
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			title.setLocation(getSize().width / 2 - title.getSize().width / 2, i);
		}
	}

	public void setting() {
		gameStart.setVisible(true);
		rank.setVisible(false);
		single.setVisible(false);
		battle.setVisible(false);
		title.setVisible(false);
	}

}
