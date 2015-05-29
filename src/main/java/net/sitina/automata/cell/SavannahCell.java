package net.sitina.automata.cell;

import net.sitina.automata.api.Cell;

import java.util.Random;

public class SavannahCell extends Cell {

    public final static int BLANK = 0;

    public final static int TREE = 1;

    public final static int FIRE = 2;

    private final static int SELF_FIRE_COEFFICIENT = 2000;

    private final static int NEAR_FIRE_COEFFICIENT = 1000;

    private final static int TREE_COEFFICIENT = 750;

    private final static int FIRE_DURATION_COEFFICIENT = 4;

    private Random r = new Random();

    public SavannahCell() {
        setState(BLANK);
        setChanged(true);
    }

    @Override
    public void performStep() {
        setChanged(true);

        if (getState() == FIRE && (r.nextInt() % FIRE_DURATION_COEFFICIENT) == 0) {
            setState(BLANK);
            return;
        }

        if (getState() == TREE) {
            if (isFireNearby() || (r.nextInt() % SELF_FIRE_COEFFICIENT) == 0) {
                setState(FIRE);
                return;
            }
        }

        if (getRoundScore() > 2 && (r.nextInt() % NEAR_FIRE_COEFFICIENT) == 0) {
            setState(FIRE);
            return;
        }

        if (getState() == BLANK && (r.nextInt() % TREE_COEFFICIENT) == 0) {
            setState(TREE);
            return;
        }

        setChanged(false);
    }

    private int getRoundScore() {
        int score = 0;

        score += getCellScoreOrZero(left);
        score += getCellScoreOrZero(right);
        score += getCellScoreOrZero(top);
        score += getCellScoreOrZero(bottom);

        return score;
    }

    private int getCellScoreOrZero(Cell cell) {
        return (cell != null) ? cell.getState() : 0;
    }

    private boolean isFireNearby() {
        return (isCellOnFire(left) || isCellOnFire(right) || isCellOnFire(top) || isCellOnFire(bottom));
    }

    private boolean isCellOnFire(Cell neighbour) {
        return (neighbour != null && FIRE == neighbour.getState());
    }

}
