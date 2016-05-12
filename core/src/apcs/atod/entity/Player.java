
package apcs.atod.entity;

public class Player extends Character {
	private double speed;
	private double damage;
	private double hp;

	public Player(double s, double d) {
		speed = s;
		damage = d;
		hp = 10.0;
	}
}

