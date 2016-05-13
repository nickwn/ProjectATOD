package apcs.atod.entity;

import com.badlogic.gdx.graphics.g3d.Model;

public class Player extends Entity {
	static Model model = EntityUtils.loadModel("");
	private double speed;
	private double damage;
	private double hp;

	public Player(double s, double d) {
		speed = s;
		damage = d;
		hp = 10.0;
	}

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
