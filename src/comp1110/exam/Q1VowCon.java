package comp1110.exam;

/**
 * COMP1110 Final Exam, Question 1.2 (harder)
 *
 * 5 Marks
 */
public class Q1VowCon {
  /**
   * Given a word, if the word is vowcon word, return the number of vowels in
   * the  word, or return -1 if the word is not a vowcon word, and 0 if the word
   * is an empty string.
   *
   * A vowcon word:
   *   a) is composed only of lower case letters, either vowels ('a', 'e', 'i',
   *      'o', 'u') or consonants (all non-vowel lower case letters),
   *   b) has the same first and last letter,
   *   c) after removing the first and last letters, the remaining letters
   *      must also be a vowcon word, or an empty string,
   *   d) if the vowcon word is one character long, that letter must be a vowel.
   *
   * Examples of vowcon words:
   *   a, o, aa, bb, zz, bab, zoz, aaa, aaaaa, zyayz
   *
   * Examples of words that are NOT vowcon words:
   *   b, z, zzz, bbb
   *
   * @param word A word
   * @return the number of vowels in the word if the word is a vowcon word (see
   * above), 0 if it is an empty string, and -1 if it is not a vowcon word.
   */
  public static int vowcon(String word) {
    return -1;  // FIXME complete this method
  }
}
