


import javax.swing.JFrame;
import java.awt.*;
import java.util.Random;

class MainChenes{
	public static void main(String []args){
		Random r = new Random();
		JFrame frame = new JFrame("Testing");
		frame.setPreferredSize(new Dimension(1000,1000));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(null);
		int i, j,k, starty = 50;
		for (i = 0; i < 5; ++i){
			k = r.nextInt(3);
			System.out.println(k + " is the randomized number.");
			if (k == 0){
				Sunflower flower = new Sunflower("./assets/sunflower.png", 150, starty, "Sunflower");
				frame.add(flower);
				Thread thread = new Thread(flower);
				thread.start();
			}else if (k == 1){
				Peashooter flower = new Peashooter("./assets/peashooter.png", 150, starty, "Peashooter");
				frame.add(flower);
				Thread thread = new Thread(flower);
				thread.start();
			}else{
				Potato flower = new Potato("./assets/potato.png", 150, starty, "Potato");
				frame.add(flower);
				Thread thread = new Thread(flower);
				thread.start();
			}
			starty +=  130;
		}

		starty = 50;
		for (i = 0; i < 5; ++i){
			k = r.nextInt(3);
			System.out.println(k + " is the randomized number.");
			if (k == 0){
				Zombie flower = new Zombie("Normal Zombie", 950, starty, 0);
				frame.add(flower);
				Thread thread = new Thread(flower);
				thread.start();
			}else if (k == 1){
				Zombie flower = new Zombie("Cone Zombie", 950, starty, 1);
				frame.add(flower);
				Thread thread = new Thread(flower);
				thread.start();
			}else{
				Zombie flower = new Zombie("Flag Zombie", 950, starty, 2);
				frame.add(flower);
				Thread thread = new Thread(flower);
				thread.start();
			}
			starty +=  130;
		}
		

		frame.pack();
		frame.setVisible(true);
	}
}