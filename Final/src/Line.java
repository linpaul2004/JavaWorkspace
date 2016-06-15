

public class Line extends Tetris {
	Line(int num){
		
	Main.x[num][0]=3;Main.x[num][1]=4;Main.x[num][2]=5;Main.x[num][3]=6;
	Main.y[num][0]=0;Main.y[num][1]=0;Main.y[num][2]=0;Main.y[num][3]=0;
	
	Main.map(num,3);
	}
	
	Line(){
		
	}
	
	public boolean rotation(int count,int num){
		
		switch(count%2){
		case 1:
			if(Main.y[num][1]+2 > Main.colSize-1) return false;
			if(Main.y[num][1]-1 < 0			   ) return false;
			if(Main.player[num][Main.x[num][1]][Main.y[num][1]+2] > 0 ) return false;
			if(Main.player[num][Main.x[num][1]][Main.y[num][1]+1] > 0 ) return false;
			if(Main.player[num][Main.x[num][1]][Main.y[num][1]-1] > 0 ) return false;
			/////////////////////////////////////////////////
			Main.demap(num);
			
			Main.x[num][0]= Main.x[num][1];
			//Main.x[1]
			Main.x[num][2]= Main.x[num][1];
			Main.x[num][3]= Main.x[num][1];
			Main.y[num][0]= Main.y[num][1]-1;
			//Main.y[1]
			Main.y[num][2]= Main.y[num][1]+1;
			Main.y[num][3]= Main.y[num][1]+2;
			
			Main.map(num,3);
			Main.setIcon(num);
			break;
		case 0:
			if(Main.x[num][1]+2 > Main.rowSize-1) return false;
			if(Main.x[num][1]-1 < 0			   ) return false;
			if(Main.player[num][Main.x[num][1]+2][Main.y[num][1]] > 0 ) return false;
			if(Main.player[num][Main.x[num][1]+1][Main.y[num][1]] > 0 ) return false;
			if(Main.player[num][Main.x[num][1]-1][Main.y[num][1]] > 0 ) return false;
			///////////////////////////////////////////////////
			Main.demap(num);
			
			Main.x[num][0]= Main.x[num][1]-1;
			//Main.x[1]
			Main.x[num][2]= Main.x[num][1]+1;
			Main.x[num][3]= Main.x[num][1]+2;
			Main.y[num][0]= Main.y[num][1];
			//Main.y[1]
			Main.y[num][2]= Main.y[num][1];
			Main.y[num][3]= Main.y[num][1];
			
			Main.map(num,3);
			Main.setIcon(num);
			break;
		
		}
		return true;
	}
	
	
}