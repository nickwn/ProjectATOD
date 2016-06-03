package apcs.atod.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class BulletLine extends Entity
{
	private Vector3 to;
	private Model model;
	private long startTime;
	
	public BulletLine(Vector3 pos, Vector3 to) 
	{
		super(pos);
		this.to = to;
		// TODO Auto-generated constructor stub
	}

	public void setup() 
	{
		//System.out.println(pos + " " + to);
		ModelBuilder modelBuilder = new ModelBuilder();
		//model = modelBuilder.createArrow(pos, to, new Material(ColorAttribute.createDiffuse(Color.RED)), Usage.Position | Usage.Normal);
		model = modelBuilder.createArrow(pos.x,pos.y,pos.z, to.x,to.y,to.z+100, 0.01f, 0.01f, 5,
			    GL20.GL_TRIANGLES, new Material(ColorAttribute.createDiffuse(Color.RED)), 
			    Usage.Position | Usage.Normal);
		modelInstance = new ModelInstance(model);
		startTime = System.currentTimeMillis();
	}

	public void update() 
	{
		if(System.currentTimeMillis()-startTime > 500)
			dispose();
	}

	public void dispose() 
	{
		worldInfo.getEntities().remove(this);
	}
	
	
}
