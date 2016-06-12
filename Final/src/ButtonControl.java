import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonControl implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Start Game")) {
			Main.start = true;
		}
	}

}
