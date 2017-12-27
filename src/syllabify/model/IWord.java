package syllabify.model;

import java.util.ArrayList;

public interface IWord {

  /**
   * Adds a syllable to this word.
   * @param syll   The syllable to be added.
   */
  public void addSyllable(ISyllable syll);

  /**
   * Returns the (unsyllabified) form of the word.
   * @return    The unsyllabified word.
   */
  public String getWord();

  /**
   * Gets the list of syllables that make up this word.
   * @return   the list of syllable
   */
  public ArrayList<ISyllable> getSyllables();

  /**
   * Gets the i-th syllable of this word.
   * @param i    The syllable's index.
   * @return     The syllable found at this index.
   */
  public ISyllable getSyllable(int i);

  /**
   * Removes the i-th syllable of this word.
   * @param i    The index of the syllable to be deleted.
   */
  public void removeSyllable(int i);

  /**
   * Sets this word's syllable list to a given list of syllables.
   * @param sy    The syllables to be used.
   */
  public void setSyllables(ArrayList<ISyllable> sy);

  /**
   * Sets this word's legality.
   * @param legal   Boolean representation of if this word is legal.
   */
  public void setLegal(boolean legal);

  /**
   * Gets this word's legality.
   * @return   True if this word is legal, false otherwise.
   */
  public boolean getLegal();

}
