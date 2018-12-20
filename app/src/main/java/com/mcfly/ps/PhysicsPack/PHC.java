package com.mcfly.ps.PhysicsPack;
import java.util.*;
import java.math.*;
import android.util.*;
import com.mcfly.ps.PhysicsPack.PhysicsObjPack.*;
import com.mcfly.ps.PhysicsPack.FieldPack.*;

public class PHC
{
	
	static double TG, Td;
	
	static final ArrayList<PhysicsObj> calcList = new ArrayList<PhysicsObj>();
	static final ArrayList<Field> fieldList = new ArrayList<Field>();
	
	public static void addCalcObj(PhysicsObj obj)
	{
		calcList.add(obj);
	}
	
	public static void addCalcObj(Field f)
	{
		fieldList.add(f);
	}
	
	public static void run()
	{
		// TODO: Implement this method
		for(PhysicsObj obj1 : calcList)
		{
			obj1.freeFList();
			for(PhysicsObj obj2 : calcList)
			{
				if(obj1 == obj2)continue;
				
				Td = Vector2.distance2(obj1.position, obj2.position);
				Log.i("PSC", "两物体的距离:" + Td);
				TG = PSconst.G * obj1.mass * obj2.mass / Td;
				obj1.addForce(new Vector2(TG * Vector2.dx(obj2.position, obj1.position) / Math.sqrt(Td), TG * Vector2.dy(obj2.position, obj1.position) / Math.sqrt(Td)));
				
				//obj1.upDate();
			}
			
			for(Field f : fieldList)
			{
				if(obj1.position.getX() < f.endP.getX()
				&& obj1.position.getX() > f.startP.getX()
				&& obj1.position.getY() < f.endP.getY()
			    && obj1.position.getY() > f.startP.getY())
				{
					f.addForceTo(obj1);
				}
			}
		}
		
		
		
		for(PhysicsObj obj1 : calcList)
		{
			if(obj1.fixed)continue;
			obj1.upDate();
		}
		
	}
}
