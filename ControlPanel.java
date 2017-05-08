import java.util.Random;

class ControlPanel{
	ZombieGenerator zombieGenerator;
	private Player player;
	private final int numberOfZombies = 50;

	public void setPlayer(Player player){
		this.player = player;
		this.zombieGenerator = new ZombieGenerator();
	}

	public void startGame(){
		int counter = 0;
		int zombieCreated = 0;
		Random r = new Random();
		try{
			while (this.player.isLife() == true){
				zombieGenerator.produceNormalZombie();
				Thread.sleep(1000);
			}
		}catch(Exception e){

		}
	}
}