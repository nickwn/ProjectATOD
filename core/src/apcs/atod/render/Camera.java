package apcs.atod.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.math.Vector3;

public class Camera 
{
	private PerspectiveCamera camera;
	private CameraInputController camController;
	
	public void setup()
	{
		camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(0,0,0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();
        
        camController = new CameraInputController(camera);
        Gdx.input.setInputProcessor(camController);
	}
	
	public PerspectiveCamera getCamera()
	{
		return camera;
	}
	
	public void update()
	{
		camController.update();
	}
	
	public Vector3 getDirection()
	{
		return camera.direction;
	}
}
