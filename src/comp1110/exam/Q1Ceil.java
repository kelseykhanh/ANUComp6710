package comp1110.exam;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.io.*;
/**
 * COMP1110 Final Exam, Question 1.1
 *
 * 5 Marks
 */
public class Q1Ceil {
    /**
     * Given an array of integers and a special value ceil,
     * return the largest value in the array that is less than
     * ceil.
     * If there is no value in the array that is less than
     * ceil, return (ceil+1).
     *
     * @param in   An array of integers
     * @param ceil a target value to search for in the array
     * @return the largest value in the array that is smaller than ceil,
     * or ceil+1 if there is no such value
     */
    public static int findLess(int[] in, int ceil) {


        int max = Integer.MIN_VALUE;
        boolean found = false;

        for (int value : in) {
            if (value < ceil) {
                if (value > max) {
                    max = value;
                    found = true;
                }
            }
        }

        if (!found) {
            return ceil + 1;
        }

        return max;
    }
}


