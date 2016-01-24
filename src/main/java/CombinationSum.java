import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> ans = new ArrayList<>();
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    depthFirst(candidates, ans, stack, target, 0);
    return ans;
  }


  private void depthFirst(int[] candidates, List<List<Integer>> ans, ArrayDeque<Integer> stack, int target, int index) {
    if(target==0) {
      if(!stack.isEmpty()) ans.add(new ArrayList<>(stack));
      return;
    }

    if(index>= candidates.length || target<candidates[index]) {
      return;
    }

    // don't include in the solution
    depthFirst(candidates, ans, stack, target, index+1);

    // include in the solution
    stack.addLast(candidates[index]);
    depthFirst(candidates, ans, stack, target-candidates[index], index);
    stack.removeLast();
  }

}