package comp1110.exam;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Q2RedactTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(1000);

    static final String INPUT_FILENAME_BASE = "assets/Q2Redact";
    static final String OUTPUT_FILENAME = "assets/Q2output";

    @Before
    public void setup() {
        try {
            Files.deleteIfExists(Paths.get(OUTPUT_FILENAME));
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    @Test
    public void empty() {
        test("A", false, "", "");
    }

    @Test
    public void small() {
        test("B", false, "Contrary to 1234 5678 9101 1121 popular belief, Lorem Ipsum", "Contrary to 1234 5678 9101 1121 popular belief, Lorem Ipsum");
    }

    @Test
    public void smallRedact() {
        test("B", true, "Contrary to XXXX XXXX XXXX XXXX popular belief, Lorem Ipsum", "Contrary to 1234 5678 9101 1121 popular belief, Lorem Ipsum");
    }

    @Test
    public void medRedact() {
        test("C", true, "Contrary 123 to XXXX XXXX XXXX XXXX popular belief, Lorem Ipsum XXXXXXXXXXXXXXXX", "Contrary 123 to 1234 5678 9101 1121 popular belief, Lorem Ipsum 1234567891011121");
    }

    @Test
    public void largeRedact() {
        test("D", true, "Contrary to popular belief, X XXX XXXX XXX X XXXX Lorem Ipsum is not XXXXXXXXXXXXXXXX simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College", "Contrary to popular belief, 1 234 5678 910 1 1121 Lorem Ipsum is not 7654123456783121 simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College");
    }

    private void test(String insuf, boolean cs, String expected, String content) {
        Q2Redact.redact(INPUT_FILENAME_BASE+insuf, OUTPUT_FILENAME, cs);
        try {
            assertTrue("Called Q2Redact.redact("+INPUT_FILENAME_BASE+insuf+", "+OUTPUT_FILENAME+", "+cs+"). Expected file \""+OUTPUT_FILENAME+"\", but no file was found", Files.exists(Paths.get(OUTPUT_FILENAME)));
            String actual = Files.readString(Paths.get(OUTPUT_FILENAME));
            assertTrue("Called Q2Redact.redact("+INPUT_FILENAME_BASE+insuf+", "+OUTPUT_FILENAME+", "+cs+"). Expected file to contain \""+expected+"\" but got \""+actual+"\" when file contained \""+content+"\".", actual.equals(expected));
        } catch (IOException e) {
            System.out.println(e);
            fail(e.getMessage());
        }
    }
}
