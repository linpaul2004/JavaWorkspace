import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class HighScore extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String name = "Player";
	private static JTextArea label = new JTextArea();
	private static JTextArea area = new JTextArea();
	private static JScrollPane scroll = new JScrollPane(area);
	private static JButton clean = new JButton("Clean");
	private static JButton close = new JButton("Close");
	public static String mode = "";

	public HighScore() {
		setTitle("Ranking");
		setLayout(null);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		add(scroll);
		add(label);
		add(clean);
		add(close);
		clean.setLocation(100, 200);
		clean.setSize(clean.getPreferredSize());
		clean.setFocusable(false);
		clean.addActionListener(new ButtonControl());
		close.setLocation(100, 230);
		close.setSize(close.getPreferredSize());
		close.setFocusable(false);
		close.addActionListener(new ButtonControl());
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
		scroll.setBounds(0, 50, 200, 150);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setModal(true);
		setSize(300, 300);
	}

	public static void clean() {
		File fileClassic = new File("classic.txt");
		File fileChallenge = new File("challenge.txt");
		File fileTimeMode = new File("timeMode.txt");
		File fileBattle = new File("battle.txt");
		if (fileBattle.exists() == true) {
			fileBattle.delete();
			try {
				fileBattle.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (fileClassic.exists() == true) {
			fileClassic.delete();
			try {
				fileClassic.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (fileChallenge.exists() == true) {
			fileChallenge.delete();
			try {
				fileChallenge.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (fileTimeMode.exists() == true) {
			fileTimeMode.delete();
			try {
				fileTimeMode.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		area.setText("");
	}

	public static void readScore() {
		label.setText("HighScore:");
		label.setSize(label.getPreferredSize());
		File fileClassic = new File("classic.txt");
		File fileChallenge = new File("challenge.txt");
		File fileTimeMode = new File("timeMode.txt");
		File fileBattle = new File("battle.txt");
		if (fileClassic.exists() == false) {
			try {
				fileClassic.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (fileChallenge.exists() == false) {
			try {
				fileChallenge.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (fileTimeMode.exists() == false) {
			try {
				fileTimeMode.createNewFile();
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
			Scanner readClassic = new Scanner(new FileInputStream("classic.txt"));
			Scanner readChallenge = new Scanner(new FileInputStream("challenge.txt"));
			Scanner readTimeMode = new Scanner(new FileInputStream("timeMode.txt"));
			Scanner readBattle = new Scanner(new FileInputStream("battle.txt"));
			String output = "Classic\n";
			while (readClassic.hasNextLine()) {
				String s = readClassic.nextLine();
				output += "Name:" + readClassic.nextLine() + " Score: " + s + "\n";
			}
			readClassic.close();
			output += "\nChallenge\n";
			while (readChallenge.hasNextLine()) {
				String s = readChallenge.nextLine();
				output += "Name:" + readChallenge.nextLine() + " Score: " + s + "\n";
			}
			readChallenge.close();
			output += "\nTime Mode\n";
			while (readTimeMode.hasNextLine()) {
				String s = readTimeMode.nextLine();
				output += "Name:" + readTimeMode.nextLine() + " Score: " + s + "\n";
			}
			readTimeMode.close();
			output += "\nBattle\n";
			while (readBattle.hasNextLine()) {
				String s = readBattle.nextLine();
				output += "Name:" + readBattle.nextLine() + " Score: " + s + "\n";
			}
			readBattle.close();
			area.setText(output);
			area.setSize(260, 450);
			scroll.setBounds(0, 50, 260, 450);
			Main.highscore.setSize(300, 600);
			HighScore.clean.setLocation(100, 500);
			HighScore.close.setLocation(100, 530);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void requestName() {
		JDialog inputName = new JDialog();
		JLabel prompt = new JLabel("Please Input Your Name:");
		JTextField field = new JTextField(name);
		JButton check = new JButton("OK");
		field.setSize(200, 30);
		field.setLocation(0, 20);
		check.setSize(check.getPreferredSize());
		check.setLocation(80, 70);
		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				inputName.setVisible(false);
				name = field.getText();
			}
		});
		prompt.setSize(prompt.getPreferredSize());
		inputName.setSize(250, 150);
		inputName.setLocationRelativeTo(Main.frame);
		inputName.add(prompt);
		inputName.add(field);
		inputName.add(check);
		inputName.setTitle("Input Name");
		inputName.setLayout(null);
		inputName.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		inputName.setModal(true);
		inputName.setVisible(true);
		name = field.getText();
	}

	public static void setHighscore(int score, int loser) {
		area.setSize(260, 150);
		scroll.setBounds(0, 50, 260, 150);
		Main.highscore.setSize(300, 300);
		HighScore.clean.setLocation(100, 200);
		HighScore.close.setLocation(100, 230);
		String newline = System.lineSeparator();
		requestName();
		if (mode.equals("battle")) {
			label.setText(name + " wins!" + "\nScore:" + score);
		} else {
			label.setText("Your Score:" + score);
		}
		label.setSize(label.getPreferredSize());
		File fileHigh = new File(mode + ".txt");
		String output = "", realoutput = "";
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
			while (readin.hasNextLine()) {
				int s = Integer.parseInt(readin.nextLine());
				if (s >= score) {
					output += "" + s + newline + readin.nextLine() + newline;
				} else {
					output += "" + score + newline + name + newline;
					output += "" + s + newline + readin.nextLine() + newline;
					last = false;
					break;
				}
			}
			while (readin.hasNextLine()) {
				output += "" + readin.nextLine() + newline + readin.nextLine() + newline;
			}
			if (last) {
				output += "" + score + newline + name + newline;
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
		while (strScanner.hasNextLine()) {
			String s = strScanner.nextLine();
			realoutput += "Name:" + strScanner.nextLine() + " Score: " + s + "\n";
		}
		strScanner.close();
		area.setText(realoutput);
	}

}
