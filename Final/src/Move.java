import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Move implements KeyListener {

	public void keyPressed(KeyEvent e) {
		Block blk = new Block();
		if (blk.bottomBlock() == true)
			return;
		if (blk.fallBlock() == true)
			return;

		int key1 = e.getKeyCode();

		switch (key1) {
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		case KeyEvent.VK_LEFT:
			if (blk.leftBlock() == true)
				break;

			if (Main.x[0] - 1 < 0)
				break;
			if (Main.x[1] - 1 < 0)
				break;
			if (Main.x[2] - 1 < 0)
				break;
			if (Main.x[3] - 1 < 0)
				break;

			Main.player[Main.x[0]][Main.y[0]] = 0;
			Main.player[Main.x[1]][Main.y[1]] = 0;
			Main.player[Main.x[2]][Main.y[2]] = 0;
			Main.player[Main.x[3]][Main.y[3]] = 0;

			for (int i = 0; i < 4; i++) {
				Main.x[i]--;
			}

			Main.player[Main.x[0]][Main.y[0]] = 1;
			Main.player[Main.x[1]][Main.y[1]] = 1;
			Main.player[Main.x[2]][Main.y[2]] = 1;
			Main.player[Main.x[3]][Main.y[3]] = 1;
			Main.setIcon();

			break;
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		case KeyEvent.VK_RIGHT:
			if (blk.rightBlock() == true)
				break;

			if (Main.x[0] + 1 > Main.rowSize - 1)
				break;
			if (Main.x[1] + 1 > Main.rowSize - 1)
				break;
			if (Main.x[2] + 1 > Main.rowSize - 1)
				break;
			if (Main.x[3] + 1 > Main.rowSize - 1)
				break;

			Main.player[Main.x[0]][Main.y[0]] = 0;
			Main.player[Main.x[1]][Main.y[1]] = 0;
			Main.player[Main.x[2]][Main.y[2]] = 0;
			Main.player[Main.x[3]][Main.y[3]] = 0;

			for (int i = 0; i < 4; i++) {
				Main.x[i]++;
			}

			Main.player[Main.x[0]][Main.y[0]] = 1;
			Main.player[Main.x[1]][Main.y[1]] = 1;
			Main.player[Main.x[2]][Main.y[2]] = 1;
			Main.player[Main.x[3]][Main.y[3]] = 1;
			Main.setIcon();

			break;

		////////////////////////////////////////////////////////////////////////////////////////////

		case KeyEvent.VK_SPACE:

			int tmp = Main.y[0];
			for (int i = 0; i < 4; i++) {
				if (Main.y[i] > tmp) {
					tmp = Main.y[i];
				}
			}

			int miny = 0;
			int stoppos = Main.colSize - 1;
			boolean downtobottom = false;

			for (int i = 0; i < 4; i++) {
				for (int j = tmp + 1; j < Main.colSize; j++) {
					if (Main.player[Main.x[i]][j] == 1) {
						downtobottom = false;
						miny = j - 1;
						break;
					}
					downtobottom = true;
				}
				if (downtobottom) {
					continue;
				}
				if (miny < stoppos) {
					stoppos = miny;
				}
			}

			Main.player[Main.x[0]][Main.y[0]] = 0;
			Main.player[Main.x[1]][Main.y[1]] = 0;
			Main.player[Main.x[2]][Main.y[2]] = 0;
			Main.player[Main.x[3]][Main.y[3]] = 0;

			for (int i = 0; i < 4; i++) {
				Main.y[i] += stoppos - tmp;
			}

			Main.player[Main.x[0]][Main.y[0]] = 1;
			Main.player[Main.x[1]][Main.y[1]] = 1;
			Main.player[Main.x[2]][Main.y[2]] = 1;
			Main.player[Main.x[3]][Main.y[3]] = 1;
			break;
		/////////////////////////////////////
		case KeyEvent.VK_DOWN:
			Tetris.speed = 10;

			break;

		default:

		}
	}

	public void keyReleased(KeyEvent e) {
		Tetris.speed = 1;
	}

	public void keyTyped(KeyEvent e) {
	}

}
