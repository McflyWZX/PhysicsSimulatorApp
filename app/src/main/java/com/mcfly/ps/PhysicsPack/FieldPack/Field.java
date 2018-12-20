package com.mcfly.ps.PhysicsPack.FieldPack;
import com.mcfly.ps.PhysicsPack.*;
import com.mcfly.ps.PhysicsPack.PhysicsObjPack.*;
import android.graphics.*;

public abstract class Field implements Graphic
{
	public Vector2 startP, endP;
	boolean visable;
	
	Field(Vector2 startP, Vector2 endP)
	{
		this.startP = startP;
		this.endP = endP;
		
	}
	
	public abstract void addForceTo(PhysicsObj obj);
	
	void addObjToPhysicsSystem()
	{
		PHC.addCalcObj(this);
		PhysicsSurfaceView.addObj(this);
	}
	
	public void visable()
	{
		visable = true;
	}
}
