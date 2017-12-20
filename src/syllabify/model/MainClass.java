package syllabify.model;

public class MainClass {

  public static void main(String[] args) {
    English lang = new English();
    Word w = new Word(args[0]);
    lang.nucleusPass(w);
    lang.onsetPass(w);
    for (ISyllable s : w.getSyllables()) {
      System.out.println(s.toString());
    }
  }
}
