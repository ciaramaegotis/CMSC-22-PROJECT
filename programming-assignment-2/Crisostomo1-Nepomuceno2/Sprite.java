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
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import java.awt.Rectangle;

/**********************************************************************************************
* Sprite class which is a JPanel. 
* Contains attributes and methods to render an object as a JPanel with image.
***********************************************************************************************/
public class Sprite extends JPanel {
	protected Image img;
	protected int xPos, yPos;
	
	/**********************************************************************************************
	* Sprite constructor.
	* Initializes the attributes and loads the image for this sprite.
	***********************************************************************************************/
	public Sprite(int xPos, int yPos, String filename){
		this.setOpaque(false);
		this.setSize(500,500);
		this.xPos = xPos;
		this.yPos = yPos;
		this.loadImage(filename);
	}

	public Rectangle getBounds()	{//get measurement of the rectangle
		return (new Rectangle(this.xPos, this.yPos, this.img.getWidth(null), this.img.getHeight(null)));
	}

	public boolean collidesWith(Sprite rect2)	{
		Rectangle rectangle1 = this.getBounds();
		Rectangle rectangle2 = rect2.getBounds();

		if (rectangle1.intersects(rectangle2))	{//rectangle1 collides with rectangle2
			return true;
		}
		else return false;
	}

	protected void loadImage(String filename){
		try{
			img = Toolkit.getDefaultToolkit().getImage(filename);
		} catch(Exception e)	{
			e.printStackTrace();
		}	
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
		this.xPos += distance;
	}

	public void incYpos(int distance)	{
		this.yPos += distance;
	}

	public void setXPos(int xPos)	{
		this.xPos = xPos;
	}

	public void setYPos(int yPos)	{
		this.yPos = yPos;
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
		Toolkit.getDefaultToolkit().sync();//makes animations smooth
	}
}