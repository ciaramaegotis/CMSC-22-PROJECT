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
import java.util.ArrayList;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

/**********************************************************************************************
* Stage class which is a JPanel. 
* Contains the Cart objects that will race.
***********************************************************************************************/
public class Stage extends JPanel {
	Image img;

	private final static String BACKGROUND = "base.png";

	private Cart cart01, cart02;
	private ArrayList<Cart> carts;
	private Pedestrian ped01, ped02;
	private ArrayList<Pedestrian> pedestrians;

	private Thread cart01Thread, cart02Thread, ped01Thread, ped02Thread;

	private void loadImage(String filename){
		try{
			img = Toolkit.getDefaultToolkit().getImage(filename);
		} catch(Exception e){}	
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(this.img, 0, 0,null);//display this image as a background
		Toolkit.getDefaultToolkit().sync();//makes animations smooth
	}

	public Stage(){
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		this.loadImage(Stage.BACKGROUND);//prepare background image
		this.repaint();//set bg image

		carts = new ArrayList<Cart>();
		pedestrians = new ArrayList<Pedestrian>();

		cart01 = new Cart(0, 300, "Red Snail", pedestrians, Cart.SNAIL_RED);
		cart02 = new Cart(0, 400, "Orange Snail", pedestrians, Cart.SNAIL_ORANGE);
		ped01 = new Pedestrian(300, 0, "Frisk", carts, Pedestrian.FRISK);
		ped02 = new Pedestrian(400, 0, "Chara", carts, Pedestrian.CHARA);
		
		//Thread instantiation
		cart01Thread = new Thread(cart01);
		cart02Thread = new Thread(cart02);		
		ped01Thread = new Thread(ped01);
		ped02Thread = new Thread(ped02);

		//ArrayList adding
		this.carts.add(cart01);
		this.carts.add(cart02);
		this.pedestrians.add(ped01);
		this.pedestrians.add(ped02);

		//JPanel adding
		this.add(cart01);
		this.add(cart02);
		this.add(ped01);
		this.add(ped02);

		cart01Thread.start();
		cart02Thread.start();
		ped01Thread.start();
		ped02Thread.start();
	}
	/**********************************************************************************************
	* This code runs in the main thread.
	* Waits for the two threads to finish before displaying the winner.
	***********************************************************************************************/
}