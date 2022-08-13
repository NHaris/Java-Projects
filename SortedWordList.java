//SortedWordList
public class SortedWordList extends WordList {
//Constructor
	public SortedWordList() {
		// call variables though super keyWord
		super();
	}

//implement the method add()
	public void add(Word word) {
		// define the head for the previous and current nodes in the liked list
		WordNode prev = head, curr = head.next;

		// define the nodes
		WordNode node = new WordNode(word);

		// Using while loop
		while (curr != null && word.getWord() > ((Word) curr.word).getWord()) {
			// set previous node as current node
			prev = curr;
			// set current node as next node
			curr = curr.next;
		}
		// set node to next is current node
		node.next = curr;
		// previous to next is node
		prev.next = node;
		// If node to next value is null
		if (node.next == null) {
			// set that is as last node
			last = node;
			// increment the node.
			size_of_list++;
		}
	}
}
