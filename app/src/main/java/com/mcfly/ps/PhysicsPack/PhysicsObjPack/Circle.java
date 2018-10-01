package com.mcfly.ps.PhysicsPack.PhysicsObjPack;
import android.graphics.*;
import java.util.*;
import com.mcfly.ps.PhysicsPack.*;

public class Circle extends PhysicsObj implements Graphic
{
	float R;

	public Circle(float mass, float R, Vector2 po)
	{

		this.mass = mass;
		this.R = R * PSconst.scaleSceern;
		this.position = po;
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 0);
		Rotation = new Vector2(0, 0);
		RotateCenter = new Vector2(0, 0);
		forces = new ArrayList<Vector2>();
		addObjToPhysicsSystem();
	}

	public Circle(float mass, float R, Vector2 po, Vector2 velocity)
	{
		this(mass, R, po);
		this.velocity = velocity;

	}

	@Override
	public void draw(Canvas ca, Paint pa)
	{
		// TODO: Implement this method
		ca.drawCircle((float)drawPosition.getX(), (float)drawPosition.getY(), R, pa);
		//ca.drawText("drawPosition" + R, 100, 100, pa);
	}
	
}
