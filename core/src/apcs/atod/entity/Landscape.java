package apcs.atod.entity;

import java.lang.reflect.Field;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.math.Vector3;

public class Landscape extends Entity
{
	private static Model model = EntityUtils.loadModel("core/assets/repeatinglandscape/largerepeatinglandscape.g3dj");
	//private static Model model = EntityUtils.loadModel("core/assets/fighterplane/fighterplane.g3db");
	
	public Landscape(Vector3 pos) 
	{
		super(pos);
		// TODO Auto-generated constructor stub
	}

	
	
	public void setup() 
	{
		String id = model.nodes.get(0).id;
        modelInstance = new ModelInstance(model, pos);
        modelInstance.materials.get(0).set(ColorAttribute.createDiffuse(new Color(0.253f, 0.135f, 0.057f, 10f)));
        modelInstance.materials.get(1).set(ColorAttribute.createDiffuse(new Color(0f, 0.26f, 0.002f, 1f)));
        modelInstance.materials.get(2).set(ColorAttribute.createDiffuse(Color.WHITE));
        Node node = modelInstance.getNode(id);
		
		//modelInstance = new ModelInstance(model, pos);
//		Node parent = new Node();
//		
//		for(int i = 0; i < 9; i++)
//		{
//			Node child = cloneObject(modelInstance.nodes.first());
//			child.translation.add(new Vector3(i%3, 0, i/3));
//			parent.addChild(child);
//		}
//		
//		modelInstance.nodes.removeIndex(0);
//		modelInstance.nodes.add(parent);
//		
//		modelInstance.calculateTransforms();
	}

	public void update() 
	{
		modelInstance.transform.translate(new Vector3(0,0,-10));
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
