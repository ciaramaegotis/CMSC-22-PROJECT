import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.BorderLayout;


public class MyFrame extends JFrame {

	public static final int DIMENSION_X = 798;
	public static final int DIMENSION_Y = 600;
	
	public MyFrame (){
		this.setPreferredSize(new Dimension(DIMENSION_X,DIMENSION_Y));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		Container container = this.getContentPane();	
		Stage stage = new Stage();
		container.add(stage, BorderLayout.CENTER);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}	
}
