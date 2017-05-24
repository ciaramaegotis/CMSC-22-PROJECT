import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.*;	//imports for necessary classes
import java.awt.event.*;
import javax.swing.*; 



public class CreditFrame extends JFrame {

	public static final int DIMENSION_X = 1005;
	public static final int DIMENSION_Y = 620;
	
	public CreditFrame (){
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(DIMENSION_X,DIMENSION_Y));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

        Container container = this.getContentPane();
        
        JPanel creditPanel = new JPanel();
        JLabel creditLabel = new JLabel("Gotis");
        creditPanel.add(creditLabel);
        container.add(creditPanel);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
