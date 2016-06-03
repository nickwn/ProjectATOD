package apcs.atod.entity;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;

public class Skybox extends Entity
{
	private static Model model = EntityUtils.loadModel("core/assets/skybox/skybox.g3db");
	
	public Skybox(Vector3 pos) 
	{
		super(pos);
	}

	public void setup() 
	{
		modelInstance = new ModelInstance(model, pos);
		modelInstance.transform.rotate(Vector3.Z, 180);
	}

	public void update() 
	{
		
	}

	public void dispose() 
	{
		
	}

}
