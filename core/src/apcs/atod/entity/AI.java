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
	private int caseNum = 3;
	private
	int finishManuever = 1;
	private int y = 2;
	private float rotation;

	public AI(Vector3 pos) 
	{
		super(pos);
	}
	
	public void setup() 
	{
		modelInstance = new ModelInstance(model, pos);
		speed = Math.random() * 5;
		damage = 1;
		hp = 1;
		rof = 1;
		caseNum = 0;
		rotation = 20f;
		finishManuever = 0;
		ArrayList<Entity> list = worldInfo.getEntities();
		for (Entity e : list)
			if (e instanceof Player)
				target = (Player)e;
	}
	
	public void update() 
	{
		if (hp > 0)
		{
			if (finishManuever == 0)
				caseNum = (int) (1 + Math.random() * 14);

			finishManuever++;
			switch(caseNum)
			{
			case 1 :
				dodge1(finishManuever);
				break;
			case 2 :
				dodge2(finishManuever);
				break;
			case 3 :
				dodge3(finishManuever);
				break;
			case 4 : case 11: case 12:
				dodge4(finishManuever);
				break;
			case 5 : case 13: case 14:
				dodge5(finishManuever);
				break;
			case 6 : case 10 :
				dodge6(finishManuever);
				break;
			case 7 :
				dodge7(finishManuever);
				break;
			case 8 :
				dodge8(finishManuever);
				break;
			case 9 : 
				dodge9(finishManuever);
				break;
			}
			
			int case1 = (int) (1 + Math.random() * 100);
			if (case1 < 30 && finishManuever < 20)
			{
				target.removeHealth();
				BulletLine bulletLine = new BulletLine(modelInstance.transform.getTranslation(new Vector3()), target.getModelInstance().transform.getTranslation(new Vector3()));
				bulletLine.setWorldInfo(worldInfo);
				bulletLine.setup();
				worldInfo.getEntities().add(bulletLine);
			}
		}
		else
			die(finishManuever);

	}
	
	public void dispose()
	{
		ArrayList<Entity> ais = new ArrayList<Entity>();
		for(Entity e: worldInfo.getEntities())
			if(e instanceof AI)
				ais.add(e);
		if(ais.size()==1)
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
	
	private void die(int x)
	{
		if (x < 100)
			modelInstance.transform.translate(new Vector3(0f, -10f, 10f));
		else
			this.dispose();
	}
	
	private void dodge1(int x)
	{
		if (x < 50)
			flyTowardsPlayer();
		else if(x < 100)
		{
			bankLeft();
			doABarrelRoll();
		}
		else if (x < 150)
		{
			flyBackwards();
		}
		else if( x < 200)
		{
			finishManuever = 0;
		}
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
			finishManuever = 0;

	}
	private void dodge4 (int x)
	{
		if (x > 0 && x < 10)
		{
			modelInstance.transform.rotate(0,0,1,-10);
		}
		if(x > 10 && x < 55)
		{
			modelInstance.transform.rotate(1,0,0,-5);
			modelInstance.transform.translate(new Vector3(0,40,50));
		}
		if(x > 55 && x < 70)
		{
			modelInstance.transform.rotate(1,0,0,-10);
			modelInstance.transform.translate(new Vector3(0,10,70));
		}
		if(x > 70 && x < 80)
		{
			modelInstance.transform.rotate(0,0,1,10);
			modelInstance.transform.translate(new Vector3(0,0,85));
		}
		if (x >= 80)
			finishManuever = 0;
	}
	private void dodge5 (int x)
	{
	if (x > 0 && x < 10)
	{
		modelInstance.transform.rotate(0,0,1,10);
	}
	if(x > 10 && x < 55)
	{
		modelInstance.transform.rotate(1,0,0,-5);
		modelInstance.transform.translate(new Vector3(0,40,50));
	}
	if(x > 55 && x < 70)
	{
		modelInstance.transform.rotate(1,0,0,-10);
		modelInstance.transform.translate(new Vector3(0,10,70));
	}
	if(x > 70 && x < 80)
	{
		modelInstance.transform.rotate(0,0,1,-10);
		modelInstance.transform.translate(new Vector3(0,0,85));
	}
	if (x >= 80)
		finishManuever = 0;
}
	
	private void dodge6(int x)
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
		if(x > 60 && x < 70)
		{
			modelInstance.transform.translate(new Vector3(0,0,85));
		}
		if (x >= 70)
		{
			finishManuever = 0;
		}
	}
	
	private void dodge7(int x)
	{
		if (x < 50)
			flyTowardsPlayer();
		else if (x < 104)
		{
			down();
			doABarrelRoll();
		}
		else if (x < 200)
		{
			flyBackwards();
		}
		else
			finishManuever = 0;
	}
	
	private void dodge8(int x)
	{
		if (x < 50)
			flyTowardsPlayer();
		else if (x < 104)
		{
			bankLeft();
			doABarrelRoll();
		}
		else if (x < 200)
		{
			flyBackwards();
		}
		else
			finishManuever = 0;
	}
	
	private void dodge9(int x)
	{
		if (x < 50)
			flyTowardsPlayer();
		else if (x < 104)
		{
			bankRight();
			reverse();
		}
		else if (x < 200)
		{
			flyBackwards();
		}
		else
			finishManuever = 0;
	}
	private void doABarrelRoll(int x)
	{
		if (x < 43)
			modelInstance.transform.rotate(pos.Z, rotation);
		else
			finishManuever = 0;
	}
	
	private void doABarrelRoll()
	{
		modelInstance.transform.rotate(pos.Z, rotation);
	}
	
	private void flyTowardsPlayer()
	{
		modelInstance.transform.translate(new Vector3(0f, 0f, 10f));
	}
	private void flyBackwards()
	{
			modelInstance.transform.translate(new Vector3(0f, 0f, -10f));
	}
	
	private void bankUp()
	{
		modelInstance.transform.translate(new Vector3(0f, 20f, 10f));
	}
	
	private void down()
	{
		modelInstance.transform.translate(new Vector3(0f, -20f, 10f));
	}
	
	private void bankLeft()
	{
		modelInstance.transform.translate(new Vector3(20f, 0f, 10f));
	}
	
	private void bankRight()
	{
		modelInstance.transform.translate(new Vector3(-20f, 0f, 10f));
	}
	
	private void turn()
	{
		modelInstance.transform.rotate(0,2,1,-5);
		modelInstance.transform.translate(new Vector3(0f, 0f, 15f));
	}
	
	private void flyForward()
	{
		modelInstance.transform.translate(new Vector3(0f, 0f, 50f));
	}
	
	private void reset(int x)
	{
		if (x < 140)
			turn();
		else if (x < 164)
			flyForward();
		else
			turn();
	}
	private void reverse()
	{
		modelInstance.transform.rotate(pos.Z, -rotation);
	}
}

