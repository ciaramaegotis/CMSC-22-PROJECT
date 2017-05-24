class Peashooter extends Plants implements Runnable{
	int damagePoints;
	Pea pea;

	public Peashooter(String fname, int xPos, int yPos, String name){
		super(fname, xPos, yPos, name);
		this.setLifePoints(50);
		this.damagePoints = 5;
	}

	public Zombie nearZombieChecker(){
		return null;
	}

	public void shootZombie(){		//Zombie zombie parameter
		//zombie.damageZombie(this.damagePoints);
		pea = new Pea("./assets/pea.png", this.xPos, this.yPos); 
		Thread thread = new Thread(pea);
		thread.start();
		try{
			thread.join();
		}catch(Exception e){

		}
	}

	@Override
	public void run(){
		while (this.getLifePoints() != 0){
			this.shootZombie();
			this.repaint();
		}		
	}
}