package com.app.quiz2.entities.alien;

import com.app.quiz2.Game;
import com.app.quiz2.lib.Entity;

public class Alien extends Entity {
    private final float width;
    private final float height;
    protected int damage;
    protected float ySpeed;

    protected Game game;

    protected float xPosition, yPosition;

    public int getDamage() {
        return damage;
    }

    public Alien  (Game game) {
        this.game = game;
        this.width = 15f;
        this.height = 15f;


    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getXPosition() {
        return xPosition;
    }

    public float getYPosition() {
        return yPosition;
    }

    public Game getGame() {
        return game;
    }

    @Override
    public void tick() {
        this.yPosition += ySpeed;

        if (this.getYPosition() > game.getHeight()-this.height) {
            this.getGame().removeEntity(this);
        }
    }

}
