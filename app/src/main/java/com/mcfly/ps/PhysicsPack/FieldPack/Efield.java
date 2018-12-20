package com.mcfly.ps.PhysicsPack.FieldPack;
import com.mcfly.ps.PhysicsPack.*;
import com.mcfly.ps.PhysicsPack.PhysicsObjPack.*;
import android.graphics.*;

public class Efield extends Field
{
	
	Vector2 E;
	
	public Efield(Vector2 startP, Vector2 endP, Vector2 a)
	{
		super(startP, endP);

		//this.a = a;
		addObjToPhysicsSystem();
	}

	@Override
	public void addForceTo(PhysicsObj obj)
	{
		// TODO: Implement this method
		obj.addForce(E.scale(obj.q));
	}
	
	@Override
	public void draw(Canvas ca, Paint pa)
	{
		// TODO: Implement this method
	}
}
