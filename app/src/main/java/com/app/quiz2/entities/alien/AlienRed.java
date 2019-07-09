package com.app.quiz2.entities.alien;

import android.graphics.Bitmap;

import com.app.quiz2.Game;
import com.app.quiz2.R;
import com.app.quiz2.lib.GameView;

public class AlienRed extends Alien {
    static private Bitmap bitmap;

    public AlienRed(Game game){
        super(game);
        init();
    }

    /**
     */
    @Override
    public void draw(GameView gameView) {
        if (bitmap == null) {
            bitmap = gameView.getBitmapFromResource(R.drawable.alienred);
        }
        gameView.drawBitmap(bitmap, this.getXPosition() - this.getWidth() / 2,
                this.getYPosition() - this.getHeight() / 2, this.getWidth(), this.getHeight());
    }


    private void init() {
        this.damage=10;
        this.xPosition = (float) (Math.random() * game.getWidth());
        this.yPosition = 0;
        this.ySpeed = (float) (Math.random() * 0.1 + 0.40);
    }
}
