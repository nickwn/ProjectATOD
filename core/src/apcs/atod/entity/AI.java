package apcs.atod.entity;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import java.util.*;

public class AI extends Entity 
{

	

	public static Model model = EntityUtils.loadModel("core/assets/fighterplane/fighterplane.g3db");
	private double speed;
	private double damage;
	private double hp;
	private double rof;
	private Player target;
	private Vector3 endPosition;
	
	public AI(Vector3 pos) 
	{
		super(pos);
		// TODO Auto-generated constructor stub
		//doABarrelRoll();
		//flyTowardsPlayer();
	}
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
		modelInstance = new ModelInstance(model, pos);
		speed = Math.random() * 5;
		damage = 1;
		hp = Math.random() * 10;
		rof = 1;
		//pos = new Vector3(1f, 1f, 1f); //will fix this later
		endPosition = new Vector3(-1f, -1f, -1f); //same
		//target = worldInfo.getInstanceOf(Player);
	}
	
	public void update() 
	{
		
		// this.getPosition().lerp(endPosition, 1f);
		die();
	}
	
	public void dispose()
	{
		if(worldInfo.getInstancesOf(AI.class).size()==1)
			model.dispose();
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
		//pos.lerp(new Vector3((pos.x / 2) - pos.x, 0 - pos.y, 0), 1f);
		//get x, y, and z values and use in Matrix4
		modelInstance.transform.translate(new Vector3(0f, -10f, 10f));
	}
	
	private void dodge1()
	{
		// do cool dodge maneuver
		
	}
	
	private void dodge2()
	{
		//do cool dodge maneuver
	}
	
	private void doABarrelRoll()
	{
		modelInstance.transform.setToRotation(Vector3.X, 0.12f);
	}
	
	private void flyTowardsPlayer()
	{
		// fly towards the player
		modelInstance.transform.translate(new Vector3(0f, 0f, 10f));
		//pos.lerp(pos.add(target.getPosition()), 1f); //change to where we will actually put player
	}

}
