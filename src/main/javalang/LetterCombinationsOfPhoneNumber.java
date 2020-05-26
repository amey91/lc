package javalang;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
  public List<String> letterCombinations(String digits) {
    char[] currentLetters = new char[digits.length()];
    List<String> ans = new ArrayList<String>();
    nextCombo(digits, currentLetters, 0, ans);
    return ans;
  }

  private void nextCombo(String digits, char[] currentLetters, Integer currIndex, List<String> list) {

    if(currIndex.equals(digits.length())) {
      if(currIndex>0) {
        list.add(new String(currentLetters));
      }
      return;
    }

    String dictLetters = dict[Integer.parseInt(String.valueOf(digits.charAt(currIndex)))];
    for(Character c : dictLetters.toCharArray()) {
      currentLetters[currIndex] = c;
      nextCombo(digits, currentLetters, currIndex+1, list);
    }
  }

  private String[] dict = new String[] {
          //0
          "",
          //1
          "",
          //2
          "abc",
          //3
          "def",
          //4
          "ghi",
          //5
          "jkl",
          //6
          "mno",
          //7
          "pqrs",
          //8
          "tuv",
          //9
          "wxyz"
  };
}