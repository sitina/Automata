package net.sitina.automata;

import java.lang.reflect.Array;

public class Playground {

	private Cell[][] playground = null;
	
	public Playground(int x, int y, Class<? extends Cell> t) {
		playground = (Cell[][])Array.newInstance(t, x, y);
		
		for (int i = 0; i < playground.length; i++) {
			for (int j = 0; j < playground[i].length; j++) {
				try {
					playground[i][j] = t.newInstance();
					
					if (j > 0) {
						playground[i][j].setLeft(playground[i][j - 1]);
						playground[i][j - 1].setRight(playground[i][j]);
					}
					
					if (i > 0) {
						playground[i][j].setTop(playground[i - 1][j]);
						playground[i - 1][j].setBottom(playground[i][j]);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			playground[i][0].setLeft(playground[i][playground[i].length - 1]);
			playground[i][playground[i].length - 1].setRight(playground[i][0]);
			
			if (i == playground.length - 1) {
				for (int j = 0; j < playground[i].length; j++) {
					playground[0][j].setTop(playground[playground.length - 1][j]);
					playground[playground.length - 1][j].setBottom(playground[0][j]);
				}
			}
		}
	}
	
	public Cell[][] getPlayground() {
		return playground;
	}
	
	public void performStep() {		
		for (int x = 0; x < playground.length; x++) {
			for (int y = 0; y < playground[x].length; y++) {
				playground[x][y].performStep();
			}
		}
	}
	
}
