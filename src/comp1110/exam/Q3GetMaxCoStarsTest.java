package comp1110.exam;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * COMP1110 Exam, Question 3.2
 */
public class Q3GetMaxCoStarsTest {

    Q3Hollywood library;


    @Rule
    public Timeout globalTimeout = Timeout.millis(500);

    String[] names = new String[]{
            "Malcolm X",
            "Boyz n da Hood",
            "Higher Learning"
    };
    int[] years = new int[]{
            1992,
            1991,
            1995
    };
    String[] directors = new String[]{
            "Spike Lee",
            "John Singleton",
            "John Singleton"
    };

    String[][] actors = new String[][]{
            new String[]{"Denzel Washington", "Angela Bassett", "Spike Lee"},
            new String[]{"Ice Cube", "Cuba Gooding, Jr.", "Angela Bassett", "Laurence Fishburne"},
            new String[]{"Jennifer Connolly", "Ice Cube", "Laurence Fishburne"}
    };

    // FIXME add one or more JUnit unit tests for the getMaxCoStars() method of the Q3Hollywood class


    @Before
    public void setUp() {
        library = new Q3Hollywood();
        for (int i = 0; i < names.length; i++) {
            Set<String> costars = new HashSet<>(Arrays.asList(actors[i]));
            library.addFilm(names[i], years[i], directors[i], costars);
        }
    }

    @Test
    public void testMultipleFilms() {
        int expectedMax = 5; // Laurence Fishburne has 3 unique co-stars: Ice Cube, Angela Bassett, Jennifer Connelly
        int actualMax = library.getMaxCoStars();
        Assertions.assertEquals(expectedMax, actualMax);
    }
    @Test
    public void testSingleFilmMultipleActors() {
        Q3Hollywood library = new Q3Hollywood();
        library.addFilm("New Film", 2022, "New Director", new HashSet<>(Arrays.asList("Actor A", "Actor B", "Actor C")));
        assertEquals(2, library.getMaxCoStars());  // Each actor has 2 co-stars
    }

    @Test
    public void testSingleFilmSingleActor() {
        Q3Hollywood library = new Q3Hollywood();
        library.addFilm("New Film", 2022, "New Director", new HashSet<>(Arrays.asList("Actor A")));
        assertEquals(0, library.getMaxCoStars());  // Single actor, no co-stars
    }

    @Test
    public void testMultipleFilmsSameActors() {
        Q3Hollywood library = new Q3Hollywood();
        library.addFilm("Film 1", 2020, "Director 1", new HashSet<>(Arrays.asList("Actor A", "Actor B")));
        library.addFilm("Film 2", 2021, "Director 2", new HashSet<>(Arrays.asList("Actor A", "Actor B")));
        assertEquals(1, library.getMaxCoStars());  // Each actor has 1 co-star (B for A and A for B)
    }

    @Test
    public void testEmptyLibrary() {
        Q3Hollywood library = new Q3Hollywood();
        assertEquals(0, library.getMaxCoStars());  // No films in the library
    }
}
