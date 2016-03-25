package homework;

import java.util.Arrays;

public class MorseCode {

	private static String[] table = new String[26];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < table.length; i++) {
			table[i] = "";
		}
		for (int i = 0; i < table.length; i++) {
			String morse;
			morse = args[0].substring(args[0].indexOf('A' + i) + 2, args[0].indexOf(';', args[0].indexOf('A' + i)));
			for (int j = 0; j < morse.length(); j++) {
				if (morse.charAt(j) == '.') {
					table[i] += "1";
				} else {
					table[i] += "111";
				}
				if (j < morse.length() - 1) {
					table[i] += "0";
				}
			}
		}
		System.out.println(args[2]);
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
				encoded += table[ch - 'A'];
			} else {
				encoded += "0000000";
			}
			if (i + 1 < sentence.length() && Character.isLetter(sentence.charAt(i + 1))) {
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
			System.out.println(word[i]);
			character = word[i].split("000");
			for (int j = 0; j < character.length; j++) {
				System.out.println(character[j]);
				System.out.println(Arrays.binarySearch(table, character[j]));
				decoded += ('A' + 1);
			}
			if (i + 1 < word.length) {
				decoded += " ";
			}
		}
		return decoded;
	}

}
