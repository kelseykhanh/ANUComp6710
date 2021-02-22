package comp1110.exam;

import java.util.Random;

/**
 * COMP1110 Final Exam, Question 5
 *
 * 5 Marks
 *
 * This class represents an actor, which is uniquely identified by a
 * combination of given name, family name, and date of birth, for example:
 * "Cate Blanchett 19690514"
 */
public class Q5Actor {
    /**
     * The given name of this actor e.g. "Cate".
     */
    String given;

    /**
     * The family name of this actor e.g. "Blanchett".
     */
    String family;

    /**
     * The date of birth for this actor in ISO form "19690514".
     */
    String dob;

    public Q5Actor(String given, String family, String dob) {
        if (given == null) throw new IllegalArgumentException("given name may not be null!");
        this.given = given;
        if (family == null) throw new IllegalArgumentException("family name may not be null!");
        this.family = family;
        if (dob == null) throw new IllegalArgumentException("date of birth may not be null!");
        this.dob = dob;
    }

    /**
     * @return a hash code value for this actor
     * In implementing this method, you may *not* use the default Java
     * implementations in Object.hashCode() or Objects.hash().
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        // FIXME complete this method
        return new Random().nextInt(2);
    }

    /**
     * @return true if this actor is equal to the provided object
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object object) {
        // FIXME complete this method
        return false;
    }

    @Override
    public String toString() {
        return given + " " + family + " (" + dob + ")";
    }

    // DO NOT DELETE OR CALL THIS METHOD
    int passThroughHash() {
        return super.hashCode();
    }
}
