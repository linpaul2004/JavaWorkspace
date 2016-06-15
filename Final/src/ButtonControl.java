import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

//import javax.swing.JOptionPane;

public class ButtonControl implements ActionListener {
	long tempbefore;
	long tempnow;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Battle")) {
			Main.mod = "battle";
		} else if (e.getActionCommand().equals("Single")) {
			Main.mod = "single";
		} else if (e.getActionCommand().equals("Start")) {
			Main.startSignal = true;
			Main.loser = -1;
			Main.pause = false;
			Main.frame.gameStart.setText("Abort");
			Main.frame.gameStart.setSize(Main.frame.gameStart.getPreferredSize());
			Main.frame.pause.setText("Pause");
			Main.frame.pause.setSize(Main.frame.pause.getPreferredSize());
		} else if (e.getActionCommand().equals("Rank")) {
			// JOptionPane.showMessageDialog(null, Main.setHighScore);
			HighScore.readScore();
			Main.highscore.setLocationRelativeTo(Main.frame);
			Main.highscore.setVisible(true);
		}else if(e.getActionCommand().equals("Classic")){
			Main.mod = "classic";
		}else if(e.getActionCommand().equals("Challenge")){
			Main.mod = "challenge";
		}else if(e.getActionCommand().equals("Time")){
			Main.mod = "timeMode";
		}else if (e.getActionCommand().equals("Clean")) {
			HighScore.clean();
		} else if (e.getActionCommand().equals("Abort")) {
			try {
				Robot robot = new Robot();
				if (Main.mod.equals("battle")) {
					robot.keyPress(KeyEvent.VK_ENTER);
				}
				robot.keyPress(KeyEvent.VK_SPACE);
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Main.startSignal = false;
			Main.loser = -2;
			Main.frame.gameStart.setText("Start");
			Main.frame.gameStart.setSize(Main.frame.gameStart.getPreferredSize());
		} else if (e.getActionCommand().equals("Close")) {
			Main.highscore.setVisible(false);
		} else if (e.getActionCommand().equals("Pause") || e.getActionCommand().equals("Continue")) {
			if(e.getActionCommand().equals("Pause")){
				tempbefore = System.currentTimeMillis();
			}
			if(e.getActionCommand().equals("Continue")){
				tempnow = System.currentTimeMillis();
				Main.pauseTime += tempnow - tempbefore;
			}
			if (Main.frame.gameStart.getText().equals("Abort")) {
				Main.pause = Main.pause ? false : true;
				Main.frame.pause.setText(Main.frame.pause.getText().equals("Pause") ? "Continue" : "Pause");
				Main.frame.pause.setSize(Main.frame.pause.getPreferredSize());
			}
		}
	}

}
