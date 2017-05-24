
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.Random;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class Stage extends JPanel{
    Random r = new Random();
	 private Image image;
    private ArrayList<Zombie> arrayOfZombie;
    private ArrayList<Thread> arrayofThread;
    private ArrayList<Plants> arrayofPlants;
    private ArrayList<Thread> arrayofThread2;


    public Stage() {
        this.setLayout(new BorderLayout());
        arrayOfZombie = new ArrayList<Zombie>();
        int j = 0;
    
        JPanel warPanel = new JPanel();
        JPanel plantPanel = new JPanel();
        try {                
          image = ImageIO.read(new File("./assets/lawn.png"));
       } catch (IOException ex) {
            System.out.println("Ooops! Trouble Loading Image");
       }

       JLabel top = new JLabel();
       ImageIcon image1 = new ImageIcon("./assets/plantlist.png");
       JButton plantlist = new JButton();
        plantlist.setIcon(image1);
      plantlist.setBorder(BorderFactory.createEmptyBorder());
      plantlist.setContentAreaFilled(false);


       ImageIcon image2 = new ImageIcon("./assets/minimenu.png");
       JButton minimenu = new JButton();
       minimenu.setIcon(image2);
       minimenu.setBorder(BorderFactory.createEmptyBorder());
      minimenu.setContentAreaFilled(false);

      top.add(plantlist);
      top.add(minimenu);

      this.add(top,BorderLayout.NORTH);


       int starty = 50;
        this.setLayout(null);
        for (j = 0; j < 5; ++j){
            int kindOfZombie = r.nextInt(3);
            System.out.println(kindOfZombie + "hehe");
            if (kindOfZombie == 0){
                arrayOfZombie.add(new Zombie("Normal Zombie", 950, starty, 0));
            }else if (kindOfZombie == 1){
                arrayOfZombie.add(new Zombie("Cone Zombie", 950, starty, 1));
            }else{
                arrayOfZombie.add(new Zombie("Flag Zombie", 950, starty, 2));
            }
            starty += 107;
            this.add(arrayOfZombie.get(j));
            Thread thread = new Thread(arrayOfZombie.get(j));
            thread.start();
        }
        int i,k;
        starty = 50;
    for (i = 0; i < 5; ++i){
      k = r.nextInt(3);
      System.out.println(k + " is the randomized number.");
      if (k == 0){
        Sunflower flower = new Sunflower("./assets/sunflower.png", 175, starty, "Sunflower");
        this.add(flower);
        Thread thread = new Thread(flower);
        thread.start();
      }else if (k == 1){
        Peashooter flower = new Peashooter("./assets/peashooter.png", 175, starty, "Peashooter");
        this.add(flower);
        Thread thread = new Thread(flower);
        thread.start();
      }else{
        Potato flower = new Potato("./assets/potato.png", 175, starty, "Potato");
        this.add(flower);
        Thread thread = new Thread(flower);
        thread.start();
      }
      starty +=  110;
    }
    starty = 50;
    for (i = 0; i < 5; ++i){
        Pea flower = new Pea("./assets/pea.png", 170, starty);
        this.add(flower);
        Thread thread = new Thread(flower);
        thread.start();
      starty +=  110;
    }

    starty = 50;

    for (i = 0; i < 5; ++i){
        Mower flower = new Mower("./assets/mower.png", 130, starty);
        this.add(flower);
        Thread thread = new Thread(flower);
        thread.start();
      starty +=  110;
    }
       
        JLabel plantLabel = new JLabel("This is a label");
        plantPanel.add(plantLabel);
        this.add(warPanel, BorderLayout.CENTER);
        this.add(plantPanel, BorderLayout.CENTER);
        starty = 60;
        
    }
         @Override
        protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
         }
}
