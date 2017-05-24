import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Toolkit;
import java.util.Random;

abstract class Plants extends Sprite implements Runnable{
	Random r = new Random();
	private String name;
	private int lifePoints;
	private static int plantID = 0;
	private Image img;

	private static final String ICON1 = "./assets/sunflower.png";
	private static final String ICON2 = "./assets/peashooter.png";
	private static final String ICON3 = "./assets/potato.png";
	public Plants(String fname, int xPos, int yPos, String name){
		
			super(fname, xPos, yPos);
		
		
		this.name = name;
		this.plantID += 1;
		Plants.plantID++;
	}

	void attackedPlant(int damage){
		this.lifePoints -= damage;
	}

	public String getNamePlant(){
		return this.name;
	}

	public int getLifePoints(){
		return this.lifePoints;
	}

	public int getPlantID(){
		return this.plantID;
	}

	public void setLifePoints(int life){
		this.lifePoints = life;
	}

	public int getXPos(){
		return this.xPos;
	}

	public int getYPos(){
		return this.yPos;
	}

	public void attack(){
		System.out.println("Something happens.............................");
		this.repaint();
		try{
		Thread.sleep(2000);
		}catch(Exception e){

		}
	}

	// public boolean checkZombie(){

	// }

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		try{
			if ((this.name).equals("Sunflower")){
				img = ImageIO.read(new File(Plants.ICON1));
			}else if ((this.name).equals("Peashooter")){
				img = ImageIO.read(new File(Plants.ICON2));
			}else{
				img = ImageIO.read(new File(Plants.ICON3));
			}
		}catch(Exception e){
			System.out.println("Ooops! Something went wrong!");
		}

		Graphics2D g2d = (Graphics2D) g;
		g.drawImage(img, xPos, yPos, 70, 75, null);
		Toolkit.getDefaultToolkit().sync();
	}

	@Override
	public void run(){
		while (this.lifePoints != 0){
			this.repaint();
		}
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println("Ooops!");
		}
	}

}