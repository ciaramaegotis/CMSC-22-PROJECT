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
	private Cart myCart, yourCart;
	private Thread myCartThread, yourCartThread;
	private Image image;	
	private ArrayList<Cart> carts = new ArrayList<Cart>();

	public Stage(){
		try{
			image = Toolkit.getDefaultToolkit().getImage("bg.png");
		} catch(Exception e){}
		this.setLayout(null);

		// myCart = new Cart(0, 120, "cart");
		yourCart = new Cart(0, 220, "zombie1");
		// carts.add(myCart);
		carts.add(yourCart);
		
		// myCartThread = new Thread(myCart);
		yourCartThread = new Thread(yourCart);	

		/*Bystander peach = new Bystander(500, 0, 51, 91, "peach", this);
		Bystander toadsworth = new Bystander(600, 0, 45, 66, "toadsworth", this);
		Thread peachThread = new Thread(peach);
		Thread toadsworthThread = new Thread(toadsworth);*/

		// this.add(myCart);
		this.add(yourCart);
		/*this.add(peach);
		this.add(toadsworth);*/
		this.add(new JPanel());

		// myCartThread.start();
		yourCartThread.start();
		/*peachThread.start();
		toadsworthThread.start();*/

		// this.setComponentZOrder(myCart, 2);
		this.setComponentZOrder(yourCart, 1);
	}

	public ArrayList<Cart> getCarts(){
		return this.carts;
	}

	/**********************************************************************************************
	* This code runs in the main thread.
	* Waits for the two threads to finish before displaying the winner.
	***********************************************************************************************/


	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(this.image,0,0,null);
		Toolkit.getDefaultToolkit().sync();
	}
}