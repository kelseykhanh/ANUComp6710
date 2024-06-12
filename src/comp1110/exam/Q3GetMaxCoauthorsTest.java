package comp1110.exam;

import org.junit.Rule;
import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    float[] ratings = new float[]{
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

    @Test
    public void testSingleBookMultipleAuthors() {
        Q3Library library = new Q3Library();
        library.addBook(1, 2020, new HashSet<>(Arrays.asList("Author A", "Author B", "Author C")), "Single Book", 4.0f);
        assertEquals(2, library.getMaxCoauthors());  // Author A has 2 unique co-authors: B, C
    }

    @Test
    public void testSingleBookSingleAuthor() {
        Q3Library library = new Q3Library();
        library.addBook(1, 2020, new HashSet<>(Arrays.asList("Author A")), "Single Book", 4.0f);
        assertEquals(0, library.getMaxCoauthors());  // Only one author, no co-authors
    }

    @Test
    public void testMultipleBooksSameAuthors() {
        Q3Library library = new Q3Library();
        library.addBook(1, 2020, new HashSet<>(Arrays.asList("Author A", "Author B")), "Book 1", 4.0f);
        library.addBook(2, 2021, new HashSet<>(Arrays.asList("Author A", "Author B")), "Book 2", 4.1f);
        assertEquals(1, library.getMaxCoauthors());  // Author A has 1 unique co-author: B (B counted once)
    }

    @Test
    public void testEmptyLibrary() {
        Q3Library library = new Q3Library();
        assertEquals(0, library.getMaxCoauthors());  // No books in the library
    }
}