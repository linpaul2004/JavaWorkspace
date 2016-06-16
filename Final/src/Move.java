import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Move implements KeyListener {
	long now1 = 0;
	long now2 = 0;
	long before1 = 0;
	long before2 = 0;
	int speed = 50;
	boolean[] isDrop = new boolean[2];

	public void keyPressed(KeyEvent e) {
		Block blk = new Block();

		int key1 = e.getKeyCode();

		switch (key1) {
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		case KeyEvent.VK_A:
			if (blk.leftBlock(0) == true)
				break;
			// if (blk.bottomBlock(0) == true || blk.fallBlock(0) == true)
			// break;
			if (isDrop[0] == true)
				break;

			if (Main.x[0][0] - 1 < 0)
				break;
			if (Main.x[0][1] - 1 < 0)
				break;
			if (Main.x[0][2] - 1 < 0)
				break;
			if (Main.x[0][3] - 1 < 0)
				break;

			Main.demap(0);

			for (int i = 0; i < 4; i++) {
				Main.x[0][i]--;
			}

			Main.map(0, Main.current1);
			Main.deHint(0);
			Main.setHint(0);
			Main.setIcon(0);

			break;
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		case KeyEvent.VK_D:
			if (blk.rightBlock(0) == true)
				break;
			// if (blk.bottomBlock(0) == true || blk.fallBlock(0) == true)
			// break;
			if (isDrop[0] == true)
				break;

			if (Main.x[0][0] + 1 > Main.rowSize - 1)
				break;
			if (Main.x[0][1] + 1 > Main.rowSize - 1)
				break;
			if (Main.x[0][2] + 1 > Main.rowSize - 1)
				break;
			if (Main.x[0][3] + 1 > Main.rowSize - 1)
				break;

			Main.demap(0);

			for (int i = 0; i < 4; i++) {
				Main.x[0][i]++;
			}

			Main.map(0, Main.current1);
			Main.deHint(0);
			Main.setHint(0);
			Main.setIcon(0);

			break;

		////////////////////////////////////////////////////////////////////////////////////////////

		case KeyEvent.VK_SPACE:
			if (blk.fallBlock(0)) {
				break;
			}
			if (blk.bottomBlock(0)) {
				break;
			}
			isDrop[0] = true;
			int tmp = Main.colSize;
			boolean downtobottom = true;
			boolean findstop = false;
			int stx = -1;
			for (int i = 0; i < 4; i++) {
				for (int j = Main.y[0][i] + 1; j < Main.colSize; j++) {
					if (Main.x[0][i] != stx && Main.player[0][Main.x[0][i]][j] <= 0) {
						findstop = true;
						for (int k = j; k < Main.colSize; k++) {
							if (Main.player[0][Main.x[0][i]][k] > 0) {
								if (tmp > k - j) {
									tmp = k - j;
								}
								stx = Main.x[0][i];
								downtobottom = false;
								j = Main.colSize + 1; // to break from j
								break; // break from k
							} // if==1,second search
							downtobottom = true;
						} // for k
						if (downtobottom) {
							if (tmp > Main.colSize - Main.y[0][i] - 1) {
								tmp = Main.colSize - Main.y[0][i] - 1;
							}
						}
					} // if==0,first search
				} // for j
				if (!findstop) {
					break;
				}
			} // for i

			Main.demap(0);
			for (int i = 0; i < 4; i++) {
				Main.y[0][i] += tmp;
			}

			Main.map(0, Main.current1);
			Main.clear(0);

			Main.isClear = true;
			if (Main.mod.equals("battle") == true)
				Main.attack(0);
			Main.setIcon(0);
			break;

		case KeyEvent.VK_S:
			now1 = System.currentTimeMillis();
			if (blk.bottomBlock(0) == true)
				break;
			if (blk.fallBlock(0) == true)
				break;
			if (now1 - before1 > speed) {

				Main.demap(0);
				Main.y[0][0]++;
				Main.y[0][1]++;
				Main.y[0][2]++;
				Main.y[0][3]++;
				Main.map(0, Main.current1);
				Main.setIcon(0);
				before1 = now1;
			}
			break;
		case KeyEvent.VK_F:
			if (Main.isHold1) {
				break;
			}
			Main.demap(0);
			Main.skip(0, Main.nowHold1);
			Main.setIcon(0);
			Main.deHint(0);
			Main.setHint(0);
			Main.setNext(0, Main.randNext1);
			Main.isHold1 = true;
			break;
		case KeyEvent.VK_SLASH:
			if (Main.isHold2) {
				break;
			}
			Main.demap(1);
			Main.skip(1, Main.nowHold2);
			Main.setIcon(1);
			Main.deHint(1);
			Main.setHint(1);
			Main.setNext(1, Main.randNext2);
			Main.isHold2 = true;
			break;
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		case KeyEvent.VK_LEFT:
			if (Main.mod.equals("battle") == false)
				break;
			if (blk.leftBlock(1) == true)
				break;
			// if (blk.bottomBlock(1) == true || blk.fallBlock(1) == true)
			// break;
			if (isDrop[1] == true)
				break;

			if (Main.x[1][0] - 1 < 0)
				break;
			if (Main.x[1][1] - 1 < 0)
				break;
			if (Main.x[1][2] - 1 < 0)
				break;
			if (Main.x[1][3] - 1 < 0)
				break;

			Main.demap(1);

			for (int i = 0; i < 4; i++) {
				Main.x[1][i]--;
			}

			Main.map(1, Main.current2);
			Main.deHint(1);
			Main.setHint(1);
			Main.setIcon(1);

			break;
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		case KeyEvent.VK_RIGHT:
			if (Main.mod.equals("battle") == false)
				break;
			if (blk.rightBlock(1) == true)
				break;
			// if (blk.bottomBlock(1) == true || blk.fallBlock(1) == true)
			// break;
			if (isDrop[1] == true)
				break;

			if (Main.x[1][0] + 1 > Main.rowSize - 1)
				break;
			if (Main.x[1][1] + 1 > Main.rowSize - 1)
				break;
			if (Main.x[1][2] + 1 > Main.rowSize - 1)
				break;
			if (Main.x[1][3] + 1 > Main.rowSize - 1)
				break;

			Main.demap(1);

			for (int i = 0; i < 4; i++) {
				Main.x[1][i]++;
			}

			Main.map(1, Main.current2);
			Main.deHint(1);
			Main.setHint(1);
			Main.setIcon(1);

			break;

		/////////////////////////////////////////////////////////////////////
		case KeyEvent.VK_ENTER:
			if (Main.mod.equals("battle") == false)
				break;
			if (blk.fallBlock(1)) {
				break;
			}
			if (blk.bottomBlock(1)) {
				break;
			}
			isDrop[1] = true;
			tmp = Main.colSize;
			downtobottom = true;
			findstop = false;
			stx = -1;
			for (int i = 0; i < 4; i++) {
				for (int j = Main.y[1][i] + 1; j < Main.colSize; j++) {
					if (Main.x[1][i] != stx && Main.player[1][Main.x[1][i]][j] <= 0) {
						findstop = true;
						for (int k = j; k < Main.colSize; k++) {
							if (Main.player[1][Main.x[1][i]][k] > 0) {
								if (tmp > k - j) {
									tmp = k - j;
								}
								stx = Main.x[1][i];
								downtobottom = false;
								j = Main.colSize + 1; // to break from j
								break; // break from k
							} // if==1,second search
							downtobottom = true;
						} // for k

						if (downtobottom) {
							if (tmp > Main.colSize - Main.y[1][i] - 1) {
								tmp = Main.colSize - Main.y[1][i] - 1;
							}
						}
					} // if==0,first search
				} // for j
				if (!findstop)
					break;
			} // for i

			Main.demap(1);
			for (int i = 0; i < 4; i++) {
				Main.y[1][i] += tmp;
			}

			Main.map(1, Main.current2);
			Main.clear(1);
			Main.isClear = true;
			if (Main.mod.equals("battle") == true)
				Main.attack(1);
			Main.setIcon(1);
			break;

		case KeyEvent.VK_DOWN:
			if (Main.mod.equals("battle") == false)
				break;
			now2 = System.currentTimeMillis();
			if (blk.bottomBlock(1) == true)
				break;
			if (blk.fallBlock(1) == true)
				break;
			if (now2 - before2 > speed) {

				Main.demap(1);
				Main.y[1][0]++;
				Main.y[1][1]++;
				Main.y[1][2]++;
				Main.y[1][3]++;
				Main.map(1, Main.current2);
				Main.setIcon(1);
				before2 = now2;
			}
			break;
		default:
			break;

		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {
	}

	//////

	////////

}
