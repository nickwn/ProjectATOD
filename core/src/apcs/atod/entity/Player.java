package apcs.atod.entity;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;

public class Player extends Entity 
{
	static Model model = EntityUtils.loadModel("core/assets/fighterplane/fighterplane.g3db");
	private double speed;
	private double damage;
	private double hp;
	private static double rof;
	private double score;
	private long time = System.nanoTime();
	//private static final Vector3 rayFrom = new Vector3();
	//private static final Vector3 rayTo = new Vector3();
	//private static final ClosestRayResultCallback callback = new ClosestRayResultCallback(rayFrom, rayTo);

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
		hp = 10;
		rof = 1;
		score = 0;
		//pos = new Vector3(1f, 1f, 1f); //will fix this later
	}

	public void update() 
	{
		// TODO Auto-generated method stub
		
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
	/*
	public void shoot()
	{
		Camera cam = WorldInfo.getCamera();
		Ray ray = new Ray(pos, cam.position);
	}
	*/
}
