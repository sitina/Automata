package net.sitina.automata;

import java.util.Random;

public class SavanahCell extends Cell {

	public final static int BLANK = 0;
	
	public final static int TREE = 1;
	
	public final static int FIRE = 2;
	
	private final static int SELF_FIRE_COEF = 2000;
	
	private final static int NEAR_FIRE_COEF = 1000;
	
	private final static int TREE_COEF = 750;
	
	private final static int FIRE_DURATION_COEF = 4;
	
	private Random r = new Random();
	
	@Override
	public void performStep() {
		setChanged(true);
		
		if (getState() == FIRE && (r.nextInt() % FIRE_DURATION_COEF) == 0) {
			setState(BLANK);
			return;
		}
		
		if (getState() == TREE) {
			if (isFireNearby() || (r.nextInt() % SELF_FIRE_COEF) == 0) {
				setState(FIRE);
				return;
			}
		}
		
		if (getRoundScore() > 2 && (r.nextInt() % NEAR_FIRE_COEF) == 0) {
			setState(FIRE);
			return;
		}
		
		if (getState() == BLANK && (r.nextInt() % TREE_COEF) == 0) {
			setState(TREE);
			return;
		}
		
		setChanged(false);
	}
	
	private int getRoundScore() {
		int score = 0;
		
        score += (left != null) ? left.getState() : 0;
        score += (right != null) ? right.getState() : 0;
        score += (top != null) ? top.getState() : 0;
        score += (bottom != null) ? bottom.getState() : 0;

		return score;
	}
	
	private boolean isFireNearby() {
        if (left != null && left.getState() == FIRE) {
            return true;
        }

        if (right != null && right.getState() == FIRE) {
            return true;
        }

        if (top != null && top.getState() == FIRE) {
            return true;
        }

        if (bottom != null && bottom.getState() == FIRE) {
            return true;
        }

		return false;
	}

}
