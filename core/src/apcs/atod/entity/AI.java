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

	private int finishManuever;
	private int x = 2;
	private float rotation;
	private int l = 0;
	private int m = 0;
	private int n = 0;

	
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
		hp = Math.random() * 10 + 10;
		rof = 1;
		rotation = 3f;
		finishManuever = 0;
		//pos = new Vector3(1f, 1f, 1f); //will fix this later
		//endPosition = new Vector3(-1f, -1f, -1f); //same
		//target = worldInfo.getInstanceOf(Player);
	}
	
	public void update() 
	{

		if (hp > 0)
		{
			dodge5(finishManuever);
			finishManuever++;
			//int caseNum = (int) (Math.random() * 5);
			
			//switch(caseNum)
			//{
			//case 0 :
			//	flyTowardsPlayer();
			//	break;
			//case 1 :
			//	doABarrelRoll(finishManuever);
			//}

		}
		else
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
		if (x >= 110)
			finishManuever = 0;

	}
	private void dodge3(int x)
	{

		if(x > 0 && x < 5)
			{
				modelInstance.transform.rotate(0, 0, 1, 5);
			}
		if(x > 5 && x < 50)
			{
				modelInstance.transform.translate(new Vector3(-10,4,0));
			}
		if(x > 50 && x < 60)
			{
				modelInstance.transform.rotate(0, 0, 1,-5);
			}
		if(x > 60 && x < 105)
			{
				modelInstance.transform.translate(new Vector3(10,4,0));
			}
		if(x > 105 && x < 110)
			{
				modelInstance.transform.rotate(0, 0, 1,5);
			}
		if (x >= 110)
		{
			finishManuever = 0;
		}
	}
	private void dodge4 (int x)
	{
		if(x > 0 && x < 45)
		{
			modelInstance.transform.rotate(1,0,0,-5);
			modelInstance.transform.translate(new Vector3(0,40,50));
		}
		if(x > 45 && x < 60)
		{
			modelInstance.transform.rotate(1,0,0,-10);
			modelInstance.transform.translate(new Vector3(0,10,70));
		}
		if (x >= 110)
		{
			finishManuever = 0;
		}
	}
	private void dodge5 (int x)
	{
		if (x > 0 && x < 50)
		{
			modelInstance.transform.translate(new Vector3(l,m,n));
			modelInstance.transform.rotate(pos.Z,90);
			switch(x % 4)
			{
			case 0:
				l += 10;
				m += 10;
			case 1:
				m -= 10;
				l += 10;
			case 2:
				l -= 10;
				m -= 10;
			case 3:
				m += 10;
				l -= 10;
			}
			
		}
		else
			finishManuever = 0;
	}
	
	private void doABarrelRoll(int x)
	{
		
	}
	
	private void flyTowardsPlayer()
	{
		// fly towards the player
		modelInstance.transform.translate(new Vector3(0f, 0f, 10f));
	}

}
