package com.app.quiz2.entities;

import com.app.quiz2.Difficulty;
import com.app.quiz2.Game;
import com.app.quiz2.entities.alien.Alien;
import com.app.quiz2.entities.alien.AlienBlue;
import com.app.quiz2.entities.alien.AlienCyan;
import com.app.quiz2.entities.alien.AlienGreen;
import com.app.quiz2.entities.alien.AlienRed;
import com.app.quiz2.lib.Entity;

import java.util.Random;



/**
 * Creates all the entities of the game
 */
public class EntityCreator extends Entity {

    private Game game;
    private Random random = new Random();
    private static int tickCount;

    public static boolean pause;

    public EntityCreator(Game game) {
        this.game = game;
    }

    public static int getTickCount() {
        return tickCount;
    }

    public static void resetTicks() {
        tickCount = 0;
    }

    @Override
    public void tick() {
        if (!pause) {
            tickCount++;
            if (tickCount % 500 == 0) {
                Difficulty.increaseDif();
            }
        }
        float avgTimeBetweenAliens = 1f + (1 / Difficulty.getDif());

        while (random.nextFloat() < (1f / avgTimeBetweenAliens) / game.ticksPerSecond()) {
            System.out.println("!!!!! " + Difficulty.getDif());
            if (Difficulty.getDif() < 10) {
                game.addEntity(new AlienRed(game));
            } else if (Difficulty.getDif() < 20) {
                double alienType = Math.random() * 101 + 1;
                if (alienType < (40 + Difficulty.getDif())) {
                    game.addEntity(new AlienBlue(game));
                } else {
                    game.addEntity(new AlienRed(game));
                }
            } else if (Difficulty.getDif() < 30) {
                double alienType = Math.random() * 101 + 1;
                if (alienType < (20 + Difficulty.getDif() / 3)) {
                    game.addEntity(new AlienGreen(game));
                } else if (alienType < (40 + Difficulty.getDif())) {
                    game.addEntity(new AlienBlue(game));
                } else {
                    game.addEntity(new AlienRed(game));
                }
            } else if (Difficulty.getDif() < 40) {
                double alienType = Math.random() * 101 + 1;
                if (alienType < (50 + Difficulty.getDif() / 3)) {
                    game.addEntity(new AlienCyan(game));
                } else if (alienType < (40 + Difficulty.getDif())) {
                    game.addEntity(new AlienBlue(game));
                } else {
                    game.addEntity(new AlienRed(game));
                }
            }
        }
    }

}





