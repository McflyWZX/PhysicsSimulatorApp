package com.mcfly.ps;
import com.mcfly.ps.PhysicsPack.*;
import android.content.*;

public class MainAnimationView extends PhysicsSurfaceView
{
	Cube a, c;
	Circle b, d;
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
		//a = new Cube(3E1f, 1, 1, new Vector2(0, 1));
		b = new Circle(2.69760318E11f, 0.3174802104f, new Vector2(5, 2), new Vector2(2, 0));
		//c = new Cube(3E8f, 1, 1, new Vector2(1, 5));
		d = new Circle(5.395206359E11f, 0.4f, new Vector2(5, 8), new Vector2(-1, 0));
	}
	

}  
