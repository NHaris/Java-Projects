import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WordGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea centralArea; // words are present here
	JTextArea Areavalid; // valid words are present here
	JTextArea invalidArea; // invalid words are present here

	public WordGUI() {
		this.setSize(500, 500);
		this.setTitle("Project 1");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new GridLayout(1, 3)); // grid layout

		centralArea = new JTextArea();
		Areavalid = new JTextArea();
		invalidArea = new JTextArea();

		JScrollPane scrollFirstPane = new JScrollPane();
		JScrollPane scrollSecondPane = new JScrollPane();
		JScrollPane scrollThirdPane = new JScrollPane();

		scrollFirstPane.setViewportView(centralArea);
		scrollSecondPane.setViewportView(Areavalid);
		scrollThirdPane.setViewportView(invalidArea);

		this.add(scrollFirstPane);
		this.add(scrollSecondPane);
		this.add(scrollThirdPane);

		this.setVisible(true);
	}

	public void addtoMasterArea(String str) {
		centralArea.append(str);
	}

	public void addtoValidArea(String str) {
		Areavalid.append(str);
	}

	public void addtoInvalidArea(String str) {
		invalidArea.append(str);
	}

}