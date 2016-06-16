
public abstract class Tetris {
	static int speed = 1;

	public abstract boolean rotation(int count, int num);

	public static int fall() {
		Block blk = new Block();
		System.out.print("");

		while (true) {
			System.out.print("");
			if (Main.isClear == true)
				return 0;

			if (Main.mod.equals("timeMode") == true) {
				Main.now = System.currentTimeMillis();
				Main.frame.counter.setText("Time:\n" + (Main.now - Main.before - Main.pauseTime) / 1000);
			}
			if (blk.bottomBlock(0) == true) {
				return 0;
			}
			if (blk.fallBlock(0) == true) {
				return 0;
			}
			if (blk.bottomBlock(1) == true && Main.mod.equals("battle") == true) {
				return 1;
			}
			if (blk.fallBlock(1) == true && Main.mod.equals("battle") == true) {
				return 1;
			}
			if (Main.isClear2 == true) {
				return 1;
			}
			//
			/////////////////////////////////
			Main.demap(0);
			Main.y[0][0]++;
			Main.y[0][1]++;
			Main.y[0][2]++;
			Main.y[0][3]++;
			Main.map(0, Main.current1);
			Main.setIcon(0);

			if (Main.mod.equals("battle") == true) {
				Main.demap(1);
				Main.y[1][0]++;
				Main.y[1][1]++;
				Main.y[1][2]++;
				Main.y[1][3]++;
				Main.map(1, Main.current2);
				Main.setIcon(1);

			}

			while (Main.pause || Main.loser == -2) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				Thread.sleep(500 - speed);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
