class Peashooter extends Plants{
	int damagePoints;

	public Peashooter(String name){
		super(name);
		this.setLifePoints(50);
		this.damagePoints = 5;
	}

	public void shootZombie(Zombie zombie){
		zombie.damageZombie(this.damagePoints);
	}
}