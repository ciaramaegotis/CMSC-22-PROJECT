import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Toolkit;
import java.util.Random;

class Zombie extends Sprite implements Runnable{
	Random r = new Random();
	final int officialKind;
	private String normalZombie = "Normal Zombie";
	private String coneZombie = "Cone Zombie";
	private String flagZombie = "Flag Zombie";
	private String kindofZombie;
	private int lifePoints;
	private int damagePoints;
	private static int PopulationCheck = 0;
	private int zombieID = 0;
	private Image img;

	private static final String ICON = "./assets/NormalZombie.png";

	public Zombie(String kind, int x, int y, int kindNum){
		super(Zombie.ICON,x,y);
		this.xPos = x;
		this.yPos = y;
		this.kindofZombie = kind;
		this.lifePoints = 100;
		this.damagePoints = 5;
		this.zombieID = Zombie.PopulationCheck;
		Zombie.PopulationCheck++;
		officialKind = kindNum;
	}

	public void eatPlant(Plants plant){
		plant.attackedPlant(this.damagePoints);
	}

	public void eatPlayer(Player player){
		player.setLife();
	}

	public void damageZombie(int hitpoints){
		this.lifePoints -= hitpoints;
	}

	public int getLifePoints(){
		return this.lifePoints;
	}

	public int getDamagePoints(){
		return this.damagePoints;
	}

	public int getZombieID(){
		return this.zombieID;
	}

	public String getKindOfZombie(){
		return this.kindofZombie;
	}

	public void walk(){
		while (this.xPos > 230){
			System.out.println("\nI am walking.... I am Zombie number " + this.zombieID);
			this.decxPos(5);
			System.out.println("MIGHAAAAAAAAAAD hehe " + this.xPos);
			this.repaint();
			try{
				Thread.sleep(r.nextInt(5)*1000);
			}catch(Exception e){

			}
		}
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		try {
			if (this.officialKind == 0){
				img = ImageIO.read(new File("./assets/NormalZombie.png"));	
			}else if (this.officialKind == 1){
				img = ImageIO.read(new File("./assets/ConeZombie.png"));
			}else{
				img = ImageIO.read(new File("./assets/FlagZombie.png"));
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Graphics2D g2d = (Graphics2D)g;
		g.drawImage(img, xPos,yPos,70,75,null);
		Toolkit.getDefaultToolkit().sync();
	}


	@Override
	public void run(){
		while (this.lifePoints != 0){
			this.walk();
		}
		try{
			Thread.sleep(1000);		
		}catch(Exception e){
			System.out.println("nono");
		}
	}

	public int getXPos(){
		return this.xPos;
	}

	public int getYPos(){
		return this.yPos;
	}
}