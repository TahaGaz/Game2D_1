package com.example.game2d_1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Joystick {

    private final Paint outerCirclePaint;
    private final Paint innerCirclePaint;
    private  int outerCircleCenterPositionX;
    private  int outerCircleCenterPositionY;
    private  int innerCircleCenterPositionX;
    private  int innerCircleCenterPositionY;
    private  int innerCircleRadius;
    private  int outerCircleRadius;
    private double joystickCenterToTouchDistance;
    private boolean IsPressed;
    private double actuatorX=1;
    private double actuatorY=0;


    public Joystick(int CenterPositionX,int CenterPositionY,int outerCircleRadius,int innerCircleRadius){
        outerCircleCenterPositionX=CenterPositionX;
        outerCircleCenterPositionY=CenterPositionY;
        innerCircleCenterPositionX=CenterPositionX;
        innerCircleCenterPositionY=CenterPositionY;
        this.outerCircleRadius=outerCircleRadius;
        this.innerCircleRadius=innerCircleRadius;

        outerCirclePaint=new Paint();
        outerCirclePaint.setColor(Color.DKGRAY);
        outerCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        innerCirclePaint=new Paint();
        innerCirclePaint.setColor(Color.GRAY);
        innerCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);



    }
    public void Update() {
        updateInnerCirclePosition();
    }

    private void updateInnerCirclePosition() {
        innerCircleCenterPositionX=(int)(outerCircleCenterPositionX+actuatorX*outerCircleRadius);
        innerCircleCenterPositionY=(int)(outerCircleCenterPositionY+actuatorY*outerCircleRadius);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(outerCircleCenterPositionX,outerCircleCenterPositionY,outerCircleRadius,outerCirclePaint);
        canvas.drawCircle(innerCircleCenterPositionX,innerCircleCenterPositionY,innerCircleRadius,innerCirclePaint);
        innerCirclePaint.setTextSize(70);


    }

    public boolean isPressed(double TouchPositionX, double TouchPositionY) {
        joystickCenterToTouchDistance=Math.sqrt(
                Math.pow(outerCircleCenterPositionX-TouchPositionX,2)+
                        Math.pow(outerCircleCenterPositionY-TouchPositionY,2)

        );
        return (joystickCenterToTouchDistance<outerCircleRadius);
    }

    public void setIsPressed(boolean IsPressed) {
        this.IsPressed=IsPressed;
    }


    public boolean getIsPressed(){
        return  IsPressed;
    }

    public void setActuator(double TouchPositionX, double TouchPositionY) {
        double deltaX=TouchPositionX-outerCircleCenterPositionX;
        double deltaY=TouchPositionY-outerCircleCenterPositionY;
        double deltaDistance = Math.sqrt(Math.pow(deltaX,2)+Math.pow(deltaY,2));

        if (deltaDistance<outerCircleRadius){
            actuatorX=deltaX/outerCircleRadius;
             actuatorY = deltaX / outerCircleRadius;

        }

        else{
           actuatorX=deltaX/deltaDistance;
           actuatorY=deltaY/deltaDistance;
        }
/////////////////////////////for snake game////////////////////////////////////////////////
        ////////////////////////////turn smooth analog into for direction control//////////////////////
        if(actuatorX>0.5||(actuatorX<0&&actuatorX>-0.5)){
          actuatorX=Math.ceil(actuatorX);
        }else {
            actuatorX=Math.floor(actuatorX);
        }
        if(actuatorY>0.5||(actuatorY<0&&actuatorY>-0.5)){
            actuatorY=Math.ceil(actuatorY);
        }else {
            actuatorY=Math.floor(actuatorY);
        }
       if (actuatorX==1&&actuatorY==-1){
           actuatorX=0;
       }
        if (actuatorX==1&&actuatorY==1){
            actuatorX=0;
        }
        if (actuatorX==-1&&actuatorY==1){
            actuatorY=0;
        }
        if (actuatorX==-1&&actuatorY==-1){
            actuatorY=0;
        }
    }

//    public void resetActuator() {
  //      actuatorY=0;
      //  actuatorX=0;
    //}

    public double getActuatorX() {
        return  actuatorX;
    }
    public double getActuatorY() {
        return  actuatorY;
    }
}
