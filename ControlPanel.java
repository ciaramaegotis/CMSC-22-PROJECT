import java.util.Random;

class ControlPanel{
	private ZombieGenerator zombieGenerator;
	private Player player;
	private final int numberOfZombie = 50;
	private Stage stage;

	public ControlPanel(){
		this.zombieGenerator = new ZombieGenerator();
	}

	public void setPlayer(Player player){
		this.player = player;
	}

	public void startGame(){
		// Random r = new Random();
		// int initialZombie = 0;
		// initialZombie = r.nextInt(5) + 1;
		// System.out.println(initialZombie + " zombies has been produced by the Zombie Generator (indicator lang to)");
		// while (this.player.isLife() == true){
		// 	int counter = 0;
		// 	while (counter < initialZombie){
		// 		this.zombieGenerator.produceNormalZombie();
		// 		counter += 1;
		// 	}
		// 	this.player.setLife();
		// }
		this.stage = new Stage();
	}
}