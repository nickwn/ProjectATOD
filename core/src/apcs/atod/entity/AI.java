package apcs.atod.entity;

public class AI extends Character {
	private double speed;
	private double damage;
	private double hp;

	public AI(double s, double d) {
		speed = s;
		damage = d;
		hp = EntityUtils.generateRandomNum(10); // random hitpoints generated
												// for each AI
	}

}
