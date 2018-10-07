package com.mcfly.ps.PhysicsPack.FieldPack;
import com.mcfly.ps.PhysicsPack.PhysicsObjPack.*;
import com.mcfly.ps.PhysicsPack.*;

public class Gfield extends Field
{

	Vector2 G;
	@Override
	public void addForceTo(PhysicsObj obj)
	{
		// TODO: Implement this method
		obj.addForce(G.scale(obj.mass));
	}
	
}
