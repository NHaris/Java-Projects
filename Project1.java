
/**
 * @author Nawrin Haris
 * @description   Put all the words in an array, put the valid words (words that
*
have only letters) in a second array, and put the invalid words
*
in a third array. Create a GUI to display the arrays using a
*
GridLayout with one row and three columns.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Project1 {

	public static void main(String[] args) {

		String[] Word = new String[700];
		int wordCount = 0;
		String[] Wordsvalid = new String[700];
		int validWordsCount = 0;
		String[] Wordsinvalid = new String[700];
		int invalidWordsCount = 0;

		try {
			// reads the input named Project1Input.txt
			File file = new File("Input1.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();

			while (line != null) {
				StringTokenizer tokenizer = new StringTokenizer(line);

				while (tokenizer.hasMoreTokens()) {
					Word[wordCount] = tokenizer.nextToken();
					wordCount++;
				}
				line = br.readLine();
			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Filling in the valid array and the invalid array
		// Starts to go through the first array
		for (int i = 0; i < wordCount; i++) {
			// Begins the validity check of every word to check every character inside the
			// string
			Boolean isvalid = true;
			for (int j = 0; j < Word[i].length(); j++) {
				// If the character isn't a string isn't a letter, it adds it into the invalid
				// array
				if (!Character.isLetter(Word[i].charAt(j))) {
					isvalid = false;
					break;
				}
			} // If the String is indeed filled with all characters, it will put it into the
				// valid array
			if (isvalid) {
				Wordsvalid[validWordsCount++] = Word[i];
			} else {
				Wordsinvalid[invalidWordsCount++] = Word[i];
			}
		}

		// Selection Sort
		int lowestCount = 0;

		for (int i = 0; i < validWordsCount - 1; i++) {
			// starting
			lowestCount = i;
			for (int j = i; j < validWordsCount; j++) {
				// current word
				if (Wordsvalid[j].compareToIgnoreCase(Wordsvalid[lowestCount]) < 0) {
					lowestCount = j;
				}
			}

			String temp = Wordsvalid[i];
			Wordsvalid[i] = Wordsvalid[lowestCount];
			Wordsvalid[lowestCount] = temp;

		}
		WordGUI gui = new WordGUI();

		// text appending in each area
		for (int i = 0; i < wordCount; i++) {
			gui.addtoMasterArea(Word[i] + "\n");
		}
		for (int i = 0; i < validWordsCount; i++) {
			gui.addtoValidArea(Wordsvalid[i] + "\n");
		}
		for (int i = 0; i < invalidWordsCount; i++) {
			gui.addtoInvalidArea(Wordsinvalid[i] + "\n");
		}
	}
}
