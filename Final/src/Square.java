
public class Square extends Tetris{
	Square(){
	Main.x[0]=4;Main.x[1]=4;Main.x[2]=5;Main.x[3]=5;
	Main.y[0]=0;Main.y[1]=1;Main.y[2]=0;Main.y[3]=1;
	
	Main.player[Main.x[0]][Main.y[0]] = 1;
	Main.player[Main.x[1]][Main.y[1]] = 1;
	Main.player[Main.x[2]][Main.y[2]] = 1;
	Main.player[Main.x[3]][Main.y[3]] = 1;
	}
	
	public boolean rotation(int count){return true;}
}