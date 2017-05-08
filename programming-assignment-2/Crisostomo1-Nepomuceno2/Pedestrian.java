import java.util.Random;

import java.util.ArrayList;

public class Pedestrian extends Sprite implements Runnable  {
    private String name;
    private boolean walking;
    private ArrayList<Cart> carts;

	private final static int TOTAL_DISTANCE = 420;

	//These variables are set to public since they are only used for image loading
    public final static String FRISK = "frisk.png";
	public final static String CHARA = "chara.png";
    
    public Pedestrian(int x, int y, String name, ArrayList<Cart> carts, String filename)    {
        super(x, y, filename);
        this.name = name;
        this.walking = true;
        this.carts = carts;
    }

	public String getName(){
		return this.name;
	}

    public void stopWalking()   {
        this.walking = false;
    }

	private void walk(){
        if  (this.walking == true)   {
            Random r = new Random();
            int step = r.nextInt(16);

			for	(int i = 0; i < this.carts.size(); ++i)	{//check if this cart will collide with any of the 2 pedestrians
				if (this.collidesWith(this.carts.get(i)))	{//pedestrian will collide with this cart
					this.walking = false;
					this.carts.get(i).stopRunning();
                    this.carts.get(i).loadImage(Cart.SNAIL_DEAD);//change image
					return;//stop moving
				}
			}

            this.incYpos(step);

            if(this.getYPos() >= Pedestrian.TOTAL_DISTANCE) {
                this.setYPos(0);
            }
        }
	}

    public void run()   {
		while(this.walking == true){
			this.walk();
			this.repaint();
			try {
				Thread.sleep(100);
			} catch (Exception e){}
		}        
    }
}
