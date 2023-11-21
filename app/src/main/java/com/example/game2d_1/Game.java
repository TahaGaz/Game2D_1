package com.example.game2d_1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.Random;

public class Game extends SurfaceView implements SurfaceHolder.Callback {
    public final Joystick joystick;
    private  Player player;
    public  GameLoop gameloop;
    private Snake snake;
    private  Cellule repas;
    int score=0;
    private Obstacles obstacles;

    public Game(Context context) {
        super(context);
        //int color= ContextCompat.getColor(context,R.color.Magenta);


        player=new Player(200,200,30,Color.RED);

        SurfaceHolder surfaceHolder=getHolder();
        surfaceHolder.addCallback(this);
        gameloop=new GameLoop(this,surfaceHolder);
        setFocusable(true);
        joystick =new Joystick(275,650,150,80);
        snake=new Snake(0,0,20);

        obstacles=new Obstacles();
        GenererRepas();
}

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
if (gameloop.getState().equals(Thread.State.TERMINATED)){
    gameloop=new GameLoop(this,surfaceHolder);
}

        gameloop.startLoop();

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        Paint p=new Paint();
        p.setColor(Color.BLUE);
        p.setTextSize(70);
        canvas.drawLine(2000,0,2000,1000,p);
        canvas.drawLine(0,0,0,1000,p);
       canvas.drawLine(0,0,2000,0,p);
        canvas.drawLine(0,1000,2000,1000,p);
        canvas.drawText("Score="+score,100,1070,p);
        joystick.draw(canvas);
        snake.draw(canvas);
        canvas.drawCircle(repas.x,repas.y,20,p);
        obstacles.draw(canvas);
        for(Cellule c:obstacles.obstacles){
            if(c.x<snake.SnakeBody.get(0).PositionX+20&&c.x>snake.SnakeBody.get(0).PositionX-20&&c.y<snake.SnakeBody.get(0).PositionY+20&&c.y>snake.SnakeBody.get(0).PositionY-20)
            {
                p.setColor(Color.RED);
                p.setTextSize(150);
                canvas.drawText("GameOver",(float) snake.SnakeBody.get(0).PositionX, (float) snake.SnakeBody.get(0).PositionY,p);

            }
        }


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                if(joystick.isPressed((double) event.getX(),(double) event.getY())){
                    joystick.setIsPressed(true);
                }


                return true;
            case MotionEvent.ACTION_MOVE:
                if(joystick.getIsPressed())
                {   joystick.setActuator((double) event.getX(),(double) event.getY());
 }
                return true;
            case MotionEvent.ACTION_UP:
                    joystick.setIsPressed(false);
                   // joystick.resetActuator();

                    return true;


        }



        return super.onTouchEvent(event);
    }




    public void Update() {
        for(Cellule c:obstacles.obstacles){
            if(c.x<snake.SnakeBody.get(0).PositionX+20
                    &&c.x>snake.SnakeBody.get(0).PositionX-20
                    &&c.y<snake.SnakeBody.get(0).PositionY+20&&
                    c.y>snake.SnakeBody.get(0).PositionY-20)
                return;
        }

        player.Update(joystick);
        joystick.Update();
        snake.Update(joystick);
        if (repas.x<snake.SnakeBody.get(0).PositionX+40&&repas.x>snake.SnakeBody.get(0).PositionX-40&&repas.y<snake.SnakeBody.get(0).PositionY+40&&repas.y>snake.SnakeBody.get(0).PositionY-40){
            snake.SnakeBody.add(new Player(repas.x,repas.y,20,Color.GREEN));
            GenererRepas();
            score++;


    }

}
    void GenererRepas() {
        Random r = new Random();
        boolean collision;

        do {
            collision = false;
            int x = r.nextInt(2000);
            int y = r.nextInt(1000);

            // Check for collision with snake body
            for (Player c : snake.SnakeBody) {
                if (c.PositionX == x && c.PositionY == y) {
                    collision = true;
                    break;
                }
            }

            // Check for collision with obstacles
            for (Cellule c : obstacles.obstacles) {
                if (x < c.x + 40 && x > c.x - 40 && y < c.y + 40 && y > c.y - 40) {
                    collision = true;
                    break;
                }
            }

            if (!collision) {
                repas = new Cellule(x, y, Color.BLACK);
            }
        } while (collision);
    }


    public void pause() {
        gameloop.stopLoop();
    }
}