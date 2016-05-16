
package apcs.atod.entity;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;

public abstract class Entity 
{
	protected Vector3 pos;
	
	protected ModelInstance modelInstance;
	
	public Vector3 getPosition()
	{
		return pos;
	}
	
	public ModelInstance getModelInstance()
	{
		return modelInstance;
	}
	
	public abstract void setup();
	
	public abstract void update();
}

