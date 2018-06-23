package com.example.asususder.test1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SnakeGame snakeGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        snakeGame = new SnakeGame(this.getApplicationContext(),null);
        // setContentView(R.layout.activity_main);
        setContentView(snakeGame);
    }
    public void showToast(View v) {
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        snakeGame.setStatus(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        snakeGame.setStatus(false);
    }
}
