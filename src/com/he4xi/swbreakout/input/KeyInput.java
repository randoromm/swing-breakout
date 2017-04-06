package com.he4xi.swbreakout.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Class to deal with key inputs.
 * Created by rando on 24.12.16.
 */
public class KeyInput implements KeyListener{
    public boolean[] keys = new boolean[145];
    public boolean left, right;

    public void update() {
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
