package com.mcfly.ps.PhysicsPack;
import android.graphics.*;
import java.util.*;
import android.util.*;

public class Cube extends PhysicsObj implements Graphic
{
	float H, W;
	
	public Cube(float mass, float W, float H, Vector2 po)
	{
		
		this.mass = mass;
		this.H = H * PSconst.scaleSceern;
		this.W = W * PSconst.scaleSceern;
		this.position = po;
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 0);
		Rotation = new Vector2(0, 0);
		RotateCenter = new Vector2(0, 0);
		forces = new ArrayList<Vector2>();
		addObjToPhysicsSystem();
	}
	
	public Cube(float mass, float W, float H, Vector2 po, Vector2 velocity)
	{
		this(mass, W, H, po);
		this.velocity = velocity;
		
	}
	

	@Override
	public void draw(Canvas ca, Paint pa)
	{
		// TODO: Implement this method
		
		float X = (float)drawPosition.getX(), Y = (float)drawPosition.getY();
		float hW = W / 2, hY = H / 2;
		ca.drawLine(X - hW, Y - hY, X + hW, Y - hY, pa);
		ca.drawLine(X - hW, Y + hY, X + hW, Y + hY, pa);
		ca.drawLine(X + hW, Y - hY, X + hW, Y + hY, pa);
		ca.drawLine(X - hW, Y - hY, X - hW, Y + hY, pa);
		
	}

	
}
