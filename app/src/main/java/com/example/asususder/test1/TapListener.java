package com.example.asususder.test1;

import android.view.MotionEvent;
import android.view.View;

public class TapListener implements View.OnTouchListener {


    private Map map;
    private SnakeGame snakegame;
    public TapListener (Map map, SnakeGame snakegame){
    this.map = map;
    this.snakegame = snakegame;

    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        int x1, y1;
        x1 = (int) event.getX();
        y1 = (int) event.getY();

        switch ( sectorNumber(x1, y1, snakegame.getWidth(), snakegame.getHeight())) {
            case 0: map.up();
                break;
            case 1: map.right();
                break;
            case 2: map.down();
                break;
            case 3: map.left();
                break;
        }
       // map.tick();
        //snakegame.invalidate();
        return false;
    }

    public boolean isAboveBC(int x1, int y1, int x, int y)
    {

        int x2 = (y - y1) * x / y;
        return (x2 >= x1);
    }

    public boolean isBelowAD(int x1, int y1, int x, int y) {
        int x2 = x*y1/y;
        return (x1 <= x2);
    }

    public int sectorNumber(int x1, int y1, int x, int y) {
        if (isAboveBC(x1,y1, x, y)) {
            if (isBelowAD( x1, y1, x, y)) {
                return 3;
            } else {
                return 0;}
        } else {
            if (isBelowAD( x1, y1, x, y)) {
                return 2;
            } else {
                return 1;}}
    }

}
