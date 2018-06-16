package com.example.asususder.test1;

import com.example.asususder.test1.GenLinkedList.*;

public class Snake {

    private LinkedList<Segment> segments;
    private int direction;
    private int maxX, maxY;
    private boolean gameOver;
    private int oldDirection;

    public Snake(int x, int y){
        segments = new LinkedList<Segment>();
        direction = 1;
        oldDirection = 1;
        maxX = x;
        maxY = y;
        int midX = x/2;
        int midY = y/2;
        segments.append(new Segment(midX + 1,midY));
        segments.append(new Segment(midX,midY));
        segments.append(new Segment(midX - 1,midY));
        gameOver = false;
    }

    public boolean isFoodValid(int x, int y){
        for (int i = 0; i<segments.length(); i++) {
            Segment curSegment = segments.getValue(i);
            if ((curSegment.x == x) && (curSegment.y == y))
                return false;
        }
        return true;
    }

    public boolean aboutToEat(int x, int y){
        Segment tempHeadSegment = segments.getValue(0);
        Segment headSegment = new Segment(tempHeadSegment.x,tempHeadSegment.y);
        switch (direction) {
            case 1: headSegment.x = headSegment.x +1;
            if (headSegment.x == maxX) {
                headSegment.x = 0;
            }
            break;
            case 2: headSegment.y = headSegment.y +1;
            if (headSegment.y == maxY) {
                headSegment.y = 0;
            }
            break;
            case 3: headSegment.x = headSegment.x -1;
            if (headSegment.x == -1) {
                headSegment.x = maxX -1;
            }
            break;
            case 0: headSegment.y = headSegment.y -1;
            if (headSegment.y == -1) {
                headSegment.y = maxY -1;
            }
            break;
        }
        if ((headSegment.x == x) && (headSegment.y == y))
            return true;
        return false;
    }

    public void eat() {
        if (gameOver){
            return;
        }
        Segment tempHeadSegment = segments.getValue(0);
        Segment newHeadSegment = new Segment(tempHeadSegment.x,tempHeadSegment.y);
        switch (direction) {
            case 1: newHeadSegment.x = newHeadSegment.x +1;
            if (newHeadSegment.x == maxX) {
                newHeadSegment.x = 0;
            }
            break;
            case 2: newHeadSegment.y = newHeadSegment.y +1;
            if (newHeadSegment.y == maxY) {
                newHeadSegment.y = 0;
            }
            break;
            case 3: newHeadSegment.x = newHeadSegment.x -1;
            if (newHeadSegment.x == -1) {
                newHeadSegment.x = maxX -1;
            }
            break;
            case 0: newHeadSegment.y = newHeadSegment.y -1;
            if (newHeadSegment.y == -1) {
                newHeadSegment.y = maxY -1;
            }
            break;
        }
        newHeadSegment.direction = direction;
        segments.add(newHeadSegment);
        if (direction != oldDirection) {
            switch (oldDirection) {
                case 0: 
                if (direction == 1) {
                    tempHeadSegment.direction = 71;
                } else {
                    tempHeadSegment.direction = 63;
                } break;
                 case 1: 
                if (direction == 0) {
                    tempHeadSegment.direction = 50;
                } else {
                    tempHeadSegment.direction = 62;
                } break;
                 case 2: 
                if (direction == 1) {
                    tempHeadSegment.direction = 41;
                } else {
                    tempHeadSegment.direction = 53;
                } break;
                 case 3: 
                if (direction == 0) {
                    tempHeadSegment.direction = 40;
                } else {
                    tempHeadSegment.direction = 72;
                } break;
            }
        }
        oldDirection = direction;
    }

    public void move() {
        if (gameOver){
            return;
        }
        eat();
        segments.deletePosition(segments.length() -1);
        Segment tailSegment = segments.getValue(segments.length() - 1);
        if (tailSegment.direction > 10) {
            tailSegment.direction = tailSegment.direction % 10;
        }
    }

    public boolean aboutToDie() {
        //Segment newHeadSegment = segments.getValue(0);
        Segment tempHeadSegment = segments.getValue(0);
        Segment newHeadSegment = new Segment(tempHeadSegment.x,tempHeadSegment.y);
        switch (direction) {
            case 1: newHeadSegment.x = newHeadSegment.x +1;
            if (newHeadSegment.x == maxX) {
                newHeadSegment.x = 0;
            }
            break;
            case 2: newHeadSegment.y = newHeadSegment.y +1;
            if (newHeadSegment.y == maxY) {
                newHeadSegment.y = 0;
            }
            break;
            case 3: newHeadSegment.x = newHeadSegment.x -1;
            if (newHeadSegment.x == -1) {
                newHeadSegment.x = maxX -1;
            }
            break;
            case 0: newHeadSegment.y = newHeadSegment.y -1;
            if (newHeadSegment.y == -1) {
                newHeadSegment.y = maxY -1;
            }
            break;
        }
        for (int i = 0; i<segments.length()-1; i++) {
            Segment curSegment = segments.getValue(i);
            if ((curSegment.x == newHeadSegment.x) && (curSegment.y == newHeadSegment.y))
                return true;
        }
        return false;

    }

    public void turnLeft(){
        if (gameOver){
            return;
        }
        if (direction==0) {
            direction = 3;
        }
        else {
            direction = direction - 1; 
        }
    }

    public void turnRight() {
        if (gameOver){
            return;
        }
        if (direction == 3) {
            direction = 0;
        }
        else {
            direction = direction + 1;
        }
    }

    public int getDirection(){
        return direction;
    }

    public boolean isHeadThere(int x, int y, int dir){
        Segment tempS; 
        tempS = segments.getValue(0);
        if ((tempS.x ==x) && (tempS.y == y))
            if (tempS.direction == dir)
                return true;
        return false;
    }

    public boolean isTailThere(int x, int y, int dir){
        Segment tempS; 
        tempS = segments.getValue(segments.length() - 1);
        if ((tempS.x ==x) && (tempS.y == y))
            if (tempS.direction == dir)
                return true;
        return false;
    }

    public boolean isBodyThere(int x, int y, int dir){
        Segment tempS = null; 
        int tempDirection;
        for (int i = 1; i< segments.length() - 1; i++) {
            tempS = segments.getValue(i);
            tempDirection = tempS.direction;
            if (tempDirection > 10) {
            tempDirection= tempDirection / 10;
        }
            if ((tempS.x ==x) && (tempS.y == y))
                if (tempDirection == dir )
                    return true;
        }
        return false;
    }   

    public void describeMe() {
        segments.print();
    }   

    public boolean gameOver() {
        return gameOver;
    }

    public void stopGame() {
        gameOver = true;
    }

} 