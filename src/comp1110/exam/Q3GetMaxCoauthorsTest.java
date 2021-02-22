package comp1110.exam;

import org.junit.Rule;
import org.junit.rules.Timeout;

/**
 * COMP1110 Exam, Question 3.2
 */
public class Q3GetMaxCoauthorsTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);

    int[] isbns = new int[]{
            743477111,
            521618746,
            743477103,
            743477545,
            679783261,
            141439661,
            141439580,
            192802631,
    };
    int[] years = new int[]{
            1595,
            1600,
            1606,
            1595,
            1813,
            1811,
            1815,
            1817,
    };
    String[][] authors = new String[][]{
            {"William Shakespeare", "Richard Andrews", "Rex Gibson"},
            {"William Shakespeare", "Robert Jackson", "Rex Gibson"},
            {"William Shakespeare"},
            {"William Shakespeare", "Barbara A. Mowat", "Paul Werstine", "Catherine Belsey"},
            {"Jane Austen"},
            {"Jane Austen", "Tony Tanner", "Ros Ballaster"},
            {"Jane Austen", "Fiona Stafford"},
            {"Jane Austen", "James Kinsley", "Deidre Shauna Lynch"},
    };
    String[] titles = new String[]{
            "An Excellent conceited Tragedie of Romeo and Juliet",
            "The Tragicall Historie of Hamlet, Prince of Denmark",
            "The Tragedy of Macbeth",
            "A Midsummer Night's Dream",
            "Pride and Prejudice",
            "Sense and Sensibility",
            "Emma",
            "Persuasion",
    };
    float[] ratings = new float[] {
            3.73f,
            4.0f,
            3.38f,
            3.94f,
            4.06f,
            4.24f,
            3.99f,
            4.13f,
    };

    // FIXME add one or more JUnit unit tests for the getMaxCoauthors() method of the Q3Library class
}