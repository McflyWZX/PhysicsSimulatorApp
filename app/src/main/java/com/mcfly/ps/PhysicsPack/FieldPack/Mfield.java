package com.mcfly.ps.PhysicsPack.FieldPack;
import com.mcfly.ps.PhysicsPack.*;
import com.mcfly.ps.PhysicsPack.PhysicsObjPack.*;
import android.graphics.*;

public class Mfield extends Field
{

	
	float B;
	
	public Mfield(Vector2 startP, Vector2 endP, Vector2 a)
	{
		super(startP, endP);

		//this.a = a;
		addObjToPhysicsSystem();
	}
	
	@Override
	public void addForceTo(PhysicsObj obj)
	{
		// TODO: Implement this method
		obj.addForce(new Vector2(- obj.velocity.scale(obj.q * B).getY(), obj.velocity.scale(obj.q * B).getX()));
	}
	
	@Override
	public void draw(Canvas ca, Paint pa)
	{
		// TODO: Implement this method
	}
	
}
