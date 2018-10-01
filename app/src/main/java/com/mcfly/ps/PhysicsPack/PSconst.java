package com.mcfly.ps.PhysicsPack;
import android.util.*;

public class PSconst
{
	final public static float frameT = 1 / 60f;//绘制帧数 Hz
	//public static float calcTime = 1 / 100f;//计算频率 Hz
	public static final double G = 6.67259E-11;
	public static final float g = 9.8f;
	public static final float meterInWeight = 10;
	public static float scaleSceern;//以横向显示多少米为准
	
	static void setScaleFactor(int height, int weight)
	{
		scaleSceern = weight / meterInWeight;
		//Log.i("PSconst", "weight:" + weight);
	}
}
