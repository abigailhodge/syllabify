package syllabify.model;

import java.util.ArrayList;
import java.util.Collections;

public class English implements ILanguage {
  private ArrayList<String> nuclei;
  private ArrayList<String> onsets;
  // private ArrayList<String> codas;

  public English() {
    nuclei = new ArrayList<>();
    onsets = new ArrayList<>();
    Collections.addAll(nuclei, "a", "i", "o", "e", "u", "ue", "ai", "oa", "ou", "ea",
            "ui", "ee", "io", "au", "oo", "ey", "oi");
    Collections.addAll(onsets, "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n",
            "p", "q", "r", "s", "t", "v", "w", "x", "y", "z", "sk", "bl", "cl", "gl", "", "sn",
            "sl", "sm", "rh", "spr", "th", "dr", "spl", "sh", "wh", "kn", "ch", "br", "tr", "pr",
            "st", "ph", "pl", "fr", "sw", "gr", "tw", "fl", "thr", "cr");
    // Collections.addAll(codas, "g", "m");
  }

  @Override
  public void nucleusPass(Word word) {
    String w = word.getWord();
    int startSyll = 0;
    for (int i = 0; i < w.length(); i++) {
      String vowel = "";
      if (nuclei.contains(vowel + w.charAt(i)) &&
              !(w.charAt(i) == 'e' && (word.getSyllables().size() > 0 || w.contains("y")) &&
                      ((i == w.length() - 1) || this.isSPronounced(i, w) ||
                              this.isEPronounced(i, w)))) {
        String onset = w.substring(startSyll, i);
        String nucleus;
        if (i < w.length() - 1 &&
                nuclei.contains(vowel + w.charAt(i) + w.charAt(i + 1))) {
          nucleus = w.substring(i, i + 2);
          startSyll = i + 2;
          i++;
        } else {
          nucleus = w.substring(i, i + 1);
          startSyll = i + 1;
        }

        Syllable toAdd = new Syllable(onset, nucleus);
        word.addSyllable(toAdd);
      }
    }
    if (startSyll < w.length()) {
      ISyllable s = new Syllable();
      s.setOnsetTo(w.substring(startSyll));
      word.addSyllable(s);
    }
  }

  private boolean isEPronounced(int index, String word) {
    return ((index > 0 && index == word.length() - 2 && (word.charAt(index - 1) != 'd' &&
            word.charAt(index - 1) != 't')
            && word.charAt(index + 1) == 'd') // verb endings
    );
  }

  private boolean isSPronounced(int index, String word) {
    return index > 0 && index == word.length() - 2 && word.charAt(index + 1) == 's' &&
            ((word.charAt(index - 1) != 's' &&
                    word.charAt(index - 1) != 'z' &&
                    word.charAt(index - 1) != 'x' &&
                    word.charAt(index - 1) != 'g') &&
                    !(index > 1 && word.charAt(index - 2) == 's' && word.charAt(index - 1) ==
                            'h'));
  }

  private void yPass(Word word) {
    ArrayList<ISyllable> sylls = word.getSyllables();
    ArrayList<ISyllable> newsylls = new ArrayList<>();
    for (ISyllable syl : sylls) {
      String onset = syl.getOnset();
      if (onset.length() != 2 && onset.endsWith("le") && syl.getNucleus().equals("")) {
        String lonset = onset.substring(0, onset.length() - 2);
        Syllable lonSyll = new Syllable(lonset, "le");
        newsylls.add(lonSyll);
      } else if (!onsets.contains(onset) && onset.contains("y")) {
        int startSyl = 0;
        for (int i = 0; i < onset.length(); i++) {
          if (onset.charAt(i) == 'y') {
            String yonset = onset.substring(startSyl, i);
            startSyl = i + 1;
            Syllable ySyll = new Syllable(yonset, "y");
            newsylls.add(ySyll);
          } else if (i == onset.length() - 1 && onset.charAt(i) != 'y') {
            String nonset = onset.substring(startSyl);
            Syllable nonSyll = new Syllable(nonset, syl.getNucleus());
            newsylls.add(nonSyll);
          }
        }
      } else {
        newsylls.add(syl);
      }
    }
    word.setSyllables(newsylls);
  }

  @Override
  public void onsetPass(Word word) {
    try {
      this.yPass(word);
      ArrayList<ISyllable> sylls = word.getSyllables();

      for (ISyllable syl : sylls) {
        int wordPosn = syl.getWordPosn();
        String onset = syl.getOnset();

        if (!onsets.contains(onset) && !syl.getNucleus().equals("")) {
          ISyllable prevSy = word.getSyllable(wordPosn - 1);
          int divide = this.getSegmentNum(onset);
          syl.setOnsetTo(onset.substring(divide));
          prevSy.addCodaSounds(onset.substring(0, divide));
        }
      }
      ISyllable lastSyllable = sylls.get(sylls.size() - 1);
      if (lastSyllable.getNucleus().equals("")) {
        ISyllable prevSy = word.getSyllable(sylls.size() - 2);
        prevSy.addCodaSounds(lastSyllable.getOnset());
        word.removeSyllable(sylls.size() - 1);
      }
    } catch (IndexOutOfBoundsException e) {
      System.out.print("Not a legal word in English");
      System.exit(0);
    }


  }


  @Override
  public boolean codaPass(Word word) {
    for (ISyllable sylls : word.getSyllables()) {
    }
    return false;
  }

  private int getSegmentNum(String onset) {
    int length = onset.length();
    int divider = 0;
    while (!onsets.contains(onset) && onset.length() > 1) {
      onset = onset.substring(1);
      divider += 1;
    }
    if (onsets.contains(onset)) {
      return divider;
    } else {
      return length;
    }
  }
}
