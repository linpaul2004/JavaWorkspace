package homework;

import java.util.ArrayList;

public class MorseCode {

	private static ArrayList<String> table = new ArrayList<>(26);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 26; i++) {
			table.add("");
		}
		for (int i = 0; i < table.size(); i++) {
			String morse;
			morse = args[0].substring(args[0].indexOf('A' + i) + 2, args[0].indexOf(';', args[0].indexOf('A' + i)));
			for (int j = 0; j < morse.length(); j++) {
				if (morse.charAt(j) == '.') {
					table.set(i, table.get(i).concat("1"));
				} else {
					table.set(i, table.get(i).concat("111"));
				}
				if (j < morse.length() - 1) {
					table.set(i, table.get(i).concat("0"));
				}
			}
		}
		if (args[1].equals("encode")) {
			System.out.println(encode(args[2]));
		} else {
			System.out.println(decode(args[2]));
		}
	}

	private static String encode(String sentence) {
		sentence = sentence.toUpperCase();
		String encoded = "";
		for (int i = 0; i < sentence.length(); i++) {
			char ch = sentence.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				encoded += table.get(ch - 'A');
			} else {
				encoded += "0000000";
			}
			if (i + 1 < sentence.length() && Character.isLetter(sentence.charAt(i + 1)) && sentence.charAt(i) != ' ') {
				encoded += "000";
			}
		}
		return encoded;
	}

	private static String decode(String morse) {
		if (morse.split("00000000").length > 1) {
			return "*INVALID*";
		}
		String decoded = "";
		String[] word, character;
		word = morse.split("0000000");
		for (int i = 0; i < word.length; i++) {
			character = word[i].split("000");
			if (character.length < 1) {
				return "*INVALID*";
			}
			for (int j = 0; j < character.length; j++) {
				int index = table.indexOf(character[j]);
				if (index >= 0) {
					decoded += (char) ('A' + index);
				} else {
					return "*INVALID*";
				}
			}
			if (i + 1 < word.length) {
				decoded += " ";
			}
		}
		return decoded;
	}

}
