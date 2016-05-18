package apcs.atod.world;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import apcs.atod.entity.*;

/**
 * Class containing information about the world. Passed to all entities.
 *
 */
public class WorldInfo {
	private ArrayList<Entity> entities;

	public ArrayList<Entity> getEntityList() {
		return entities;
	}

	public Entity getInstanceOf(Class c) {
		int ind = entities.indexOf(c);
		if (ind < 0)
			return null;
		return entities.get(ind);
	}

	public ArrayList<Entity> getInstancesOf(Class c) {
		ArrayList<Entity> arr = new ArrayList<Entity>();
		Iterator<Entity> iter = entities.iterator();
		while (iter.hasNext())
		{
			Entity ent = iter.next();
			if (ent instanceof c)
				arr.add(ent);
		}
		return arr;
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
