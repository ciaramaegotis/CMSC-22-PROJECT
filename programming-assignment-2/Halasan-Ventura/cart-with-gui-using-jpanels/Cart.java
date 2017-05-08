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

/**********************************************************************************************
* Cart class which extends the Sprite class. 
* An object from the Cart class is a Runnable object used to create a thread.
***********************************************************************************************/
public class Cart extends Sprite implements Runnable {
	private int distance;
	private static Cart winner;
	private int upState;
	private boolean stop;
	private String filename;

	/**********************************************************************************************
	* Cart constructor.
	* Calls the constructor of the Sprite class and then initializes the remaining attributes.
	***********************************************************************************************/
	public Cart(int x, int y, String sprite){
		super(x, y, sprite);
		this.filename = sprite;
		this.upState = 0;
		this.stop = false;
	}

	public static Cart getWinner(){
		return Cart.winner;
	}

	private void bounce(){
		if (this.upState == 0){
			this.decYPos(4);
		} else if (this.upState == 5){
			this.incYPos(4);
		} else if (this.upState == 10){
			this.upState = -1;
		}
		this.upState++;
	}

	public void stop(){
		this.stop = true;
	}

	/**********************************************************************************************
	* A random value is genereated for the cart to move. 
	* If a cart reaches the TOTAL_DISTANCE, it is set to be the winner.
	***********************************************************************************************/
	private void move(){
		Random r = new Random();
		int step = r.nextInt(5)+5;

		this.distance += step;
		this.incXPos(step);

		if(this.distance>=MyFrame.DIMENSION_X+this.getlength()) {
			this.setXPos(0-this.getlength());
			this.distance = 0;
		}
	}

	/**********************************************************************************************
	* Overrides the run method of the Runnable interface
	* When the thread is started, it continuously checks if there is already a winner.
	* While there is no winner yet, it moves and repaints the cart and sleeps for 30 milliseconds.
	***********************************************************************************************/
	@Override
	public void run(){
		while(!this.stop){
			this.move();
			this.bounce();
			this.repaint();
			try {
				Thread.sleep(1500);
			} catch (Exception e){}
		}

		int i = 0;
		while (true){
			if (this.filename.equals("cart")){
				this.loadImage(filename+"_stop.png", 82, 88, i);
			} else if (this.filename.equals("cart1")){
				this.loadImage(filename+"_stop.png", 82, 92, i);
			}
			i++;
			this.repaint();
			try {
				Thread.sleep(80);
			} catch (Exception e){}
		}
		

	}
}
