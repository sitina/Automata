package net.sitina.automata.gui;

import net.sitina.automata.api.Cell;
import net.sitina.automata.api.Playground;

import javax.swing.*;
import java.awt.*;


public class PlaygroundPanel extends JPanel {

    private static final long serialVersionUID = 3696811458128936378L;

    private Playground playground = null;

    private static final int PIXEL_SIZE = 3;

    public PlaygroundPanel(int x, int y, Class<? extends Cell> cellType) {
        Dimension size = new Dimension(x * PIXEL_SIZE, y * PIXEL_SIZE);
        setPreferredSize(size);
        setSize(size);

        playground = new Playground(x, y, cellType);
    }

    @Override
    public void paintComponent(Graphics g) {

        for (int x = 0; x < playground.getPlayground().length; x++) {
            for (int y = 0; y < playground.getPlayground()[x].length; y++) {

                Cell cell = playground.getPlayground()[x][y];

                if (cell != null && cell.isChanged()) {
                    if (cell.getState() == 0) {
                        g.setColor(Color.BLACK);
                    } else if (cell.getState() == 1) {
                        g.setColor(Color.GRAY);
                    } else if (cell.getState() == 2) {
                        g.setColor(Color.RED);
                    }

                    g.fillRect(PIXEL_SIZE * x, PIXEL_SIZE * y, PIXEL_SIZE, PIXEL_SIZE);
                }
            }
        }
    }

    public void refresh() {
        playground.performStep();
        paintComponent(this.getGraphics());
    }

}
