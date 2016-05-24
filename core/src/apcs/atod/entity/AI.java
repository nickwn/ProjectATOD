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

	private int FinishManuever;
	private int x = 2;
	private float rotation = 0;

	
	public AI(Vector3 pos) 
	{
		super(pos);
		// TODO Auto-generated constructor stub
		
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
		
		rotation = 3f;
		//pos = new Vector3(1f, 1f, 1f); //will fix this later
		//endPosition = new Vector3(-1f, -1f, -1f); //same
		//target = worldInfo.getInstanceOf(Player);
	}
	
	public void update() 
	{


		dodge2(FinishManuever);
		FinishManuever++;


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
	
	private void dodge1(int x)
	{

		modelInstance.transform.rotate(0, 0, 1,(5));

	}
	
	private void dodge2(int x)
	{

		if(x > 0 && x < 5)
			{
				modelInstance.transform.rotate(0, 0, 1,-5);
			}
		if(x > 5 && x < 50)
			{
				modelInstance.transform.translate(new Vector3(10,4,0));
			}
		if(x > 50 && x < 60)
			{
				modelInstance.transform.rotate(0, 0, 1,5);
			}
		if(x > 60 && x < 105)
			{
				modelInstance.transform.translate(new Vector3(-10,4,0));
			}
		if(x > 105 && x < 110)
			{
				modelInstance.transform.rotate(0, 0, 1,-5);
			}

	}
	
	private void doABarrelRoll(int x)
	{

		modelInstance.transform.rotate(pos.Z, rotation);
		//rotation+= 2;
		//mostly works

	}
	
	private void flyTowardsPlayer()
	{
		// fly towards the player
		
		
			modelInstance.transform.translate(new Vector3(0f, 0f, 10f));
			//modelInstance.transform.rotate(pos.Z, rotation);
		
		
		//pos.lerp(pos.add(target.getPosition()), 1f); //change to where we will actually put player
	}

}
