package com.mcfly.ps.PhysicsPack.FieldPack;
import com.mcfly.ps.PhysicsPack.*;
import com.mcfly.ps.PhysicsPack.PhysicsObjPack.*;

public abstract class Field
{
	Vector2 startP, endP;
	
	public abstract void addForceTo(PhysicsObj obj);
}
