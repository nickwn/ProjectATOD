
package apcs.atod.entity;

import com.badlogic.gdx.math.Vector3;

public abstract class Entity 
{
	protected Vector3 pos;
	
	public Vector3 getPosition()
	{
		return pos;
	}
	
	public abstract void setup();
	
	public abstract void update();
}

