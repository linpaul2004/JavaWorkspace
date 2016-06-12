
public abstract class Tetris {
	static int speed = 1;

	public abstract boolean rotation(int count, int num);

	public static int fall() {
		Block blk = new Block();
		while (true) {
			if (blk.bottomBlock(0) == true) {
				return 0;
			}
			if (blk.fallBlock(0) == true) {
				return 0;
			}
			if (blk.bottomBlock(1) == true) {
				return 1;
			}
			if (blk.fallBlock(1) == true) {
				return 1;
			}

			/////////////////////////////////
			Main.demap(0);
			Main.demap(1);

			Main.y[0][0]++;
			Main.y[0][1]++;
			Main.y[0][2]++;
			Main.y[0][3]++;

			Main.y[1][0]++;
			Main.y[1][1]++;
			Main.y[1][2]++;
			Main.y[1][3]++;

			Main.map(0, Main.current1);
			Main.map(1, Main.current2);
			Main.setIcon(0);
			Main.setIcon(1);

			try {
				Thread.sleep(500 / speed);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
