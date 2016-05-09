package chapter11;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class PaintTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaintTest frame = new PaintTest();
		frame.setVisible(true);
	}

	public PaintTest() {
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLUE);
		g.drawRect(100, 100, 300, 200);
		g.drawOval(0, 0, 300, 400);
		g.drawArc(100, 100, 500, 300, 180, 180);
		Font f = new Font("Arial Bold", Font.BOLD | Font.ITALIC, 30);
		g.setFont(f);
		g.drawString("Hello Fuck YOU", 100, 100);
	}
}
