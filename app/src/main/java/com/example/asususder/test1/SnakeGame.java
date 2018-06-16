package com.example.asususder.test1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
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

    public SnakeGame(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        myPaint = new Paint();
        myPaint.setColor(Color.BLACK);
        myRedPaint = new Paint();
        myRedPaint.setColor(Color.RED);
        map = new Map (X,Y);
        apple = BitmapFactory.decodeResource(getResources(),R.drawable.apple);
        snakeheadright =BitmapFactory.decodeResource(getResources(),R.drawable.snakeheadright);
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
                    canvas.drawBitmap(apple,null,new RectF(j * rowW + deltaW, i * rowH + deltaH, j * rowW + rowW + deltaW, i * rowH + rowH + deltaH),myPaint);
                }
                if (tempCell == 'B') {
                    canvas.drawBitmap(snakeheadright, null, new RectF(j*rowW + deltaW, i*rowH + deltaH, j*rowW + rowW + deltaW, i*rowH + rowH + deltaH), myPaint );

                }
            }
        }
    }
}

