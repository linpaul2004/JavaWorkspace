
public class TShape extends Tetris{
	TShape(){
	Main.x[0]=4;Main.x[1]=4;Main.x[2]=4;Main.x[3]=5;
	Main.y[0]=0;Main.y[1]=1;Main.y[2]=2;Main.y[3]=1;
	
	Main.player[Main.x[0]][Main.y[0]] = 1;
	Main.player[Main.x[1]][Main.y[1]] = 1;
	Main.player[Main.x[2]][Main.y[2]] = 1;
	Main.player[Main.x[3]][Main.y[3]] = 1;
	
	}
	
	public boolean rotation(int count){
		switch(count%4){
		case 1:
			if(Main.x[1]-1 < 0) return false;
			if(Main.x[1]+1 > Main.rowSize-1) return false;
			if(Main.y[1]-1 < 0) return false;
			if(Main.y[1]+1 > Main.colSize-1) return false;
			if(Main.player[Main.x[1]-1][Main.y[1]  ] == 1 ) return false;
			/////////////////////////////////////////////////
			Main.player[Main.x[0]][Main.y[0]] = 0;
			Main.player[Main.x[1]][Main.y[1]] = 0;
			Main.player[Main.x[2]][Main.y[2]] = 0;
			Main.player[Main.x[3]][Main.y[3]] = 0;
			
			Main.x[0]= Main.x[1]-1;
			Main.x[2]= Main.x[1]+1;
			Main.x[3]= Main.x[1];
			
			Main.y[0]= Main.y[1];
			Main.y[2]= Main.y[1];
			Main.y[3]= Main.y[1]+1;
			
			Main.player[Main.x[0]][Main.y[0]] = 1;
			Main.player[Main.x[1]][Main.y[1]] = 1;
			Main.player[Main.x[2]][Main.y[2]] = 1;
			Main.player[Main.x[3]][Main.y[3]] = 1;
			break;
			
		case 2:
			if(Main.x[1]-1 < 0) return false;
			if(Main.x[1]+1 > Main.rowSize-1) return false;
			if(Main.y[1]-1 < 0) return false;
			if(Main.y[1]+1 > Main.colSize-1) return false;
			if(Main.player[Main.x[1]][Main.y[1]-1 ] == 1 ) return false;
			///////////////////////////////////////////////////
			Main.player[Main.x[0]][Main.y[0]] = 0;
			Main.player[Main.x[1]][Main.y[1]] = 0;
			Main.player[Main.x[2]][Main.y[2]] = 0;
			Main.player[Main.x[3]][Main.y[3]] = 0;
			
			Main.x[0]= Main.x[1]-1;
			Main.x[2]= Main.x[1];
			Main.x[3]= Main.x[1];
			
			Main.y[0]= Main.y[1];
			Main.y[2]= Main.y[1]-1;
			Main.y[3]= Main.y[1]+1;
			
			Main.player[Main.x[0]][Main.y[0]] = 1;
			Main.player[Main.x[1]][Main.y[1]] = 1;
			Main.player[Main.x[2]][Main.y[2]] = 1;
			Main.player[Main.x[3]][Main.y[3]] = 1;
			break;
		case 3:
			if(Main.x[1]-1 < 0) return false;
			if(Main.x[1]+1 > Main.rowSize-1) return false;
			if(Main.y[1]-1 < 0) return false;
			if(Main.y[1]+1 > Main.colSize-1) return false;
			if(Main.player[Main.x[1]+1][Main.y[1]  ] == 1 ) return false;
			///////////////////////////////////////////////////
			Main.player[Main.x[0]][Main.y[0]] = 0;
			Main.player[Main.x[1]][Main.y[1]] = 0;
			Main.player[Main.x[2]][Main.y[2]] = 0;
			Main.player[Main.x[3]][Main.y[3]] = 0;
			
			Main.x[0]= Main.x[1]-1;
			Main.x[2]= Main.x[1];
			Main.x[3]= Main.x[1]+1;
			
			Main.y[0]= Main.y[1];
			Main.y[2]= Main.y[1]-1;
			Main.y[3]= Main.y[1];
			
			Main.player[Main.x[0]][Main.y[0]] = 1;
			Main.player[Main.x[1]][Main.y[1]] = 1;
			Main.player[Main.x[2]][Main.y[2]] = 1;
			Main.player[Main.x[3]][Main.y[3]] = 1;
			break;
		case 0:
			if(Main.x[1]-1 < 0) return false;
			if(Main.x[1]+1 > Main.rowSize-1) return false;
			if(Main.y[1]-1 < 0) return false;
			if(Main.y[1]+1 > Main.colSize-1) return false;
			if(Main.player[Main.x[1]][Main.y[1]+1] == 1 ) return false;
			///////////////////////////////////////////////////
			Main.player[Main.x[0]][Main.y[0]] = 0;
			Main.player[Main.x[1]][Main.y[1]] = 0;
			Main.player[Main.x[2]][Main.y[2]] = 0;
			Main.player[Main.x[3]][Main.y[3]] = 0;
			
			Main.x[0]= Main.x[1];
			Main.x[2]= Main.x[1];
			Main.x[3]= Main.x[1]+1;
			
			Main.y[0]= Main.y[1]-1;
			Main.y[2]= Main.y[1]+1;
			Main.y[3]= Main.y[1];
			
			Main.player[Main.x[0]][Main.y[0]] = 1;
			Main.player[Main.x[1]][Main.y[1]] = 1;
			Main.player[Main.x[2]][Main.y[2]] = 1;
			Main.player[Main.x[3]][Main.y[3]] = 1;
			break;
		
		}
		return true;
	}
}
