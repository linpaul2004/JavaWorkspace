
import java.awt.Font;
import java.awt.SystemColor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Main {
	static final int rowSize = 10;
	static final int colSize = 20;
	static int[][][] player = new int[2][rowSize][colSize];
	static JLabel[][][] lb = new JLabel[2][rowSize][colSize];
	static JLabel[][][] next = new JLabel[2][4][3];
	static JLabel showLose = new JLabel();
	static JLabel title = new JLabel();
	static JTextArea[] scoreLabel = new JTextArea[2];
	static JButton startButton = new JButton();
	static ImageIcon icon = new ImageIcon("t1.png");
	static ImageIcon icon1 = new ImageIcon("t.png");
	static ImageIcon icon2 = new ImageIcon("t2.png");
	static ImageIcon icon3 = new ImageIcon("t3.png");
	static ImageIcon icon4 = new ImageIcon("t4.png");
	static ImageIcon icon5 = new ImageIcon("t5.png");
	static ImageIcon icon6 = new ImageIcon("t6.png");
	static ImageIcon icon7 = new ImageIcon("t7.png");
	static ImageIcon iconLose = new ImageIcon("lose.jpg");
	static ImageIcon iconTitle = new ImageIcon("title.jpg");
	static int[][] x = new int[2][4];
	static int[][] y = new int[2][4];
	static int[] score = new int[2];
	static int loser;
	static int current1, current2;
	static boolean start;

	public static void main(String[] args) {
		int rand1;
		int rand2;
		int randNext1;
		int randNext2;
		Random ran = new Random();
		Move mov = new Move();
		Rotate rot = new Rotate();
		JFrame frame = new JFrame();
		start = false;
		frame.setSize(1400, 870);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(mov);
		frame.addKeyListener(rot);
		frame.add(showLose);
		frame.add(title);
		frame.add(startButton);
		showLose.setIcon(iconLose);
		showLose.setSize(showLose.getPreferredSize());
		showLose.setVisible(false);
		title.setIcon(iconTitle);
		title.setSize(title.getPreferredSize());
		title.setLocation(frame.getSize().width / 2 - title.getSize().width / 2, 300);
		startButton.setText("Start Game");
		startButton.setSize(startButton.getPreferredSize());
		startButton.setLocation(frame.getSize().width / 2 - startButton.getSize().width / 2, 550);
		startButton.addActionListener(new ButtonControl());
		frame.setLayout(null);
		frame.setVisible(true);
		startButton.setFocusable(false);
		while (start == false) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		title.setVisible(false);
		startButton.setVisible(false);

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 20; k++) {
					player[i][j][k] = 0;
				}
			}
		}

		score[0] = score[1] = 0;
		loser = -1;
		scoreLabel[0] = new JTextArea();
		scoreLabel[1] = new JTextArea();
		scoreLabel[0].setBackground(SystemColor.control);
		scoreLabel[1].setBackground(SystemColor.control);
		scoreLabel[0].setEditable(false);
		scoreLabel[1].setEditable(false);
		scoreLabel[0].setFont(new Font(scoreLabel[0].getFont().getName(), scoreLabel[0].getFont().getStyle(), 40));
		scoreLabel[1].setFont(new Font(scoreLabel[1].getFont().getName(), scoreLabel[1].getFont().getStyle(), 40));
		scoreLabel[0].setText("Score:\n" + score[0]);
		scoreLabel[0].setSize(scoreLabel[0].getPreferredSize());
		scoreLabel[0].setLocation(500, 400);
		frame.add(scoreLabel[0]);
		scoreLabel[1].setText("Score:\n" + score[1]);
		scoreLabel[1].setSize(scoreLabel[1].getPreferredSize());
		scoreLabel[1].setLocation(1200, 400);
		frame.add(scoreLabel[1]);
		scoreLabel[0].setFocusable(false);
		scoreLabel[1].setFocusable(false);

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				lb[0][i][j] = new JLabel();
				lb[0][i][j].setIcon(icon);
				lb[0][i][j].setLocation(41 * (i + 1), 41 * (j - 2));
				lb[0][i][j].setSize(40, 40);

				lb[1][i][j] = new JLabel();
				lb[1][i][j].setIcon(icon);
				lb[1][i][j].setLocation(41 * (i + 1) + 700, 41 * (j - 2));
				lb[1][i][j].setSize(40, 40);

				frame.add(lb[0][i][j]);
				frame.add(lb[1][i][j]);
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				next[0][i][j] = new JLabel();
				next[0][i][j].setIcon(icon);
				next[0][i][j].setLocation(41 * (i + 1) + 450, 41 * (j) + 150);
				next[0][i][j].setSize(40, 40);

				next[1][i][j] = new JLabel();
				next[1][i][j].setIcon(icon);
				next[1][i][j].setLocation(41 * (i + 1) + 1150, 41 * (j) + 150);
				next[1][i][j].setSize(40, 40);

				frame.add(next[0][i][j]);
				frame.add(next[1][i][j]);
			}
		}
		frame.repaint();

		while (true) {
			randNext1 = ran.nextInt(7) + 1;
			randNext2 = ran.nextInt(7) + 1;
			rand1 = ran.nextInt(7) + 1;
			rand2 = ran.nextInt(7) + 1;
			current1 = rand1;
			current2 = rand2;
			setNext(0, randNext1);
			setNext(1, randNext2);

			switch (rand1) {
			case 1:
				new TShape(0);
				break;
			case 2:
				new Square(0);
				break;
			case 3:
				new Line(0);
				break;
			case 4:
				new LeftL(0);
				break;
			case 5:
				new LeftZ(0);
				break;
			case 6:
				new RightL(0);
				break;
			case 7:
				new RightZ(0);
				break;
			}

			switch (rand2) {
			case 1:
				new TShape(1);
				break;
			case 2:
				new Square(1);
				break;
			case 3:
				new Line(1);
				break;
			case 4:
				new LeftL(1);
				break;
			case 5:
				new LeftZ(1);
				break;
			case 6:
				new RightL(1);
				break;
			case 7:
				new RightZ(1);
				break;
			}

			Tetris.fall();

			////////////////////////////////////////////////////////////////////////
			while (loser == -1) {
				loser = isOver();
				if (Tetris.fall() == 0) {
					clear();
					Rotate.rotation1 = 0;
					rand1 = randNext1;
					current1 = rand1;
					randNext1 = ran.nextInt(7) + 1;
					setNext(0, randNext1);
					switch (rand1) {
					case 1:
						new TShape(0);
						break;
					case 2:
						new Square(0);
						break;
					case 3:
						new Line(0);
						break;
					case 4:
						new LeftL(0);
						break;
					case 5:
						new LeftZ(0);
						break;
					case 6:
						new RightL(0);
						break;
					case 7:
						new RightZ(0);
						break;
					}

					Tetris.fall();
				} else {
					clear();
					rand2 = randNext2;
					current2 = rand2;
					randNext2 = ran.nextInt(7) + 1;
					setNext(1, randNext2);
					Rotate.rotation2 = 0;
					switch (rand2) {
					case 1:
						new TShape(1);
						break;
					case 2:
						new Square(1);
						break;
					case 3:
						new Line(1);
						break;
					case 4:
						new LeftL(1);
						break;
					case 5:
						new LeftZ(1);
						break;
					case 6:
						new RightL(1);
						break;
					case 7:
						new RightZ(1);
						break;
					}

					Tetris.fall();
				}
			}
			frame.removeKeyListener(rot);
			frame.removeKeyListener(mov);
			showLose.setLocation(50 + loser * 720, 100);
			showLose.setVisible(true);
			String message = "Player " + (loser == 0 ? 2 : 1) + " wins!" + "\nScore:" + score[1 - loser];
			message += "\nHigh Score:\n";
			message += (setHighscore(score[1 - loser], loser));
			JOptionPane.showMessageDialog(null, message);
			resetGame();
			frame.addKeyListener(rot);
			frame.addKeyListener(mov);
		}
	}

	public static void resetGame() {
		loser = -1;
		score[0] = score[1] = 0;
		Tetris.speed = 1;
		showLose.setVisible(false);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 20; k++) {
					player[i][j][k] = 0;
				}
			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				x[i][j] = 0;
				y[i][j] = 0;
			}
		}
		setIcon(0);
		setIcon(1);
	}

	public static void setIcon(int num) {
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				// if (player[num][i][j] == 1) {
				// lb[num][i][j].setIcon(icon1);
				// }
				switch (player[num][i][j]) {
				case 1:
					lb[num][i][j].setIcon(icon1);
					break;
				case 2:
					lb[num][i][j].setIcon(icon2);
					break;
				case 3:
					lb[num][i][j].setIcon(icon3);
					break;
				case 4:
					lb[num][i][j].setIcon(icon4);
					break;
				case 5:
					lb[num][i][j].setIcon(icon5);
					break;
				case 6:
					lb[num][i][j].setIcon(icon6);
					break;
				case 7:
					lb[num][i][j].setIcon(icon7);
					break;
				case 0:
					lb[num][i][j].setIcon(icon);
					break;

				}
				// if (player[num][i][j] == 0) {
				// lb[num][i][j].setIcon(icon);
				// }
			}
		}
	}

	public static String setHighscore(int score, int loser) {
		File fileHigh = new File("highscore.txt");
		int winner = loser == 0 ? 2 : 1;
		String output = "";
		if (fileHigh.exists() == false) {
			try {
				fileHigh.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			boolean last = true;
			Scanner readin = new Scanner(new FileInputStream("highscore.txt"));
			while (readin.hasNextInt()) {
				int s = readin.nextInt();
				if (s >= score) {
					output += "" + s + " " + readin.nextInt() + "\n";
				} else {
					output += "" + score + " " + winner + "\n";
					output += "" + s + " " + readin.nextInt() + "\n";
					last = false;
					break;
				}
			}
			while (readin.hasNextInt()) {
				output += "" + readin.nextInt() + " " + readin.nextInt() + "\n";
			}
			if (last) {
				output += "" + score + " " + winner + "\n";
			}
			readin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PrintWriter writer = new PrintWriter(new FileOutputStream("highscore.txt"));
			writer.write(output);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner strScanner = new Scanner(output);
		String realOutput = "";
		while (strScanner.hasNextInt()) {
			int s = strScanner.nextInt();
			realOutput += "Player" + strScanner.nextInt() + " Score: " + s + "\n";
		}
		strScanner.close();
		return realOutput;
	}

	public static void clear() {
		boolean needClear;
		for (int k = 0; k < 2; k++) {
			int add = 50;
			for (int i = Main.colSize - 1; i >= 0; i--) {
				needClear = true;
				for (int j = 0; j < Main.rowSize; j++) {
					if (Main.player[k][j][i] == 0) {
						needClear = false;
						break;
					}
				}
				if (needClear) {
					for (int ii = i; ii >= 1; ii--) {
						for (int jj = 0; jj < Main.rowSize; jj++) {
							Main.player[k][jj][ii] = Main.player[k][jj][ii - 1];
						}
					}
					i++;
					add *= 2;
				}
			}
			if (add == 50) {
				add = 0;
			}
			score[k] += add;
			scoreLabel[k].setText("Score:\n" + score[k]);
		}
	}

	public static int isOver() {
		int over = 1;
		for (int col = 2; col < colSize; col++) {
			for (int row = 0; row < rowSize; row++) {
				if (player[0][row][col] != 0) {
					break;
				}
				if (row == rowSize - 1) {
					over = 0;
				}
			}
		}
		if (over == 1) {
			return 0;
		}
		over = 1;
		for (int col = 2; col < colSize; col++) {
			for (int row = 0; row < rowSize; row++) {
				if (player[1][row][col] != 0) {
					break;
				}
				if (row == rowSize - 1) {
					over = 0;
				}
			}
		}
		if (over == 1) {
			return 1;
		}
		return -1;
	}

	public static void map(int num, int shape) {
		player[num][Main.x[num][0]][Main.y[num][0]] = shape;
		player[num][Main.x[num][1]][Main.y[num][1]] = shape;
		player[num][Main.x[num][2]][Main.y[num][2]] = shape;
		player[num][Main.x[num][3]][Main.y[num][3]] = shape;

	}

	public static void demap(int num) {
		player[num][Main.x[num][0]][Main.y[num][0]] = 0;
		player[num][Main.x[num][1]][Main.y[num][1]] = 0;
		player[num][Main.x[num][2]][Main.y[num][2]] = 0;
		player[num][Main.x[num][3]][Main.y[num][3]] = 0;
	}

	private static void setNext(int num, int rand) {
		next[num][0][0].setIcon(icon);
		next[num][0][1].setIcon(icon);
		next[num][0][2].setIcon(icon);
		next[num][1][0].setIcon(icon);
		next[num][1][1].setIcon(icon);
		next[num][1][2].setIcon(icon);
		next[num][2][0].setIcon(icon);
		next[num][2][1].setIcon(icon);
		next[num][2][2].setIcon(icon);
		next[num][3][0].setIcon(icon);
		next[num][3][1].setIcon(icon);
		next[num][3][2].setIcon(icon);
		switch (rand) {
		case 1:

			next[num][1][0].setIcon(icon1);
			next[num][1][1].setIcon(icon1);
			next[num][1][2].setIcon(icon1);
			next[num][2][1].setIcon(icon1);

			break;
		case 2:
			next[num][1][1].setIcon(icon2);
			next[num][1][2].setIcon(icon2);
			next[num][2][1].setIcon(icon2);
			next[num][2][2].setIcon(icon2);
			break;
		case 3:
			next[num][0][1].setIcon(icon3);
			next[num][1][1].setIcon(icon3);
			next[num][2][1].setIcon(icon3);
			next[num][3][1].setIcon(icon3);
			break;
		case 4:
			next[num][0][0].setIcon(icon4);
			next[num][0][1].setIcon(icon4);
			next[num][1][1].setIcon(icon4);
			next[num][2][1].setIcon(icon4);
			break;
		case 5:
			next[num][0][0].setIcon(icon5);
			next[num][1][0].setIcon(icon5);
			next[num][1][1].setIcon(icon5);
			next[num][2][1].setIcon(icon5);
			break;
		case 6:
			next[num][0][1].setIcon(icon6);
			next[num][1][1].setIcon(icon6);
			next[num][2][0].setIcon(icon6);
			next[num][2][1].setIcon(icon6);
			break;
		case 7:
			next[num][0][1].setIcon(icon7);
			next[num][1][0].setIcon(icon7);
			next[num][1][1].setIcon(icon7);
			next[num][2][0].setIcon(icon7);
			break;
		}
	}

}
