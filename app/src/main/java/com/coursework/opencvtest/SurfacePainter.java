package com.coursework.opencvtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SurfacePainter extends SurfaceView implements SurfaceHolder.Callback {

    private DrawClock drawClock;

    public SurfacePainter(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        getHolder().addCallback(this);
    }

    public SurfacePainter(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    public SurfacePainter(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
    }

    public void SetPaint(float Ax, float Ay, float Bx, float By){
        drawClock.SetPaintThread(Ax, Ay, Bx, By);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawClock = new DrawClock(getHolder());
        drawClock.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                drawClock.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }

    }

    class DrawClock extends Thread {
        private SurfaceHolder surfaceHolder;

        public DrawClock(SurfaceHolder surfaceHolder) {
            this.surfaceHolder = surfaceHolder;

        }

        @Override
        public void run() {
            this.SetPaintThread(280,650,800,650);
        }

        public void SetPaintThread(float Ax, float Ay, float Bx, float By){
            Canvas canvas;
            canvas = null;
            try {
                canvas = surfaceHolder.lockCanvas(null);
                synchronized (surfaceHolder) {
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                    Paint pa = new Paint();
                    pa.setColor(Color.YELLOW);
                    pa.setStyle(Paint.Style.FILL);
                    canvas.drawCircle(Ax,Ay,10,pa);
                    canvas.drawCircle(Bx,By,10,pa);
                    pa.setStrokeWidth(3);
                    canvas.drawLine(Ax, Ay, Bx, By, pa);

                }
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }  finally {
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
