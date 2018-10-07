package com.mcfly.ps.PhysicsPack.FieldPack;
import com.mcfly.ps.PhysicsPack.*;
import com.mcfly.ps.PhysicsPack.PhysicsObjPack.*;

public class Efield extends Field
{
	Vector2 E;

	@Override
	public void addForceTo(PhysicsObj obj)
	{
		// TODO: Implement this method
		obj.addForce(E.scale(obj.q));
	}
	
	
}
