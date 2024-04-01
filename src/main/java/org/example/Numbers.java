package org.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class Numbers {
    //1
    public static int findMidNum(int a, int b, int c) {
        if (a > b) {
            if (a < c)
                return a;
            else return Math.max(b, c);
        } else {
            if (a > c)
                return a;
            else
                return Math.min(b, c);
        }
    }

    //2
    private static double pwFuncA(double x) {
        if (x >= -4 && x <= 4)
            return Math.pow(x, 2) * Math.cos(2 * x);
        else
            return -Math.sin(x / 5);
    }

    public static boolean isSolutionA(double x) {
        return Math.abs(pwFuncA(x)) <= Math.pow(10, -5);
    }

    //3
    public static boolean isPythTriple(int a, int b, int c) throws IllegalArgumentException {
        if (a <= 0 || b <= 0 || c <= 0)
            throw new IllegalArgumentException("side of triangle cannot be less than 0");

        return a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a;
    }

    public enum Feels {HOT, WARM, CHILLY, COLD}

    //4
    public static String warmness(int degree, char scale) {
        if (scale == 'c') {
            if (degree >= 38)
                return Feels.HOT.toString();
            else if (degree >= 23)
                return Feels.WARM.toString();
            else if (degree >= 0)
                return Feels.CHILLY.toString();
            else
                return Feels.COLD.toString();
        } else if (scale == 'f') {
            if (degree >= 100)
                return Feels.HOT.toString();
            else if (degree >= 73)
                return Feels.WARM.toString();
            else if (degree >= 32)
                return Feels.CHILLY.toString();
            else
                return Feels.COLD.toString();
        } else
            return "Not a valid scale";
    }

    @Test
    public void Assertions1() {
        assertEquals(5, findMidNum(5, 4, 6));
        assertEquals(4, findMidNum(5, 4, 3));
        assertEquals(5, findMidNum(6, 4, 5));
        assertEquals(4, findMidNum(4, 5, 1));
        assertEquals(5, findMidNum(3, 5, 6));
        assertEquals(4, findMidNum(3, 5, 4));
    }

    @Test
    public void Assertions2() {
        double pi = Math.PI;
        assertTrue(isSolutionA(5 * pi));
        assertTrue(isSolutionA(pi / 4 + pi));
        assertTrue(isSolutionA(pi / 4 - pi / 2));
        assertFalse(isSolutionA(3));
        assertFalse(isSolutionA(-10));
    }

    @Test
    public void Assertions3() {
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> isPythTriple(-1, 10, 13));
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> isPythTriple(20, -10, 13));
        Exception exception3 = assertThrows(IllegalArgumentException.class, () -> isPythTriple(20, 10, -13));
        assertEquals("side of triangle cannot be less than 0", exception1.getMessage());
        assertEquals("side of triangle cannot be less than 0", exception2.getMessage());
        assertEquals("side of triangle cannot be less than 0", exception3.getMessage());
        assertTrue(isPythTriple(3, 4, 5));
        assertTrue(isPythTriple(5, 13, 12));
        assertTrue(isPythTriple(25, 24, 7));
        assertFalse(isPythTriple(1, 10, 11));
    }

    @Test
    public void Assertions4() {
        assertEquals("HOT", warmness(40, 'c'));
        assertEquals("WARM", warmness(25, 'c'));
        assertEquals("CHILLY", warmness(5, 'c'));
        assertEquals("COLD", warmness(-5, 'c'));
        assertEquals("HOT", warmness(105, 'f'));
        assertEquals("WARM", warmness(80, 'f'));
        assertEquals("CHILLY", warmness(41, 'f'));
        assertEquals("COLD", warmness(20, 'f'));
        assertEquals("Not a valid scale", warmness(55, 'd'));
    }

}