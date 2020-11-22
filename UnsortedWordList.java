//UnsortedWordList

public class UnsortedWordList extends WordList {
//define the Constructor
	public UnsortedWordList() {
		// call the variables
		super();
	}

//implement the method add
	public void add(Word unsortedWord) {
		// just append values to the text area
		append(unsortedWord);
	}
}