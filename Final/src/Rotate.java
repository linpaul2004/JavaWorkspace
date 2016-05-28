import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Rotate implements KeyListener{
	static int rotation1 = 0;
	static int rotation2 = 0;
	Tetris t1 = null;
	Tetris t2 = null;
	
	public void keyPressed(KeyEvent e){
		int key1 = e.getKeyCode();
		
		if(key1 == KeyEvent.VK_UP){
			rotation2++;
			if(isSquare(1) == true && rotation2 == 1){
				t2= new Square();
				}
			else if(isTShape(1) == true && rotation2 == 1){
				t2= new TShape();
				if(t2.rotation(rotation2, 1) == false) rotation2--;
				}
			else if(isLine(1) == true && rotation2 == 1){
				t2= new Line();
				if(t2.rotation(rotation2, 1) == false) rotation2--;
				}
			else if(isLeftL(1) == true && rotation2 == 1){
				t2= new LeftL();
				if(t2.rotation(rotation2, 1) == false) rotation2--;
				}
			else if(isLeftZ(1) == true && rotation2 == 1){
				t2= new LeftZ();
				if(t2.rotation(rotation2, 1) == false) rotation2--;
				}
			else if(isRightL(1) == true && rotation2 == 1){
				t2= new RightL();
				if(t2.rotation(rotation2, 1) == false) rotation2--;
				}
			else if(isRightZ(1) == true && rotation2 == 1){
				t2= new RightZ();
				if(t2.rotation(rotation2, 1) == false) rotation2--;
				}
			
			else if(t2.rotation(rotation2, 1) == false) rotation2--;
		}
		
		if(key1 == KeyEvent.VK_W){
			
			rotation1++;
			if(isSquare(0) == true && rotation1 == 1){
				t1= new Square();
				}
			else if(isTShape(0) == true && rotation1 == 1){
				t1= new TShape();
				if(t1.rotation(rotation1, 0) == false) rotation1--;
				}
			else if(isLine(0) == true && rotation1 == 1){
				t1= new Line();
				if(t1.rotation(rotation1, 0) == false) rotation1--;
				}
			else if(isLeftL(0) == true && rotation1 == 1){
				t1= new LeftL();
				if(t1.rotation(rotation1, 0) == false) rotation1--;
				}
			else if(isLeftZ(0) == true && rotation1 == 1){
				t1= new LeftZ();
				if(t1.rotation(rotation1, 0) == false) rotation1--;
				}
			else if(isRightL(0) == true && rotation1 == 1){
				t1= new RightL();
				if(t1.rotation(rotation1, 0) == false) rotation1--;
				}
			else if(isRightZ(0) == true && rotation1 == 1){
				t1= new RightZ();
				if(t1.rotation(rotation1, 0) == false) rotation1--;
				}
			
			else if(t1.rotation(rotation1, 0) == false) rotation1--;
		
			
		}
		
	}
	
  public void keyReleased(KeyEvent e) {} 
  public void keyTyped(KeyEvent e) {}
  
  public boolean isTShape(int num){
	    int tempX0 = Main.x[num][0];
		int tempX1 = Main.x[num][1];
		int tempX2 = Main.x[num][2];
		int tempX3 = Main.x[num][3];
		int tempY0 = Main.y[num][0];
		int tempY1 = Main.y[num][1];
		int tempY2 = Main.y[num][2];
		int tempY3 = Main.y[num][3];
		if(tempX1 == tempX0 && tempX2 == tempX0 && tempX3 == tempX0+1){
			if(tempY1 == tempY0+1 && tempY2 == tempY0+2 && tempY3 == tempY0+1){
				return true;
			}
		}
		
	  return false;
  }
  
  public boolean isSquare(int num){
	  	int tempX0 = Main.x[num][0];
	  	int tempX1 = Main.x[num][1];
		int tempX2 = Main.x[num][2];
		int tempX3 = Main.x[num][3];
		int tempY0 = Main.y[num][0];
		int tempY1 = Main.y[num][1];
		int tempY2 = Main.y[num][2];
		int tempY3 = Main.y[num][3];
		
		if(tempX1 == tempX0 && tempX2 == tempX0+1 && tempX3 == tempX0+1){
			if(tempY1 == tempY0+1 && tempY2 == tempY0 && tempY3 == tempY0+1){
				return true;
			}
		}
	  return false;
  }
 
  public boolean isLine(int num){
	  	int tempX0 = Main.x[num][0];
	  	int tempX1 = Main.x[num][1];
		int tempX2 = Main.x[num][2];
		int tempX3 = Main.x[num][3];
		int tempY0 = Main.y[num][0];
		int tempY1 = Main.y[num][1];
		int tempY2 = Main.y[num][2];
		int tempY3 = Main.y[num][3];
		if(tempX1 == tempX0+1 && tempX2 == tempX0+2 && tempX3 == tempX0+3){
			if(tempY1 == tempY0 && tempY2 == tempY0 && tempY3 == tempY0){
				return true;
			}
		}
	  return false;
  }
  
  public boolean isLeftL(int num){
	  	int tempX0 = Main.x[num][0];
	  	int tempX1 = Main.x[num][1];
		int tempX2 = Main.x[num][2];
		int tempX3 = Main.x[num][3];
		int tempY0 = Main.y[num][0];
		int tempY1 = Main.y[num][1];
		int tempY2 = Main.y[num][2];
		int tempY3 = Main.y[num][3];
		if(tempX1 == tempX0 && tempX2 == tempX0+1 && tempX3 == tempX0+2){
			if(tempY1 == tempY0+1 && tempY2 == tempY0+1 && tempY3 == tempY0+1){
				return true;
			}
		}
	  return false;
  }
  
  public boolean isLeftZ(int num){
	  	int tempX0 = Main.x[num][0];
	  	int tempX1 = Main.x[num][1];
		int tempX2 = Main.x[num][2];
		int tempX3 = Main.x[num][3];
		int tempY0 = Main.y[num][0];
		int tempY1 = Main.y[num][1];
		int tempY2 = Main.y[num][2];
		int tempY3 = Main.y[num][3];
		if(tempX1 == tempX0+1 && tempX2 == tempX0+1 && tempX3 == tempX0+2){
			if(tempY1 == tempY0 && tempY2 == tempY0+1 && tempY3 == tempY0+1){
				return true;
			}
		}
	  return false;
  }
  
  public boolean isRightL(int num){
	  	int tempX0 = Main.x[num][0];
	  	int tempX1 = Main.x[num][1];
		int tempX2 = Main.x[num][2];
		int tempX3 = Main.x[num][3];
		int tempY0 = Main.y[num][0];
		int tempY1 = Main.y[num][1];
		int tempY2 = Main.y[num][2];
		int tempY3 = Main.y[num][3];
		if(tempX1 == tempX0-2 && tempX2 == tempX0-1 && tempX3 == tempX0){
			if(tempY1 == tempY0+1 && tempY2 == tempY0+1 && tempY3 == tempY0+1){
				return true;
			}
		}
	  return false;
  }
  
  public boolean isRightZ(int num){
	  	int tempX0 = Main.x[num][0];
	  	int tempX1 = Main.x[num][1];
		int tempX2 = Main.x[num][2];
		int tempX3 = Main.x[num][3];
		int tempY0 = Main.y[num][0];
		int tempY1 = Main.y[num][1];
		int tempY2 = Main.y[num][2];
		int tempY3 = Main.y[num][3];
		if(tempX1 == tempX0+1 && tempX2 == tempX0-1 && tempX3 == tempX0){
			if(tempY1 == tempY0 && tempY2 == tempY0+1 && tempY3 == tempY0+1){
				return true;
			}
		}
	  return false;
  }
}