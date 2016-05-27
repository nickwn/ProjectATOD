package apcs.atod.render;

import apcs.atod.entity.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Heads Up Display shows the crosshair, number of kills and health of player.
 *
 */

public class HUDRenderer {

	enum IMG {
		GUN("core/assets/img/gun.png"), GAME_OVER(
				"core/assets/img/game-over.png"), GUN_SHOOTING(
				"core/assets/img/shooting.png");

		String myPath;

		IMG(String path) {
			myPath = path;
		}

		public String getPath() {
			return myPath;
		}
	}

	OrthographicCamera camera;
	SpriteBatch spriteBatch;
	Texture img;
	BitmapFont text;
	String scoreText;
	Player player;
	FPSLogger fpsLogger;
	int myHp;
	boolean shooting, fail;

	private int score;

	public void init() { // sets up HUD
		spriteBatch = new SpriteBatch();
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		camera.position.set(0, 0, 0);

		img = new Texture(IMG.GUN.getPath());
		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();
		spriteBatch.draw(img, -145, -240);
		spriteBatch.end();
		text = new BitmapFont();
		scoreText = "health: " + myHp;
		spriteBatch.begin();
		text.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		text.draw(spriteBatch, scoreText, -300, 230);
		text.draw(spriteBatch, "health: " + 10, 230, 230);
		spriteBatch.end();
		camera.update();
	}

	public void genericTick() {
		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();
		if (fail == true) {
			spriteBatch.draw(new Texture(IMG.GAME_OVER.getPath()), 0, 0);
			spriteBatch.end();
		}
		if (shooting == false) {
			img = new Texture(IMG.GUN.getPath());
			spriteBatch.draw(img, -145, -240);
		} else {
			img = new Texture(IMG.GUN_SHOOTING.getPath());
			// spriteBatch.setProjectionMatrix(camera.combined);
			spriteBatch.draw(img, 0, 0);
		}
		scoreText = "score: " + score;
		text.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		text.draw(spriteBatch, scoreText, -300, 230);
		text = new BitmapFont();
		text.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		text.draw(spriteBatch, "health: " + myHp, 230, 230);
		text = new BitmapFont();
		text.setColor(Color.RED);
		text.draw(spriteBatch, "FPS: " + Gdx.graphics.getFramesPerSecond(), -300, -220);
		spriteBatch.end();
	}

	public boolean retryScreen() {
		// img = new Texture(IMG.GAME_OVER.getPath());
		fail = true;
		if (Gdx.input.isButtonPressed(Input.Keys.SPACE)) {
			return true;
		}
		return false;
	}

	public void setScore(int x) { // sets internal score and updates overlay
		score += x;
		// genericTick(1);
	}

	public void setHealth(int hp) { // sets internal health ad updates overlay
		myHp = hp;
		// genericTick(4);
	}

	public void setShooting(boolean logic) {
		shooting = logic;
	}

}
