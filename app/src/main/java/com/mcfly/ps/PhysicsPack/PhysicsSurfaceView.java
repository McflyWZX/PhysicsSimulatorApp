package com.mcfly.ps.PhysicsPack;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.view.SurfaceHolder.*;
import javax.security.auth.callback.*;
import com.mcfly.ps.PhysicsPack.*;
import android.util.*;
import java.util.*;

public abstract class PhysicsSurfaceView extends SurfaceView implements Callback
{

	LoopThread thread;  
	Canvas c;
	long T, t, tfps, FPS, dt;
	static ArrayList<Graphic> graphic = new ArrayList<Graphic>();


    public PhysicsSurfaceView(Context context) {  
        super(context);  

        init(); //初始化,设置生命周期回调方法  
		//graphic.add(b2 = new Cube(5E17f, 50, 50, new Vector2(700, 1100), new Vector2(-450.236f, 0)));

		//phc.run();
    }  

	public abstract void uInit();
	
    private void init(){  

        SurfaceHolder holder = getHolder();  
        holder.addCallback(this); //设置Surface生命周期回调  
        thread = new LoopThread(holder, getContext());  
		
    }  

    @Override  
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {  
    }  

    @Override  
    public void surfaceCreated(SurfaceHolder holder) {  
		
        thread.isRunning = true;  
        thread.start();  
		PSconst.setScaleFactor(this.getHeight(), this.getWidth());
		uInit();
    }  

    @Override  
    public void surfaceDestroyed(SurfaceHolder holder) {  
        thread.isRunning = false;  
        try {  
            thread.join();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  

	int touchedId;
	@Override
	public boolean onTouchEvent(MotionEvent event) {



		return true;
	}

	public abstract void onRun();

	public static void addObj(Graphic obj)
	{
		graphic.add(obj);
	}
    /** 
     * 执行绘制的绘制线程 
     * @author Administrator 
     * 
     */  
    class LoopThread extends Thread{  

        SurfaceHolder surfaceHolder;  
        Context context;  
        boolean isRunning;  
        float radius = 10f;  
        Paint paint;  

        public LoopThread(SurfaceHolder surfaceHolder,Context context){  

            this.surfaceHolder = surfaceHolder;  
            this.context = context;  
            isRunning = false;  

            paint = new Paint();  
            paint.setColor(Color.YELLOW);  
            //paint.setStyle(Paint.Style.STROKE);  
			paint.setAntiAlias(true);
        }  

        @Override  
        public void run() {  

            //c = null;  
			t = System.currentTimeMillis();
            while(isRunning){  

                try{  
                    synchronized (surfaceHolder) {  
						T = System.currentTimeMillis();
						Log.i("farme", "帧开始");
						dt = System.currentTimeMillis() - 
							tfps++;
						if(T - t > 1000)
						{
							FPS = tfps;
							tfps = 0;
							t = System.currentTimeMillis();
						}
                        c = surfaceHolder.lockCanvas(null);  
						onRun();
						PHC.run();
                        doDraw(c);  
						Log.i("farme", "帧结束");
						dt = System.currentTimeMillis() - T;
                        //通过它来控制帧数执行一次绘制后休息50ms  
                        Thread.sleep((int)Math.max(((PSconst.frameT * 1000) - dt), 0));  
						//Thread.sleep(0);
                    }  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                } finally {  
                    surfaceHolder.unlockCanvasAndPost(c);  
                }  

            }  

        }  

        public void doDraw(Canvas c){  

            //这个很重要，清屏操作，清楚掉上次绘制的残留图像  
            c.drawColor(Color.BLACK);  

            c.translate(0, 0);  
			paint.setTextSize(40);
			paint.setStrokeWidth(1);
			paint.setColor(Color.LTGRAY);
            c.drawText("FPS:" + FPS + "; 屏幕宽度" + PSconst.scaleSceern * PSconst.meterInWeight, 20, 70, paint);
			//绘制坐标轴
			paint.setStrokeWidth(5);
			paint.setColor(Color.BLUE);
			c.drawLine(10, 10, PSconst.scaleSceern + 10, 10, paint);
			paint.setColor(Color.RED);
			c.drawLine(10, 10, 10, PSconst.scaleSceern + 10, paint);
			paint.setStrokeWidth(10);
			paint.setColor(Color.CYAN);
			for(Graphic obj: graphic)
			{
				obj.draw(c, paint);
			}

        }  
		
		

    }
}
