package syllabify.model;

public class MainClass {

  public static void main(String[] args) {
    English lang = new English();
    for (int i = 0; i < args.length; i++) {
      Word w = new Word(args[i]);
      lang.nucleusPass(w);
      lang.onsetPass(w);
      System.out.print("[");
      for (ISyllable s : w.getSyllables()) {
        System.out.print(s.toString() + ".");
      }
      System.out.print("]\n");
    }
  }
}
