package apcs.atod.entity;

import java.util.ArrayList;

import apcs.atod.render.Camera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;

public class Player extends Entity 
{
	static Model model = EntityUtils.loadModel("core/assets/fighterplane/fighterplane.g3db");
	private double speed;
	private double damage;
	private double hp;
	private static double rof;
	private double score;
	private long time = System.nanoTime();
	private Camera camera;
	
/*
	public Player(double s, double d, double rateoffire, Vector3 initPos) 
	{
		rof = rateoffire;
		speed = s;
		damage = d;
		hp = 10.0;
		pos = initPos;
		score = 0;
	}
*/
	
	public Player(Vector3 pos) 
	{
		super(pos);
		// TODO Auto-generated constructor stub
	}
	
	public static double getrof()
	{
		return rof;
	}
	public void setup() 
	{
		// TODO Auto-generated method stub
		modelInstance = new ModelInstance(model, pos);
		speed = Math.random() * 5;
		damage = 1;
		hp = 100;
		rof = 1;
		score = 0;
		//pos = new Vector3(1f, 1f, 1f); //will fix this later
		camera = worldInfo.getCamera();
	}

	public void update() 
	{
		ArrayList<Entity> ais = new ArrayList<Entity>();
		Entity hit;
		for(Entity e: worldInfo.getEntities())
			if(e instanceof AI)
				ais.add(e);
		if(Gdx.input.isTouched())
		{
			hit = EntityUtils.raycastHasHit(modelInstance.transform.getTranslation(new Vector3()), camera.getDirection(), ais, worldInfo.getCamera());
			if(hit != null)
			{
				((AI)hit).removeHealth();
				System.out.println(((AI)hit).getHealth());
				score += 100;
				worldInfo.getHUDRenderer().setScore((int)score);
			}
		}
		
		worldInfo.getHUDRenderer().setHealth((int)hp);
		
	}
	
	public void dispose()
	{
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
	
	public void addToScore()
	{
		score++;
	}
	
	public double getScore()
	{
		return score;
	}
	public boolean canfire()
	{
		if(System.nanoTime() + rof == time)
		{
			time = System.nanoTime();
			return true;
		}
		else 
			return false;
	}
}
