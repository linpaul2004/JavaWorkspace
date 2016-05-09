package chapter11;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WindowListenerDemo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowListenerDemo demoWindow = new WindowListenerDemo();
		demoWindow.setVisible(true);
	}

	public WindowListenerDemo() {
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new CheckOnExit());
		JLabel aLabel = new JLabel("I like to be sure you are sincere.");
		add(aLabel);
	}

	private class CheckOnExit implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			ConfirmWindow checkers = new ConfirmWindow();
			checkers.setVisible(true);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class ConfirmWindow extends JFrame implements ActionListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ConfirmWindow() {
			setSize(200, 100);
			setLayout(new BorderLayout());
			JLabel confirmLabel = new JLabel("Are you sure you want to exit?");
			add(confirmLabel, BorderLayout.CENTER);
			JButton exitButton = new JButton("Yes");
			exitButton.addActionListener(this);
			add(exitButton, BorderLayout.SOUTH);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	}

}
