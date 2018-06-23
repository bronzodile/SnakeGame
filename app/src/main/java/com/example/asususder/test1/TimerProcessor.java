package com.example.asususder.test1;

import android.os.Handler;

public class TimerProcessor implements Runnable {

    private Map map;
    private SnakeGame snakegame;
    private Handler handler;

    public TimerProcessor(Map map, SnakeGame snakegame, Handler handler) {
        this.map = map;
        this.snakegame = snakegame;
        this.handler = handler;


    }


    @Override
    public void run() {
        map.tick();
        snakegame.invalidate();
       if (snakegame.getStatus())   {
        handler.postDelayed(this, 800);}

    }
}

