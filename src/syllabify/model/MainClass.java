package syllabify.model;

public class MainClass {

  public static void main(String[] args) {
    English lang = new English();
    for (int i = 0; i < args.length; i++) {
      Word w = new Word(args[i]);
      lang.nucleusPass(w);
      lang.onsetPass(w);
      if (!w.getLegal()) {
        System.out.print("Not a legal word in English\n");
      } else {
        System.out.print("[");
        for (ISyllable s : w.getSyllables()) {
          System.out.print(s.toString() + ".");
        }
        System.out.print("]\n");
      }
    }
  }
}
