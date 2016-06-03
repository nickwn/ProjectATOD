
package apcs.atod.entity;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;

import apcs.atod.world.WorldInfo;

public abstract class Entity 
{
	protected Vector3 pos;
	protected Vector3 rot;
	protected ModelInstance modelInstance;
	protected WorldInfo worldInfo;
	//protected static Model model;
	
	public Entity(Vector3 pos)
	{
		this.pos = pos;
	}
	
	public abstract void setup();
	
	public abstract void update();
	
	public void setPosition(Vector3 newPos)
	{
		pos = newPos;
	}
	
	public void setWorldInfo(WorldInfo worldInfo)
	{
		this.worldInfo = worldInfo;
	}
	
	public Vector3 getPosition()
	{
		return pos;
	}
	
	public ModelInstance getModelInstance()
	{
		return modelInstance;
	}
	
	public abstract void dispose();
}

