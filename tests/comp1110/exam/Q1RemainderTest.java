package comp1110.exam;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.Random;

import static junit.framework.TestCase.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1RemainderTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);

    public static int ITERATIONS = 10;
    Random r = new Random();

    @Test
    public void testEmpty() {
        test(new int[]{}, 2, 2);
        test(new int[]{}, 0, 0);
    }

    @Test
    public void testOne() {
        test(new int[]{1}, 0, 0);
        test(new int[]{2}, 2, 2);
        test(new int[]{2}, 1, 2);
        test(new int[]{3}, 2, 3);
        test(new int[]{-1}, 0, 0);
    }

    @Test
    public void testMultiple() {
        test(new int[]{1, 2, -3}, 1, -3);
        test(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 1, 1);
        test(new int[]{2, 1}, 2, 2);
        test(new int[]{3, 2}, 1, 2);
        test(new int[]{8, 3, -5, 2, 1, -8}, -2, -8);
        test(new int[]{8, 3, -5, 2, 1, 0}, -2, 0);
        test(new int[]{3, 1}, 1, 1);
        test(new int[]{0, 9}, 5, 0);
        test(new int[]{3, 1, 5, -4, 0}, -2, -4);
    }

    @Test
    public void testDuplicate() {
        test(new int[]{2, 2}, 1, 2);
        test(new int[]{3, 2, -2, 2}, 1, -2);
        test(new int[]{1, 3, 1}, 2, 1);
        test(new int[]{3, 1, 3}, 2, 1);
    }

    @Test
    public void testOther() {
        test(new int[]{2, 2}, 2, 2);
        test(new int[]{-4, 2, 1}, 3, -4);
        test(new int[]{1, 3, 2}, 3, 3);
        test(new int[]{9, 7, 8}, 8, 8);
        test(new int[]{1, 0, 1}, 0, 0);
        test(new int[]{-7, 0, 7}, 7, -7);
        test(new int[]{2, 2}, 2, 2);
        test(new int[]{12, 2, 2}, 7, 2);
        test(new int[]{12, 6, 5}, 8, 12);
    }

    void test(int[] values, int target, int expected) {
        int result = Q1Remainder.findCloseDivisor(values, target);
        assertTrue("Q1Remainder.findCloseDivisor(" + Arrays.toString(values) + ", " + target + ") returned " + result + ", expected " + expected, result == expected);
    }
}
