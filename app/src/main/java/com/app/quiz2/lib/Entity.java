package com.app.quiz2.lib;

import android.support.annotation.NonNull;
import android.view.MotionEvent;

import java.io.Serializable;


abstract public class Entity implements Comparable<Entity>, Serializable {

    // Used to sort objects on the same layer in the entities tree.
    private int id;

    // Static variable that provides the next `id`.
    private static int count = 0;

    // The constructor assigns an id that is used for ordering draws.
    public Entity() {
        id = ++count;
    }

    /**
     */
    public int getLayer() {
        return 0;
    }

    /**
     */
    public void tick() {
    }

    /**
     */
    public void draw(GameView gv) {
    }

    /**
     */
    public void handleTouch(GameModel.Touch touch, MotionEvent event) {
    }

    @Override
    public int compareTo(@NonNull Entity o) {
        int prio = getLayer() - o.getLayer();
        return prio == 0 ? id - o.id : prio;
    }
}

