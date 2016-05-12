package apcs.atod.world;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;

import apcs.atod.entity.AI;
import apcs.atod.entity.Entity;
import apcs.atod.entity.EntityUtils;
import apcs.atod.entity.Player;
import apcs.atod.render.Renderer;

public class World implements ApplicationListener {

	private ArrayList<Entity> entities = new ArrayList<Entity>();
	private ArrayList<Renderer> renderers = new ArrayList<Renderer>();
	int level;

	public World(int lvl) {
		level = lvl;
		entities.add(new Player(1, 1));
		switch (level) {
		case 1:
			for (int i = 0; i < EntityUtils.generateRandomNum(30); i++) { // generates
				// up to
				// 30 AI
				// planes
				entities.add(new AI(EntityUtils.LevelData.ONE.getDamage(),
						EntityUtils.LevelData.ONE.getHp()));
			}
			break;
		case 2:
			for (int i = 0; i < EntityUtils.generateRandomNum(30); i++) { // generates
				// up to
				// 30 AI
				// planes
				entities.add(new AI(EntityUtils.LevelData.TWO.getDamage(),
						EntityUtils.LevelData.TWO.getHp()));
			}
			break;
		}

		// TODO Auto-generated constructor stub
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

}
