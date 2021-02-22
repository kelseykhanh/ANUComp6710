package comp1110.exam;

/**
 * COMP1110 Final Exam, Question 2
 *
 * 5 Marks
 */
public class Q2Redact {

  /**
   *
   * Q2 Part I (2 marks)
   *
   * Open the specified input file.  If the redact boolean is false, simply
   * copy all bytes of the input file to the specified output file.  Part II
   * covers the case where the redact boolean is true.
   *
   *
   * Q2 Part II (3 marks)
   *
   * Open the specified input file.  If the redact boolean is true then copy all
   * bytes of the input file directly to the output file, except any credit card
   * number (a series of 16 digits with optional spaces between them).  Credit
   * card numbers should have all digits replaced with 'X' (but spaces should
   * remain unchanged).  Everything else should be copied directly,
   * unchanged.
   *
   * A credit card number is defined as a sequence of 16 digits with single
   * space character between zero or more of the digits. If a sequence of more
   * than 16 digits occurs, then only the first 16 are considered to be a credit
   * card number and the remainder are treated as normal characters, so are
   * unchanged.
   *
   * Examples (input file contents on left, output on right):
   *  "hi there" -> "hi there"
   *  "hi 1234 5678 there" -> "hi 1234 5678 there"
   *  "hi 1234 5678 1234 5678 there" -> "hi XXXX XXXX XXXX XXXX there"
   *  "hi 12345678 12345678 there" -> "hi XXXXXXXX XXXXXXXX there"
   *  "hi 1234567812345678 there" -> "hi XXXXXXXXXXXXXXXX there"
   *  "hi 1 234567812345678 there" -> "hi X XXXXXXXXXXXXXXX there"
   *  "hi 1234 5678 1234 5678123 there" -> "hi XXXX XXXX XXXX XXXX123 there"
   *
   * @param input The name of the input file
   * @param output The name of the output file
   * @param redact if true, replace all numbers that are part of a credit card
   *               number with an 'X', and copy all other characters unchanged.
   */
  public static void redact(String input, String output, boolean redact) {
    // FIXME complete this method
  }
}
