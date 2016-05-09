package chapter11;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class IconDemo extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IconDemo frame = new IconDemo();
		frame.setVisible(true);
	}

	public IconDemo() {
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		try {
			ImageIcon icon = new ImageIcon(new URL("http://www.smes.tyc.edu.tw/~learn/images/1015.gif"));
			JLabel lb = new JLabel(icon);
			lb.setText("hello");
			add(lb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
