package apcs.atod.world;

import apcs.atod.entity.AI;
import apcs.atod.entity.Player;
import apcs.atod.render.Camera;
import apcs.atod.render.EntityRenderer;
import apcs.atod.render.HUDRenderer;
import apcs.atod.entity.Entity;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;

/**
 * Controls the entire application. Extends libGDX’s ApplicationListener
 * interface.
 *
 */
public class ATODApp implements ApplicationListener 
{
	private World world;

	public void create()
	{
		world = new World();
		world.create();
	}

	public void render() 
	{
		world.render();
	}

	public void dispose() 
	{
		world.dispose();

	}

	public void pause() 
	{
		// TODO Auto-generated method stub

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
