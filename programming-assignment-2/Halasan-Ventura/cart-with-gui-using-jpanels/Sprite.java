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
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.Color;

/**********************************************************************************************
* Sprite class which is a JPanel. 
* Contains attributes and methods to render an object as a JPanel with image.
***********************************************************************************************/
public class Sprite extends JPanel {
	private BufferedImage img;
	private BufferedImage sheet;
	private int xPos, yPos;
	protected int length, width;
	protected int state;

	/**********************************************************************************************
	* Sprite constructor.
	* Initializes the attributes and loads the image for this sprite.
	***********************************************************************************************/
	public Sprite(int xPos, int yPos, String filename){
		this.setOpaque(false);
		this.xPos = xPos-width;
		this.yPos = yPos-length;
		this.loadImage(filename+".gif");

		this.setSize(MyFrame.DIMENSION_X+(2*this.width),MyFrame.DIMENSION_Y+(2*this.length));
		this.setBackground(Color.RED);
	}

	public Sprite(int xPos, int yPos, int width, int length, String filename){
		this.setOpaque(false);
		this.length = length;
		this.width = width;
		this.xPos = xPos-width;
		this.yPos = yPos-length;
		this.loadImage(filename+".png", 0);
		this.state = 0;

		this.setSize(MyFrame.DIMENSION_X+(2*this.width),MyFrame.DIMENSION_Y+(2*this.length));
	}

	protected void loadImage(String filename){
		try{
			img = ImageIO.read(new File(filename));
		} catch(Exception e){}	

		this.width = img.getWidth();
		this.length = img.getHeight();
	}

	protected void loadImage(String filename, int state){
		try{
			sheet = ImageIO.read(new File(filename));
		} catch (IOException e){
		}

		img = sheet.getSubimage(0, (state%(sheet.getHeight()/this.length))*this.length, this.width, this.length);
	}

	protected void loadImage(String filename, int width, int length, int state){
		this.width = width;
		this.length = length;
		try{
			sheet = ImageIO.read(new File(filename));
		} catch (IOException e){
		}

		img = sheet.getSubimage(0, (state%(sheet.getHeight()/this.length))*this.length, this.width, this.length);
	}

	public Image getImage(){
		return this.img;
	}

	public int getXPos(){
		return this.xPos;
	}

	public int getYPos(){
		return this.yPos;
	}

	public void incXPos(int distance){
		this.xPos+=distance;
	}

	public void decXPos(int distance){
		this.xPos-=distance;
	}

	public void setXPos(int distance){
		this.xPos=distance;
	}

	public void incYPos(int distance){
		this.yPos+=distance;
	}

	public void decYPos(int distance){
		this.yPos-=distance;
	}

	public void setYPos(int distance){
		this.yPos=distance;
	}


	public int getlength(){
		return this.length;
	}

	public int getwidth(){
		return this.width;
	}

	public Rectangle getRectangle(){
		return new Rectangle(this.xPos, this.yPos+this.length/2, this.width, this.length/2);
	}


	/**********************************************************************************************
	* Overrides the paintComponent method of JPanel.
	* Draws the image on its x and y coordinates.
	***********************************************************************************************/
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(this.getImage(),this.getXPos(),this.getYPos(),null);
		Toolkit.getDefaultToolkit().sync();
	}
}