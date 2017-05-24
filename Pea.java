import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Toolkit;

class Pea extends Sprite implements Runnable{
	private final static String ICON = "./assets/pea.png";
	private Image img;

	public Pea(String fname, int xPos, int yPos){
		super(fname, xPos, yPos);
	}

	public void shootPea(){
		if (this.xPos >= 1000){
			this.xPos = 170;
		}else{
			this.xPos += 10;
		}
		this.repaint();
	}

	@Override
	public void run(){
		while (true){
			this.shootPea();
			System.out.println("I am a peaaaaaa");
			try{
				Thread.sleep(1000);
			}catch(Exception e){


			}
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		try{
			img = ImageIO.read(new File(Pea.ICON));
		}catch(Exception e){
			System.out.println("Can't load the pea image");
		}
		Graphics2D g2d = (Graphics2D) g;
		g.drawImage(img, xPos, yPos, 70, 75, null);
		Toolkit.getDefaultToolkit().sync();
	}
}