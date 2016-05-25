

public class Line extends Tetris {
	Line(){
	Main.x[0]=3;Main.x[1]=4;Main.x[2]=5;Main.x[3]=6;
	Main.y[0]=0;Main.y[1]=0;Main.y[2]=0;Main.y[3]=0;
	
	Main.player[Main.x[0]][Main.y[0]] = 1;
	Main.player[Main.x[1]][Main.y[1]] = 1;
	Main.player[Main.x[2]][Main.y[2]] = 1;
	Main.player[Main.x[3]][Main.y[3]] = 1;
	}
	
	public boolean rotation(int count){
		
		switch(count%2){
		case 1:
			if(Main.y[1]+2 > Main.colSize-1) return false;
			if(Main.y[1]-1 < 0			   ) return false;
			if(Main.player[Main.x[1]][Main.y[1]+2] == 1 ) return false;
			if(Main.player[Main.x[1]][Main.y[1]+1] == 1 ) return false;
			if(Main.player[Main.x[1]][Main.y[1]-1] == 1 ) return false;
			/////////////////////////////////////////////////
			Main.player[Main.x[0]][Main.y[0]] = 0;
			Main.player[Main.x[1]][Main.y[1]] = 0;
			Main.player[Main.x[2]][Main.y[2]] = 0;
			Main.player[Main.x[3]][Main.y[3]] = 0;
			Main.x[0]= Main.x[1];
			//Main.x[1]
			Main.x[2]= Main.x[1];
			Main.x[3]= Main.x[1];
			Main.y[0]= Main.y[1]-1;
			//Main.y[1]
			Main.y[2]= Main.y[1]+1;
			Main.y[3]= Main.y[1]+2;
			Main.player[Main.x[0]][Main.y[0]] = 1;
			Main.player[Main.x[1]][Main.y[1]] = 1;
			Main.player[Main.x[2]][Main.y[2]] = 1;
			Main.player[Main.x[3]][Main.y[3]] = 1;
			break;
		case 0:
			if(Main.x[1]+2 > Main.rowSize-1) return false;
			if(Main.x[1]-1 < 0			   ) return false;
			if(Main.player[Main.x[1]+2][Main.y[1]] == 1 ) return false;
			if(Main.player[Main.x[1]+1][Main.y[1]] == 1 ) return false;
			if(Main.player[Main.x[1]-1][Main.y[1]] == 1 ) return false;
			///////////////////////////////////////////////////
			Main.player[Main.x[0]][Main.y[0]] = 0;
			Main.player[Main.x[1]][Main.y[1]] = 0;
			Main.player[Main.x[2]][Main.y[2]] = 0;
			Main.player[Main.x[3]][Main.y[3]] = 0;
			Main.x[0]= Main.x[1]-1;
			//Main.x[1]
			Main.x[2]= Main.x[1]+1;
			Main.x[3]= Main.x[1]+2;
			Main.y[0]= Main.y[1];
			//Main.y[1]
			Main.y[2]= Main.y[1];
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