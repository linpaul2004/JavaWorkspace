import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.JOptionPane;

public class ButtonControl implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Battle")) {
			Main.mod = "battle";
		}
		
		if (e.getActionCommand().equals("Single")) {
			Main.mod = "single";
		}
		
		if (e.getActionCommand().equals("Start")) {
			Main.startSignal = true;
		}
		
		if (e.getActionCommand().equals("Rank")) {
			//JOptionPane.showMessageDialog(null, Main.setHighScore);
			System.out.println("rank");
		}
	}

}
