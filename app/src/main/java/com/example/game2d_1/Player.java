package com.example.game2d_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

public class Player {
    private static final double SPEED_PIXEL_PER_SECOND =600 ;
    private static final double MAX_SPEED = SPEED_PIXEL_PER_SECOND/GameLoop.MAX_UPS;
    private Paint paint;
    private double radius;
    public double PositionY;
    public double PositionX;
    private double velocityX;
    private double velocityY;
    int color;


    public Player( double positionX, double positionY, double radius,int color){
        this.PositionX=positionX;
        this.PositionY=positionY;
        this.radius=radius;

        paint=new Paint();
        this.color=color;
        paint.setColor(color);

    }

    public Player(Player player) {
        this.PositionX= player.PositionX;
        this.PositionY= player.PositionY;
        this.radius=player.radius;
        this.color= player.color;
    }


    public void draw(Canvas canvas) {
        canvas.drawCircle((float)PositionX,(float)PositionY,(float)radius,paint);
    }

    public void Update(Joystick joystick) {
        velocityX=(joystick.getActuatorX())*MAX_SPEED;
        velocityY=(joystick.getActuatorY())*MAX_SPEED;
        PositionY+=velocityY;
        PositionX+=velocityX;
    }

    public void setPosition(double x, double y) {
        PositionX=x;
        PositionY=y;

    }
}
