package apcs.atod.render;


import apcs.atod.entity.*;
import apcs.atod.world.*;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.utils.Array;

/**
 * Renders a group of entities.
 *
 */
public class EntityRenderer 
{
	private WorldInfo worldInfo;
	private ModelBatch modelBatch;
	private Environment environment;
	private PerspectiveCamera camera;
	
	/**
	 * Sets up the renderer. Entities must be setup and initialized before this is called
	 * @param ents 
	 */
	public void setup(WorldInfo info)
	{
		worldInfo = info;
		
		modelBatch = new ModelBatch();
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
	    environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
		
		camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(worldInfo.getCamera().getPosition());
        camera.near = 1f;
        camera.far = 300f;
        camera.update();
		
		
	}
	
	public void render()
	{
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Array<ModelInstance> entArr = new Array<ModelInstance>();
        for(Entity ent: worldInfo.getEntities())
        	entArr.add(ent.getModelInstance());

        modelBatch.begin(camera);
        modelBatch.render(entArr, environment);
        modelBatch.end();
	}
}