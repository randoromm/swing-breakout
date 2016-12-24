package com.he4xi.swbreakout.entity.pad;

import com.he4xi.swbreakout.Breakout;
import com.he4xi.swbreakout.entity.Entity;
import com.he4xi.swbreakout.graphics.Display;
import com.he4xi.swbreakout.input.KeyInput;

/**
 * Class for the pad.
 * Created by rando on 24.12.16.
 */
public class Pad extends Entity {

    public KeyInput input;
    public int width = 80, height = 10;
    public double xVel = 4;

    public Pad(KeyInput input) {
        this.input = input;
        x = (Breakout.WIDTH / 2) - (width / 2);
        y = Breakout.HEIGHT - 20;
    }

    public void render(Display display) {
        display.renderPad((int)x, (int)y, width, height);
    }

    public void update() {
        if (input.left && x > 0) {
            x -= xVel;
        }
        if (input.right && x + width < Breakout.WIDTH) {
            x += xVel;
        }
    }
}
