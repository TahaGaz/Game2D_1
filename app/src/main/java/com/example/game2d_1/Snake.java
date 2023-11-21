package com.example.game2d_1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;

public class Snake {

    public  ArrayList<Player> SnakeBody;

    public Snake(double Xstart,double Ystart,double Radius){
SnakeBody=new ArrayList<Player>();
SnakeBody.add(new Player(Xstart,Ystart,Radius, Color.RED));
        SnakeBody.add(new Player(Xstart-2*Radius,Ystart,Radius, Color.RED));
        SnakeBody.add(new Player(Xstart-4*Radius,Ystart,Radius, Color.GREEN));
        SnakeBody.add(new Player(Xstart-6*Radius,Ystart,Radius, Color.GREEN));
        SnakeBody.add(new Player(Xstart-8*Radius,Ystart,Radius, Color.GREEN));
        SnakeBody.add(new Player(Xstart-10*Radius,Ystart,Radius, Color.GREEN));

    }


    public void draw(Canvas canvas) {
        for (Player cellule:SnakeBody) {
            cellule.draw(canvas);
        }
        canvas.drawText(Double.toString(SnakeBody.get(0).PositionX),100,100,new Paint(Color.RED));
    }


    public void Update(Joystick joystick) {
        for(int i=SnakeBody.size()-1;i>=1;i--){
            SnakeBody.get(i).PositionX=SnakeBody.get(i-1).PositionX;
            SnakeBody.get(i).PositionY=SnakeBody.get(i-1).PositionY;
        }
        SnakeBody.get(0).Update(joystick);
        if(SnakeBody.get(0).PositionY>=1000){
            SnakeBody.get(0).PositionY=1;
        }
        if(SnakeBody.get(0).PositionX>=2000){
            SnakeBody.get(0).PositionX=1;
        }
        if(SnakeBody.get(0).PositionX<=0){
            SnakeBody.get(0).PositionX=1999;
        }
        if(SnakeBody.get(0).PositionY<=0){
            SnakeBody.get(0).PositionY=999;
        }
    }


}
