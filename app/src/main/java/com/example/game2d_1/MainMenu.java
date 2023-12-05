package com.example.game2d_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    private int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Button b1 = findViewById(R.id.button);
        Button b2 = findViewById(R.id.button3);
        Button b3 = findViewById(R.id.button2);
        Button b4 = findViewById(R.id.button4);
        Button b5 = findViewById(R.id.button5);
Intent i=new Intent(MainMenu.this, MainActivity.class);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("level",1);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("level",2);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
            i.putExtra("level",3);
            startActivity(i);
    }
    });

        b4.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
            i.putExtra("level",4);
            startActivity(i);
    }
    });
  b5.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
            i.putExtra("level",5);
            startActivity(i);
    }
    });

}}