
public class Square extends Tetris {
	Square(int num) {

		Main.x[num][0] = 4;
		Main.x[num][1] = 4;
		Main.x[num][2] = 5;
		Main.x[num][3] = 5;
		Main.y[num][0] = 0;
		Main.y[num][1] = 1;
		Main.y[num][2] = 0;
		Main.y[num][3] = 1;

		Main.map(num, 2);
	}

	Square() {

	}

	public boolean rotation(int count, int num) {
		return true;
	}
}