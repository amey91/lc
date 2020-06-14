package javalang.bfsdfs.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CourseSchedule2 {

    // 210. Course Schedule II
// https://leetcode.com/problems/course-schedule-ii/
    class Solution {

        // DFS with stack for storing answer
        // start from literally any node and keep adding children into the stack from deepest node being in bottom of stack
        // We do not need about traversal order since if there is a direct dependency, we will store in stack, if there is
        // no direct dependecy, then order doesnt matter anyways.
        // In the end you will have to REVERSE the stack to get the actual answer since we want the order in which the courses need to be completed
        // space = V + E for creating graph + V for stack
        // time = E for creaing graph + V for traversing it
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = new List[numCourses];

            for (int[] pr: prerequisites) {
                int to = pr[1];
                int from = pr[0];
                if (graph[from] == null) {
                    graph[from] = new ArrayList<>();
                }
                graph[from].add(to);
            }

            // maps node to current status
            // missing node indicates we have not seen this node till now
            // map mapping to true means we have seen this node and it has been processed i.e. no cyles in all children
            // map mapping to false means we have not finished processing the node. Thus when we cycle around and come back to this node at any point in time and the node is still mapping to false (unprocessed) then we have detected a cycle
            Map<Integer, Boolean> processed = new HashMap<>();

            // stack stores elements in order of deepest node first. The order of traversal does not matter beacause of stack !!!!!
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < numCourses; i++) {
                stack = dfs(stack, processed, graph, i);
                if (stack == null) {
                    // cycle detected!
                    return new int[0];
                }
            }

            int[] result = new int[stack.size()];

            // reserve the stack while filling in the answer
            for (int i = result.length-1; i >=0; i--) {
                result[i] = stack.pop();
            }

            return result;
        }

        private Stack<Integer> dfs(Stack<Integer> stack, Map<Integer, Boolean> processed, List<Integer>[] graph, int curr) {
            if(processed.containsKey(curr)) {
                if (!processed.get(curr)) {
                    // cycle detected!
                    return null;
                } else {
                    return stack;
                }
            }

            processed.put(curr, false);

            if (graph[curr] != null) {
                for (int child: graph[curr]) {
                    stack = dfs(stack, processed, graph, child);
                    if (stack == null) {
                        return null;
                    }
                }
            }

            processed.put(curr, true);
            stack.add(curr);
            return stack;
        }
    }
}
