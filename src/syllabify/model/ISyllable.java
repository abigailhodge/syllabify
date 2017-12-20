package syllabify.model;

public interface ISyllable {

  /**
   * Sets this syllable's onset to the given string.
   * @param onset    The new onset of this syllable.
   */
  public void setOnsetTo(String onset);

  /**
   * Sets this syllable's nucleus to the given string.
   * @param nucleus   The new nucleus of this syllable.
   */
  public void setNucleusTo(String nucleus);

  /**
   * Adds the given string to this syllable's current coda.
   * @param coda       The sounds to be added to the coda.
   */
  public void addCodaSounds(String coda);

  /**
   * Returns the position of this syllable in the word.
   * @return    The position of this syllable in the word.
   */
  public int getWordPosn();

  public String getOnset();

  public String getNucleus();

  public void setWordPosn(int i);

}
