
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Component extends JFrame {
	private static final long serialVersionUID = 1L;
	JButton gameStart = new JButton();
	JButton rank = new JButton();
	JButton rule = new JButton();
	JButton end = new JButton();
	JButton single = new JButton();
	JButton battle = new JButton();
	JButton pause = new JButton();
	JButton classic = new JButton();
	JButton challenge = new JButton();
	JButton timeMode = new JButton();
	JButton back = new JButton();
	JLabel showLose = new JLabel();
	JLabel next1 = new JLabel("1P Next"), next2 = new JLabel("2P Next");
	JLabel hold1 = new JLabel("1P Hold"), hold2 = new JLabel("2P Hold");
	JLabel backGround = new JLabel();
	JLabel title = new JLabel();
	JLabel ruleP = new JLabel();
	JTextArea restline = new JTextArea();
	JTextArea counter = new JTextArea();
	ImageIcon iconLose = new ImageIcon("lose.jpg");
	ImageIcon iconTitle = new ImageIcon("title.jpg");
	ImageIcon iconRule = new ImageIcon("rule.jpg");
	ImageIcon iconBackGround = new ImageIcon("backGround.jpg");

	public Component() {
		setSize(500, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		pause.setText("Pause");
		pause.setSize(pause.getPreferredSize());
		pause.setLocation(500, 580);
		pause.addActionListener(new ButtonControl());
		pause.setVisible(false);
		
		gameStart.setText("Start");
		gameStart.setSize(pause.getPreferredSize());
		gameStart.setLocation(500, 550);
		gameStart.addActionListener(new ButtonControl());
		gameStart.setVisible(false);

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

		rule.setText("Rule");
		rule.setSize(single.getPreferredSize());
		rule.setLocation(getSize().width / 2 - single.getSize().width / 2, 700);
		rule.addActionListener(new ButtonControl());

		end.setText("End");
		end.setSize(single.getPreferredSize());
		end.setLocation(getSize().width / 2 - single.getSize().width / 2, 725);
		end.addActionListener(new ButtonControl());
		end.setVisible(false);

		next1.setSize(next1.getPreferredSize());
		next1.setLocation(500, 80);

		next2.setSize(next2.getPreferredSize());
		next2.setLocation(1200, 80);

		hold1.setSize(hold1.getPreferredSize());
		hold1.setLocation(500, 230);

		hold2.setSize(hold2.getPreferredSize());
		hold2.setLocation(1200, 230);

		backGround.setIcon(iconBackGround);
		backGround.setSize(getSize().width, getSize().height);
		backGround.setLocation(0, 0);

		challenge.setText("Challenge");
		challenge.setSize(challenge.getPreferredSize());
		challenge.setLocation(getSize().width / 2 - rank.getSize().width / 2, 350);
		challenge.addActionListener(new ButtonControl());
		challenge.setVisible(false);

		classic.setText("Classic");
		classic.setSize(challenge.getPreferredSize());
		classic.setLocation(getSize().width / 2 - rank.getSize().width / 2, 300);
		classic.addActionListener(new ButtonControl());
		classic.setVisible(false);

		timeMode.setText("Time");
		timeMode.setSize(challenge.getPreferredSize());
		timeMode.setLocation(getSize().width / 2 - rank.getSize().width / 2, 400);
		timeMode.addActionListener(new ButtonControl());
		timeMode.setVisible(false);

		back.setText("Back");
		back.setSize(challenge.getPreferredSize());
		back.setLocation(getSize().width / 2 - rank.getSize().width / 2, 450);
		back.addActionListener(new ButtonControl());
		back.setVisible(false);

		showLose.setIcon(iconLose);
		showLose.setSize(showLose.getPreferredSize());
		showLose.setVisible(false);

		title.setIcon(iconTitle);
		title.setSize(title.getPreferredSize());
		title.setLocation(getSize().width / 2 - title.getSize().width / 2, -200);

		ruleP.setIcon(iconRule);
		ruleP.setSize(ruleP.getPreferredSize());
		ruleP.setLocation(getSize().width / 2 - ruleP.getSize().width / 2 - 10, -775);

		restline.setBackground(SystemColor.control);
		restline.setText("Rest line:\n" + 3);
		restline.setFont(new Font(restline.getFont().getName(), restline.getFont().getStyle(), 40));
		restline.setSize(restline.getPreferredSize());
		restline.setLocation(500, 650);
		restline.setFocusable(false);
		restline.setVisible(false);

		counter.setBackground(SystemColor.control);
		counter.setText("Time:\n" + (Main.now - Main.before) / 1000);
		counter.setFont(new Font(counter.getFont().getName(), counter.getFont().getStyle(), 40));
		counter.setSize(counter.getPreferredSize());
		counter.setLocation(500, 400);
		counter.setFocusable(false);
		counter.setVisible(false);

		add(ruleP);
		add(gameStart);
		add(rank);
		add(rule);
		add(end);
		add(single);
		add(battle);
		add(showLose);
		add(title);
		add(pause);
		add(classic);
		add(challenge);
		add(timeMode);
		add(back);
		add(restline);
		add(counter);
		add(next1);
		add(next2);
		add(hold1);
		add(hold2);
		add(backGround);
		//////////////////////////////////////////////////////
		setLayout(null);
		setVisible(true);
		gameStart.setFocusable(false);
		rank.setFocusable(false);
		rule.setFocusable(false);
		end.setFocusable(false);
		single.setFocusable(false);
		battle.setFocusable(false);
		pause.setFocusable(false);
		classic.setFocusable(false);
		challenge.setFocusable(false);
		timeMode.setFocusable(false);
		back.setFocusable(false);

		for (int i = -200; i < 300; i++) {
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
		pause.setVisible(true);
		rank.setVisible(false);
		rule.setVisible(false);
		end.setFocusable(false);
		single.setVisible(false);
		battle.setVisible(false);
		title.setVisible(false);
		classic.setVisible(false);
		challenge.setVisible(false);
		backGround.setVisible(false);
		timeMode.setVisible(false);
		back.setVisible(true);
		back.setLocation(580, 50);

		for (int i = 0; i < Main.rowSize; i++) {
			for (int j = 2; j < Main.colSize; j++) {
				Main.lb[0][i][j].setVisible(true);

				if (Main.mod.equals("battle") == true) {
					Main.lb[1][i][j].setVisible(true);
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {

				Main.next[0][i][j].setVisible(true);
				Main.holding[0][i][j].setVisible(true);

				if (Main.mod.equals("battle") == true) {
					Main.next[1][i][j].setVisible(true);
					Main.holding[1][i][j].setVisible(true);
				}
			}
		}

		Main.scoreLabel[0].setVisible(true);
		if (Main.mod.equals("battle") == true) {
			Main.scoreLabel[1].setVisible(true);
		}
	}

	public void singleSetting() {
		pause.setVisible(false);
		gameStart.setVisible(false);
		rank.setVisible(false);
		rule.setVisible(false);
		end.setFocusable(false);
		single.setVisible(false);
		battle.setVisible(false);
		title.setVisible(false);
		classic.setVisible(true);
		challenge.setVisible(true);
		backGround.setVisible(true);
		timeMode.setVisible(true);
		back.setVisible(true);
		restline.setVisible(false);
		counter.setVisible(false);
		next1.setVisible(true);
		hold1.setVisible(true);
		back.setLocation(getSize().width / 2 - rank.getSize().width / 2, 450);
	}

	public void singleChooseBack() {
		gameStart.setVisible(false);
		pause.setVisible(false);
		setSize(500, 800);
		rank.setVisible(true);
		rule.setVisible(true);
		end.setFocusable(false);
		single.setVisible(true);
		battle.setVisible(true);
		title.setVisible(true);
		classic.setVisible(false);
		backGround.setVisible(true);
		challenge.setVisible(false);
		timeMode.setVisible(false);
		back.setVisible(false);
		restline.setVisible(false);
		counter.setVisible(false);

		for (int i = -200; i < 300; i++) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			title.setLocation(getSize().width / 2 - title.getSize().width / 2, i);
		}
		Main.isback = false;
		Main.mod = "";
	}

	public void singlePlayBack() {
		setSize(500, 800);
		Main.mod = "single";
		rank.setVisible(false);
		rule.setVisible(false);
		end.setFocusable(false);
		single.setVisible(false);
		battle.setVisible(false);
		title.setVisible(false);
		classic.setVisible(true);
		challenge.setVisible(true);
		timeMode.setVisible(true);
		gameStart.setVisible(false);
		next1.setVisible(false);
		backGround.setVisible(true);
		hold1.setVisible(false);
		pause.setVisible(false);
		back.setLocation(getSize().width / 2 - rank.getSize().width / 2, 450);
		back.setVisible(true);
		setSize(500, 800);
		for (int i = 0; i < Main.rowSize; i++) {
			for (int j = 2; j < Main.colSize; j++) {
				Main.lb[0][i][j].setVisible(false);

			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {

				Main.next[0][i][j].setVisible(false);
				Main.holding[0][i][j].setVisible(false);

			}
		}

		Main.scoreLabel[0].setVisible(false);
		Main.isback = false;
		repaint();
	}

	public void battlePlayBack() {
		setSize(500, 800);
		gameStart.setVisible(false);
		pause.setVisible(false);
		rank.setVisible(true);
		rule.setVisible(true);
		end.setFocusable(false);
		single.setVisible(true);
		battle.setVisible(true);
		title.setVisible(true);
		classic.setVisible(false);
		challenge.setVisible(false);
		next1.setVisible(false);
		hold1.setVisible(false);
		next2.setVisible(false);
		backGround.setVisible(true);
		hold2.setVisible(false);
		timeMode.setVisible(false);
		back.setVisible(false);
		setSize(500, 800);
		for (int i = 0; i < Main.rowSize; i++) {
			for (int j = 2; j < Main.colSize; j++) {
				Main.lb[0][i][j].setVisible(false);
				Main.lb[1][i][j].setVisible(false);
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {

				Main.next[0][i][j].setVisible(false);
				Main.next[1][i][j].setVisible(false);
				Main.holding[0][i][j].setVisible(false);
				Main.holding[1][i][j].setVisible(false);

			}
		}

		Main.scoreLabel[0].setVisible(false);
		Main.scoreLabel[1].setVisible(false);

		repaint();
		Main.isback = false;
		Main.mod = "";
	}

	public void rulesetting(boolean isRuleShow) {
		if (isRuleShow) {
			rank.setVisible(true);
			rule.setVisible(true);
			single.setVisible(true);
			battle.setVisible(true);
			ruleP.setLocation(getSize().width / 2 - ruleP.getSize().width / 2 - 10, -775);
			end.setVisible(false);
		} else {
			rank.setVisible(false);
			rule.setVisible(false);
			single.setVisible(false);
			battle.setVisible(false);
			// for(int i = -775; i<=25; i+=5)
			// {
			// try {
			// Thread.sleep(10);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// }
			ruleP.setLocation(getSize().width / 2 - ruleP.getSize().width / 2 - 10, 25);
			end.setVisible(true);
		}
	}
}
