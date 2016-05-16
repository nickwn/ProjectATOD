package apcs.atod.world;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

import apcs.atod.entity.*;

/**
 * Class containing information about the world. Passed to all entities.
 *
 */
public class WorldInfo 
{
	private ArrayList<Entity> entities;
	
	public <T> T getInstanceOf()
	{
		for(Entity e: entities)
			if(e instanceof ParameterizedType)
				return (T)e;
		return null;
	}
	
	public Entity getInstancesOf(Class c)
	{
		return null;
	}
	
	public ArrayList<Entity> getEntities()
	{
		return entities;
	}
	
	public Camera getCamera()
	{
		for(Entity e: entities)
			if(e instanceof Camera)
				return (Camera)e;
		return null;
	}
	
	public Player getPlayer()
	{
		for(Entity e: entities)
			if(e instanceof Player)
				return (Player)e;
		return null;
	}
}
