package net.sitina.automata.api;

import net.sitina.automata.cell.SavannahCell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {

    @Test
    public void cellChanged() {
        Cell c = new SavannahCell();
        c.performStep();

        int originalState = c.getState();
        c.performStep();
        int newState = c.getState();

        assertEquals((originalState != newState), c.isChanged());
    }

}
