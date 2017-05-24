import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.*;
import javax.swing.JPanel;

public class HomePanel extends JPanel{
	private JPanel top = new JPanel();
	private JPanel center = new JPanel();
	private JPanel bottom = new JPanel();
	private Stage gameStage;
	private BufferedImage image;
	ControlPanel panel;
	
	public HomePanel(ControlPanel panel) {
		this.panel = panel;
		try {
            image = ImageIO.read(new File("./assets/menu.png"));

          } catch (IOException ioe) {
            System.out.println(ioe.getMessage()); 
          }
		

		top.setPreferredSize(new Dimension(900,100));
		center.setPreferredSize(new Dimension(300,400));
		bottom.setPreferredSize(new Dimension(700,360));
		
		top.setOpaque(false);
		center.setOpaque(false);
		bottom.setOpaque(false);

		ImageIcon image = new ImageIcon("./assets/b1.png");
		JButton startAdventure = new JButton();
		startAdventure.setIcon(image);
		startAdventure.setBorder(BorderFactory.createEmptyBorder());
		startAdventure.setContentAreaFilled(false);
		//startAdventure.setBounds(1000, 5000, 200, 100);

		

		//startAdventure.setLocation(1000, 400);

		ImageIcon image1 = new ImageIcon("./assets/b2.png");
		JButton load = new JButton();
		load.setIcon(image1);
		load.setBorder(BorderFactory.createEmptyBorder());
		load.setContentAreaFilled(false);
		//startAdventure.setBounds(1100, 2000, 200, 100);

		ImageIcon image2 = new ImageIcon("./assets/b3.png");
		JButton credits = new JButton();
		credits.setIcon(image2);
		credits.setBorder(BorderFactory.createEmptyBorder());
		credits.setContentAreaFilled(false);

		ImageIcon image3 = new ImageIcon("./assets/b4.png");
		JButton help = new JButton();
		help.setIcon(image3);
		help.setBorder(BorderFactory.createEmptyBorder());
		help.setContentAreaFilled(false);

		ImageIcon image4 = new ImageIcon("./assets/b5.png");
		JButton quit = new JButton();
		quit.setIcon(image4);
		quit.setBorder(BorderFactory.createEmptyBorder());
		quit.setContentAreaFilled(false);

		

		// JTextField nameField = new JTextField("Enter your name", 30);
		// Font font = new Font("Courier", Font.BOLD,20);
		// nameField.setForeground(Color.GREEN);
		// nameField.setFont(font);
		// nameField.setOpaque(false);


		// JButton enterName = new JButton("Enter");

		
		//this.add(bg);


		center.add(startAdventure);
		center.add(load);
		center.add(help);
		center.add(credits);
		center.add(quit);
		// bottom.add(nameField);
		// bottom.add(enterName);


		

		startAdventure.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			// CardLayout c = (CardLayout) Project.cards.getLayout();
			// c.add(new MyFrame());
			// c.show(Project.cards, Project.GAMEPANEL);
			// Project.cards.add(c, "New Game");
			String name = JOptionPane.showInputDialog("Hi! Enter your name:");
			 MyFrame frame = new MyFrame();
			// gameCard = new GameCard(null,"GG.png");
			// Project.cards.add(gameCard, "New Game");
			// CardLayout c = (CardLayout) Project.cards.getLayout();
			// c.show(Project.cards, Project.GAMEPANEL);
			// gameCard.getBattleField().setPaused(false);
		}
	});

		// enterName.addActionListener(new ActionListener(){
		// 	public void actionPerformed(ActionEvent e){
		// 		String textFieldValue = nameField.getText();
		// 		//panel.setPlayer(new Player(textFieldValue));
		// 		//set the name to the player		
		// 	}
		// });

	
		quit.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e)  {
				System.exit(0);
			}
		});

		this.add(top,BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		//this.add(bottom, BorderLayout.SOUTH);
}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	     //this is the image
	     g.drawImage(image,0,0,null);
	}

	public void setAdd(JLabel label, String position){
		this.add(label, position);
	}


}
