package apcs.atod.entity;

import java.lang.reflect.Field;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.math.Vector3;

public class Landscape extends Entity
{
	
	private static Model model = EntityUtils.loadModel("landscape.g3db");
	
	public void setup() 
	{
		modelInstance = new ModelInstance(model);
		Node parent = new Node();
		
		for(int i = 0; i < 9; i++)
		{
			Node child = cloneObject(modelInstance.nodes.first());
			child.translation.add(new Vector3(i%3, 0, i/3));
			parent.addChild(child);
		}
		
		modelInstance.nodes.removeIndex(0);
		modelInstance.nodes.add(parent);
		
		modelInstance.calculateTransforms();
	}

	public void update() 
	{
		
	}
	
	public void dispose()
	{
		model.dispose();
	}
	
	 private static <T> T cloneObject(T obj)
	{
        try
        {
            Object clone = obj.getClass().newInstance();
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                field.set(clone, field.get(obj));
            }
            return (T) clone;
        }
        
        catch(Exception e)
        {
            return null;
        }
    }
	
}
