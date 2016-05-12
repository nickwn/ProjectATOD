
package apcs.atod.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;

public final class EntityUtils {

	private EntityUtils() {
		
	}
	
	public enum LevelData {
		ONE(1, 10), TWO(2, 20);

		private double dmg, hp;

		public double getDamage() {
			return dmg;
		}

		public double getHp() {
			return hp;
		}

		LevelData(double damage, double health) {
			dmg = damage;
			hp = health;
		}
	}

	public static int generateRandomNum(int max) {
		int random = (int) (Math.random() * max) + 1;
		return random;
	}
	
	public static Model loadModel(String name) {
		ModelLoader loader = new ObjLoader();
       return loader.loadModel(Gdx.files.internal(name));
	}

}

