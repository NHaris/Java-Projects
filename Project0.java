
import javax.swing.JOptionPane;

/**
 *
 * @author Nawrin Haris Section 22D
 * @since 09/21/20
 * @version 1
 * @description search the user input to check how many upper case E's and lower case e's are in a sentence
 */
public class Project0 {

	public static void main(String[] args) {

		String sentence;
		sentence = JOptionPane.showInputDialog(null, "Please enter a sentence.");
		// The variable will keep count how many E's and e's in the program and its length

		int E = 0;
		int e = 0;
		int length = sentence.length();
		for (int i = 0; i < length; i++) {
			// This statement is going to check for any lower case e's or upper case E's in the string

			if (sentence.charAt(i) == 'E')
				E += 1;
			if (sentence.charAt(i) == 'e')
				e += 1;
			if (sentence.contains("stop"))
				System.exit(0); // terminate the program

		}

		JOptionPane.showMessageDialog(null,
				"There are " + E + " upper case E's and " + e + " lower case e's in this sentence.");
		/**
		 * @param int E, e user input
		 * @param sentence array
		 * @return how many upper case E's and lower case e's, otherwise stop
		 */

	}

}