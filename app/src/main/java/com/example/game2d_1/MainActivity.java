package com.example.game2d_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
public Game game;
    Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
window=getWindow();
        window.setFlags(
               WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN

        );
        game=new Game(this);
        setContentView(game);


    }

    @Override
    protected void onPause() {
        game.pause();
        super.onPause();

}}