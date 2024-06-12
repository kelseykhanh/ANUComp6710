package comp1110.exam;

/**
 * COMP1110 Final Exam, Question 1.1
 *
 * 5 Marks
 */
public class Q1Furthest {
    /**
     * Given an array of integers and a special value target,
     * return the value in the array that is numerically furthest from
     * target. If the array contains two different values equally
     * close to target, return the larger value.  If the array is
     * empty, return target.
     *
     * @param in    An array of integers
     * @param target a target value to search for in the array
     * @return the value in the array that is numerically furthest from
     * target, returning the larger of equally close values, and
     * returning target if the array
     * has no entries.
     */
    public static int findFurthest(int[] in, int target) {
        // FIXME complete this method

        if (in == null || in.length == 0){
            return target;
        }

        int furthestValue = in[0];
        int furthestDifference = Math.abs(in[0] - target);

        for (int value : in){
            int currentDifference = Math.abs(target - value);
            if (currentDifference > furthestDifference || (currentDifference == furthestDifference && value > furthestValue)){
                furthestValue = value;
                furthestDifference = currentDifference;
            }
        }
        return furthestValue;

    }
}
