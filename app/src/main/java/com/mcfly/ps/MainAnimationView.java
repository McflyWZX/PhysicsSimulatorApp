package com.mcfly.ps;
import com.mcfly.ps.PhysicsPack.*;
import com.mcfly.ps.PhysicsPack.PhysicsObjPack.*;
import android.content.*;
import com.mcfly.ps.PhysicsPack.FieldPack.*;

public class MainAnimationView extends PhysicsSurfaceView
{
	Cube a, c;
	Circle b, d;
	Gfield G1, G2;
	MainAnimationView(Context co)
	{
		super(co);
	}

	@Override
	public void onRun()
	{
		// TODO: Implement this method
	}


	@Override
	public void uInit()
	{
		// TODO: Implement this method
		
		a = new Cube(3E1f, 1, 1, new Vector2(5, 2));
		G1 = new Gfield(new Vector2(1, 1), new Vector2(9, 5), new Vector2(0, 100));
		G1.visable();
		G2 = new Gfield(new Vector2(1, 6), new Vector2(9, 14), new Vector2(0, -50));
		G2.visable();
		//b = new Circle(2.69760318E11f, 0.3174802104f, new Vector2(5, 2), new Vector2(2, 0));
		//c = new Cube(3E8f, 1, 1, new Vector2(1, 5));
		//d = new Circle(5.395206359E11f, 0.4f, new Vector2(5, 8), new Vector2(-1, 0));
	}
	

}  
