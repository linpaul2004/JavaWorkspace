import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	static final int rowSize = 10;
	static final int colSize = 20;
	static int[][] player = new int[rowSize][colSize];
	static JLabel[][] lb = new JLabel[rowSize][colSize];
	static ImageIcon icon = new ImageIcon("t1.png");
	static ImageIcon icon1 = new ImageIcon("t.png");
	static int[] x = new int[4];
	static int[] y = new int[4];

	public static void main(String[] args) {
		Random ran = new Random();
		Move mov = new Move();
		JFrame frame = new JFrame();
		frame.setSize(1000, 870);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(mov);

		frame.setLayout(null);

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				lb[i][j] = new JLabel();
				lb[i][j].setIcon(icon);
				lb[i][j].setLocation(41 * (i + 1), 41 * (j - 2));
				lb[i][j].setSize(40, 40);

				frame.add(lb[i][j]);
			}
		}

		// for(int i=0; i<20; i++){
		// player[0][i] = 1;
		// }
		frame.setVisible(true);
		while (true) {
			// ran.nextInt(7)+1
			switch (ran.nextInt(7) + 1) {

			case 1:
				Tetris t1 = new TShape();
				frame.addKeyListener(t1);
				t1.fall();
				frame.removeKeyListener(t1);
				clear();
				setIcon();
				break;
			case 2:
				Tetris t2 = new RightL();
				frame.addKeyListener(t2);
				t2.fall();
				frame.removeKeyListener(t2);
				clear();
				setIcon();
				break;
			case 3:
				Tetris t3 = new LeftL();
				frame.addKeyListener(t3);
				t3.fall();
				frame.removeKeyListener(t3);
				clear();
				setIcon();
				break;
			case 4:
				Tetris t4 = new Square();
				frame.addKeyListener(t4);
				t4.fall();
				frame.removeKeyListener(t4);
				clear();
				setIcon();
				break;
			case 5:
				Tetris t5 = new Line();
				frame.addKeyListener(t5);
				t5.fall();
				frame.removeKeyListener(t5);
				clear();
				setIcon();
				break;
			case 6:
				Tetris t6 = new LeftZ();
				frame.addKeyListener(t6);
				t6.fall();
				frame.removeKeyListener(t6);
				clear();
				setIcon();
				break;
			case 7:
				Tetris t7 = new RightZ();
				frame.addKeyListener(t7);
				t7.fall();
				frame.removeKeyListener(t7);
				clear();
				setIcon();
				break;
			}

		}

	}

	public static void setIcon() {
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				if (player[i][j] == 1) {
					Main.lb[i][j].setIcon(icon1);
				}

				if (player[i][j] == 0) {
					Main.lb[i][j].setIcon(icon);
				}
			}

		}
	}

	public static void clear() {
		boolean needClear;
		for (int i = Main.colSize - 1; i >= 0; i--) {
			needClear = true;
			for (int j = 0; j < Main.rowSize; j++) {
				if (Main.player[j][i] == 0) {
					needClear = false;
					break;
				}
			}
			if (needClear) {
				for (int ii = i; ii >= 1; ii--) {
					for (int jj = 0; jj < Main.rowSize; jj++) {
						Main.player[jj][ii] = Main.player[jj][ii - 1];
					}
				}
				i++;
			}
		}
	}

}
