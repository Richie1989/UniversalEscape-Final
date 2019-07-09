package com.app.quiz2.entities.ship;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;

import com.app.quiz2.Game;
import com.app.quiz2.R;
import com.app.quiz2.lib.Entity;
import com.app.quiz2.lib.GameModel;
import com.app.quiz2.lib.GameView;


/**
 */
public class Ship extends Entity {
    private final float width;

    private final float height;

    private final float xSpeed;
    private final float ySpeed;

    public int getHealth() {
        return health;
    }

    private int maxHealth;
    private int health;
    private boolean Alive;

    static private Bitmap bitmap;

    private int shipFrame;
    private Game game;

    private float xPosition, yPosition;

    public Ship(Game game) {
        this.game = game;

        this.width = 17f;
        this.height = 17f;
        this.xSpeed = 0.5f;
        this.ySpeed = 0.5f;
        this.xPosition = game.getWidth() / 2;
        this.yPosition = game.getHeight() / 1.05f;


        this.maxHealth = 100;
        this.health = maxHealth;

        //Activity.setUp();
    }


    public void setHealth(int health) {
        this.health = health;
    }

    public float getXPosition() {
        return xPosition;
    }

    public float getYPosition() {
        return yPosition;
    }

    /**
     * public void tick() {
     *
     * if (alive == false) {
     *
     * Intent intent = new Intent(this, YOURACTIVITY.class);
     *
     *
     * startActivity(intent);
     *
     * }
     */
    @Override
    public void tick() {
        if (this.health <= 0) {
            Alive = false;
            game.removeEntity(this);

        } else {
            //Collect all the screen touches
            for (GameModel.Touch touch : this.game.touches) {
                int margin = 2;
                if (touch.x > xPosition + margin) {
                    xPosition += xSpeed;
                } else if (touch.x < xPosition - margin) {
                    xPosition -= xSpeed;
                }
            }
        }
    }


    /**
     */
    @Override
    public void draw(GameView gv) {

        bitmap = gv.getBitmapFromResource(R.drawable.ship);

        //Draw the ship
        gv.drawBitmap(bitmap, xPosition - width / 2, yPosition - height / 2, width, height);
        //Update the picture
        gv.invalidate();
    }

}
