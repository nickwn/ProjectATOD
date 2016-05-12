package apcs.atod.world;

import java.util.ArrayList;

import apcs.atod.entity.*;

/**
 * Class containing information about the world. Passed to all entities.
 *
 */
public class WorldInfo 
{
	private ArrayList<Entity> entities;
	
	public Entity getInstanceOf(Class c)
	{
		return null;
	}
	
	public Entity getInstancesOf(Class c)
	{
		return null;
	}
	
	public Camera getCamera()
	{
		for(Entity e: entities)
			if(e instanceof Camera)
				return (Camera)e;
		return null;
	}
}
