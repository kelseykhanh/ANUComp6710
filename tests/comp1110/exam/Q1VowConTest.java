package comp1110.exam;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1VowConTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(1000);

    @Test
    public void testEmpty() {
        test("", 0);
    }

    @Test
    public void testOne() {
        test("a", 1);
        test("e", 1);
        test("i", 1);
        test("o", 1);
        test("u", 1);
        test("b", -1);
        test("z", -1);
        test("c", -1);
    }

    @Test
    public void testTwo() {
        test("aa", 2);
        test("uu", 2);
        test("ao", -1);
        test("oo", 2);
        test("az", -1);
        test("bb", 0);
        test("zz", 0);
    }

    @Test
    public void testThree() {
        test("xax", 1);
        test("aaa", 3);
        test("zzz", -1);
        test("xxs", -1);
        test("xoo", -1);
        test("xox", 1);
        test("oox", -1);
        test("oxo", -1);
        test("oxx", -1);
    }

    @Test
    public void testFive() {
        test("xxaxx", 1);
        test("aaaaa", 5);
        test("oxoxo", 3);
        test("xxxoo", -1);
        test("xoxxx", -1);
    }

    private void test(String s, int e) {
        int r = Q1VowCon.vowcon(s);
        assertTrue("For string \""+s+"\", expected '"+e+"' but got '"+r+"'", e == r);
    }
}
