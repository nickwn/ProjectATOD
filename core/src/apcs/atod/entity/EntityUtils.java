
package apcs.atod.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;

public final class EntityUtils 
{
	
	private EntityUtils() 
	{
		
	}
	
	public static Model loadModel(String name) 
	{
		ModelLoader loader = new ObjLoader();
       return loader.loadModel(Gdx.files.internal(name));
	}
	
	public static void raycastHasHit() {
		
	}

}

