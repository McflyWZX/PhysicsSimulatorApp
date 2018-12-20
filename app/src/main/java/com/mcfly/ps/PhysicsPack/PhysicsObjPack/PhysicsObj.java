package com.mcfly.ps.PhysicsPack.PhysicsObjPack;
import com.mcfly.ps.PhysicsPack.*;
import java.util.*;

public abstract class PhysicsObj implements Graphic
{
	public float mass, q;
	public boolean fixed;
	public Vector2 position, velocity, acceleration, Rotation, RotateCenter;
	//Vector2 drawPosition;
	ArrayList<Vector2> forces;
	
	Vector2 resultantForce(int i)
	{
		Vector2 ans = new Vector2(0, 0);
		for(Vector2 v : forces)
		{
			ans = ans.add(v);
		}
		//Log.i("cube", "resultantForce(" + ans.getX() + ", " + ans.getY() + ");" );

		return ans;
	}
	
	public void freeFList()
	{
		// TODO: Implement this method
		forces.clear();
	}

	public void addForce(Vector2 force)
	{
		forces.add(force);
		//Log.i("cube", "Add force(" + force.getX() + ", " + force.getY() + ");" );
	}

	public void upDate()
	{

		acceleration = resultantForce(0).scale(1 / mass);
		velocity = velocity.add(acceleration.scale(PSconst.frameT * 1f));
		position = position.add(velocity.scale(PSconst.frameT * 1f));
		//drawPosition = position.scale(PSconst.scaleSceern);
	}
	
	void addObjToPhysicsSystem()
	{
		PHC.addCalcObj(this);
		PhysicsSurfaceView.addObj(this);
	}
}
