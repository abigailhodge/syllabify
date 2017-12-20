package syllabify.model;

public class Syllable implements ISyllable {
  private String onset;
  private String nucleus;
  private String coda;
  private int syllNum;

  public Syllable() {
    this.onset = "";
    this.nucleus = "";
    this.coda = "";
  }

  public Syllable(String onset, String nucleus) {
    this.onset = onset;
    this.nucleus = nucleus;
    this.coda = "";
  }

  @Override
  public void setOnsetTo(String onset) {
    this.onset = onset;
  }

  @Override
  public void setNucleusTo(String nucleus) {
    this.nucleus = nucleus;
  }

  @Override
  public void addCodaSounds(String coda) {
    this.coda += coda;
  }

  @Override
  public int getWordPosn() {
    return this.syllNum;
  }

  @Override
  public String getOnset() {
    return this.onset;
  }

  @Override
  public String getNucleus() {
    return this.nucleus;
  }

  @Override
  public String toString() {
    return this.onset + this.nucleus + this.coda;
  }

  @Override
  public void setWordPosn(int i) {
    this.syllNum = i;
  }
}
