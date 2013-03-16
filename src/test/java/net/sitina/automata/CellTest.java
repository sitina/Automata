package net.sitina.automata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {

    @Test
    public void cellChanged() {
        Cell c = new SavanahCell();
        c.performStep();

        int originalState = c.getState();
        c.performStep();
        int newState = c.getState();

        assertEquals((originalState != newState), c.isChanged());
    }

}
