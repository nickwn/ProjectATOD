package apcs.atod.entity;

public class EntityUtils {

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

}
