package syllabify.model;

import java.util.ArrayList;

public class Word implements IWord {
  private String word;
  private ArrayList<ISyllable> syllables;

  public Word(String word) {
    this.word = word;
    this.syllables = new ArrayList<>();
  }

  @Override
  public void addSyllable(ISyllable syll) {
    this.syllables.add(syll);
    syll.setWordPosn(this.syllables.size() - 1);
  }

  @Override
  public String getWord() {
    return this.word;
  }

  @Override
  public ArrayList<ISyllable> getSyllables() {
    return this.syllables;
  }

  @Override
  public ISyllable getSyllable(int i) {
    return syllables.get(i);
  }

  @Override
  public void removeSyllable(int i) {
    syllables.remove(i);
  }

  public void setSyllables(ArrayList<ISyllable> sy) {
    this.syllables.clear();
    for (ISyllable s : sy) {
      this.addSyllable(s);
    }
  }
}
