package com.app.quiz2;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;

import com.app.quiz2.entities.alien.Alien;
import com.app.quiz2.entities.ship.Ship;
import com.app.quiz2.lib.Entity;
import com.app.quiz2.lib.GameView;


/**
 */
public class Collision extends Entity {

    private Game game;

    private float hitShip;

    public Collision(Game game) {
        this.game = game;
        this.hitShip = 0;
    }

    private float distance(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    /**
     * Events on one tick
     */
    @Override
    public void tick() {
        this.hitShip = hitShip * 0.99f;

        Ship ship = game.getEntity(Ship.class);

        if (ship != null) {


            collisionWithAlien(ship);
        }
    }

    @Override
    public void draw(GameView gv) {

        if (hitShip > 0.01) {
            Paint greenPaint = new Paint();
            greenPaint.setColor(Color.argb(Math.round(hitShip * 150), 0, 255, 0));
            gv.getCanvas().drawPaint(greenPaint);
        }
    }

private int timeBetweenDamage = 0;

    private void collisionWithAlien(Ship ship) {

        for (Alien alien : game.getEntities(Alien.class)) {
            if (distance(alien.getXPosition(), alien.getYPosition(), ship.getXPosition(),
                    ship.getYPosition()) < alien.getWidth()) {
                if (timeBetweenDamage == 0) {
                    this.hitShip = 1;
                    ship.setHealth(ship.getHealth() -
                            alien.getDamage());
                    System.out.println(ship.getHealth());
                } else if (timeBetweenDamage ==
                        10) {
                    timeBetweenDamage = -1;
                }
                timeBetweenDamage++;
            }
        }
    }

}
