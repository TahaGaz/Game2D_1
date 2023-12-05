package com.example.game2d_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
public Game game;
    Window window;
int level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
window=getWindow();
        window.setFlags(
               WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN

        );
        Bundle extras=getIntent().getExtras();
        if(extras !=null){
             level = extras.getInt("level");
        }
        game=new Game(this,level);
        setContentView(game);


    }

    @Override
    protected void onPause() {
        game.pause();
        super.onPause();

}

    @Override
    public void onBackPressed() {

startActivity(new Intent(this, MainMenu.class));
        super.onBackPressed();
    }
}
