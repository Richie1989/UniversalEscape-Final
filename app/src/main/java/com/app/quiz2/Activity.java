package com.app.quiz2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.quiz2.entities.EntityCreator;
import com.app.quiz2.entities.ship.Ship;
import com.app.quiz2.lib.GameView;

/**
 */
public class Activity extends AppCompatActivity {

    private static Game game;
    private static GameView gameView;



    public static Context getContext() {
        return context;
    }


    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null && savedInstanceState.containsKey("game")) {
            game = (Game) savedInstanceState.getSerializable("game");
        } else {
            game = new Game();
        }
        context = this;
    }

    @Override
    protected void onResume() {
        super.onResume();

        setContentView(R.layout.activity_play);
        gameView = findViewById(R.id.universalEscape);
        gameView.setGame(game);

    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.setGame(null);
    }




}
