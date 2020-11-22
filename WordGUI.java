//WordGUI for PROJECT 1
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WordGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea UnsortedWords; // words are present here
	JTextArea SortedWords; // valid words are present here

	public WordGUI() {
		this.setSize(500, 500);
		this.setTitle("Project 2");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new GridLayout(1, 3)); // grid layout

		UnsortedWords = new JTextArea();
		SortedWords = new JTextArea();

		JScrollPane scrollFirstPane = new JScrollPane();
		JScrollPane scrollSecondPane = new JScrollPane();

		scrollFirstPane.setViewportView(UnsortedWords);
		scrollSecondPane.setViewportView(SortedWords);

		this.add(scrollFirstPane);
		this.add(scrollSecondPane);

		this.setVisible(true);
	}

	public WordGUI(String string) {
		// TODO Auto-generated constructor stub
	}

	public void addtoMasterArea(String str) {
		UnsortedWords.append(str);
	}

	public void addtoValidArea(String str) {
		SortedWords.append(str);
	}

}
