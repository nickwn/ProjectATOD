package apcs.atod.world;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

import apcs.atod.entity.*;

/**
 * Class containing information about the world. Passed to all entities.
 *
 */
public class WorldInfo {
	private ArrayList<Entity> entities;
<<<<<<< HEAD

	public ArrayList<Entity> getEntityList() {
		return entities;
	}

	public Entity getInstanceOf(Class c) {
=======
	
	public <T> T getInstanceOf()
	{
		for(Entity e: entities)
			if(e instanceof ParameterizedType)
				return (T)e;
>>>>>>> 7bd5d4b9a2c673aa75d2a1276f533a4b8e390dae
		return null;
	}

	public Entity getInstancesOf(Class c) {
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
