package chapter10;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn1 = new JButton("Click me!");
		JButton btn2 = new JButton("Click me!");
		JPanel panel = new JPanel();
		panel.setSize(200, 200);
		panel.setLayout(new GridLayout());
		panel.add(btn1);
		panel.add(btn2);
		frame.setLayout(null);
		frame.add(panel);
		frame.setVisible(true);
		int i = 0, j = 0, R = 1, D = 1;
		while (true) {
			panel.setLocation(i, j);
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (R == 1) {
				i++;
			} else {
				i--;
			}
			if (D == 1) {
				j++;
			} else {
				j--;
			}
			if (i >= 600 || i <= 0) {
				R *= (-1);
			}
			if (j >= 400 || j <= 0) {
				D *= (-1);
			}
		}
	}

}
