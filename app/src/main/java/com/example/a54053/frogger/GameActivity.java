package com.example.a54053.frogger;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a54053.frogger.FrogView.FrogView;
import com.example.a54053.frogger.GameEngine.GameEngine;
import com.example.a54053.frogger.Objects.GameObject;

public class GameActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private long delay = 100;
    private GameEngine gameEngine;
    private FrogView frogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gameEngine = new GameEngine();
        gameEngine.init();

        frogView = findViewById(R.id.frogView);
        frogView.setGameObjects(gameEngine.getGameObjects());
        frogView.setFrog(gameEngine.getFrog());

    }


    private void startUpdateHandler(){
         handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            gameEngine.update();
        }
    },delay);


}

}
