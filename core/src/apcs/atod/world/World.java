package apcs.atod.world;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;

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

	public void create() {

	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void pause() {
		// TODO Auto-generated method stub

	}

	public void render() {
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
