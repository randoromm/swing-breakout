package com.he4xi.swbreakout;

import com.he4xi.swbreakout.entity.pad.Pad;
import com.he4xi.swbreakout.graphics.Display;
import com.he4xi.swbreakout.input.KeyInput;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * com.he4xi.swbreakout.Breakout clone.
 * Created by rando on 24.12.16.
 */
public class Breakout extends JPanel implements Runnable {
    public static final int WIDTH = 700 ,HEIGHT = 500;

    private JFrame frame;
    private Thread thread;
    private Display display;
    private KeyInput keys;
    private Pad pad;

    private Graphics2D g2d;
    private BufferedImage image;
    private boolean running;

    public Breakout() {
        frame = new JFrame("Breakout");
        display = new Display(WIDTH, HEIGHT);
        keys = new KeyInput();
        pad = new Pad(keys);

        frame.addKeyListener(keys);
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();

        double tsq = 1000000000.0 / 60.0;
        double deltaTime = 0;
        int frames = 0;
        int updates = 0;

        while (running) {
            long startTime = System.nanoTime();
            deltaTime += (startTime - lastTime) / tsq;
            lastTime = startTime;

            while (deltaTime >= 1) {
                update();
                updates++;
                deltaTime--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer >= 1000) {
                timer += 1000;
                System.out.println(frames + "FPS, " + updates + "UPS");
                frame.setTitle("com.he4xi.swbreakout.Breakout | " + frames + "FPS, " + updates + "UPS");
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    private void start() {
        running = true;
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        g2d = image.createGraphics();

        thread = new Thread(this,"com.he4xi.swbreakout.Breakout");
        thread.start();
    }

    private void stop() {

    }

    private void render() {
        display.render(g2d);
        pad.render(display);

        Graphics g = getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
    }

    private void update() {
        keys.update();
        pad.update();
    }

    public static void main(String[] args) {
        Breakout game = new Breakout();

        game.frame.add(game);
        game.frame.pack();
        game.frame.setSize(WIDTH, HEIGHT);
        game.frame.setLocationRelativeTo(null);
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setVisible(true);

        game.start();
    }
}
