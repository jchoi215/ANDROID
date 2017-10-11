package jrim.myapplication;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;



public class WindowInfo {

    private int width, height;
    private AppCompatActivity mApp;

    public WindowInfo(AppCompatActivity mContext){
        mApp = mContext;
        Display display = mContext.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height= size.y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public AppCompatActivity getContext(){
        return mApp;
    }
}
