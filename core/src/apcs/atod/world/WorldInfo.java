package apcs.atod.world;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

import apcs.atod.entity.*;
import apcs.atod.render.*;

/**
 * Class containing information about the world. Passed to all entities.
 *
 */
public class WorldInfo {
	private ArrayList<Entity> entities;
	private Camera camera;

	public Entity getInstanceOf(Class c)
	{
		for(Entity e: entities)
			if(c.isInstance(e))
				return e;
		return null;
	}
	
	public ArrayList<Entity> getInstancesOf(Class c)
	{
		ArrayList<Entity> arr = new ArrayList<Entity>();
		for(Entity e: entities)
			if(c.isInstance(e))
				arr.add(e);
		return arr;
	}

	public ArrayList<Entity> getEntities()
	{
		return entities;
	}
	
	public Camera getCamera()
	{
		return camera;
	}
	
}
