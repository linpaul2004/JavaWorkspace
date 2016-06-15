
public class TShape extends Tetris{
	TShape(int num){
	Main.x[num][0]=4;Main.x[num][1]=4;Main.x[num][2]=4;Main.x[num][3]=5;
	Main.y[num][0]=0;Main.y[num][1]=1;Main.y[num][2]=2;Main.y[num][3]=1;
	
	Main.map(num,1);
	
	
	}
	
	TShape(){
		
	}
	
	public boolean rotation(int count,int num){
		
		switch(count%4){
		case 1:
			if(Main.x[num][1]-1 < 0) return false;
			if(Main.x[num][1]+1 > Main.rowSize-1) return false;
			if(Main.y[num][1]-1 < 0) return false;
			if(Main.y[num][1]+1 > Main.colSize-1) return false;
			if(Main.player[num][Main.x[num][1]-1][Main.y[num][1]  ] > 0 ) return false;
			/////////////////////////////////////////////////
			Main.demap(num);
			
			Main.x[num][0]= Main.x[num][1]-1;
			Main.x[num][1]= Main.x[num][1];
			Main.x[num][2]= Main.x[num][1]+1;
			Main.x[num][3]= Main.x[num][1];
			
			Main.y[num][0]= Main.y[num][1];
			Main.y[num][1]= Main.y[num][1];
			Main.y[num][2]= Main.y[num][1];
			Main.y[num][3]= Main.y[num][1]+1;
			
			Main.map(num,1);
			Main.setIcon(num);
			break;
			
		case 2:
			if(Main.x[num][1]-1 < 0) return false;
			if(Main.x[num][1]+1 > Main.rowSize-1) return false;
			if(Main.y[num][1]-1 < 0) return false;
			if(Main.y[num][1]+1 > Main.colSize-1) return false;
			if(Main.player[num][Main.x[num][1]][Main.y[num][1]-1 ] > 0 ) return false;
			///////////////////////////////////////////////////
			Main.demap(num);
			
			Main.x[num][0]= Main.x[num][1]-1;
			Main.x[num][1]= Main.x[num][1];
			Main.x[num][2]= Main.x[num][1];
			Main.x[num][3]= Main.x[num][1];
			
			Main.y[num][0]= Main.y[num][1];
			Main.y[num][1]= Main.y[num][1];
			Main.y[num][2]= Main.y[num][1]-1;
			Main.y[num][3]= Main.y[num][1]+1;
			
			Main.map(num,1);
			Main.setIcon(num);
			break;
		case 3:
			if(Main.x[num][1]-1 < 0) return false;
			if(Main.x[num][1]+1 > Main.rowSize-1) return false;
			if(Main.y[num][1]-1 < 0) return false;
			if(Main.y[num][1]+1 > Main.colSize-1) return false;
			if(Main.player[num][Main.x[num][1]+1][Main.y[num][1]  ] > 0 ) return false;
			///////////////////////////////////////////////////
			Main.demap(num);
			
			Main.x[num][0]= Main.x[num][1]-1;
			Main.x[num][1]= Main.x[num][1];
			Main.x[num][2]= Main.x[num][1];
			Main.x[num][3]= Main.x[num][1]+1;
			
			Main.y[num][0]= Main.y[num][1];
			Main.y[num][1]= Main.y[num][1];
			Main.y[num][2]= Main.y[num][1]-1;
			Main.y[num][3]= Main.y[num][1];
			
			Main.map(num,1);
			Main.setIcon(num);
			break;
		case 0:
			if(Main.x[num][1]-1 < 0) return false;
			if(Main.x[num][1]+1 > Main.rowSize-1) return false;
			if(Main.y[num][1]-1 < 0) return false;
			if(Main.y[num][1]+1 > Main.colSize-1) return false;
			if(Main.player[num][Main.x[num][1]][Main.y[num][1]+1] > 0 ) return false;
			///////////////////////////////////////////////////
			Main.demap(num);
			
			Main.x[num][0]= Main.x[num][1];
			Main.x[num][1]= Main.x[num][1];
			Main.x[num][2]= Main.x[num][1];
			Main.x[num][3]= Main.x[num][1]+1;
			
			Main.y[num][0]= Main.y[num][1]-1;
			Main.y[num][1]= Main.y[num][1];
			Main.y[num][2]= Main.y[num][1]+1;
			Main.y[num][3]= Main.y[num][1];
			
			Main.map(num,1);
			Main.setIcon(num);
			break;
		
		}
		return true;
	}
}
