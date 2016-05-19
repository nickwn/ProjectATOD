package apcs.atod.entity;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

public class AI extends Entity 
{

	static Model model = EntityUtils.loadModel("core/assets/repeatinglandscape/repeatinglandscape.g3db");
	private double speed;
	private double damage;
	private double hp;
	private double rof;
	private Vector3 endPosition;

	/*
	public AI(double s, double d, Vector3 initPos, Vector3 endPos) {
		
		speed = s;
		damage = d;
		hp = 10;
		endPosition = endPos;
		pos = initPos;
		// random hitpoints generated
		// for each AI
	}
	*/
	
	public void setup() 
	{
		// TODO Auto-generated method stub
		// hello
		//change x y and z coordinates to whatever
		modelInstance = new ModelInstance(model, 0f,0f,0f);
	}
	
	public void dispose() 
	{
		model.dispose();
	}
	
	public void update() 
	{
		
		// this.getPosition().lerp(endPosition, 1f);
	}
	
	public double getHealth()
	{
		return hp;
	}
	
	public void removeHealth()
	{
		hp -= 1;
	}
	
	private void die()
	{
		//fall to the ground
		pos.lerp(new Vector3((pos.x / 2) - pos.x, 0 - pos.y, 0), 1f);
	}
	
	private void dodge1()
	{
		// do cool dodge maneuver
		
	}
	
	private void dodge2()
	{
		//do cool dodge maneuver
	}
	
	private void flyTowardsPlayer()
	{
		// fly towards the player
	}

}
