import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Project extends JFrame{
	static JPanel cards;
	ControlPanel panel;
	
	//String identifiers for each card
	final static String GAMEPANEL = "New Game";
	final static String OTHERGAMEPANEL = "Continue";
	final static String EXITPANEL = "Exit";
	final static String HOMEPANEL = "Help";

	
	//constructor
	public Project(ControlPanel panel) {
		
		this.cards = new JPanel(new CardLayout());
		this.panel = panel;
		
		JFrame frame = new JFrame("PROJECT");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setPreferredSize(new Dimension(900, 600));
		frame.setResizable(false);
		
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		
		//For Home menu
		HomePanel homecard = new HomePanel(this.panel);
		cards.add(homecard, HOMEPANEL);

		c.add(cards, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);
	}

}
