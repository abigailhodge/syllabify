package syllabify.model;

public interface ILanguage {

  /**
   * Segments the given word into rudimentary syllables based on this language's nuclei
   * @param word   The word to segment.
   */
  public void nucleusPass(Word word);

  /**
   * Checks legality of onsets in this word's syllables. Moves illegal onset sounds into
   * codas of previous syllables.
   * @param word    The word to segment.
   */
  public void onsetPass(Word word);


}
