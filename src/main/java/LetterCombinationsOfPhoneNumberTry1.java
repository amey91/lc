import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LetterCombinationsOfPhoneNumberTry1 {
  public List<String> letterCombinations(String digits) {
    return generateNextCombo(digits, 0, new ArrayList<String>());
  }

  private List<String> generateNextCombo(String digits, Integer currIndex, List<String> oldList) {
    if(null==digits || digits.length()==0 || currIndex>=digits.length() ) {
      return oldList;
    }
    char currDigit = digits.charAt(currIndex);
    String currDigitList = dict[Integer.parseInt(String.valueOf(currDigit))];
    List<String> newList = new ArrayList<>();
    for(char digit : currDigitList.toCharArray()) {
      if(oldList.isEmpty()) {
        newList.add(String.valueOf(digit));
      } else {
        List<String> oldListClone = new ArrayList<>(oldList);
        newList.addAll(oldListClone.stream().map(_oldString -> _oldString+String.valueOf(digit)).collect(Collectors.toList()));
      }
    }
    oldList = null;
    return generateNextCombo(digits, currIndex+1, newList);

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