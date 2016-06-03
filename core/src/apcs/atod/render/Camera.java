package apcs.atod.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.math.Vector3;

public class Camera implements InputProcessor
{
	private PerspectiveCamera camera;
	private CameraInputController camController;
	private int prevX, prevY;
	
	public void setup()
	{
		camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(0,10,-10);
        camera.near = 1f;
        camera.far = 17000f;
        camera.update();
        
        prevX = 0;
        prevY = 90;
        camController = new CameraInputController(camera);
        Gdx.input.setInputProcessor(this);
        //Gdx.input.setInputProcessor(camController);
        
//        camController = new CameraInputController(camera);
//        camController.target.set(camera.position);
//        Gdx.input.setInputProcessor(new InputMultiplexer(new CameraInputAdapter(), camController));
	}
	
	public PerspectiveCamera getPerspectiveCamera()
	{
		return camera;
	}
	
	public void update()
	{
		//camController.update();
		//camera.rotate(new Vector3(0, 1, 0), Gdx.input.getX());
		//camera.update();
	}
	
	public void setPosition(Vector3 to)
	{
		camera.position.set(to);
	}
	
	public Vector3 getDirection()
	{
		return camera.direction;
	}


	public boolean keyDown(int arg0) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean keyTyped(char arg0) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean keyUp(int arg0) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean mouseMoved(int arg0, int arg1) 
	{
		int dX = (prevX-arg0);///Gdx.graphics.getWidth();
		int dY = (prevY-arg1);///Gdx.graphics.getHeight();
		//dX*=360;
		//dY*=360;
		camera.direction.rotate(new Vector3(0,1,0), dX);
		camera.direction.rotate(new Vector3(1,0,0), dY);
		//System.out.println(arg0 + " " + arg1);
		camera.update();
		prevX = arg0;
		prevY = arg1;
		return true;
	}

	public boolean scrolled(int arg0) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean touchDragged(int arg0, int arg1, int arg2) 
	{
		int dX = (prevX-arg0);///Gdx.graphics.getWidth();
		int dY = (prevY-arg1);///Gdx.graphics.getHeight();
		//dX*=360;
		//dY*=360;
		camera.direction.rotate(new Vector3(0,1,0), dX);
		camera.direction.rotate(new Vector3(1,0,0), dY);
		//System.out.println(arg0 + " " + arg1);
		camera.update();
		prevX = arg0;
		prevY = arg1;
		return true;
	}

	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) 
	{
		// TODO Auto-generated method stub
		return false;
	}
}
