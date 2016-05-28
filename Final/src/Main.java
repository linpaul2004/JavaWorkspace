
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	static final int rowSize = 10;
	static final int colSize = 20;
	static int[][][] player = new int[2][rowSize][colSize];
	static JLabel[][][] lb = new JLabel[2][rowSize][colSize];
	static ImageIcon icon = new ImageIcon("t1.png");
	static ImageIcon icon1 = new ImageIcon("t.png");
	static int[][] x = new int[2][4];
	static int[][] y = new int[2][4];
	
	

	public static void main(String[] args) {
		int rand1;
		int rand2;
		Random ran = new Random();
		Move mov = new Move();
		Rotate rot = new Rotate();
		JFrame frame = new JFrame();
		frame.setSize(1000, 870);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(mov);
		frame.addKeyListener(rot);

		frame.setLayout(null);
		for(int i=0; i<2; i++){
			for(int j=0; j<10; j++){
				for(int k=0; k<20; k++){
					player[i][j][k]=0;
				}
			}
		}

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				lb[0][i][j] = new JLabel();
				lb[0][i][j].setIcon(icon);
				lb[0][i][j].setLocation(41 * (i + 1), 41 * (j ));
				lb[0][i][j].setSize(40, 40);
				
				lb[1][i][j] = new JLabel();
				lb[1][i][j].setIcon(icon);
				lb[1][i][j].setLocation(41 * (i + 1)+500, 41 * (j ));
				lb[1][i][j].setSize(40, 40);
				
				frame.add(lb[0][i][j]);
				frame.add(lb[1][i][j]);
			}
		}
		

		frame.setVisible(true);

				rand1 = ran.nextInt(7) + 1;
				rand2 = ran.nextInt(7) + 1;
				Tetris t1 = null;
				Tetris t2 = null;
				Tetris t3 = null;
				Tetris t4 = null;
				
				switch(rand1){
				case 1:
					t1 = new TShape(0);
					break;
				case 2:
					t1 = new Square(0);
					break;
				case 3:
					t1 = new Line(0);
					break;
				case 4:
					t1 = new LeftL(0);
					break;
				case 5:
					t1 = new LeftZ(0);
					break;
				case 6:
					t1 = new RightL(0);
					break;
				case 7:
					t1 = new RightZ(0);
					break;
				}
				
				
				switch(rand2){
				case 1:
					t2 = new TShape(1);
					break;
				case 2:
					t2 = new Square(1);
					break;
				case 3:
					t2 = new Line(1);
					break;
				case 4:
					t2 = new LeftL(1);
					break;
				case 5:
					t2 = new LeftZ(1);
					break;
				case 6:
					t2 = new RightL(1);
					break;
				case 7:
					t2 = new RightZ(1);
					break;
				}
				
				Tetris.fall();
				
		////////////////////////////////////////////////////////////////////////		
			while(true){
				
				
				if(Tetris.fall() == 0){
					Rotate.rotation1 = 0;
					rand1 = ran.nextInt(7) + 1; 
					
					switch(rand1){
					case 1:
						t3 = new TShape(0);
						break;
					case 2:
						t3 = new Square(0);
						break;
					case 3:
						t3 = new Line(0);
						break;
					case 4:
						t3 = new LeftL(0);
						break;
					case 5:
						t3 = new LeftZ(0);
						break;
					case 6:
						t3 = new RightL(0);
						break;
					case 7:
						t3 = new RightZ(0);
						break;
					}
					
					Tetris.fall();
				}else{

					
					rand2 = ran.nextInt(7) + 1; 					
					Rotate.rotation2 = 0;
					switch(rand2){
					case 1:
						t4 = new TShape(1);
						break;
					case 2:
						t4 = new Square(1);
						break;
					case 3:
						t4 = new Line(1);
						break;
					case 4:
						t4 = new LeftL(1);
						break;
					case 5:
						t4 = new LeftZ(1);
						break;
					case 6:
						t4 = new RightL(1);
						break;
					case 7:
						t4 = new RightZ(1);
						break;
					}
					
					Tetris.fall();
				}
			}
				

	}
	

	public static void setIcon(int num) {
	
			for (int i = 0; i < rowSize; i++) {
				for (int j = 0; j < colSize; j++) {
					if (player[num][i][j] == 1) {
						lb[num][i][j].setIcon(icon1);
					}

					if (player[num][i][j] == 0) {
						lb[num][i][j].setIcon(icon);
					}
				}

			}
	}

	public static void clear() {
		boolean needClear;
		for (int i = Main.colSize - 1; i >= 0; i--) {
			needClear = true;
			for (int j = 0; j < Main.rowSize; j++) {
				if (Main.player[0][j][i] == 0) {
					needClear = false;
					break;
				}
			}
			if (needClear) {
				for (int ii = i; ii >= 1; ii--) {
					for (int jj = 0; jj < Main.rowSize; jj++) {
						Main.player[0][jj][ii] = Main.player[0][jj][ii - 1];
					}
				}
				i++;
			}
		}
	}
	
	public static void map(int num){
		player[num][Main.x[num][0]][Main.y[num][0]] = 1;
		player[num][Main.x[num][1]][Main.y[num][1]] = 1;
		player[num][Main.x[num][2]][Main.y[num][2]] = 1;
		player[num][Main.x[num][3]][Main.y[num][3]] = 1;
		
	}
	
	public static void demap(int num){
		player[num][Main.x[num][0]][Main.y[num][0]] = 0;
		player[num][Main.x[num][1]][Main.y[num][1]] = 0;
		player[num][Main.x[num][2]][Main.y[num][2]] = 0;
		player[num][Main.x[num][3]][Main.y[num][3]] = 0;
		
		
	}

}
