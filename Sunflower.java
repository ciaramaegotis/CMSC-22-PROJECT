class Sunflower extends Plants{
	int Sunpoints;

	public Sunflower(String name){
		super(name);
		this.setLifePoints(50);
		this.Sunpoints = 0;
	}

	public void giveSun(){
		//give Sun
		this.Sunpoints += 25;
	}

	public void expireSun(){
		this.Sunpoints -= 25;
	}
}