package chapter10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyNewFrame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea input = new JTextArea(1, 0);
	private int pre = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyNewFrame frame = new MyNewFrame();
		frame.setVisible(true);
	}

	public MyNewFrame() {
		setSize(600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		getContentPane().setBackground(Color.BLUE);
		JButton btnplus = new JButton("+");
		JPanel panel = new JPanel();
		btnplus.addActionListener(this);
		btnplus.setSize(btnplus.getPreferredSize());
		JButton btnminus = new JButton("-");
		btnminus.addActionListener(this);
		btnminus.setSize(btnminus.getPreferredSize());
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(this);
		btnReset.setSize(btnReset.getPreferredSize());
		panel.add(btnplus);
		panel.add(btnminus);
		panel.add(btnReset);
		add(input, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		int total;
		if (command.equals("+")) {
			total = pre + Integer.parseInt(input.getText());
			input.setText(Integer.toString(total));
			pre = Integer.parseInt(input.getText());
		} else if (command.equals("-")) {
			total = pre - Integer.parseInt(input.getText());
			input.setText(Integer.toString(total));
			pre = Integer.parseInt(input.getText());
		} else {
			input.setText("");
			pre = 0;
		}
		input.grabFocus();
	}

}
