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
			int tmp = Main.y[0][0];
            int stbrick1=0;
			for (int i = 0; i < 4; i++) {
				if (Main.y[0][i] > tmp) {
					tmp = Main.y[0][i];
                    stbrick1=Main.x[0][i];
				}
			}
			int miny = 0;
			int stbrick2=0;
			int stoppos = Main.colSize - 1;
			boolean downtobottom = false;

			for (int i = 0; i < 4; i++) {
				for (int j = tmp + 1; j < Main.colSize; j++) {
					if (Main.player[0][Main.x[0][i]][j] == 1) {
						downtobottom = false;
						miny = j -1;
						break;
					}
					downtobottom = true;
				}
				if (downtobottom) {
					continue;
				}
				if (miny < stoppos) {
				  stbrick2=Main.x[0][i];
				  stoppos = miny;
				}			
			}           

			if(stbrick1!=stbrick2){
				for(int i=0;i<4;i++){
				 if(Main.x[0][i]==stbrick2 ){
					if(Main.y[0][i]==tmp)break;	
					else{ 
					 tmp=Main.y[0][i];
					}
				 }
				}
			}        		

			Main.demap(0);         
			for (int i = 0; i < 4; i++) {
				Main.y[0][i] += stoppos - tmp;
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

		    tmp = Main.y[1][0];
            stbrick1=0;
			for (int i = 0; i < 4; i++) {
				if (Main.y[1][i] > tmp) {
					tmp = Main.y[1][i];
                    stbrick1=Main.x[1][i];
				}
			}

			miny = 0;
			stbrick2=0;
			stoppos = Main.colSize - 1;
			downtobottom = false;	

			for (int i = 0; i < 4; i++) {
				for (int j = tmp + 1; j < Main.colSize; j++) {
					if (Main.player[1][Main.x[1][i]][j] == 1) {
						downtobottom = false;
						miny = j -1;
						break;
					}
					downtobottom = true;
				}
				if (downtobottom) {
					continue;
				}
				if (miny < stoppos) {
				  stbrick2=Main.x[1][i];
				  stoppos = miny;
				}
			
			}            

			if(stbrick1!=stbrick2){
				for(int i=0;i<4;i++){
				 if(Main.x[1][i]==stbrick2 ){
					if(Main.y[1][i]==tmp)break;	
					else{ 
					 tmp=Main.y[1][i];
					}
				 }
				}
			}        		

			Main.demap(1);         
			for (int i = 0; i < 4; i++) {
				Main.y[1][i] += stoppos - tmp;
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
