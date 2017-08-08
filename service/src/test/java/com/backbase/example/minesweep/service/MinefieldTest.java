package com.backbase.example.minesweep.service;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by ton on 05/02/17.
 */
public class MinefieldTest {

    @Test
    public void testProvidedHeight() throws Exception {
        try {
            Minefield.scan(3, 3, new String[] {"...","..."});
            fail("should throw exception if height does not match");
        } catch (RuntimeException e) {
            assertThat(e.getMessage(), is("Provided minefield does not match provided height"));
        }
    }

    @Test
    public void testEmptyField() throws Exception {
        String[] bombs = new String[] {
                "....",
                "....",
                "...."
        };
        Minefield mf = Minefield.scan(3, 4, bombs);
        String[] hints = mf.getHints();
        String[] expected = new String[] {
                "0000",
                "0000",
                "0000"
        };
        assertArrayEquals(expected, hints);
    }

    @Test
    public void testSingleBomb() throws Exception {
        String[] bombs = new String[] {
                "....",
                ".*..",
                "...."
        };
        Minefield mf = Minefield.scan(3, 4, bombs);
        String[] hints = mf.getHints();
        String[] expected = new String[] {
                "1110",
                "1*10",
                "1110"
        };
        assertArrayEquals(expected, hints);
    }

    @Test
    public void testMultipleBombs() throws Exception {
        String[] bombs = new String[] {
                "**..",
                "..*.",
                "...."
        };
        Minefield mf = Minefield.scan(3, 4, bombs);
        String[] hints = mf.getHints();
        String[] expected = new String[] {
                "**21",
                "23*1",
                "0111"
        };
        assertArrayEquals(expected, hints);
    }
}
