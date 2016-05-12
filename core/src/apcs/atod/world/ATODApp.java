package apcs.atod.world;

import apcs.atod.entity.AI;
import apcs.atod.entity.Player;

import com.badlogic.gdx.ApplicationListener;

/**
 * Controls the entire application. Extends libGDX’s ApplicationListener
 * interface.
 *
 */
public class ATODApp implements ApplicationListener {

	public void create() {
		World world = new World();
		Player p = new Player(1, 1);
		world.addEntity(p);
		p.setup();
		for (int i = 0; i < 30; i++) {
			AI bots = new AI(1, 1);
			world.addEntity(bots);
			bots.setup();
		}

	}

	public void render() {

	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void pause() {
		// TODO Auto-generated method stub

	}

	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	public void resume() {
		// TODO Auto-generated method stub

	}
}
