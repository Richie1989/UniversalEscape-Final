package com.app.quiz2;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.view.View;

import com.app.quiz2.entities.EntityCreator;
import com.app.quiz2.entities.ship.Ship;
import com.app.quiz2.lib.GameModel;


public class Game extends GameModel {

    public Game() {
    }

    protected Game(Parcel in) {
        this.actualWidth = in.readFloat();
        this.actualHeight = in.readFloat();
    }



    @Override
    public void start() {

        addEntity(new Ship(this));

        addEntity(new Collision(this));

        addEntity(new EntityCreator(this));
    }

    @Override
    public float getWidth() {
        // Virtual screen should be at least 100 wide and 100 high.
        return 100f * actualWidth / Math.min(actualWidth, actualHeight);
    }

    @Override
    public float getHeight() {
        // Virtual screen should be at least 100 wide and 100 high.
        return 100f * actualHeight / Math.min(actualWidth, actualHeight);
    }

}
