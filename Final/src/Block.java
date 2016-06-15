public class Block {
	private boolean isBlock = false;

	public boolean bottomBlock(int num) {
		if (Main.y[num][0] == Main.colSize - 1)
			return true;
		if (Main.y[num][1] == Main.colSize - 1)
			return true;
		if (Main.y[num][2] == Main.colSize - 1)
			return true;
		if (Main.y[num][3] == Main.colSize - 1)
			return true;
		return false;
	}

	public boolean fallBlock(int num) {
		isBlock = false;
		for (int i = 0; i < 4; i++) {
			if (Main.player[num][Main.x[num][i]][Main.y[num][i] + 1] > 0) {
				for (int j = 0; j < 4; j++) {
					if (i != j && Main.x[num][i] == Main.x[num][j] && Main.y[num][j] > Main.y[num][i]) {
						isBlock = false;
						break;
					}
					isBlock = true;
				}
				if (isBlock) {
					return true;
				}
			}
		}
		return false;

	}

	public boolean leftBlock(int num) {
		isBlock = false;
		for (int i = 0; i < 4; i++) {
			if (Main.x[num][i] - 1 < 0)
				return true;
		}

		for (int i = 0; i < 4; i++) {

			if (Main.player[num][Main.x[num][i] - 1][Main.y[num][i]] > 0) {
				for (int j = 0; j < 4; j++) {
					if (i != j && Main.y[num][i] == Main.y[num][j] && Main.x[num][j] == Main.x[num][i] - 1) {
						isBlock = false;
						break;
					}
					isBlock = true;
				}
				if (isBlock) {
					return true;
				}
			}
		}
		return false;

	}

	public boolean rightBlock(int num) {
		isBlock = false;
		for (int i = 0; i < 4; i++) {
			if (Main.x[num][i] + 1 == Main.rowSize)
				return true;
		}
		for (int i = 0; i < 4; i++) {
			if (Main.player[num][Main.x[num][i] + 1][Main.y[num][i]] > 0) {
				for (int j = 0; j < 4; j++) {
					if (i != j && Main.y[num][i] == Main.y[num][j] && Main.x[num][j] == Main.x[num][i] + 1) {
						isBlock = false;
						break;
					}
					isBlock = true;
				}
				if (isBlock) {
					return true;
				}
			}
		}
		return false;
	}
}