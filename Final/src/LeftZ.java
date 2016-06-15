
public class LeftZ extends Tetris{
	LeftZ(int num){
		
	Main.x[num][0]=3;Main.x[num][1]=4;Main.x[num][2]=4;Main.x[num][3]=5;
	Main.y[num][0]=0;Main.y[num][1]=0;Main.y[num][2]=1;Main.y[num][3]=1;
	
	Main.map(num,5);
	}
	
	LeftZ(){
		
	}
	
	public boolean rotation(int count,int num){
		int tempX0 = Main.x[num][0];
		int tempX1 = Main.x[num][1];
		int tempX2 = Main.x[num][2];
		int tempX3 = Main.x[num][3];
		int tempY0 = Main.y[num][0];
		int tempY1 = Main.y[num][1];
		int tempY2 = Main.y[num][2];
		int tempY3 = Main.y[num][3];
		switch(count%2){
		case 1:
			tempX0 = Main.x[num][0];
			tempX1 = Main.x[num][1];
			tempX2 = Main.x[num][2];
			tempX3 = Main.x[num][3];
			tempY0 = Main.y[num][0];
			tempY1 = Main.y[num][1];
			tempY2 = Main.y[num][2];
			tempY3 = Main.y[num][3];
			if(tempY2+1>Main.colSize-1) return false;
			if(Main.player[num][tempX1+1][tempY1] > 0 ) return false;
			if(Main.player[num][tempX2][tempY2+1] > 0 ) return false;
			/////////////////////////////////////////////////
			Main.demap(num);
			
			Main.x[num][0]= tempX0+2;
			Main.x[num][1]= tempX1;
			Main.x[num][2]= tempX2+1;
			Main.x[num][3]= tempX3-1;
			
			Main.y[num][0]= tempY0;
			Main.y[num][1]= tempY1+1;
			Main.y[num][2]= tempY2;
			Main.y[num][3]= tempY3+1;
			
			Main.map(num,5);
			Main.setIcon(num);
			break;
		case 0:
			tempX0 = Main.x[num][0];
			tempX1 = Main.x[num][1];
			tempX2 = Main.x[num][2];
			tempX3 = Main.x[num][3];
			tempY0 = Main.y[num][0];
			tempY1 = Main.y[num][1];
			tempY2 = Main.y[num][2];
			tempY3 = Main.y[num][3];
			if(tempX1-1<0) return false;
			if(Main.player[num][tempX0-2][tempY0] > 0 ) return false;
			if(Main.player[num][tempX0-1][tempY0] > 0 ) return false;
			///////////////////////////////////////////////////
			Main.demap(num);
			
			Main.x[num][0]= tempX0-2;
			Main.x[num][1]= tempX1;
			Main.x[num][2]= tempX2-1;
			Main.x[num][3]= tempX3+1;
			
			Main.y[num][0]= tempY0;
			Main.y[num][1]= tempY1-1;
			Main.y[num][2]= tempY2;
			Main.y[num][3]= tempY3-1;
			
			
			Main.map(num,5);
			Main.setIcon(num);
			break;
		
		}
		return true;
	}
}