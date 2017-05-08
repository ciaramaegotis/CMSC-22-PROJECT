class Zombie implements Runnable{
	private String normalZombie = "Normal Zombie";
	private String coneZombie = "Cone Zombie";
	private String flagZombie = "Flag Zombie";
	private String kindofZombie;
	private int lifePoints;
	private int damagePoints;
	private static int zombieID = 0;

	public Zombie(String kind){
		this.kindofZombie = kind;
		this.lifePoints = 100;
		this.damagePoints = 5;
		this.zombieID = Zombie.zombieID + 1;
		Zombie.zombieID++;
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
		System.out.println("I am walking....." + this.zombieID);
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			
		}
	}

	@Override
	public void run(){
		try{
			while (this.lifePoints != 0){
				this.walk();
				Thread.sleep(1000);
			}
		}catch(Exception e){

		}
	}
}