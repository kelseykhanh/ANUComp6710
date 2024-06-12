package comp1110.exam;

/**
 * COMP1110 Final Exam, Question 1.1
 *
 * 5 Marks
 */
public class Q1Closest {
    /**
     * Given an array of integers and a special value target,
     * return the value in the array that is numerically closest to
     * target. If the array contains two different values equally
     * close to target, return the smaller value.  If the array is
     * empty, return Integer.MAX_VALUE.
     *
     * @param in    An array of integers
     * @param target a target value to search for in the array
     * @return the value in the array that is numerically closest to
     * target, returning the lesser of equally close values, and
     * returning Integer.MAX_VALUE if the array
     * has no entries.
     */
    public static int findClosest(int[] in, int target) {
        // FIXME complete this method

// If the array is empty, return Integer.MAX_VALUE
        if (in == null || in.length == 0) {
            return Integer.MAX_VALUE;
        }

        // Initialize variables to track the closest value and the smallest difference
        int closestValue = in[0];
        int smallestDifference = Math.abs(in[0] - target);

        // Iterate through the array to find the closest value to the target
        for (int value : in) {
            int currentDifference = Math.abs(value - target);

            // Update closestValue if the current value is closer to the target
            // or if the current value is equally close but smaller
            if (currentDifference < smallestDifference ||
                    (currentDifference == smallestDifference && value < closestValue)) {
                closestValue = value;
                smallestDifference = currentDifference;
            }
        }

        // Return the closest value
        return closestValue;
    }
}