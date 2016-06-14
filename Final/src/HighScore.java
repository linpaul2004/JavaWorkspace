import java.awt.Font;
import java.awt.SystemColor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class HighScore extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextArea label = new JTextArea();
	private static JTextArea area = new JTextArea();
	private static JScrollPane scroll = new JScrollPane(area);
	public static String mode = "";

	public HighScore() {
		setTitle("Ranking");
		setLayout(null);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		add(scroll);
		add(label);
		label.setLocation(0, 0);
		label.setVisible(true);
		label.setEditable(false);
		label.setFocusable(false);
		label.setBackground(SystemColor.control);
		label.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(), 15));
		area.setEditable(false);
		area.setFont(new Font(area.getFont().getName(), area.getFont().getStyle(), 20));
		area.setFocusable(false);
		area.setBackground(SystemColor.control);
		area.setLocation(0, 50);
		area.setSize(200, 150);
		scroll.setBounds(area.getBounds().x, area.getBounds().y, area.getBounds().width + 50, area.getBounds().height);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		setModal(true);
		setSize(300, 250);
	}

	public static void readScore() {
		label.setText("HighScore:");
		label.setSize(label.getPreferredSize());
		File fileSingle = new File("single.txt");
		File fileBattle = new File("battle.txt");
		if (fileSingle.exists() == false) {
			try {
				fileSingle.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (fileBattle.exists() == false) {
			try {
				fileBattle.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Scanner readSingle = new Scanner(new FileInputStream("single.txt"));
			Scanner readBattle = new Scanner(new FileInputStream("battle.txt"));
			String output = "Single\n";
			while (readSingle.hasNextInt()) {
				output += "Score: " + readSingle.nextInt() + "\n";
			}
			readSingle.close();
			output += "Battle";
			while (readBattle.hasNextInt()) {
				int s = readBattle.nextInt();
				output += "Player" + readBattle.nextInt() + " Score: " + s + "\n";
			}
			readBattle.close();
			area.setText(output);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setHighscore(int score, int loser) {
		if (mode.equals("battle")) {
			label.setText("Player " + (loser == 0 ? 2 : 1) + " wins!" + "\nScore:" + score);
		} else if (mode.equals("single")) {
			label.setText("Score:" + score);
		}
		label.setSize(label.getPreferredSize());
		File fileHigh = new File(mode + ".txt");
		int winner = loser == 0 ? 2 : 1;
		String output = "";
		String realoutput = "";
		if (fileHigh.exists() == false) {
			try {
				fileHigh.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			boolean last = true;
			Scanner readin = new Scanner(new FileInputStream(mode + ".txt"));
			while (readin.hasNextInt()) {
				int s = readin.nextInt();
				if (s >= score) {
					if (mode.equals("battle")) {
						output += "" + s + " " + readin.nextInt() + "\n";
					} else if (mode.equals("single")) {
						output += "" + s + "\n";
					}
				} else {
					if (mode.equals("battle")) {
						output += "" + score + " " + winner + "\n";
						output += "" + s + " " + readin.nextInt() + "\n";
						last = false;
					} else if (mode.equals("single")) {
						output += "" + score + "\n";
						output += "" + s + "\n";
					}
					break;
				}
			}
			while (readin.hasNextInt()) {
				if (mode.equals("battle")) {
					output += "" + readin.nextInt() + " " + readin.nextInt() + "\n";
				} else if (mode.equals("single")) {
					output += "" + readin.nextInt() + "\n";
				}
			}
			if (last) {
				if (mode.equals("battle")) {
					output += "" + score + " " + winner + "\n";
				} else if (mode.equals("single")) {
					output += "" + score + "\n";
				}
			}
			readin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PrintWriter writer = new PrintWriter(new FileOutputStream(mode + ".txt"));
			writer.write(output);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner strScanner = new Scanner(output);
		while (strScanner.hasNextInt()) {
			if (mode.equals("battle")) {
				int s = strScanner.nextInt();
				realoutput += "Player" + strScanner.nextInt() + " Score: " + s + "\n";
			} else if (mode.equals("single")) {
				realoutput += "Score:" + strScanner.nextInt() + "\n";
			}
		}
		strScanner.close();
		area.setText(realoutput);
	}

}
