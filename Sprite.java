import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.imageio.ImageIO;
import java.io.File;


public class Sprite extends JPanel{
	private Image img;
	protected int xPos, yPos;

	public Sprite(String filename, int xPos, int yPos){
		this.setOpaque(false);
		this.setSize(1005, 600);
		this.xPos = xPos;
		this.yPos = yPos;
		this.loadImage(filename);
	}

	private void loadImage(String filename){
		try{
			img = Toolkit.getDefaultToolkit().getImage(filename);
		}catch(Exception e){
			System.out.println("Trouble loading image...");
		}
	}

	public Image getImage(){
		return this.img;
	}

	public int getyPos(){
		return this.yPos;
	}

	public int getxPos(){
		return this.xPos;
	}

	public void incxPos(int distance){
		this.xPos += distance;
	}

	public void decxPos(int distance){
		this.xPos -= distance;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		Graphics2D g2d = (Graphics2D)g;
		g.drawImage(this.getImage(), this.getxPos(),this.getyPos(),70,75,null);
	}

}