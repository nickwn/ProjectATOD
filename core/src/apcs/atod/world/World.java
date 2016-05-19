package apcs.atod.world;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;
import apcs.atod.entity.*;
import apcs.atod.render.*;

/**
 * Controls the game world. Contains a list of entities and renderers and is
 * responsible for setting them up, updating them, and rendering them (if
 * needed).
 *
 */
public class World {

	private ArrayList<Entity> entities;
	private WorldInfo worldInfo;
	private EntityRenderer entityRenderer;
	private HUDRenderer hudRenderer;

	public World()
	{
		
	}
	
	/*
	public void removeEntity()
	{
		for (Entity e : entities)
		{
			if (e instanceof AI && ((AI)e).getHealth() <= 0)
				entities.remove(e);
			else if (e instanceof Player && ((Player)e).getHealth() <= 0)
				entities.remove(e); //also do end screen, murder the player in cold blood
		}
	}
	 */
	
	public void create(ArrayList<Entity> ents, EntityRenderer er, HUDRenderer hr, Camera camera) 
	{
		entities = ents;
		entityRenderer = er;
		hudRenderer = hr;
		
		worldInfo = new WorldInfo(entities, hudRenderer, camera);
		
		for(Entity ent: entities)
			ent.setup();
		
		er.setup(worldInfo);
		hr.init();
	}

	public void dispose() 
	{
		entityRenderer.dispose();
		for(Entity ent: entities)
			ent.dispose();

	}

	public void pause() 
	{
		// TODO Auto-generated method stub

	}

	public void render()
	{
		entityRenderer.render();
		
		//loop through all the entities
		//if player and dead:
		//	if hudRenderer.retryScreen() (non-blocking function - don't wait for input to continue, returns true if space pressed)
		//		reset world (re-setup entities, renderers, etc)
		//else if ai and dead:
		//	entities.remove current index
		//else
		//	update
		
		/*
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT))
		{
			//call shoot
			Thread.sleep((long) Player.getrof());
		}
		*/
	}

	public void resize(int arg0, int arg1) 
	{
		// TODO Auto-generated method stub

	}

	public void resume() 
	{
		// TODO Auto-generated method stub

	}

}
