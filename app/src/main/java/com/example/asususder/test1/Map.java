package com.example.asususder.test1;

public class Map {

    private Snake s;
    private Food f;
    private int height, width;
    private int foodCounter;
    private int stepCount;
    private long startTime;

    public Map(int x, int y) {
        width = x;
        height = y;
        s = new Snake(x, y);
        f = new Food(x, y);
        foodCounter = 0;
        f.cook();
        while(!s.isFoodValid(f.getX(),f.getY()))
            f.cook();
        startTime = System.currentTimeMillis();
    }

    public void reset() {
        foodCounter = 0;
        stepCount = 0;
        startTime = System.currentTimeMillis();
        s = new Snake(width,height);
        f = new Food(width,height);
        f.cook();
        while(!s.isFoodValid(f.getX(),f.getY()))
            f.cook();
    }

    public void describeMe() {
        System.out.println(" "  );
        for (int i = 0; i<height; i++)
        {
            for (int j = 0; j< width; j++){
                System.out.print(" " + getCell(j, i));
            }
            System.out.println();
        }
        s.describeMe();
    }

    public void tick() {
        if (s.aboutToEat(f.getX(), f.getY())){
            s.eat();
            foodCounter++;
            stepCount++;
            f.cook();
            while (!s.isFoodValid(f.getX(), f.getY()))
                f.cook();
        }   
        else {
            if (s.aboutToDie()) {
                s.stopGame();
            } else  {
                s.move();
                stepCount++;
            }
        }   
    }

    public int getFoodCount () {
        return foodCounter;
    }

    public int getStepCount () {
        return stepCount;
    }

    public long getPassedTime () {
        return System.currentTimeMillis() - startTime;
    }

    public void right() {
        switch (s.getDirection()) {
            case 0: s.turnRight();
            break;
            case 2: s.turnLeft();
            break;
        }
    }

    public void left() {
        switch (s.getDirection()) {
            case 0: s.turnLeft();
            break;
            case 2: s.turnRight();
            break;
        }
    }

    public void up() {
        switch (s.getDirection()) {
            case 1: s.turnLeft();
            break;
            case 3: s.turnRight();
            break;
        }
    }

    public void down() {
        switch (s.getDirection()) {
            case 1: s.turnRight();
            break;
            case 3: s.turnLeft();
            break;
        }
    }

    public int getX() {
        return width;
    }

    public int getY() {
        return height;
    }

    public char getCell(int x, int y) {
        if (s.gameOver()) {
            return 'X';
        }
        if (f.isFoodThere(x, y)) {
            return 'x';
        }
        if (s.isHeadThere(x, y, 1)) {
            return 'B';
        }
        if (s.isHeadThere(x, y, 3)) {
            return 'b';
        }
        if (s.isHeadThere(x, y, 0)) {
            return 'Y';
        }
        if (s.isHeadThere(x, y, 2)) {
            return 'y';
        }
        if (s.isBodyThere(x,y, 0)) {
            return 'I';
        }
        if (s.isBodyThere(x,y, 1)) {
            return '-';
        }
        if (s.isBodyThere(x,y, 2)) {
            return 'I';
        }
        if (s.isBodyThere(x,y, 3)) {
            return '-';
        }
        if (s.isBodyThere(x,y, 4)) {
            return '4';
        }
        if (s.isBodyThere(x,y, 5)) {
            return '5';
        }
        if (s.isBodyThere(x,y, 6)) {
            return '6';
        }
        if (s.isBodyThere(x,y, 7)) {
            return '7';
        }
        if (s.isTailThere(x,y, 0)) {
            return 'V';
        }
        if (s.isTailThere(x,y, 1)) {
            return '>';
        }
        if (s.isTailThere(x,y, 2)) {
            return 'v';
        }
        if (s.isTailThere(x,y, 3)) {
            return '<';
        }
        return '_';
    }
}