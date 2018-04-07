package com.example.a54053.frogger;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.a54053.frogger.Enums.GameState;
import com.example.a54053.frogger.FrogView.FrogView;
import com.example.a54053.frogger.GameEngine.GameEngine;
import com.example.a54053.frogger.Objects.Frog;
import com.example.a54053.frogger.Objects.GameObject;

public class GameActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private long delay = 1000;
    private GameEngine gameEngine;
    private FrogView frogView;
    private TextView scoreBoard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gameEngine = new GameEngine();
        gameEngine.init();

        frogView = findViewById(R.id.frogView);
        frogView.setGameObjects(gameEngine.getGameObjects());
        frogView.setFrog(gameEngine.getFrog());
        frogView.setOnTouchListener(gameEngine.getFrog());

        scoreBoard = findViewById(R.id.life);
        startUpdateHandler();
    }


    private void startUpdateHandler(){
         handler.postDelayed(new Runnable() {
        @Override
        public void run() {

            if(gameEngine.getGameState() == GameState.Running){

                scoreBoard.setText("Life  "+gameEngine.getLife());
                gameEngine.update();
                frogView.setGameObjects(gameEngine.getGameObjects());
                frogView.setFrog(gameEngine.getFrog());
                handler.postDelayed(this,delay);
                frogView.invalidate();
            }else if(gameEngine.getGameState()==GameState.Losing){
                Log.d("GAMELOST","Lost");
                onGameLost();
            }
        }
    },delay);
}

    private void onGameLost() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);



    }


}
