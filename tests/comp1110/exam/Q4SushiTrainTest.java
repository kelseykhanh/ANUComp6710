package comp1110.exam;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4SushiTrainTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    static class Thing {
        final String name;

        public Thing(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Thing " + name;
        }
    }

    @Test
    public void testAddNotEmpty() {
        Q4SushiTrain<Thing> SushiTrain = new Q4SushiTrain<>(10);
        assertTrue("Newly created SushiTrain should be empty!", SushiTrain.isEmpty());
        Thing thing1 = new Thing("One");
        assertTrue("SushiTrain.add() should not return false for empty train", SushiTrain.add(thing1));
        assertFalse("SushiTrain should not be empty after add", SushiTrain.isEmpty());
    }

    @Test
    public void testAddString() {
        Q4SushiTrain<Thing> SushiTrain = new Q4SushiTrain<>(10);
        checkToString(SushiTrain, ",,,,,,,,,");
        Thing thing1 = new Thing("One");
        assertTrue("SushiTrain.add() should not return false for empty wheel", SushiTrain.add(thing1));
        checkToString(SushiTrain, "Thing One,,,,,,,,,");
    }

    private <T> void checkToString(Q4SushiTrain<T> SushiTrain, String expected) {
        assertTrue("Incorrect output from toString().  Expected \"" + expected + "\" but got \"" + SushiTrain.toString() + "\"", expected.equals(SushiTrain.toString()));
    }

    @Test
    public void testLoadRemove() {
        Q4SushiTrain<Thing> SushiTrain = new Q4SushiTrain<>(8);
        Thing thingToDo = new Thing("to do");
        assertTrue("SushiTrain.add() should not return false for empty wheel", SushiTrain.add(thingToDo));
        checkRemove(SushiTrain, thingToDo, 0);
        assertTrue("SushiTrain should be empty after one add and one remove", SushiTrain.isEmpty());
    }

    private void checkRemove(Q4SushiTrain<Thing> SushiTrain, Thing expected, int pos) {
        Thing result = SushiTrain.remove(pos);
        assertTrue("SushiTrain.remove("+pos+") returned " + result + ", expected " + expected, expected == result);
    }

    @Test
    public void testAddRemoveString() {
        Q4SushiTrain<Thing> SushiTrain = new Q4SushiTrain<>(8);
        Thing thingToDo = new Thing("to do");
        assertTrue("SushiTrain.add() should not return false for empty wheel", SushiTrain.add(thingToDo));
        checkToString(SushiTrain, "Thing to do,,,,,,,");
        checkRemove(SushiTrain, thingToDo, 0);
        checkToString(SushiTrain, ",,,,,,,");
    }

    @Test
    public void testAddAddRemoveNonZeroString() {
        Q4SushiTrain<Thing> SushiTrain = new Q4SushiTrain<>(8);
        Thing thing1 = new Thing("One");
        assertTrue("SushiTrain.add() should not return false for empty wheel", SushiTrain.add(thing1));
        checkToString(SushiTrain, "Thing One,,,,,,,");
        SushiTrain.advance();
        Thing thing2 = new Thing("Two");
        assertTrue("SushiTrain.add() should not return false for empty wheel", SushiTrain.add(thing2));
        checkToString(SushiTrain, "Thing Two,Thing One,,,,,,");
        checkRemove(SushiTrain, thing1, 1);
        checkToString(SushiTrain, "Thing Two,,,,,,,");
    }

    @Test
    public void testAddAdvanceRemove() {
        final int SIZE = 7;
        Q4SushiTrain<Thing> SushiTrain = new Q4SushiTrain<>(SIZE);
        Thing thing1 = new Thing("One");
        assertTrue("SushiTrain.add() should not return false when empty", SushiTrain.add(thing1));
        SushiTrain.advance();
        Thing thing2 = new Thing("Two");
        assertTrue("SushiTrain.add() should not return false after one add and one advance", SushiTrain.add(thing2));
        checkRemove(SushiTrain, thing2, 0);
        assertFalse("SushiTrain should not be empty after two loads and one remove", SushiTrain.isEmpty());
        for (int i = 0; i < SIZE - 1; i++) {
            SushiTrain.advance();
        }
        checkRemove(SushiTrain, thing1, 0);
        assertTrue("SushiTrain should be empty after two loads and two removes", SushiTrain.isEmpty());
    }

    @Test
    public void testAddAdvanceRemoveString() {
        final int SIZE = 7;
        Q4SushiTrain<Thing> SushiTrain = new Q4SushiTrain<>(SIZE);
        Thing thing1 = new Thing("One");
        assertTrue("SushiTrain.add() should not return false after one add and one advance", SushiTrain.add(thing1));
        checkToString(SushiTrain, "Thing One,,,,,,");
        SushiTrain.advance();
        checkToString(SushiTrain, ",Thing One,,,,,");
        Thing thing2 = new Thing("Two");
        assertTrue("SushiTrain.add() should not return false after one add and one advance", SushiTrain.add(thing2));
        checkToString(SushiTrain, "Thing Two,Thing One,,,,,");
        checkRemove(SushiTrain, thing2, 0);
        checkToString(SushiTrain, ",Thing One,,,,,");
        assertFalse("SushiTrain should not be empty after two adds and one remove", SushiTrain.isEmpty());
        for (int i = 0; i < SIZE - 2; i++) SushiTrain.advance();
        checkToString(SushiTrain, ",,,,,,Thing One");
        checkRemove(SushiTrain, thing1, SIZE - 1);
        assertTrue("SushiTrain should be empty after two adds and two removes", SushiTrain.isEmpty());
        checkToString(SushiTrain, ",,,,,,");
    }
    @Test
    public void testRemoveEmptyTrain() {
        Q4SushiTrain<String> SushiTrain = new Q4SushiTrain<>(11);
        assertNull("SushiTrain.remove() should return null for empty train, but returned non-null", SushiTrain.remove(0));
        assertTrue("SushiTrain.add() should not return false for empty train", SushiTrain.add("One"));
    }

    @Test
    public void testRemoveEmptyHolder() {
        Q4SushiTrain<String> SushiTrain = new Q4SushiTrain<>(15);
        assertTrue("SushiTrain.add() should not return false for empty wheel", SushiTrain.add("One"));
        SushiTrain.advance();
        assertNull("SushiTrain.remove() should return null for empty holder, but returned non-null", SushiTrain.remove(2));
    }

    @Test
    public void testAddFullHolder() {
        Q4SushiTrain<String> SushiTrain = new Q4SushiTrain<>(16);
        assertTrue("SushiTrain.add() should not return false for empty belt", SushiTrain.add("One"));
        assertFalse("SushiTrain.add() should return false for full holder, but returned true", SushiTrain.add("Two"));
    }

    @Test
    public void testAddFullDoesNotOverwrite() {
        Q4SushiTrain<Thing> SushiTrain = new Q4SushiTrain<>(9);
        Thing thing1 = new Thing("One");
        SushiTrain.add(thing1);
        Thing thing2 = new Thing("Two");
        assertFalse("SushiTrain.add() should return false for full holder, but returned true", SushiTrain.add(thing2));
        // after failure to load thing2, thing1 should still be in car
        checkRemove(SushiTrain, thing1, 0);
    }

    @Test
    public void testAddFullString() {
        Q4SushiTrain<Thing> SushiTrain = new Q4SushiTrain<>(5);
        Thing thing1 = new Thing("One");
        SushiTrain.add(thing1);
        checkToString(SushiTrain, "Thing One,,,,");
        Thing thing2 = new Thing("Two");
        SushiTrain.add(thing2);
        checkToString(SushiTrain, "Thing One,,,,");
    }

    @Test
    public void testRemoveTwice() {
        Q4SushiTrain<String> SushiTrain = new Q4SushiTrain<>(6);
        String a = "a";
        SushiTrain.add(a);
        SushiTrain.advance();
        String b = "b";
        SushiTrain.add(b);
        SushiTrain.advance();
        String v1 = SushiTrain.remove(1);
        assertTrue("SushiTrain.remove() returned " + v1 + ", expected " + b, b.equals(v1));
        String v2 = SushiTrain.remove(1);
        assertNull("SushiTrain.remove() returned " + v2 + ", should be null", v2);
    }

    @Test
    public void testNoMemoryLeaks() {
        final int SIZE = 15;
        Q4SushiTrain<Thing> SushiTrain = new Q4SushiTrain<>(SIZE);
        Thing thing1 = new Thing("One");
        SushiTrain.add(thing1);
        SushiTrain.advance();
        WeakReference<Thing> reference1 = new WeakReference<>(thing1);
        Thing thing2 = new Thing("Two");
        SushiTrain.add(thing2);
        WeakReference<Thing> reference2 = new WeakReference<>(thing2);
        checkRemove(SushiTrain, thing2, 0);
        for (int i = 0; i < SIZE - 1; i++) SushiTrain.advance();
        checkRemove(SushiTrain, thing1, 0);
        thing1 = null;
        thing2 = null;
        Runtime.getRuntime().gc();
        assertNull("A reference still exists to thing1 somewhere in the SushiTrain!", reference1.get());
        assertNull("A reference still exists to thing2 somewhere in the SushiTrain!", reference2.get());
    }

    @Test
    public void testLoadRemoveLarge() {
        List<String> range = IntStream.range(0, 3).boxed().map(String::valueOf).collect(Collectors.toList());
        Q4SushiTrain<String> SushiTrain = new Q4SushiTrain<>(range.size());
        testCircle(range, SushiTrain);
    }

    // assumes values list is initially as large as the wheel
    private void testCircle(List<String> values, Q4SushiTrain<String> SushiTrain) {
        for (String v : values) {
            assertTrue("SushiTrain.add() returned false for empty holder, should return true", SushiTrain.add(v));
            assertFalse("SushiTrain should not be empty after loading " + v, SushiTrain.isEmpty());
            SushiTrain.advance();
        }
        for (String v : values) {
            String result = SushiTrain.remove(0);
            assertTrue("SushiTrain.remove(0) returned " + result + ", expected " + v, v.equals(result));
            SushiTrain.advance();
        }
    }

    @Test
    public void testContainsBottom() {
        final int SIZE = 13;
        Q4SushiTrain<Thing> SushiTrain = new Q4SushiTrain<>(SIZE);
        Thing thing1 = new Thing("One");
        Thing thing2 = new Thing("Two");
        assertFalse("SushiTrain.contains(thing1) returned true, expected false", SushiTrain.contains(thing1));
        assertFalse("SushiTrain.contains(thing2) returned true, expected false", SushiTrain.contains(thing2));
        SushiTrain.add(thing1);
        assertTrue("SushiTrain.contains(thing1) returned false, expected true", SushiTrain.contains(thing1));
        SushiTrain.advance();
        SushiTrain.add(thing2);
        SushiTrain.advance();
        assertTrue("SushiTrain.contains(thing2) returned false, expected true", SushiTrain.contains(thing2));
        assertTrue("SushiTrain.contains(thing1) returned false, expected true", SushiTrain.contains(thing1));
        for (int i = 0; i < SIZE - 1; i++) SushiTrain.advance();
        SushiTrain.remove(1);
        assertFalse("SushiTrain.contains(thing1) returned true, expected false", SushiTrain.contains(thing1));
        assertFalse("SushiTrain.contains(null) returned true, expected false", SushiTrain.contains(null));
    }

    @Test
    public void testContainsBuried() {
        final int SIZE = 4;
        Q4SushiTrain<Thing> SushiTrain = new Q4SushiTrain<>(SIZE);
        Thing thing1 = new Thing("One");
        Thing thing2 = new Thing("Two");
        assertFalse("SushiTrain.contains(thing1) returned true, expected false", SushiTrain.contains(thing1));
        assertFalse("SushiTrain.contains(thing2) returned true, expected false", SushiTrain.contains(thing2));
        SushiTrain.add(thing1);
        SushiTrain.advance();
        assertTrue("SushiTrain.contains(thing1) returned false, expected true", SushiTrain.contains(thing1));
        assertFalse("SushiTrain.contains(thing2) returned true, expected false", SushiTrain.contains(thing2));
        SushiTrain.add(thing2);
        SushiTrain.advance();
        assertTrue("SushiTrain.contains(thing1) returned false, expected true", SushiTrain.contains(thing1));
        assertTrue("SushiTrain.contains(thing2) returned false, expected true", SushiTrain.contains(thing2));
        for (int i = 0; i < SIZE - 2; i++) SushiTrain.advance();
        SushiTrain.remove(0);
        assertFalse("SushiTrain.contains(thing1) returned true, expected false", SushiTrain.contains(thing1));
        assertTrue("SushiTrain.contains(thing2) returned false, expected true", SushiTrain.contains(thing2));
        SushiTrain.advance();
        SushiTrain.remove(0);
        assertFalse("SushiTrain.contains(thing1) returned true, expected false", SushiTrain.contains(thing1));
        assertFalse("SushiTrain.contains(thing2) returned true, expected false", SushiTrain.contains(thing2));
    }
