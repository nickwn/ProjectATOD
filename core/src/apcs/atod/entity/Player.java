package apcs.atod.entity;

import com.badlogic.gdx.*;

public class Player extends Character
{
	private double speed;
	private double damage;
	
	public Player(double s, double d)
	{
		speed = s;
		damage = d;
	}
}
