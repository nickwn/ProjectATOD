package apcs.atod.entity;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.math.*;

public class AI extends Entity {

	static Model model = EntityUtils.loadModel("");
	private double speed;
	private double damage;
	private double hp;
	private double rof;
	private Vector3 endPosition;

	public AI(double s, double d, Vector3 initPos, Vector3 endPos) {
		
		speed = s;
		damage = d;
		hp = 10;
		endPosition = endPos;
		pos = initPos;
		// random hitpoints generated
		// for each AI
	}

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		// hello
		setPosition(this.pos);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.getPosition().lerp(endPosition, 1f);
		
	}
	
	public double getHealth()
	{
		return hp;
	}
	
	public void removeHealth()
	{
		hp -= 1;
	}

}
