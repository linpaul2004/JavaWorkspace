
public class RightL extends Tetris{
	RightL(int num){
		
		Main.x[num][0]=6;Main.x[num][1]=4;Main.x[num][2]=5;Main.x[num][3]=6;
		Main.y[num][0]=0;Main.y[num][1]=1;Main.y[num][2]=1;Main.y[num][3]=1;
		
		Main.map(num);
	}
	
	RightL(){
		
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
		switch(count%4){
		case 1:
			tempX0 = Main.x[num][0];
			tempX1 = Main.x[num][1];
			tempX2 = Main.x[num][2];
			tempX3 = Main.x[num][3];
			tempY0 = Main.y[num][0];
			tempY1 = Main.y[num][1];
			tempY2 = Main.y[num][2];
			tempY3 = Main.y[num][3];
			if(tempY0-1<0) return false;
			if(Main.player[num][tempX0-1][tempY0-1] == 1 ) return false;
			if(Main.player[num][tempX0-1][tempY0] == 1 ) return false;
			/////////////////////////////////////////////////
			Main.demap(num);
			
			Main.x[num][0]= tempX0-1;
			Main.x[num][1]= tempX1+1;
			Main.x[num][2]= tempX2;
			Main.x[num][3]= tempX3;
			
			Main.y[num][0]= tempY0-1;
			Main.y[num][1]= tempY1-1;
			Main.y[num][2]= tempY2;
			Main.y[num][3]= tempY3;
			
			Main.map(num);
			Main.setIcon(num);
			break;
		case 2:
			tempX0 = Main.x[num][0];
			tempX1 = Main.x[num][1];
			tempX2 = Main.x[num][2];
			tempX3 = Main.x[num][3];
			tempY0 = Main.y[num][0];
			tempY1 = Main.y[num][1];
			tempY2 = Main.y[num][2];
			tempY3 = Main.y[num][3];
			if(tempX2-1<0) return false;
			if(Main.player[num][tempX1-1][tempY1] == 1 ) return false;
			if(Main.player[num][tempX1+1][tempY1] == 1 ) return false;
			if(Main.player[num][tempX1-1][tempY1+1] == 1 ) return false;
			///////////////////////////////////////////////////
			Main.demap(num);
			
			Main.x[num][0]= tempX0-1;
			Main.x[num][1]= tempX1;
			Main.x[num][2]= tempX2+1;
			Main.x[num][3]= tempX3-2;
			
			Main.y[num][0]= tempY0+1;
			Main.y[num][1]= tempY1;
			Main.y[num][2]= tempY2-1;
			Main.y[num][3]= tempY3;
			
			
			Main.map(num);
			Main.setIcon(num);
			break;
			
		case 3:
			tempX0 = Main.x[num][0];
			tempX1 = Main.x[num][1];
			tempX2 = Main.x[num][2];
			tempX3 = Main.x[num][3];
			tempY0 = Main.y[num][0];
			tempY1 = Main.y[num][1];
			tempY2 = Main.y[num][2];
			tempY3 = Main.y[num][3];
			if(tempY1-1<0) return false;
			if(Main.player[num][tempX1-1][tempY1-1] == 1 ) return false;
			if(Main.player[num][tempX1][tempY1-1] == 1 ) return false;
			if(Main.player[num][tempX1][tempY1+1] == 1 ) return false;
			///////////////////////////////////////////////////
			Main.demap(num);
			
			Main.x[num][0]= tempX0;
			Main.x[num][1]= tempX1;
			Main.x[num][2]= tempX2-1;
			Main.x[num][3]= tempX3+1;
			
			Main.y[num][0]= tempY0-1;
			Main.y[num][1]= tempY1-1;
			Main.y[num][2]= tempY2;
			Main.y[num][3]= tempY3;
			
			
			Main.map(num);
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
			if(tempX1+1>Main.rowSize-1) return false;
			if(Main.player[num][tempX1+1][tempY1] == 1 ) return false;
			if(Main.player[num][tempX1-1][tempY1+1] == 1 ) return false;
			if(Main.player[num][tempX1+1][tempY1+1] == 1 ) return false;
			///////////////////////////////////////////////////
			Main.demap(num);
			
			Main.x[num][0]= tempX0+2;
			Main.x[num][1]= tempX1-1;
			Main.x[num][2]= tempX2;
			Main.x[num][3]= tempX3+1;
			
			Main.y[num][0]= tempY0;
			Main.y[num][1]= tempY1+1;
			Main.y[num][2]= tempY2;
			Main.y[num][3]= tempY3-1;
			
			
			Main.map(num);
			Main.setIcon(num);
			break;
		
		}
		return true;
	}
}
