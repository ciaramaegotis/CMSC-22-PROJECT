import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Toolkit;
import java.util.Random;

class Mower extends Sprite implements Runnable{
	int coordinate;
	boolean isFinished;
	private Image img;
	private final static String ICON = "./assets/mower.png";

	public Mower(String fname, int xPos, int yPos){
		super(fname, xPos, yPos);
		this.isFinished = false;
	}
	public void runOver(){
		//runover the zombies
	}

	public boolean checkNearZombie(){
		return false;
	}
	@Override
	public void run(){
		while (this.checkNearZombie() == false){
			this.repaint();
		}
		if (this.checkNearZombie() == true){
			while (this.xPos < 1000){
				this.xPos += 10;
			}
			this.runOver();
			
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		try{
			img = ImageIO.read(new File(Mower.ICON));
		}catch(Exception e){
			System.out.println("Can't load the mower image");
		}
		Graphics2D g2d = (Graphics2D) g;
		g.drawImage(img, xPos, yPos, 70, 75, null);
		Toolkit.getDefaultToolkit().sync();
	}
}