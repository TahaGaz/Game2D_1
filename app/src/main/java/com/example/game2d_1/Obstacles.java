package com.example.game2d_1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

public class Obstacles {
    ArrayList<Cellule> obstacles;

public Obstacles(){
    obstacles=new ArrayList<Cellule>();


    for (int i=200;i<700;i++){
        obstacles.add(new Cellule(i, 200, Color.DKGRAY));
        obstacles.add(new Cellule(i, 201, Color.DKGRAY));
        obstacles.add(new Cellule(i, 399, Color.DKGRAY));
        obstacles.add(new Cellule(i, 400, Color.DKGRAY));
    }
    for (int i=1400;i<1900;i++){
        obstacles.add(new Cellule(i, 300, Color.DKGRAY));
        obstacles.add(new Cellule(i, 301, Color.DKGRAY));
        obstacles.add(new Cellule(i, 599, Color.DKGRAY));
        obstacles.add(new Cellule(i, 600, Color.DKGRAY));
    }

    for (int i=500;i<900;i++){
        obstacles.add(new Cellule(1200, i, Color.DKGRAY));

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
