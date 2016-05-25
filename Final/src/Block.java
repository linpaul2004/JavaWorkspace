public class Block {
	private boolean isBlock = false;

	public boolean bottomBlock() {
		if (Main.y[0] == Main.colSize - 1)
			return true;
		if (Main.y[1] == Main.colSize - 1)
			return true;
		if (Main.y[2] == Main.colSize - 1)
			return true;
		if (Main.y[3] == Main.colSize - 1)
			return true;
		return false;
	}

	public boolean fallBlock() {
		isBlock = false;
		for (int i = 0; i < 4; i++) {
			if (Main.player[Main.x[i]][Main.y[i] + 1] == 1) {
				for (int j = 0; j < 4; j++) {
					if (i != j && Main.x[i] == Main.x[j] && Main.y[j] > Main.y[i]) {
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

	public boolean leftBlock() {
		isBlock = false;
		for (int i = 0; i < 4; i++) {
			if (Main.x[i] - 1 < 0)
				return true;
		}

		for (int i = 0; i < 4; i++) {

			if (Main.player[Main.x[i] - 1][Main.y[i]] == 1) {
				for (int j = 0; j < 4; j++) {
					if (i != j && Main.y[i] == Main.y[j] && Main.x[j] == Main.x[i] - 1) {
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

	public boolean rightBlock() {
		isBlock = false;
		for (int i = 0; i < 4; i++) {
			if (Main.x[i] + 1 == Main.rowSize)
				return true;
		}
		for (int i = 0; i < 4; i++) {
			if (Main.player[Main.x[i] + 1][Main.y[i]] == 1) {
				for (int j = 0; j < 4; j++) {
					if (i != j && Main.y[i] == Main.y[j] && Main.x[j] == Main.x[i] + 1) {
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