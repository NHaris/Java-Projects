//WordList
public abstract class WordList {
//declare local variables
	protected WordNode head, last;
	protected int size_of_list;

//define the default constructor
	public WordList() {
		head = last = new WordNode(null);
		size_of_list = 0;
	}

//implement the method to test the linked list is empty
//or not
	public boolean isEmpty() {
		if (size_of_list == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void append(Word unsortedWord) {

		last.next = new WordNode(unsortedWord);
		// set the last node to last.next
		last = last.next;
		// increment the size of list
		size_of_list++;
	}

//implement the method toString
	public String toString() {
		// define the current node
		WordNode curr = head.next;
		String str = "";
		while (curr != null) {
			// call the toString()
			str += WordNode.WordList.toString() + "\n";
			// set current to current next
			curr = curr.next;
		}
		// return the string
		return str;
	}
}