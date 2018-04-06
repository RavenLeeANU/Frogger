package com.example.a54053.frogger.Objects;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by 54053 on 2018/4/6.
 */

public class GameObject {

    protected int posX;
    protected int posY;
    protected Canvas canvas;

    public GameObject(Canvas canvas,int posX,int posY){
        this.posX = posX;
        this.posY = posY;
        this.canvas = canvas;
    }



    public void onDraw(){


    }

}
