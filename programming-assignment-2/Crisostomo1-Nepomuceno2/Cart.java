/*************************************************************************************************************************
 *
 * CMSC 22 2nd Semester SY 2016-1017
 * Multithreading Example (with GUI): Cart
 * 
 * (c) Institute of Computer Science, CAS, UPLB
 * @author Miyah Queliste
 *
 *************************************************************************************************************************/
import java.util.Random;

import java.util.ArrayList;

/**********************************************************************************************
* Cart class which extends the Sprite class. 
* An object from the Cart class is a Runnable object used to create a thread.
***********************************************************************************************/
public class Cart extends Sprite implements Runnable {
	private String name;
	private boolean running;
	private ArrayList<Pedestrian> pedestrians;

	private final static int TOTAL_DISTANCE = 430;

	//These variables are set to public since they are only used for image loading
	public final static String SNAIL_RED = "snail_red.png";
	public final static String SNAIL_ORANGE = "snail_orange.png";
	public final static String SNAIL_DEAD = "snail_dead.png";

	/**********************************************************************************************
	* Cart constructor.
	* Calls the constructor of the Sprite class and then initializes the remaining attributes.
	***********************************************************************************************/
	public Cart(int x, int y, String name, ArrayList<Pedestrian> pedestrians, String filename){
		super(x, y, filename);
		this.name = name;
		this.running = true;
		this.pedestrians = pedestrians;
	}

	public String getName(){
		return this.name;
	}

	public void stopRunning()	{
		this.running = false;
	}

	/**********************************************************************************************
	* A random value is genereated for the cart to move. 
	* If a cart reaches the TOTAL_DISTANCE, it is set to be the winner.
	***********************************************************************************************/
	private void move(){
		if (this.running == true)	{
			Random r = new Random();
			int step = r.nextInt(5)+5;

			for	(int i = 0; i < this.pedestrians.size(); ++i)	{//check if this cart will collide with any of the 2 pedestrians
				if (this.collidesWith(this.pedestrians.get(i)))	{//cart will collide with this pedestrian
					this.running = false;
					this.pedestrians.get(i).stopWalking();
					this.loadImage(Cart.SNAIL_DEAD);//change image
					return;//stop moving
				}
			}

			this.incXPos(step);

			if(this.getXPos() >= Cart.TOTAL_DISTANCE) {
				this.setXPos(0);
			}
		}
	}

	/**********************************************************************************************
	* Overrides the run method of the Runnable interface
	* When the thread is started, it continuously checks if there is already a winner.
	* While there is no winner yet, it moves and repaints the cart and sleeps for 30 milliseconds.
	***********************************************************************************************/
	@Override
	public void run(){
		while(this.running == true){
			this.move();
			this.repaint();
			try {
				Thread.sleep(30);
			} catch (Exception e){}
		}		
	}
}
