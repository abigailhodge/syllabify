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

  /**
   * Checks if this word has a legal syllable structure for this language.
   * @param word    The word to check.
   * @return        True if this word has a legal syllable structure, false elsewise.
   */
  public boolean codaPass (Word word);

}
