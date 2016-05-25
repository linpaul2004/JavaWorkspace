
public class LeftL extends Tetris{
	LeftL(){
	Main.x[0]=4;Main.x[1]=4;Main.x[2]=5;Main.x[3]=6;
	Main.y[0]=0;Main.y[1]=1;Main.y[2]=1;Main.y[3]=1;
	
	Main.player[Main.x[0]][Main.y[0]] = 1;
	Main.player[Main.x[1]][Main.y[1]] = 1;
	Main.player[Main.x[2]][Main.y[2]] = 1;
	Main.player[Main.x[3]][Main.y[3]] = 1;
	}
	
	public boolean rotation(int count){
		int tempX0 = Main.x[0];
		int tempX1 = Main.x[1];
		int tempX2 = Main.x[2];
		int tempX3 = Main.x[3];
		int tempY0 = Main.y[0];
		int tempY1 = Main.y[1];
		int tempY2 = Main.y[2];
		int tempY3 = Main.y[3];
		switch(count%4){
		case 1:
			tempX0 = Main.x[0];
			tempX1 = Main.x[1];
			tempX2 = Main.x[2];
			tempX3 = Main.x[3];
			tempY0 = Main.y[0];
			tempY1 = Main.y[1];
			tempY2 = Main.y[2];
			tempY3 = Main.y[3];
			if(tempY0-1<0) return false;
			if(Main.player[tempX0+1][tempY0-1] == 1 ) return false;
			if(Main.player[tempX0+2][tempY0-1] == 1 ) return false;
			if(Main.player[tempX0+1][tempY0] == 1 ) return false;
			/////////////////////////////////////////////////
			Main.player[Main.x[0]][Main.y[0]] = 0;
			Main.player[Main.x[1]][Main.y[1]] = 0;
			Main.player[Main.x[2]][Main.y[2]] = 0;
			Main.player[Main.x[3]][Main.y[3]] = 0;
			
			Main.x[0]= tempX0+1;
			Main.x[1]= tempX1+2;
			Main.x[2]= tempX2;
			Main.x[3]= tempX3-1;
			
			Main.y[0]= tempY0-1;
			Main.y[1]= tempY1-2;
			Main.y[2]= tempY2-1;
			Main.y[3]= tempY3;
			
			Main.player[Main.x[0]][Main.y[0]] = 1;
			Main.player[Main.x[1]][Main.y[1]] = 1;
			Main.player[Main.x[2]][Main.y[2]] = 1;
			Main.player[Main.x[3]][Main.y[3]] = 1;
			break;
		case 2:
			tempX0 = Main.x[0];
			tempX1 = Main.x[1];
			tempX2 = Main.x[2];
			tempX3 = Main.x[3];
			tempY0 = Main.y[0];
			tempY1 = Main.y[1];
			tempY2 = Main.y[2];
			tempY3 = Main.y[3];
			if(tempX2-1<0) return false;
			if(Main.player[tempX2-1][tempY2] == 1 ) return false;
			if(Main.player[tempX2+1][tempY2] == 1 ) return false;
			if(Main.player[tempX2+1][tempY2+1] == 1 ) return false;
			///////////////////////////////////////////////////
			Main.player[Main.x[0]][Main.y[0]] = 0;
			Main.player[Main.x[1]][Main.y[1]] = 0;
			Main.player[Main.x[2]][Main.y[2]] = 0;
			Main.player[Main.x[3]][Main.y[3]] = 0;
			
			Main.x[0]= tempX0-1;
			Main.x[1]= tempX1-1;
			Main.x[2]= tempX2+1;
			Main.x[3]= tempX3+1;
			
			Main.y[0]= tempY0+1;
			Main.y[1]= tempY1+1;
			Main.y[2]= tempY2;
			Main.y[3]= tempY3;
			
			
			Main.player[Main.x[0]][Main.y[0]] = 1;
			Main.player[Main.x[1]][Main.y[1]] = 1;
			Main.player[Main.x[2]][Main.y[2]] = 1;
			Main.player[Main.x[3]][Main.y[3]] = 1;
			break;
			
		case 3:
			tempX0 = Main.x[0];
			tempX1 = Main.x[1];
			tempX2 = Main.x[2];
			tempX3 = Main.x[3];
			tempY0 = Main.y[0];
			tempY1 = Main.y[1];
			tempY2 = Main.y[2];
			tempY3 = Main.y[3];
			if(tempY1-1<0) return false;
			if(Main.player[tempX1][tempY1-1] == 1 ) return false;
			if(Main.player[tempX1][tempY1+1] == 1 ) return false;
			if(Main.player[tempX1-1][tempY1+1] == 1 ) return false;
			///////////////////////////////////////////////////
			Main.player[Main.x[0]][Main.y[0]] = 0;
			Main.player[Main.x[1]][Main.y[1]] = 0;
			Main.player[Main.x[2]][Main.y[2]] = 0;
			Main.player[Main.x[3]][Main.y[3]] = 0;
			
			Main.x[0]= tempX0+1;
			Main.x[1]= tempX1;
			Main.x[2]= tempX2-1;
			Main.x[3]= tempX3-2;
			
			Main.y[0]= tempY0-1;
			Main.y[1]= tempY1;
			Main.y[2]= tempY2+1;
			Main.y[3]= tempY3;
			
			
			Main.player[Main.x[0]][Main.y[0]] = 1;
			Main.player[Main.x[1]][Main.y[1]] = 1;
			Main.player[Main.x[2]][Main.y[2]] = 1;
			Main.player[Main.x[3]][Main.y[3]] = 1;
			break;
		case 0:
			tempX0 = Main.x[0];
			tempX1 = Main.x[1];
			tempX2 = Main.x[2];
			tempX3 = Main.x[3];
			tempY0 = Main.y[0];
			tempY1 = Main.y[1];
			tempY2 = Main.y[2];
			tempY3 = Main.y[3];
			if(tempX1+1>Main.rowSize-1) return false;
			if(Main.player[tempX1-1][tempY1-1] == 1 ) return false;
			if(Main.player[tempX1-1][tempY1] == 1 ) return false;
			if(Main.player[tempX1+1][tempY1] == 1 ) return false;
			///////////////////////////////////////////////////
			Main.player[Main.x[0]][Main.y[0]] = 0;
			Main.player[Main.x[1]][Main.y[1]] = 0;
			Main.player[Main.x[2]][Main.y[2]] = 0;
			Main.player[Main.x[3]][Main.y[3]] = 0;
			
			Main.x[0]= tempX0-1;
			Main.x[1]= tempX1-1;
			Main.x[2]= tempX2;
			Main.x[3]= tempX3+2;
			
			Main.y[0]= tempY0;
			Main.y[1]= tempY1;
			Main.y[2]= tempY2-1;
			Main.y[3]= tempY3-1;
			
			
			Main.player[Main.x[0]][Main.y[0]] = 1;
			Main.player[Main.x[1]][Main.y[1]] = 1;
			Main.player[Main.x[2]][Main.y[2]] = 1;
			Main.player[Main.x[3]][Main.y[3]] = 1;
			break;
		
		}
		return true;
	}
}
