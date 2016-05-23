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
		camera.position.set(0,10,-10);
        camera.near = 1f;
        camera.far = 9000f;
        camera.update();
        
        camController = new CameraInputController(camera);
        camController.target.set(camera.position);
        Gdx.input.setInputProcessor(camController);
	}
	
	public PerspectiveCamera getPerspectiveCamera()
	{
		return camera;
	}
	
	public void update()
	{
		camController.update();
	}
	
	public void setPosition(Vector3 to)
	{
		camera.position.set(to);
	}
	
	public Vector3 getDirection()
	{
		return camera.direction;
	}
}
