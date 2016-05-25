import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class Tetris implements KeyListener{
	static int speed = 1;
	int rotationCount = 0;
	public abstract boolean rotation(int count);
	public void keyPressed(KeyEvent e){
		int key1 = e.getKeyCode();
		if(key1 == KeyEvent.VK_UP){
			rotationCount++;
			if(rotation(rotationCount) == false) rotationCount--;
		}
	}
	public void keyReleased(KeyEvent e) {} 
    public void keyTyped(KeyEvent e) {}
	public void fall(){
		while(true){
			Block blk = new Block(); 
			if(blk.bottomBlock() == true) break;
			if(blk.fallBlock() == true) break;
			
			/////////////////////////////////
			Main.player[Main.x[0]][Main.y[0]] = 0;
			Main.player[Main.x[1]][Main.y[1]] = 0;
			Main.player[Main.x[2]][Main.y[2]] = 0;
			Main.player[Main.x[3]][Main.y[3]] = 0;
		
			
			Main.player[Main.x[0]][Main.y[0]+1] = 1;
			Main.player[Main.x[1]][Main.y[1]+1] = 1;
			Main.player[Main.x[2]][Main.y[2]+1] = 1;
			Main.player[Main.x[3]][Main.y[3]+1] = 1;
			
			Main.y[0]++;
			Main.y[1]++;
			Main.y[2]++;
			Main.y[3]++;
			Main.setIcon();
			
			try{
				Thread.sleep(500/speed);
			}catch(Exception e){
				e.printStackTrace();
			}
		
		}
	}
}
