package apcs.atod.entity;

import java.util.ArrayList;

import apcs.atod.render.Camera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.utils.UBJsonReader;


public final class EntityUtils 
{
	private static AssetManager assets = new AssetManager();
	
	private EntityUtils() {

	}

	/**
	 * Does not exit until model has loaded.
	 * 
	 * @return the specified Model with the given filename.
	 */
	public static Model loadModel(String filename) 
	{
		assets.load(filename, Model.class);

		assets.finishLoading();
		return assets.get(filename, Model.class);
	}

	public static Entity raycastHasHit(Vector3 pos, Vector3 direction,
			ArrayList<Entity> entity, Camera cam) 
	{
		Ray ray = cam.getPerspectiveCamera().getPickRay(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		for (Entity e : entity) {
			BoundingBox out = new BoundingBox();
			e.getModelInstance().calculateBoundingBox(out).mul(e.getModelInstance().transform);
			if (Intersector.intersectRayBoundsFast(ray, out))
			{
				return e;
				
			}
			// e.getModelInstance().model.calculateBoundingBox();
		}
		return null;
	}

	public static void dispose() {
//		assets.dispose();
	}

	/**
	 * public static boolean raycastHasHit(float x1, float y1, float x2, float
	 * y2) { float deltaX = Math.abs(x1 - x2); float deltaY = Math.abs(y1 - y2);
	 * if (deltaX >= 0 && deltaX <= 2 && deltaY >= 0 && deltaY <= 2) { return
	 * true; } return false; }
	 **/

}
