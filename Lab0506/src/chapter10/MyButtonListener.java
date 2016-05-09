package chapter10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButtonListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("+")) {
			System.out.println("You pressed menuitem2");
		} else if (command.equals("-")) {
			System.out.println("You pressed menuitem2");
		} else {
			System.out.println(e.getActionCommand());
			System.out.println(e.getSource());
		}
	}
}