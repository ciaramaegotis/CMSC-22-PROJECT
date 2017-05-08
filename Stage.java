/*************************************************************************************************************************
 *
 * CMSC 22 2nd Semester SY 2016-1017
 * Multithreading Example (with GUI): Cart
 * 
 * (c) Institute of Computer Science, CAS, UPLB
 * @author Miyah Queliste
 *
 *************************************************************************************************************************/
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

/**********************************************************************************************
* Stage class which is a JPanel. 
* Contains the Cart objects that will race.
***********************************************************************************************/
public class Stage extends JPanel {
	private Image image;

	public Stage(){
		try{
			image = Toolkit.getDefaultToolkit().getImage("bg.png");
		} catch(Exception e){}
		this.setLayout(null);

		
		this.add(new JPanel());

	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(this.image,0,0,null);
		Toolkit.getDefaultToolkit().sync();
	}
}