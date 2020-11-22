import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @author Nawrin Haris Section 22D
 * @date November 2nd, 2020
 * @description Create a class called WordNode which has fields for the data (a
 *              Word) and next (WordNode) instance variables. Include a
 *              one-argument constructor which takes a Word as a parameter.
 *              Create an abstract linked list class called WordList. This
 *              should be a linked list with head node as described in lecture.
 *              Create two more linked list classes that extend the abstract
 *              class WordList: One called UnsortedWordList and one called
 *              SortedWordList, each with appropriate no-argument constructors.
 *              Each of these classes should have a method called add(Word that
 *              will add a new node to the list. Instantiate two linked lists,
 *              and for every Word read from the file, add it to the unsorted
 *              and sorted lists using the add method. You will end up with the
 *              first list having the Words from the input file in the order
 *              they were read, and in the second list the Words will be in
 *              sorted order. Display the unsorted and sorted Words in the GUI
 *              just as in project 1.
 */

public class Project2 {

	public static void main(String[] args) {

		String[] Word = new String[700];
		int wordCount = 0;
		String[] Wordsvalid = new String[700];
		int validWordsCount = 0;

		try {
			// reads the input named Project2Input.txt
			File file = new File("FileInput");
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

	}
}
