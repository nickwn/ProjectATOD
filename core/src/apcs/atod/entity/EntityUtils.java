
package apcs.atod.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;

public final class EntityUtils 
{
	private static AssetManager assets = new AssetManager();
	
	private EntityUtils() 
	{
		
	}
	
	/**
	 * Does not exit until model has loaded.
	 * @return the specified Model with the given filename.
	 */
	public static Model loadModel(String filename) 
	{
		assets.load(filename, Model.class);
		
		while(!assets.update())
		{
			try 
			{
				Thread.sleep(100);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		return assets.get(filename, Model.class);
	}
	
	public static boolean raycastHasHit() 
	{
		return false;
	}

}

