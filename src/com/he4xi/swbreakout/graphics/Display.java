package com.he4xi.swbreakout.graphics;

import java.awt.*;

/**
 * Class to deal with rendering.
 * Created by rando on 24.12.16.
 */
public class Display {
    private int width, height;
    private Graphics2D g2d;

    public Display(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void render(Graphics2D g2d) {
        this.g2d = g2d;
        clear();
        renderBackground();
    }

    private void renderBackground() {
        g2d.setColor(new Color(255, 141, 184));
        g2d.fillRect(0, 0, width, height);
    }

    public void renderPad(int x, int y, int width, int height) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x, y, width, height);
    }

    public void clear() {
        g2d.clearRect(0, 0, width, height);
    }
}
