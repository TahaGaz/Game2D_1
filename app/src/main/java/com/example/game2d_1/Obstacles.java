package com.example.game2d_1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

public class Obstacles {
    ArrayList<Cellule> obstacles;

public Obstacles(int level){
    obstacles=new ArrayList<Cellule>();
    int i= 0;
if (level==1){
    for ( i = 200; i < 900; i++) {
        obstacles.add(new Cellule(1400, i, Color.DKGRAY));
    }
        for (i = 200; i < 900; i++) {
            obstacles.add(new Cellule(900, i, Color.DKGRAY));
        }
    }
if (level==2){
        for ( i = 200; i < 900; i++) {
            obstacles.add(new Cellule(1000, i, Color.DKGRAY));
        }
        for (i = 500; i < 1500; i++) {
            obstacles.add(new Cellule( i,500, Color.DKGRAY));
        }
    }
if (level==3){
    for ( i = 200; i < 700; i++) {
        obstacles.add(new Cellule(i, 200, Color.DKGRAY));
        obstacles.add(new Cellule(i, 201, Color.DKGRAY));
        obstacles.add(new Cellule(i, 399, Color.DKGRAY));
        obstacles.add(new Cellule(i, 400, Color.DKGRAY));
    }
    for ( i = 1400; i < 1900; i++) {
        obstacles.add(new Cellule(i, 300, Color.DKGRAY));
        obstacles.add(new Cellule(i, 301, Color.DKGRAY));
        obstacles.add(new Cellule(i, 599, Color.DKGRAY));
        obstacles.add(new Cellule(i, 600, Color.DKGRAY));
    }

    for ( i = 500; i < 900; i++) {
        obstacles.add(new Cellule(1200, i, Color.DKGRAY));

    }
}
if (level==4){
        for(i=100;i<1000;i+=300){
            for(int j=100;j<1900;j+=300){
                   for(int k=0;k<100;k++){
                obstacles.add(new Cellule(j, i+k, Color.DKGRAY));
                obstacles.add(new Cellule(j+100, i+k, Color.DKGRAY));
                obstacles.add(new Cellule(j+k, i+100, Color.DKGRAY));
                obstacles.add(new Cellule(j+k, i, Color.DKGRAY));
            }}}


    }
if (level==5){
        for(i=100;i<1000;i+=500){
            for(int j=100;j<1900;j+=300){
                for(int k=0;k<200;k++)
                    obstacles.add(new Cellule(j+k, i+k, Color.DKGRAY));

            }}


    }
}
    public void draw(Canvas canvas) {
        Paint p =new Paint();
        p.setColor(Color.DKGRAY);
        for(Cellule c:obstacles){

            canvas.drawCircle(c.x,c.y,20,p);

        }
    }
}