/*
    @Test
    public void testContainsRemoved() {
        Q4SushiTrain<Thing> SushiTrain = new Q4SushiTrain<>(22);
        Thing thing1 = new Thing("One");
        SushiTrain.add(thing1);
        assertTrue("SushiTrain.contains(thing1) returned false, expected true", SushiTrain.contains(thing1));
        SushiTrain.remove();
        assertFalse("SushiTrain.contains(thing1) returned true, expected flase", SushiTrain.contains(thing1));
    }
*/
    @Test
    public void testContainsDuplicateRemoved() {
        Q4SushiTrain<Thing> SushiTrain = new Q4SushiTrain<>(7);
        Thing thing1 = new Thing("One");
        Thing thing2 = new Thing("Two");
        SushiTrain.add(thing1);
        SushiTrain.advance();
        SushiTrain.add(thing2);
        SushiTrain.advance();
        SushiTrain.add(thing1);
        SushiTrain.remove(0);
        assertTrue("SushiTrain.contains(thing1) returned false, expected true", SushiTrain.contains(thing1));
    }

    @Test
    public void testLoadRemoveTwiceString() {
        Q4SushiTrain<Thing> SushiTrain = new Q4SushiTrain<>(9);
        Thing thingvellir = new Thing("vellir");
        SushiTrain.add(thingvellir);
        SushiTrain.remove(0);
        SushiTrain.remove(0);
        checkToString(SushiTrain, ",,,,,,,,");
        SushiTrain.add(thingvellir);
        checkToString(SushiTrain, "Thing vellir,,,,,,,,");
    }

    @Test
    public void testContainsLarge() {
        final int SIZE = 874;
        Q4SushiTrain<String> SushiTrain = new Q4SushiTrain<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            SushiTrain.add(String.valueOf(i));
            SushiTrain.advance();
        }
        assertFalse("SushiTrain.contains(null) returned true, expected false", SushiTrain.contains(null));
        for (int i = 0; i < SIZE; i++) {
            assertTrue("SushiTrain.contains(\"" + i + "\") returned false, expected true", SushiTrain.contains(String.valueOf(i)));
        }
    }
}
