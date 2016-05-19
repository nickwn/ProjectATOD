package apcs.atod.render;

import apcs.atod.entity.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Heads Up Display shows the crosshair, number of kills and health of player.
 *
 */

public class HUDRenderer {

	OrthographicCamera camera;
	SpriteBatch spriteBatch;
	Texture img;
	BitmapFont text;
	String scoreText;
	Player player;
	int myHp;

	private int score;

	public void init() { // sets up HUD
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		camera.position.set(0, 0, 0);
		camera.update();
		img = new Texture("gun.png");
		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();
		spriteBatch.draw(img, 150, 0);
		spriteBatch.end();
		text = new BitmapFont();
		scoreText = "health: " + myHp;
		spriteBatch.begin();
		text.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		text.draw(spriteBatch, scoreText, 0, 100);
		text.draw(spriteBatch, "health: " + 10, 25, 75);
		spriteBatch.end();
	}

	public void genericTick() { // resend gun
		img = new Texture("gun.png");
		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();
		spriteBatch.draw(img, 150, 0);
		spriteBatch.end();
	}

	public void setScore(int x) { // sets internal score and updates overlay
		score += x;
		genericTick(1);
	}

	public void setHealth(int hp) { // sets internal health ad updates overlay
		myHp = hp;
		genericTick(4);
	}

	public void setShooting(boolean yes) { // switches state of gun, resends gun
											// image
		if (yes == true) {
			genericTick(3);
		} else {
			genericTick();
		}
	}

	public void genericTick(int param) { // main handler for sending information
											// to game
		switch (param) {
		case 1: // send score update
			text = new BitmapFont();
			scoreText = "score: " + score;
			spriteBatch.begin();
			text.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			text.draw(spriteBatch, scoreText, 25, 100);
			spriteBatch.end();
			break;
		case 2: // send game over text
			img = new Texture("game-over.png");
			spriteBatch.setProjectionMatrix(camera.combined);
			spriteBatch.begin();
			spriteBatch.draw(img, 0, 0);
			spriteBatch.end();
			break;
		case 3: // shooting
			img = new Texture("shooting.png");
			spriteBatch.setProjectionMatrix(camera.combined);
			spriteBatch.begin();
			spriteBatch.draw(img, 150, 0);
			spriteBatch.end();
			break;
		case 4: // health overlay
			text = new BitmapFont();
			spriteBatch.begin();
			text.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			text.draw(spriteBatch, "health: " + myHp, 0, 100);
			spriteBatch.end();
			break;
		}

	}

}
