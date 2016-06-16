
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
	static JLabel[][][] holding = new JLabel[2][4][3];
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
	static int rand1;
	static int rand2;
	static int randNext1;
	static int randNext2;
	static int nowHold1 = -1, nowHold2 = -1;
	static long before = 0;
	static long now = 0;
	static long pauseTime = 0;
	static boolean isback = false;
	static boolean isHold1 = false, isHold2 = false;
	// static JTextArea counter = new JTextArea();

	public static void main(String[] args) {

		Random ran = new Random();
		Move mov = new Move();
		Rotate rot = new Rotate();
		SoundTry sound = new SoundTry();
		sound.start();
		frame.addKeyListener(mov);
		frame.addKeyListener(rot);
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
		scoreLabel[0].setVisible(false);

		// if (mod.equals("battle") == true) {
		scoreLabel[1] = new JTextArea();
		scoreLabel[1].setBackground(SystemColor.control);
		scoreLabel[1].setEditable(false);
		scoreLabel[1].setFont(new Font(scoreLabel[1].getFont().getName(), scoreLabel[1].getFont().getStyle(), 40));
		scoreLabel[1].setText("Score:\n" + score[1]);
		scoreLabel[1].setSize(scoreLabel[1].getPreferredSize());
		scoreLabel[1].setLocation(1200, 400);
		frame.add(scoreLabel[1]);
		scoreLabel[1].setFocusable(false);
		scoreLabel[1].setVisible(false);
		// }

		for (int i = 0; i < rowSize; i++) {
			for (int j = 2; j < colSize; j++) {
				lb[0][i][j] = new JLabel();
				lb[0][i][j].setIcon(icon);
				lb[0][i][j].setLocation(41 * (i + 1), 41 * (j - 2));
				lb[0][i][j].setSize(40, 40);
				frame.add(lb[0][i][j]);
				lb[0][i][j].setVisible(false);

				// if (mod.equals("battle") == true) {
				lb[1][i][j] = new JLabel();
				lb[1][i][j].setIcon(icon);
				lb[1][i][j].setLocation(41 * (i + 1) + 700, 41 * (j - 2));
				lb[1][i][j].setSize(40, 40);
				frame.add(lb[1][i][j]);
				lb[1][i][j].setVisible(false);
				// }
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				next[0][i][j] = new JLabel();
				next[0][i][j].setIcon(icon);
				next[0][i][j].setLocation(41 * (i + 1) + 450, 41 * (j) + 100);
				next[0][i][j].setSize(40, 40);
				frame.add(next[0][i][j]);
				next[0][i][j].setVisible(false);

				// if (mod.equals("battle") == true) {
				next[1][i][j] = new JLabel();
				next[1][i][j].setIcon(icon);
				next[1][i][j].setLocation(41 * (i + 1) + 1150, 41 * (j) + 100);
				next[1][i][j].setSize(40, 40);
				frame.add(next[1][i][j]);
				next[1][i][j].setVisible(false);
				// }
				holding[0][i][j] = new JLabel();
				holding[0][i][j].setIcon(icon);
				holding[0][i][j].setLocation(41 * (i + 1) + 450, 41 * (j) + 250);
				holding[0][i][j].setSize(40, 40);
				frame.add(holding[0][i][j]);
				holding[0][i][j].setVisible(false);

				holding[1][i][j] = new JLabel();
				holding[1][i][j].setIcon(icon);
				holding[1][i][j].setLocation(41 * (i + 1) + 1150, 41 * (j) + 250);
				holding[1][i][j].setSize(40, 40);
				frame.add(holding[1][i][j]);
				holding[1][i][j].setVisible(false);

			}
		}
		frame.repaint();

		//////////////////////////////////////////////////////
		while (true) {////////////// big while
			System.out.print("");
			while (true) {
				System.out.print("");
				if (mod.equals("battle") == true) {
					frame.next1.setVisible(true);
					frame.next2.setVisible(true);
					frame.hold1.setVisible(true);
					frame.hold2.setVisible(true);
					frame.setSize(1400, 870);
					frame.setting();
					break;
				}

				if (mod.equals("single") == true) {
					frame.singleSetting();
					while (true) {
						System.out.print("");
						if (mod.equals("classic") == true) {
							frame.setSize(700, 870);
							frame.setting();
							break;
						}

						if (mod.equals("challenge") == true) {
							frame.setSize(700, 870);
							frame.setting();
							frame.restline.setText("Rest line:\n" + 3);
							frame.restline.setVisible(true);
							break;
						}

						if (mod.equals("timeMode") == true) {
							frame.setSize(700, 870);
							frame.setting();
							frame.restline.setText("Rest line:\n" + 5);
							frame.restline.setVisible(true);
							frame.counter.setVisible(true);
							break;
						}

						if (isback == true) {
							frame.setSize(500, 550);
							break;
						}
					}
					if (isback == true) {
						frame.singleChooseBack();
					} else
						break;
				}
			}
			/////////////////////////////////////////////////////////////////////// setting
			/////////////////////////////////////////////////////////////////////// end
			HighScore.mode = mod;

			while (mod.equals("battle") == true) {
				System.out.print("");
				if (isback == true) {
					frame.battlePlayBack();
					break;
				}
				if (startSignal == false) {
					continue;
				}

				frame.back.setVisible(false);
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
					if (isback == true) {
						break;
					}
					Main.isHold1 = isHold2 = false;
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
						Main.isHold1 = false;
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
						Main.isHold2 = false;
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
				frame.back.setVisible(true);
				frame.showLose.setVisible(false);
			}

			///////////////////////////////// classic
			while (mod.equals("classic") == true) {
				System.out.print("");
				if (isback == true) {
					frame.singlePlayBack();
					break;
				}
				if (startSignal == false) {
					continue;
				}
				frame.back.setVisible(false);
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
					System.out.print("");
					if (isback == true) {
						break;
					}
					Main.isHold1 = false;
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
						Main.isHold1 = false;
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
				frame.back.setVisible(true);
				frame.showLose.setVisible(false);
			}

			while (mod.equals("challenge") == true) {
				System.out.print("");
				if (isback == true) {
					frame.singlePlayBack();
					break;
				}
				int goal = 3;
				int add = 1;
				int other;

				//////
				if (startSignal == false) {
					continue;
				}
				frame.back.setVisible(false);

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
				Main.isHold1 = false;
				Tetris.fall();

				////////////////////////////////////////////////////////////////////////
				while (loser == -1) {
					System.out.print("");
					if (isback == true) {
						frame.singlePlayBack();
						break;
					}
					if (Tetris.fall() == 0) {
						if (isClear == false) {
							clear(0);
						}
						other = score[0] / 100;
						frame.restline.setText("Rest line:\n" + (goal - other));
						if (goal <= other) {
							other = other - goal;
							add += 2;
							goal += add;

							Tetris.speed += 40;
							frame.restline.setText("Rest line:\n" + (goal - other));
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
						Main.isHold1 = false;
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
				frame.back.setVisible(true);
				frame.showLose.setVisible(false);
				frame.restline.setText("Rest line:\n0");
			}

			while (mod.equals("timeMode") == true) {
				System.out.print("");
				if (isback == true) {
					frame.singlePlayBack();
					break;
				}
				line = 5;

				scoreLabel[0].setVisible(false);

				if (startSignal == false) {
					continue;
				}
				frame.back.setVisible(false);

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
					System.out.print("");
					if (isback == true) {
						break;
					}
					if (line <= 0) {
						HighScore.setHighscore((int) (now - before) / 1000, loser);
						highscore.setLocationRelativeTo(frame);
						highscore.setVisible(true);
						break;
					}
					if (before == 0) {
						before = System.currentTimeMillis();
					}

					Main.isHold1 = false;
					if (Tetris.fall() == 0) {
						if (isClear == false) {
							clear(0);
						}
						frame.restline.setText("Rest line:\n" + line);
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
						Main.isHold1 = false;
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
				frame.back.setVisible(true);

				frame.showLose.setVisible(false);

			}

		} // big while
	}

	public static void resetGame() {
		loser = -1;
		score[0] = score[1] = 0;
		scoreLabel[0].setText("Score:\n" + score[0]);
		if (mod.equals("battle") == true) {
			scoreLabel[1].setText("Score:\n" + score[1]);
		}
		isHold1 = isHold2 = false;
		nowHold1 = nowHold2 = -1;
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
				hintx[i][j] = 0;
				hinty[i][j] = 0;
			}
		}
		setIcon(0);
		deHint(0);
		if (Main.mod.equals("battle") == true) {
			setIcon(1);
			deHint(1);
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
				/*
				 * for (int i = 0; i < 4; i++) { tmp = Main.y[1][i] + up; if
				 * (Main.player[1][Main.x[1][i]][tmp] > 0) { isEmpty = false; }
				 * }
				 */
				if (isEmpty == false) {
					while (blk.fallBlock(1) == false) {
						for (int i = 0; i < 4; i++) {
							Main.y[1][i]++;
						}
					}
					deHint(1);
					map(1, Main.current2);
					setHint(1);

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
				if (isEmpty == true) {
					deHint(1);
					map(1, Main.current2);
					setHint(1);
				}
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
					deHint(0);
					map(0, Main.current1);
					setHint(0);
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
				if (isEmpty == true) {
					deHint(0);
					map(0, Main.current1);
					setHint(0);
				}
			}

		}
	}

	public static void map(int num, int shape) {
		player[num][Main.x[num][0]][Main.y[num][0]] = shape;
		player[num][Main.x[num][1]][Main.y[num][1]] = shape;
		player[num][Main.x[num][2]][Main.y[num][2]] = shape;
		player[num][Main.x[num][3]][Main.y[num][3]] = shape;

	}

	public static void setHold(int num, int rand) {
		holding[num][0][0].setIcon(icon);
		holding[num][0][1].setIcon(icon);
		holding[num][0][2].setIcon(icon);
		holding[num][1][0].setIcon(icon);
		holding[num][1][1].setIcon(icon);
		holding[num][1][2].setIcon(icon);
		holding[num][2][0].setIcon(icon);
		holding[num][2][1].setIcon(icon);
		holding[num][2][2].setIcon(icon);
		holding[num][3][0].setIcon(icon);
		holding[num][3][1].setIcon(icon);
		holding[num][3][2].setIcon(icon);
		switch (rand) {
		case 1:

			holding[num][1][0].setIcon(icon1);
			holding[num][1][1].setIcon(icon1);
			holding[num][1][2].setIcon(icon1);
			holding[num][2][1].setIcon(icon1);

			break;
		case 2:
			holding[num][1][1].setIcon(icon2);
			holding[num][1][2].setIcon(icon2);
			holding[num][2][1].setIcon(icon2);
			holding[num][2][2].setIcon(icon2);
			break;
		case 3:
			holding[num][0][1].setIcon(icon3);
			holding[num][1][1].setIcon(icon3);
			holding[num][2][1].setIcon(icon3);
			holding[num][3][1].setIcon(icon3);
			break;
		case 4:
			holding[num][0][0].setIcon(icon4);
			holding[num][0][1].setIcon(icon4);
			holding[num][1][1].setIcon(icon4);
			holding[num][2][1].setIcon(icon4);
			break;
		case 5:
			holding[num][0][0].setIcon(icon5);
			holding[num][1][0].setIcon(icon5);
			holding[num][1][1].setIcon(icon5);
			holding[num][2][1].setIcon(icon5);
			break;
		case 6:
			holding[num][0][1].setIcon(icon6);
			holding[num][1][1].setIcon(icon6);
			holding[num][2][0].setIcon(icon6);
			holding[num][2][1].setIcon(icon6);
			break;
		case 7:
			holding[num][0][1].setIcon(icon7);
			holding[num][1][0].setIcon(icon7);
			holding[num][1][1].setIcon(icon7);
			holding[num][2][0].setIcon(icon7);
			break;
		}
	}

	public static void skip(int num, int assign) {
		Random rnd = new Random();
		if (num == 0) {
			Main.nowHold1 = current1;
			if (assign == -1) {
				rand1 = randNext1;
			} else {
				rand1 = assign;
			}
			randNext1 = rnd.nextInt(7) + 1;
			Main.setHold(0, current1);
			current1 = rand1;
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
		} else {
			Main.nowHold2 = current2;
			if (assign == -1) {
				rand2 = randNext2;
			} else {
				rand2 = assign;
			}
			randNext2 = rnd.nextInt(7) + 1;
			Main.setHold(1, current2);
			current2 = rand2;
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
		}
	}

	public static void demap(int num) {
		player[num][Main.x[num][0]][Main.y[num][0]] = 0;
		player[num][Main.x[num][1]][Main.y[num][1]] = 0;
		player[num][Main.x[num][2]][Main.y[num][2]] = 0;
		player[num][Main.x[num][3]][Main.y[num][3]] = 0;
	}

	public static void setNext(int num, int rand) {
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
