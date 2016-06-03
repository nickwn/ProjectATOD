package apcs.atod.entity;

import java.util.ArrayList;

import apcs.atod.render.Camera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;

public class Player extends Entity 
{
	private static Model model = EntityUtils.loadModel("core/assets/fighterplane/fighterplane.g3db");
	private double speed;
	private double damage;
	private int hp;
	private static double rof;
	private double score;
	private Camera camera;
	private boolean isShooting;
	
	public Player(Vector3 pos) 
	{
		super(pos);
	}
	
	public static double getrof()
	{
		return rof;
	}
	public void setup() 
	{
		modelInstance = new ModelInstance(model, pos);
		speed = Math.random() * 5;
		damage = 1;
		hp = 100;
		rof = 1;
		score = 0;
		camera = worldInfo.getCamera();
		isShooting = false;
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
			toggleShooting();
			hit = EntityUtils.raycastHasHit(modelInstance.transform.getTranslation(new Vector3()), camera.getDirection(), ais, worldInfo.getCamera());
			if(hit != null)
			{
				((AI)hit).removeHealth();
				System.out.println(((AI)hit).getHealth());
			}
		}
		else
		{
			isShooting = false;
			worldInfo.getHUDRenderer().setShooting(false);
		}
		worldInfo.getHUDRenderer().setHealth((int)hp);
		
	}
	
	public void dispose()
	{
		model.dispose();
	}
	
	private void toggleShooting()
	{
		isShooting = !isShooting;
		worldInfo.getHUDRenderer().setShooting(isShooting);
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
}
