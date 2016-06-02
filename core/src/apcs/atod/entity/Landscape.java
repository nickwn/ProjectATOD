package apcs.atod.entity;

import java.lang.reflect.Field;
import java.util.function.Consumer;

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
        
        
        Node landscape = new Node();
        landscape.id = "landscape2";
        landscape.globalTransform.set(modelInstance.getNode("landscape").globalTransform);
        landscape.inheritTransform = modelInstance.getNode("landscape").inheritTransform;
        landscape.isAnimated = modelInstance.getNode("landscape").isAnimated;
        landscape.localTransform.set(modelInstance.getNode("landscape").localTransform);
        landscape.parts = modelInstance.getNode("landscape").parts;
        landscape.rotation.set(modelInstance.getNode("landscape").rotation);
        landscape.scale.set(modelInstance.getNode("landscape").scale);
        landscape.translation.set(modelInstance.getNode("landscape").translation);
        landscape.translation.add(0, 0, 17000);
        landscape.calculateTransforms(true);
        
        modelInstance.nodes.add(landscape);
	}

	public void update() 
	{
		//System.out.println(modelInstance.transform.getTranslation(new Vector3()).z);
		if(modelInstance.transform.getTranslation(new Vector3()).z <= -17000 )
		{
			//System.out.println("moving");
			modelInstance.transform.translate(0, 0, 17000);
		}
		modelInstance.transform.translate(new Vector3(0,0,-10));
	}
	
	public void dispose()
	{
		model.dispose();
	}
	
}
