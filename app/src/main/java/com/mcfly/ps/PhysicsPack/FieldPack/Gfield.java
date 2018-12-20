package com.mcfly.ps.PhysicsPack.FieldPack;
import com.mcfly.ps.PhysicsPack.PhysicsObjPack.*;
import com.mcfly.ps.PhysicsPack.*;
import android.graphics.*;

public class Gfield extends Field
{

	Vector2 a;//gravit accumulate
	
	public Gfield(Vector2 startP, Vector2 endP, Vector2 a)
	{
		super(startP, endP);
		
		this.a = a;
		addObjToPhysicsSystem();
	}
	
	@Override
	public void addForceTo(PhysicsObj obj)
	{
		// TODO: Implement this method
		obj.addForce(a.scale(obj.mass));
	}
	
	@Override
	public void draw(Canvas ca, Paint pa)
	{
		// TODO: Implement this method
		if(visable)
		{
			pa.setStyle(Paint.Style.STROKE);
			ca.drawRect((float)startP.getScreenVector().getX(), (float)startP.getScreenVector().getY(), 
						(float)endP.getScreenVector().getX(), (float)endP.getScreenVector().getY(), pa);
			pa.setStyle(Paint.Style.FILL);
		}
	}

	
	
}
