import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Move implements KeyListener {

	public void keyPressed(KeyEvent e) {
		Block blk = new Block();
		//if (blk.bottomBlock() == true)
		//	return;
		//if (blk.fallBlock() == true)
		//	return;

		int key1 = e.getKeyCode();

		switch (key1) {
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		case KeyEvent.VK_A:
			if (blk.leftBlock(0) == true)
				break;

			if (Main.x[0][0] - 1 < 0)
				break;
			if (Main.x[0][1] - 1 < 0)
				break;
			if (Main.x[0][2] - 1 < 0)
				break;
			if (Main.x[0][3] - 1 < 0)
				break;

			Main.demap(0);

			for (int i = 0; i < 4; i++) {
				Main.x[0][i]--;
			}

			Main.map(0);
			Main.setIcon(0);

			break;
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		case KeyEvent.VK_D:
			if (blk.rightBlock(0) == true)
				break;

			if (Main.x[0][0] + 1 > Main.rowSize - 1)
				break;
			if (Main.x[0][1] + 1 > Main.rowSize - 1)
				break;
			if (Main.x[0][2] + 1 > Main.rowSize - 1)
				break;
			if (Main.x[0][3] + 1 > Main.rowSize - 1)
				break;

			Main.demap(0);

			for (int i = 0; i < 4; i++) {
				Main.x[0][i]++;
			}

			Main.map(0);
			Main.setIcon(0);

			break;

		////////////////////////////////////////////////////////////////////////////////////////////

		case KeyEvent.VK_SPACE:	  
			if(blk.fallBlock(0)){break;}
			int tmp=Main.colSize;
			boolean downtobottom=true;
			boolean findstop=false;
			int stx=-1;
			for (int i = 0; i < 4; i++) {
			  for(int j=Main.y[0][i]+1;j<Main.colSize;j++){				
				if (Main.x[0][i]!=stx && Main.player[0][ Main.x[0][i] ][ j ] == 0  ) {
			     findstop=true;
				 for(int k=j;k<Main.colSize;k++){
                   if (Main.player[0][ Main.x[0][i] ][ k ] == 1){
                	 if(tmp>k-j){
                	  tmp=k-j;
                	 }        
                	 stx=Main.x[0][i];
                	 downtobottom=false;
                	 j=Main.colSize+1; //to break from j
                	 break; //break from k
                   }//if==1,second search
                   downtobottom=true;                 
                  }//for k
				 if(downtobottom){
                    if(tmp> Main.colSize-Main.y[0][i]-1){tmp=Main.colSize-Main.y[0][i]-1;}
				 }
				}//if==0,first search
			   }//for j
			  if(!findstop){break;}
			}//for i

			Main.demap(0);         
			for (int i = 0; i < 4; i++) {
				Main.y[0][i] +=  tmp;
			}			
			Main.map(0);
			Main.setIcon(0);
			break;

		case KeyEvent.VK_S:
			Tetris.speed = 10;
			break;
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		case KeyEvent.VK_LEFT:
			if (blk.leftBlock(1) == true)
				break;

			if (Main.x[1][0] - 1 < 0)
				break;
			if (Main.x[1][1] - 1 < 0)
				break;
			if (Main.x[1][2] - 1 < 0)
				break;
			if (Main.x[1][3] - 1 < 0)
				break;

			Main.demap(1);

			for (int i = 0; i < 4; i++) {
				Main.x[1][i]--;
			}

			Main.map(1);
			Main.setIcon(1);

			break;
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		case KeyEvent.VK_RIGHT:
			if (blk.rightBlock(1) == true)
				break;

			if (Main.x[1][0] + 1 > Main.rowSize - 1)
				break;
			if (Main.x[1][1] + 1 > Main.rowSize - 1)
				break;
			if (Main.x[1][2] + 1 > Main.rowSize - 1)
				break;
			if (Main.x[1][3] + 1 > Main.rowSize - 1)
				break;

			Main.demap(1);

			for (int i = 0; i < 4; i++) {
				Main.x[1][i]++;
			}

			Main.map(1);
			Main.setIcon(1);

			break;

		/////////////////////////////////////////////////////////////////////
		case KeyEvent.VK_ENTER:
			if(blk.fallBlock(1)){break;}
			tmp=Main.colSize;
			downtobottom=true;
			findstop=false;
			stx=-1;
			for (int i = 0; i < 4; i++) {
			  for(int j=Main.y[1][i]+1;j<Main.colSize;j++){				
				if (Main.x[1][i]!=stx && Main.player[1][ Main.x[1][i] ][ j ] == 0  ) {
			     findstop=true;
				 for(int k=j;k<Main.colSize;k++){
                   if (Main.player[1][ Main.x[1][i] ][ k ] == 1){
                	 if(tmp>k-j){
                	  tmp=k-j;
                	 }        
                	 stx=Main.x[1][i];
                	 downtobottom=false;
                	 j=Main.colSize+1; //to break from j
                	 break; //break from k
                   }//if==1,second search
                   downtobottom=true;                 
                  }//for k
				 if(downtobottom){
                    if(tmp> Main.colSize-Main.y[1][i]-1){tmp=Main.colSize-Main.y[1][i]-1;}
				 }
				}//if==0,first search
			   }//for j
			  if(!findstop){break;}
			}//for i

			Main.demap(1);         
			for (int i = 0; i < 4; i++) {
				Main.y[1][i] +=  tmp;
			}			
			Main.map(1);
			Main.setIcon(1);
			break;
		    default:

		}
	}

	public void keyReleased(KeyEvent e) {
		Tetris.speed = 1;
	}

	public void keyTyped(KeyEvent e) {
	}

}
