package me.karthikrao.algorithms;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsTest {

    @Test
    @Ignore
    void reverse() {
        assertEquals(321, Algorithms.reverse(123));
        assertEquals(-123, Algorithms.reverse(-321));
        assertEquals(21, Algorithms.reverse(120));

        assertEquals(0, Algorithms.reverse(1534236469));
    }

    @Test
    void zigzag() {
        assertEquals("PAYPALISHIRING", Algorithms.zigzag("PAYPALISHIRING", 1));
        assertEquals("PYAIHRNAPLSIIG", Algorithms.zigzag("PAYPALISHIRING", 2));
        assertEquals("PAHNAPLSIIGYIR", Algorithms.zigzag("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", Algorithms.zigzag("PAYPALISHIRING", 4));
        assertEquals("A", Algorithms.zigzag("A", 3));
        assertEquals("", Algorithms.zigzag("", 3));
    }
}