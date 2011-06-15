package net.sitina.automata.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import net.sitina.automata.Cell;
import net.sitina.automata.Playground;


public class PlaygroundPanel extends JPanel {

	private static final long serialVersionUID = 3696811458128936378L;

	private Playground playground = null;
	
	private static final int PIXEL_SIZE = 3;
	
	public PlaygroundPanel(int x, int y, Class<? extends Cell> t) {
		setPreferredSize(new Dimension(300, 300));
		playground = new Playground(x, y, t);
	}
	
	@Override 
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (int x = 0; x < playground.getPlayground().length; x++) {
        	for (int y = 0; y < playground.getPlayground()[x].length; y++) {
        		
        		Cell cell = playground.getPlayground()[x][y];
        		
        		if (cell != null) { // && cell.isChanged()) {
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
