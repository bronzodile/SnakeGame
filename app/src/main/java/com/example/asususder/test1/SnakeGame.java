package com.example.asususder.test1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class SnakeGame extends View {
    private Paint myPaint;
    private Paint myRedPaint;
    private Map map;
    private final int X = 10;
    private final int Y = 15;
    private Bitmap apple;
    private Bitmap snakeheadright;
    private Bitmap snakebodyv;
    private Bitmap snakebodyh;
    private Bitmap snaketailright;
    private Bitmap snaketailleft;
    private Bitmap snaketaildown;
    private Bitmap snaketailup;
    private Bitmap snakeheadleft;
    private Bitmap snakeheadup;
    private Bitmap snakeheaddown;
    private Bitmap snaketurn4;
    private Bitmap snaketurn5;
    private Bitmap snaketurn6;
    private Bitmap snaketurn7;
    private TapListener tapListener;
    private TimerProcessor timerProcessor;
    private Handler handler;
    private boolean status;

    public SnakeGame(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        myPaint = new Paint();
        myPaint.setColor(Color.BLACK);
        myRedPaint = new Paint();
        myRedPaint.setColor(Color.RED);
        map = new Map (X,Y);
        apple = BitmapFactory.decodeResource(getResources(),R.drawable.apple);
        snakeheadright = BitmapFactory.decodeResource(getResources(),R.drawable.snakeheadright);
        snakebodyv = BitmapFactory.decodeResource(getResources(),R.drawable.snakebodyv);
        snakebodyh = BitmapFactory.decodeResource(getResources(), R.drawable.snakebodyh);
        snaketailright = BitmapFactory.decodeResource(getResources(), R.drawable.snaketailright);
        snaketailleft = BitmapFactory.decodeResource(getResources(), R.drawable.snaketailleft);
        snaketaildown = BitmapFactory.decodeResource(getResources(), R.drawable.snaketaildown);
        snaketailup = BitmapFactory.decodeResource(getResources(), R.drawable.snaketailup);
        snakeheadleft = BitmapFactory.decodeResource(getResources(), R.drawable.snakeheadleft);
        snakeheadup = BitmapFactory.decodeResource(getResources(), R.drawable.snakeheadup);
        snakeheaddown = BitmapFactory.decodeResource(getResources(), R.drawable.snakeheaddown);
        snaketurn4 = BitmapFactory.decodeResource(getResources(), R.drawable.snaketurn4);
        snaketurn5 = BitmapFactory.decodeResource(getResources(), R.drawable.snaketurn5);
        snaketurn6 = BitmapFactory.decodeResource(getResources(), R.drawable.snaketurn6);
        snaketurn7 = BitmapFactory.decodeResource(getResources(), R.drawable.snaketurn7);

        tapListener = new TapListener(map , this);
        this.setOnTouchListener(tapListener);
        handler = new Handler();
        timerProcessor = new TimerProcessor(map, this, handler);


    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;

        if (status) {
            handler.postDelayed(timerProcessor, 800); }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


       // canvas.drawLine(1f,1f,100f,100f,myPaint);
        // canvas.drawCircle(canvas.getWidth() / 2 ,canvas.getHeight() / 2 , 200, myRedPaint );


        int height = 0;
        int width = 0;
        int x = (this.getWidth());
        int y = (this.getHeight());
        int deltaW = 0;
        int deltaH = 0;

        // g.drawLine(x, y, width, height);

        int rowH = y / map.getY();
        int rowW = x / map.getX();
        deltaW = (x - rowW * map.getX()) / 2;
        deltaH = (y - rowH * map.getY()) / 2;
        int [] xArray = {0, x, x/2};
        int [] yArray = {0, 0, y/2};

        for (int i = 0; i <= map.getY(); i ++) {
            canvas.drawLine(0 + deltaW, rowH * i + deltaH, map.getX() * rowW + deltaW, rowH * i + deltaH,myPaint);
        }

        for (int j = 0; j <= map.getX(); j ++) {
            canvas.drawLine(rowW * j + deltaW, 0 + deltaH, rowW * j + deltaW, map.getY() * rowH + deltaH, myPaint);
        }

        for (int i = 0; i < map.getY(); i++) {
            for (int j = 0; j < map.getX(); j++) {
                char tempCell = map.getCell(j, i);
                if (tempCell == 'x') {
                    // canvas.drawRect(j * rowW + deltaW, i * rowH + deltaH, j * rowW + rowW + deltaW, i * rowH + rowH + deltaH, myRedPaint);
                    // canvas.drawBitmap(apple,j * rowW + deltaW, i * rowH + deltaH,myPaint);
                    canvas.drawBitmap(apple, null, new RectF(j * rowW + deltaW, i * rowH + deltaH, j * rowW + rowW + deltaW, i * rowH + rowH + deltaH), myPaint);
                }
                if (tempCell == 'B') {
                    canvas.drawBitmap(snakeheadright, null, new RectF(j * rowW + deltaW, i * rowH + deltaH, j * rowW + rowW + deltaW, i * rowH + rowH + deltaH), myPaint);
                }
                if (tempCell == 'I') {
                    canvas.drawBitmap(snakebodyv, null, new RectF(j * rowW + deltaW, i * rowH + deltaH, j * rowW + rowW + deltaW, i * rowH + rowH + deltaH), myPaint);
                }
                if (tempCell == '-') {
                    canvas.drawBitmap(snakebodyh, null, new RectF(j * rowW + deltaW, i * rowH + deltaH, j * rowW + rowW + deltaW, i * rowH + rowH + deltaH), myPaint);
                }
                if (tempCell == '<') {
                    canvas.drawBitmap(snaketailright, null, new RectF(j * rowW + deltaW, i * rowH + deltaH, j * rowW + rowW + deltaW, i * rowH + rowH + deltaH), myPaint);
                }
                if (tempCell == '>') {
                    canvas.drawBitmap(snaketailleft, null, new RectF(j * rowW + deltaW, i * rowH + deltaH, j * rowW + rowW + deltaW, i * rowH + rowH + deltaH), myPaint);
                }
                if (tempCell == 'V') {
                    canvas.drawBitmap(snaketaildown, null, new RectF(j * rowW + deltaW, i * rowH + deltaH, j * rowW + rowW + deltaW, i * rowH + rowH + deltaH), myPaint);
                }
                if (tempCell == 'v') {
                    canvas.drawBitmap(snaketailup, null, new RectF(j * rowW + deltaW, i * rowH + deltaH, j * rowW + rowW + deltaW, i * rowH + rowH + deltaH), myPaint);
                }
                if (tempCell == 'b') {
                    canvas.drawBitmap(snakeheadleft, null, new RectF(j * rowW + deltaW, i * rowH + deltaH, j * rowW + rowW + deltaW, i * rowH + rowH + deltaH), myPaint);
                }
                if (tempCell == 'Y') {
                    canvas.drawBitmap(snakeheadup, null, new RectF(j * rowW + deltaW, i * rowH + deltaH, j * rowW + rowW + deltaW, i * rowH + rowH + deltaH), myPaint);
                }
                if (tempCell == 'y') {
                    canvas.drawBitmap(snakeheaddown, null, new RectF(j * rowW + deltaW, i * rowH + deltaH, j * rowW + rowW + deltaW, i * rowH + rowH + deltaH), myPaint);
                }
                if (tempCell == '4') {
                    canvas.drawBitmap(snaketurn4, null, new RectF(j * rowW + deltaW, i * rowH + deltaH, j * rowW + rowW + deltaW, i * rowH + rowH + deltaH), myPaint);
                }
                if (tempCell == '5') {
                    canvas.drawBitmap(snaketurn5, null, new RectF(j * rowW + deltaW, i * rowH + deltaH, j * rowW + rowW + deltaW, i * rowH + rowH + deltaH), myPaint);
                }
                if (tempCell == '6') {
                    canvas.drawBitmap(snaketurn6, null, new RectF(j * rowW + deltaW, i * rowH + deltaH, j * rowW + rowW + deltaW, i * rowH + rowH + deltaH), myPaint);
                }
                if (tempCell == '7') {
                    canvas.drawBitmap(snaketurn7, null, new RectF(j * rowW + deltaW, i * rowH + deltaH, j * rowW + rowW + deltaW, i * rowH + rowH + deltaH), myPaint);
                }

            }
        }
    }
}

