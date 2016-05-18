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

	private ArrayList<Entity> entities = new ArrayList<Entity>();
	// private WorldInfo worldInfo;

	// EntityRenderer entityRenderer;

	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public void addPlayer()
	{
		entities.add(new Player(1, 1, 1,new Vector3(0,0,0)));
	}
	
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

	public void create() {

	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void pause() {
		// TODO Auto-generated method stub

	}

	public void render() throws InterruptedException {
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT))
				{
				//call shoot
				Thread.sleep((long) Player.getrof());
				}
		// TODO Auto-generated method stub

	}

	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	public void resume() {
		// TODO Auto-generated method stub

	}

	public ArrayList<Entity> getEntityList() {
		return entities;
	}

}
