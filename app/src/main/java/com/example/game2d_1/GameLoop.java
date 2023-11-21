package com.example.game2d_1;


import android.graphics.Canvas;

import android.view.SurfaceHolder;

public class GameLoop extends Thread {
    static final double MAX_UPS=60;
    private static final double UPS_PERIOD=1E+3/MAX_UPS;
    public boolean isRunning=false;
    private final SurfaceHolder surfaceHolder;
    private  Game game;
    private double averageUPS;
    private double averageFPS;

    public GameLoop(Game game, SurfaceHolder surfaceHolder) {
        this.surfaceHolder=surfaceHolder;
        this.game=game;
    }


    public void startLoop() {
         isRunning = true;
         start();

    }


    @Override
    public void run() {
        super.run();

        int UpdateCount=0;
        int frameCount=0;

        long startTime=0;
        long elapsedTime=0;
        long sleepTime=0;

        Canvas canvas=new Canvas();
        startTime=System.currentTimeMillis();

        while (isRunning){
            try {
                canvas=surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    game.Update();
                    UpdateCount++;
                    game.draw(canvas);
                }
                surfaceHolder.unlockCanvasAndPost(canvas);
                frameCount++;

            }catch (Exception e){


            }
            sleepTime=(long)(UpdateCount*UPS_PERIOD -elapsedTime);
            if(sleepTime>0){
                try {
                    sleep(sleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
while (sleepTime<0&&UpdateCount<MAX_UPS-1){

    game.Update();
    UpdateCount++;
    elapsedTime=System.currentTimeMillis()-startTime;
    sleepTime=(long)(UpdateCount*UPS_PERIOD -elapsedTime);
}



elapsedTime=System.currentTimeMillis()-startTime;
if (elapsedTime>=1000){
    averageUPS=UpdateCount/(elapsedTime/1000);
    averageFPS=frameCount/(elapsedTime/1000);

    UpdateCount=0;
    frameCount=0;
    startTime=System.currentTimeMillis();
}
        }

    }


    public void stopLoop() {
        isRunning=false;
        try {
            join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
