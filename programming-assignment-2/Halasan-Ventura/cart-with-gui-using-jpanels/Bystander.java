import java.util.Random;

public class Bystander extends Sprite implements Runnable{
	private int distance;
	private String filename;
	private Stage stage;

	// public Bystander(int x, int y, String sprite){
	// 	super(x, y, sprite);
	// 	this.distance = 0;
	// }

	public Bystander(int xPos, int yPos, int width, int length, String sprite, Stage stage){
		super(xPos, yPos, width, length, sprite);
		this.distance = 0;
		this.filename = sprite;
		this.stage = stage;

	}

	private boolean move(){
		Random r = new Random();
		int step = r.nextInt(16);

		this.distance += step;
		this.incYPos(step);

		this.loadImage(this.filename+".png", this.state++);

		if(this.distance>=MyFrame.DIMENSION_Y+this.getwidth()) {
			this.setYPos(0-this.getlength());
			this.distance = 0;
		}

		if (this.getYPos()+this.getlength()<= 120+(87/2)){
			stage.setComponentZOrder(this, 4);
		} else if (this.getYPos()-this.getlength()/2 < 220){
			stage.setComponentZOrder(this, 2);
		} else {
			stage.setComponentZOrder(this, 0);
		}

		for (int i = 0; i<stage.getCarts().size(); i++){
			Cart cart = stage.getCarts().get(i);

			if (this.getRectangle().intersects(cart.getRectangle())){
				cart.stop();
				return false;
			}
		}
		return true;
	}

	@Override
	public void run(){
		while(this.move()){
			this.repaint();
			try {
				Thread.sleep(80);
			} catch (Exception e){}
		}	

		int i =0;
		while (true){
			if (filename.equals("peach")){
				this.loadImage(this.filename+"_stop.png", 132, 79, i);
				if (i==0){
					this.setXPos(this.getXPos()-42);
				}
			} else if (filename.equals("toadsworth")){
				this.loadImage(this.filename+"_stop.png", 60, 67, i);
			}
			i++;
			this.repaint();
			try {
				Thread.sleep(80);
			} catch (Exception e){}
		}	
	}
	
}