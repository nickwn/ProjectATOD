package apcs.atod.world;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import apcs.atod.entity.*;
import apcs.atod.render.Camera;
import apcs.atod.render.HUDRenderer;

/**
 * Class containing information about the world. Passed to all entities.
 *
 */
public class WorldInfo 
{
	private ArrayList<Entity> entities;
	private HUDRenderer hud;
	private Camera camera;

	public WorldInfo(ArrayList<Entity> entities, HUDRenderer hud, Camera camera)
	{
		this.entities = entities;
		this.hud = hud;
		this.camera = camera;
	}

	public Entity getInstanceOf(Class c) 
	{
		for(Entity ent: entities)
			if(c.isInstance(ent))
				return ent;
		return null;
	}

	public ArrayList<Entity> getInstancesOf(Class<?> c) 
	{
		ArrayList<Entity> arr = new ArrayList<Entity>();
		for(Entity ent: entities)
		{
			if(c.isInstance(ent));
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
		return camera;
	}
	
	public HUDRenderer getHUDRenderer()
	{
		return hud;
	}
}
