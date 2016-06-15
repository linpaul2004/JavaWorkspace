import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Rotate implements KeyListener{
	int rotation1 = 0;
	int rotation2 = 0;
	Tetris t1 = null;
	Tetris t2 = null;
	Block blk = new Block();
	public void keyPressed(KeyEvent e){
		int key1 = e.getKeyCode();
		if(key1 == KeyEvent.VK_UP){
			if (blk.bottomBlock(1)==true || blk.fallBlock(1) == true)  return;
			rotation2++;
			switch(Main.current2){
				case 1:
					t2 = new TShape();
					if(t2.rotation(rotation2, 1) == false) rotation2--;
					break;
				case 2:
					t2 = new Square();
					if(t2.rotation(rotation2, 1) == false) rotation2--;
					break;
				case 3:
					t2 = new Line();
					if(t2.rotation(rotation2, 1) == false) rotation2--;
					break;
				case 4:
					t2 = new LeftL();
					if(t2.rotation(rotation2, 1) == false) rotation2--;
					break;
				case 5:
					t2 = new LeftZ();
					if(t2.rotation(rotation2, 1) == false) rotation2--;
					break;
				case 6:
					t2 = new RightL();
					if(t2.rotation(rotation2, 1) == false) rotation2--;
					break;
				case 7:
					t2 = new RightZ();
					if(t2.rotation(rotation2, 1) == false) rotation2--;
					break;
			}
			
		}
		
		if(key1 == KeyEvent.VK_W){
			if (blk.bottomBlock(0)==true || blk.fallBlock(0) == true)  return;
			rotation1++;
			switch(Main.current1){
			case 1:
				t1 = new TShape();
				if(t1.rotation(rotation1, 0) == false) rotation1--;
				break;
			case 2:
				t1 = new Square();
				if(t1.rotation(rotation1, 0) == false) rotation1--;
				break;
			case 3:
				t1 = new Line();
				if(t1.rotation(rotation1, 0) == false) rotation1--;
				break;
			case 4:
				t1 = new LeftL();
				if(t1.rotation(rotation1, 0) == false) rotation1--;
				break;
			case 5:
				t1 = new LeftZ();
				if(t1.rotation(rotation1, 0) == false) rotation1--;
				break;
			case 6:
				t1 = new RightL();
				if(t1.rotation(rotation1, 0) == false) rotation1--;
				break;
			case 7:
				t1 = new RightZ();
				if(t1.rotation(rotation1, 0) == false) rotation1--;
				break;
			}
			
		}
		
	}
	
  public void keyReleased(KeyEvent e) {} 
  public void keyTyped(KeyEvent e) {}
}
