package comp1110.exam;

/**
 * COMP1110 Final Exam, Question 4
 *
 * 20 Marks
 *
 * This question is about a data structure that closely resembles a sushi
 * train.
 *
 * A sushi train is a continuously moving belt with a N holders, each designed
 * to hold a plate of sushi.  Sushi plates are added or removed at the kitchen
 * (position 0), and may be removed by customers at any other position
 * (1 to N - 1), as the belt passes by.
 *
 * The data structure has the concept of holders (which move on the belt), and
 * positions, which are fixed, with the holders continuously moving past.  There
 * are the same number of positions and holders.
 *
 * Each holder may be either empty or hold a single object of type T.
 *
 * Objects can only be added at position 0, and only when there is an
 * empty holder in that position.
 *
 * Objects can be removed at any position.
 *
 * The belt can advance.   Each time it advances, all holders move forward
 * one position modulus the number of positions in the train.
 */
public class Q4SushiTrain<T> {
    /**
     * Create a SushiTrain of a given size.
     *
     * @param size the number of positions (and holders) in the SushiBelt
     */
    public Q4SushiTrain(int size) {
        // FIXME complete this constructor
    }

    /**
     * @return true if this sushi belt is empty, that is, if
     * every holder is empty
     */
    public boolean isEmpty() {
        // FIXME complete this method
        return false;
    }

    /**
     * If the holder at position 0 is empty, add the given object into the
     * holder and return true; otherwise return false.
     *
     * @param obj the object to add to the belt; must not be null
     * @return true if the object was added
     */
    public boolean add(T obj) {
        // FIXME complete this method
        return false;
    }

    /**
     * If the holder at position pos is not empty, remove the object from the
     * holder at position pos, and return it. Otherwise, return null.
     *
     * @param pos the position from which to remove the object
     * @return the object that was in the holder at position pos, or null if
     * there is no such object
     */
    public T remove(int pos) {
        // FIXME complete this method
        return null;
    }

    /**
     * Advance the sushi train, moving all holders forward by one position.
     * The holder at position N-1 moves to position 0.  The holder at position
     * 0 moves to position 1, etc.
     */
    public void advance() {
        // FIXME complete this method
    }

    /**
     * Check whether a given value is contained in this sushi train.
     *
     * Specifically, return true if value is not null and an element e is
     * contained in this sushi belt such that e.equals(value).
     *
     * @param value the value to search for
     * @return true if the value is contained in this sushi train
     */
    public boolean contains(T value) {
        // FIXME complete this method
        return false;
    }

    /**
     * Create a String representation of this sushi train.
     *
     * Objects are listed in position order around the train, starting with the
     * object in the holder at position 0, then the object in the holder
     * at position 1, etc.
     *
     * Values in the train are separated by commas (without spaces).
     * Each value is converted to string as by {@link String#valueOf(Object)}.
     * If a holder is empty (null), its value is represented by the empty string,
     * still including a comma to mark its place in the train.
     * For example, a train of size five in which:
     * - the holder at position 0 contains "b"
     * - the holder at position 1 contains "c"
     * - the holder at position 2 is empty
     * - the holder at position 3 is empty
     * - the holder at position 4 is empty contains "a"
     * would be represented as "b,c,,,a".
     * A train of size three where the holder at position 0 contains "zz" and the
     * other holders are empty would be represented as "zz,,".
     * An empty train of size seven would be represented as ",,,,,,".
     *
     * @return a String representation of this sushi train
     */
    public String toString() {
        // FIXME complete this method
        return null;
    }
}

