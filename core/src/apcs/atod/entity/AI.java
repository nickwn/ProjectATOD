package apcs.atod.entity;

import com.badlogic.gdx.graphics.g3d.Model;

public class AI extends Entity {

	static Model model = EntityUtils.loadModel("");
	private double speed;
	private double damage;
	private double hp;

	public AI(double s, double d) {
		speed = s;
		damage = d;
		hp = 10;
		// random hitpoints generated
		// for each AI
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
