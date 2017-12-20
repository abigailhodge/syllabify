package syllabify.model;

import java.util.ArrayList;

public interface IWord {

  /**
   * Adds a syllable to this word.
   * @param syll   The syllable to be added.
   */
  public void addSyllable(ISyllable syll);

  public String getWord();

  public ArrayList<ISyllable> getSyllables();

  public ISyllable getSyllable(int i);

  public void removeSyllable(int i);
}
