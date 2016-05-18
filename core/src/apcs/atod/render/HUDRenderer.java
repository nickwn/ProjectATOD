package apcs.atod.render;

import apcs.atod.entity.Player;

import apcs.atod.world.World;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;


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

	private int score;
	
	public void init() {
		//for testing purposes
//		img = new Texture("hud-af.png");
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		camera.position.set(0, 0, 0);
		// camera.near = 1f;
		// camera.far = 300f;
		camera.update();
		img = new Texture("gun.png");
		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();
		spriteBatch.draw(img, 150, 0);
//		spriteBatch.draw(img, 0, 0);
		spriteBatch.end();	
	}

//<<<<<<< HEAD
	public void genericTick() { //resend gun
		img = new Texture("gun.png");
		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();
		spriteBatch.draw(img, 150, 0);
//		spriteBatch.draw(img, 0, 0);
		spriteBatch.end();	
	}
	
//=======
	public void draw() {
		//for testing purposes
		img = new Texture("hud-af.png");
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		camera.position.set(0, 0, 0);
		// camera.near = 1f;
		// camera.far = 300f;
		camera.update();
		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();
		spriteBatch.draw(img, 0, 0);
		spriteBatch.end();
	}


//>>>>>>> a11b5f78b1aa7e36462f29c4f97a58ceb303b0bc
	public void genericTick(int param) {
		switch (param) {
		case 1: // send score update
			// score++;
			text = new BitmapFont();
			scoreText = "score: " + score;
			spriteBatch.begin();
			text.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			text.draw(spriteBatch, scoreText, 25, 100);
			// TODO add health implementation
			text.draw(spriteBatch, "health: " + 10, 25, 75);
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
//		case 3: // check gun position
//		
//			break;
		}

	}

	public void setScore(int x) {
		score += x;
		genericTick(1);
	}



//	@Override
//	public void create() {
		//for testing purposes
//		img = new Texture("hud-af.png");
//		camera = new OrthographicCamera(Gdx.graphics.getWidth(),
//				Gdx.graphics.getHeight());
//		camera.position.set(0, 0, 0);
		// camera.near = 1f;
		// camera.far = 300f;
//		camera.update();
//		spriteBatch.setProjectionMatrix(camera.combined);
//		spriteBatch.begin();
//		spriteBatch.draw(img, 0, 0);
//		spriteBatch.end();		
//	}



}
