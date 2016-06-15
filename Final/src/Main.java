
import java.awt.Font;
import java.awt.SystemColor;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Main {
	static final int rowSize = 10;
	static final int colSize = 22;
	static int[][][] player = new int[2][rowSize][colSize];
	static JLabel[][][] lb = new JLabel[2][rowSize][colSize];
	static JLabel[][][] next = new JLabel[2][4][3];
	static JTextArea[] scoreLabel = new JTextArea[2];
	static ImageIcon icon = new ImageIcon("t.png");
	static ImageIcon icon1 = new ImageIcon("t1.png");
	static ImageIcon icon2 = new ImageIcon("t2.png");
	static ImageIcon icon3 = new ImageIcon("t3.png");
	static ImageIcon icon4 = new ImageIcon("t4.png");
	static ImageIcon icon5 = new ImageIcon("t5.png");
	static ImageIcon icon6 = new ImageIcon("t6.png");
	static ImageIcon icon7 = new ImageIcon("t7.png");
	static ImageIcon iconhint = new ImageIcon("hint.jpg");
	// attack
	static ImageIcon iconbrick = new ImageIcon("brick.png");
	static boolean attack0, attack1;
	static int[] attacktime = new int[2];
	static boolean isClear = false;
	////////////

	static int[][] hintx = new int[2][4];
	static int[][] hinty = new int[2][4];
	static int[][] x = new int[2][4];
	static int[][] y = new int[2][4];
	static int[] score = new int[2];
	static int loser;
	static int current1, current2;
	static boolean startSignal = false;
	static boolean pause = false;
	static String mod = "";
	static HighScore highscore = new HighScore();
	static Component frame = new Component();
	static int line = 0;
	static long before = 0;
	static long now = 0;
	static long pauseTime = 0;
	static JTextArea counter = new JTextArea();

	public static void main(String[] args) {
		int rand1;
		int rand2;
		int randNext1;
		int randNext2;

		Random ran = new Random();
		Move mov = new Move();
		Rotate rot = new Rotate();
		frame.addKeyListener(mov);
		frame.addKeyListener(rot);
		JTextArea restline = new JTextArea();

		//////////////////////////////////////////////////////
		/*
		 * while(true){ if(mod.equals("battle") == false) {
		 * System.out.println(""); frame.gameStart.setVisible(false); try {
		 * Thread.sleep(500); } catch (InterruptedException e) {
		 * e.printStackTrace(); } }
		 * 
		 * 
		 * }
		 */
		while (true) {
			System.out.println("");
			if (mod.equals("battle") == true) {
				frame.setSize(1400, 870);
				frame.setting();
				break;
			}

			if (mod.equals("single") == true) {
				frame.singleSetting();
				while (true) {
					System.out.println("");
					if (mod.equals("classic") == true) {
						frame.setSize(700, 870);
						frame.setting();
						break;
					}

					if (mod.equals("challenge") == true) {
						frame.setSize(700, 870);
						frame.setting();
						break;
					}

					if (mod.equals("timeMode") == true) {
						frame.setSize(700, 870);
						frame.setting();
						break;
					}
				}
				break;
			}
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 20; k++) {
					player[i][j][k] = 0;
				}
			}
		}

		score[0] = score[1] = 0;
		loser = -1;
		/////
		attacktime[0] = attacktime[1] = 0;
		////
		scoreLabel[0] = new JTextArea();
		scoreLabel[0].setBackground(SystemColor.control);
		scoreLabel[0].setEditable(false);
		scoreLabel[0].setFont(new Font(scoreLabel[0].getFont().getName(), scoreLabel[0].getFont().getStyle(), 40));
		scoreLabel[0].setText("Score:\n" + score[0]);
		scoreLabel[0].setSize(scoreLabel[0].getPreferredSize());
		scoreLabel[0].setLocation(500, 400);
		frame.add(scoreLabel[0]);
		scoreLabel[0].setFocusable(false);

		HighScore.mode = mod;

		if (mod.equals("battle") == true) {
			scoreLabel[1] = new JTextArea();
			scoreLabel[1].setBackground(SystemColor.control);
			scoreLabel[1].setEditable(false);
			scoreLabel[1].setFont(new Font(scoreLabel[1].getFont().getName(), scoreLabel[1].getFont().getStyle(), 40));
			scoreLabel[1].setText("Score:\n" + score[1]);
			scoreLabel[1].setSize(scoreLabel[1].getPreferredSize());
			scoreLabel[1].setLocation(1200, 400);
			frame.add(scoreLabel[1]);
			scoreLabel[1].setFocusable(false);
		}

		for (int i = 0; i < rowSize; i++) {
			for (int j = 2; j < colSize; j++) {
				lb[0][i][j] = new JLabel();
				lb[0][i][j].setIcon(icon);
				lb[0][i][j].setLocation(41 * (i + 1), 41 * (j - 2));
				lb[0][i][j].setSize(40, 40);
				frame.add(lb[0][i][j]);

				if (mod.equals("battle") == true) {
					lb[1][i][j] = new JLabel();
					lb[1][i][j].setIcon(icon);
					lb[1][i][j].setLocation(41 * (i + 1) + 700, 41 * (j - 2));
					lb[1][i][j].setSize(40, 40);
					frame.add(lb[1][i][j]);
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				next[0][i][j] = new JLabel();
				next[0][i][j].setIcon(icon);
				next[0][i][j].setLocation(41 * (i + 1) + 450, 41 * (j) + 150);
				next[0][i][j].setSize(40, 40);
				frame.add(next[0][i][j]);

				if (mod.equals("battle") == true) {
					next[1][i][j] = new JLabel();
					next[1][i][j].setIcon(icon);
					next[1][i][j].setLocation(41 * (i + 1) + 1150, 41 * (j) + 150);
					next[1][i][j].setSize(40, 40);
					frame.add(next[1][i][j]);
				}
			}
		}
		frame.repaint();

		while (mod.equals("battle") == true) {
			System.out.println("");
			if (startSignal == false) {
				continue;
			}

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
			setHint(0);
			setHint(1);
			Tetris.fall();

			////////////////////////////////////////////////////////////////////////
			while (loser == -1 && startSignal) {
				System.out.print("");
				if (Tetris.fall() == 0) {

					if (isClear == false) {
						clear(0);
					}
					attack(0);
					loser = isOver();
					rot.rotation1 = 0;
					rand1 = randNext1;
					current1 = rand1;
					randNext1 = ran.nextInt(7) + 1;
					setNext(0, randNext1);
					isClear = false;
					mov.isDrop[0] = false;
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
					setHint(0);
					Tetris.fall();
				} else {
					if (isClear == false) {
						clear(1);
					}
					loser = isOver();
					//
					attack(1);
					/////
					rand2 = randNext2;
					current2 = rand2;
					randNext2 = ran.nextInt(7) + 1;
					setNext(1, randNext2);
					rot.rotation2 = 0;
					isClear = false;
					mov.isDrop[1] = false;
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
					setHint(1);
					Tetris.fall();
				}
			}
			frame.gameStart.setText("Start");
			if (loser >= 0) {
				frame.showLose.setLocation(50 + loser * 720, 100);
				frame.showLose.setVisible(true);
				HighScore.setHighscore(score[1 - loser], loser);
				highscore.setLocationRelativeTo(frame);
				highscore.setVisible(true);
			}
			resetGame();
			frame.showLose.setVisible(false);
		}

		///////////////////////////////// classic
		while (mod.equals("classic") == true) {
			System.out.println("");
			if (startSignal == false) {
				continue;
			}
			randNext1 = ran.nextInt(7) + 1;
			rand1 = ran.nextInt(7) + 1;
			current1 = rand1;
			setNext(0, randNext1);
			mov.isDrop[0] = false;
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
			setHint(0);
			Tetris.fall();

			////////////////////////////////////////////////////////////////////////
			while (loser == -1 && startSignal) {
				if (Tetris.fall() == 0) {
					if (isClear == false) {
						clear(0);
					}
					loser = isOver();
					rot.rotation1 = 0;
					rand1 = randNext1;
					current1 = rand1;
					randNext1 = ran.nextInt(7) + 1;
					setNext(0, randNext1);
					isClear = false;
					mov.isDrop[0] = false;
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
					setHint(0);
					Tetris.fall();
				}
			}
			frame.gameStart.setText("Start");
			if (loser >= 0) {
				frame.showLose.setLocation(50 + loser * 720, 100);
				frame.showLose.setVisible(true);
				HighScore.setHighscore(score[0], loser);
				highscore.setLocationRelativeTo(frame);
				highscore.setVisible(true);
			}
			resetGame();
			frame.showLose.setVisible(false);
		}

		while (mod.equals("challenge") == true) {
			System.out.println("");
			int goal = 3;
			int add = 1;
			int other;

			restline.setBackground(SystemColor.control);
			restline.setText("Rest line:\n" + (goal - line));
			restline.setFont(new Font(restline.getFont().getName(), restline.getFont().getStyle(), 40));
			restline.setSize(restline.getPreferredSize());
			restline.setLocation(500, 650);
			frame.add(restline);
			restline.setFocusable(false);
			//////
			if (startSignal == false) {
				continue;
			}

			randNext1 = ran.nextInt(7) + 1;
			rand1 = ran.nextInt(7) + 1;
			current1 = rand1;
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
			setHint(0);
			Tetris.fall();

			////////////////////////////////////////////////////////////////////////
			while (loser == -1) {
				if (Tetris.fall() == 0) {
					if (isClear == false) {
						clear(0);
					}
					other = score[0] / 100;
					restline.setText("Rest line:\n" + (goal - other));
					if (goal <= other) {
						other = other - goal;
						add += 2;
						goal += add;

						Tetris.speed += 40;
						restline.setText("Rest line:\n" + (goal - other));
					}
					loser = isOver();
					rot.rotation1 = 0;
					rand1 = randNext1;
					current1 = rand1;
					randNext1 = ran.nextInt(7) + 1;
					setNext(0, randNext1);
					isClear = false;
					mov.isDrop[0] = false;
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
					setHint(0);
					Tetris.fall();
				}
			}
			frame.gameStart.setText("Start");
			if (loser >= 0) {
				frame.showLose.setLocation(50 + loser * 720, 100);
				frame.showLose.setVisible(true);
				HighScore.setHighscore(score[0], loser);
				highscore.setLocationRelativeTo(frame);
				highscore.setVisible(true);
			}
			resetGame();
			frame.showLose.setVisible(false);
			restline.setText("Rest line:\n0");
		}

		while (mod.equals("timeMode") == true) {
			System.out.println("");
			line = 5;
			scoreLabel[0].setVisible(false);
			counter.setBackground(SystemColor.control);
			counter.setText("Time:\n" + (now - before) / 1000);
			counter.setFont(new Font(counter.getFont().getName(), counter.getFont().getStyle(), 40));
			counter.setSize(counter.getPreferredSize());
			counter.setLocation(500, 400);
			frame.add(counter);
			restline.setBackground(SystemColor.control);
			restline.setText("Rest line:\n" + line);
			restline.setFont(new Font(restline.getFont().getName(), restline.getFont().getStyle(), 40));
			restline.setSize(restline.getPreferredSize());
			restline.setLocation(500, 650);
			frame.add(restline);
			restline.setFocusable(false);

			if (startSignal == false) {
				continue;
			}

			before = System.currentTimeMillis();

			randNext1 = ran.nextInt(7) + 1;
			rand1 = ran.nextInt(7) + 1;
			current1 = rand1;
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
			setHint(0);
			Tetris.fall();

			////////////////////////////////////////////////////////////////////////
			while (loser == -1 && startSignal) {
				if (line <= 0) {
					HighScore.setHighscore((int) (now - before) / 1000, loser);
					highscore.setLocationRelativeTo(frame);
					highscore.setVisible(true);
					break;
				}
				if (before == 0)
					before = System.currentTimeMillis();

				if (Tetris.fall() == 0) {
					if (isClear == false) {
						clear(0);
					}
					restline.setText("Rest line:\n" + line);
					loser = isOver();
					rot.rotation1 = 0;
					rand1 = randNext1;
					current1 = rand1;
					randNext1 = ran.nextInt(7) + 1;
					setNext(0, randNext1);
					isClear = false;
					mov.isDrop[0] = false;
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
					setHint(0);
					Tetris.fall();
				}
			}
			frame.gameStart.setText("Start");
			if (loser >= 0) {
				frame.showLose.setLocation(50 + loser * 720, 100);
				frame.showLose.setVisible(true);
				HighScore.setHighscore((int) (now - before) / 1000, 1);
				highscore.setLocationRelativeTo(frame);
				highscore.setVisible(true);
				now = 999;
				before = 0;
			}
			resetGame();

			frame.showLose.setVisible(false);

		}
	}

	public static void resetGame() {
		loser = -1;
		score[0] = score[1] = 0;
		scoreLabel[0].setText("Score:\n" + score[0]);
		if (mod.equals("battle") == true) {
			scoreLabel[1].setText("Score:\n" + score[1]);
		}

		//////////
		attacktime[0] = attacktime[1] = 0;
		//////////

		Tetris.speed = 1;
		startSignal = false;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < rowSize; j++) {
				for (int k = 0; k < colSize; k++) {
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
		if (Main.mod.equals("battle") == true) {
			setIcon(1);
		}
	}

	public static void setIcon(int num) {
		for (int i = 0; i < rowSize; i++) {
			for (int j = 2; j < colSize; j++) {

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
				case 100:
					lb[num][i][j].setIcon(iconbrick);
					break;
				case -1:
					lb[num][i][j].setIcon(iconhint);
					break;
				}

			}
		}
	}

	public static int isOver() {
		int over = 1;
		for (int col = 0; col < colSize; col++) {
			for (int row = 0; row < rowSize; row++) {
				if (player[0][row][col] > 0) {
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

		if (mod.equals("battle") == true) {
			over = 1;
			for (int col = 0; col < colSize; col++) {
				for (int row = 0; row < rowSize; row++) {
					if (player[1][row][col] > 0) {
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
		}
		return -1;
	}

	public static void clear(int num) {
		boolean needClear;
		boolean hasCombo = false;
		int combo = 0;
		int add = 0;

		for (int i = Main.colSize - 1; i >= 0; i--) {
			needClear = true;
			for (int j = 0; j < Main.rowSize; j++) {
				if (Main.player[num][j][i] <= 0) {
					needClear = false;
					break;
				}
			}
			if (needClear) {

				hasCombo = true;
				if (mod.equals("challenge") == true)
					line++;
				else if (mod.equals("timeMode") == true)
					line--;
				for (int ii = i; ii >= 1; ii--) {
					for (int jj = 0; jj < Main.rowSize; jj++) {
						Main.player[num][jj][ii] = Main.player[num][jj][ii - 1];
					}
				}
				i++;
				add++;
			}

		}
		if (hasCombo) {
			combo++;
		} else {
			combo = 0;
		}

		score[num] += (100 * ((add * (add + 1)) / 2)) * ((combo + 1) / 2);
		scoreLabel[num].setText("Score:\n" + score[num]);

	}

	//
	public static void attack(int num) {

		Random ran = new Random();
		int randblank;
		int up = 0;
		int tmp = 0;

		boolean isEmpty = true;
		Block blk = new Block();
		if (num == 0) {
			// player1 attack player2
			if (score[0] >= (attacktime[0] + 1) * 200) {
				randblank = ran.nextInt(Main.rowSize);
				up = (score[0] - attacktime[0] * 200) / 200;
				attacktime[0] += up;

				demap(1);
				isEmpty = true;
				tmp = 0;
				for (int i = 0; i < 4; i++) {
					tmp = Main.y[1][i] + up;
					if (Main.player[1][Main.x[1][i]][tmp] > 0) {
						isEmpty = false;
					}
				}

				if (isEmpty == false) {
					while (blk.fallBlock(1) == false) {
						for (int i = 0; i < 4; i++) {
							Main.y[1][i]++;
						}
					}
					map(1, Main.current2);
				}
				// up
				for (int i = 0; i < Main.colSize - up; i++) {
					for (int j = 0; j < Main.rowSize; j++) {
						Main.player[1][j][i] = Main.player[1][j][i + up];
					}
				}
				for (int k = 1; k <= up; k++) {
					for (int i = 0; i < Main.rowSize; i++) {
						if (i == randblank) {
							Main.player[1][i][Main.colSize - k] = 0;
							continue;
						}
						Main.player[1][i][Main.colSize - k] = 100;
					}
				}
				///////
				if (isEmpty == true)
					map(1, Main.current2);
			}

		} else {
			// player2 attack player1
			if (score[1] >= (attacktime[1] + 1) * 200) {
				randblank = ran.nextInt(Main.rowSize);
				up = (score[1] - attacktime[1] * 200) / 200;
				attacktime[1] += up;
				System.out.println(up);
				demap(0);

				isEmpty = true;
				tmp = 0;
				for (int i = 0; i < 4; i++) {
					tmp = Main.y[0][i] + up;
					if (Main.player[0][Main.x[0][i]][tmp] > 0) {
						isEmpty = false;
					}
				}

				if (isEmpty == false) {
					while (blk.fallBlock(0) == false) {
						for (int i = 0; i < 4; i++) {
							Main.y[0][i]++;
						}
					}
					map(0, Main.current1);
				}

				//
				for (int i = 0; i < Main.colSize - up; i++) {
					for (int j = 0; j < Main.rowSize; j++) {
						Main.player[0][j][i] = Main.player[0][j][i + up];
					}
				}

				for (int k = 1; k <= up; k++) {
					for (int i = 0; i < Main.rowSize; i++) {
						if (i == randblank) {
							Main.player[0][i][Main.colSize - k] = 0;
							continue;
						}
						Main.player[0][i][Main.colSize - k] = 100;
					}
				}
				//
				if (isEmpty == true)
					map(0, Main.current1);
			}

		}
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

	///////////////////////// hint
	public static void setHint(int num) {
		Block blk = new Block();
		if (blk.bottomBlock(num) == true || blk.fallBlock(num) == true)
			return;

		int tmp = Main.colSize;
		boolean downtobottom = true;
		boolean findstop = false;
		boolean overlap = false;
		int stx = -1;

		for (int i = 0; i < 4; i++) {
			for (int j = Main.y[num][i] + 1; j < Main.colSize; j++) {
				if (Main.x[num][i] != stx && Main.player[num][Main.x[num][i]][j] <= 0) {
					findstop = true;
					for (int k = j; k < Main.colSize; k++) {
						if (Main.player[num][Main.x[num][i]][k] > 0) {
							if (tmp > k - j) {
								tmp = k - j;
							}
							stx = Main.x[num][i];
							downtobottom = false;
							j = Main.colSize + 1; // to break from j
							break; // break from k
						} // if==1,second search
						downtobottom = true;
					} // for k
					if (downtobottom) {
						if (tmp > Main.colSize - Main.y[num][i] - 1) {
							tmp = Main.colSize - Main.y[num][i] - 1;
						}
					}
				} // if==0,first search
			} // for j
			if (!findstop) {
				break;
			}
		} // for i

		for (int i = 0; i < 4; i++) {
			hinty[num][i] = Main.y[num][i] + tmp;
			hintx[num][i] = Main.x[num][i];
		}

		for (int i = 0; i < 4; i++) {
			overlap = false;
			for (int j = 0; j < 4; j++) {
				if (hinty[num][i] == Main.y[num][j]) {
					overlap = true;
					break;
				}
			}
			if (!overlap)
				player[num][hintx[num][i]][hinty[num][i]] = -1;

		}

		setIcon(num);
	}

	public static void deHint(int num) {
		for (int i = 0; i < 4; i++) {
			if (player[num][hintx[num][i]][hinty[num][i]] <= 0)
				player[num][hintx[num][i]][hinty[num][i]] = 0;
		}
	}
	////////////////////////////////////////// hint end

}
