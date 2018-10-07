package com.mcfly.ps.PhysicsPack.FieldPack;
import com.mcfly.ps.PhysicsPack.*;
import com.mcfly.ps.PhysicsPack.PhysicsObjPack.*;

public class Mfield extends Field
{
	float B;
	@Override
	public void addForceTo(PhysicsObj obj)
	{
		// TODO: Implement this method
		obj.addForce(new Vector2(- obj.velocity.scale(obj.q * B).getY(), obj.velocity.scale(obj.q * B).getX()));
	}
	
}
