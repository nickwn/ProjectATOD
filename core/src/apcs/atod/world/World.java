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
	private Camera camera;
	private Player player1;
	private int score;

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
	
	private void setupWorld()
	{
		entities = new ArrayList<Entity>();
		Player player1 = new Player(Vector3.Zero);
		//player1.update();
		entities.add(player1);
		entities.add(new Landscape(new Vector3(0, -1000, 0)));
		entities.add(new Skybox(new Vector3(0,0,0)));
		for(int i = 0; i < 3; i++)
		{
			entities.add(new AI(new Vector3((i-1)*300, 0, -700)));
		}
		
		entityRenderer = new EntityRenderer();
		hudRenderer = new HUDRenderer();
		camera = new Camera();
		
		worldInfo = new WorldInfo(entities, hudRenderer, camera);
		
		for(Entity ent: entities)
		{
			ent.setWorldInfo(worldInfo);
			ent.setup();
		}
		
		//entityRenderer.setup(worldInfo);
		hudRenderer.init();
		entityRenderer.setup(worldInfo);
		
		score = 0;
		
	}
	
	private void addAIs()
	{
		for(int i = 0; i < 3; i++)
		{
			AI temp = new AI(new Vector3((i-1)*300, 0, -700));
			temp.setWorldInfo(worldInfo);
			temp.setup();
			entities.add(temp);
		}
	}
	
	public void create() 
	{
		setupWorld();
	}

	public void dispose() 
	{
		entityRenderer.dispose();
		for(Entity ent: entities)
			ent.dispose();
		EntityUtils.dispose();

	}

	public void pause() 
	{
		// TODO Auto-generated method stub

	}

	public void render()
	{
		
		
		//loop through all the entities
		//if player and dead:
		//	if hudRenderer.retryScreen() (non-blocking function - don't wait for input to continue, returns true if space pressed)
		//		reset world (re-setup entities, renderers, etc)
		//else if ai and dead:
		//	entities.remove current index
		//else
		//	update
		
		
		int AICount = 0;
		
		for(int i = 0; i < entities.size(); i++)
		{
			
			if(entities.get(i) instanceof Player && ((Player)entities.get(i)).getHealth() <= 0)
			{
				if (hudRenderer.retryScreen())
				{
					entityRenderer.dispose();
					entities.clear();
//					for(Entity ent: entities)
//						ent.dispose();
					setupWorld();
				}
			}
			
			else if(entities.get(i) instanceof AI)
			{
				AICount++;
				if(((AI)entities.get(i)).getHealth() <= 0)
				{
					//entities.get(i).dispose();
					entities.remove(i);
					i--;
					score += 100;
					hudRenderer.setScore(score);
				}
			}
			
			entities.get(i).update();
			
				
		}
		
		if(AICount == 0)
		{
			addAIs();
		}
		

		entityRenderer.render();
		hudRenderer.genericTick();
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
