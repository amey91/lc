import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> ans = new ArrayList<>();
    ArrayDeque<Integer> list = new ArrayDeque<>();
    depthFirst(candidates, ans, list, target, 0);
    return ans;
  }

  private void depthFirst(int[] candidates, List<List<Integer>> ans, ArrayDeque<Integer> list, int target, int index) {

    if(target==0) {
      if(!list.isEmpty()) ans.add(new ArrayList<>(list));
      return;
    }
    if(index>=candidates.length || target<0) {
      return;
    }

    // don't include this number
    // IMP skip over all duplicates
    int _index = index+1;
    while(_index<candidates.length && candidates[_index]==candidates[_index-1]) {
      _index++;
    }
    depthFirst(candidates, ans, list, target, _index);

    // include this number
    list.addLast(candidates[index]);
    depthFirst(candidates, ans, list, target-candidates[index],
            index+1); //include each number just once
    list.removeLast();
  }
}