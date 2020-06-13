package javalang.bfsdfs.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    // 207. Course Schedule
// https://leetcode.com/problems/course-schedule/

    class Solution {

        // DFS each node and make each node as in process or finished processing
        // Please read note written below
        // space = V + E for graph (keyed by V and valued by E)
        // time = E for creating initial graph + V for DFS of each node
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            List<Integer>[] graph = new List[numCourses];

            // build graph
            for (int[] pr : prerequisites) {
                int from = pr[0];
                int to = pr[1];

                if (graph[from] == null) {
                    graph[from] = new ArrayList<>();
                }
                graph[from].add(to);
            }

            // this stores currently seen values and maps to whether the value has
            // been processed in a DFS way. If processing completed i.e. all children have been certified, then maps to yes, otherwise false indicating we have seen this node but have not finished processing children.
            // NOTE: this is an optimization that remembers DFS'ed nodes and prevents reprocessing them again
            // IMPORTANT: note this yeinds V complexity since each node is processed only once
            Map<Integer, Boolean> processed = new HashMap<>();
            for (int i = 0; i < graph.length; i++) {

                // IMPORTANT: creating map inside the for loop will yeild DFS from each node every time. However,
                // we must realize that once DFS for a node is performed and the node is certified of
                // having no cycles, then we can always refer to that info again as graph has not changed.
                // Note; this yeilds V^2 complexity since each node ir processed for every other node.
                // Map<Integer, Boolean> processed = new HashMap<>();


                if (isCyclic(processed, graph, i)) {
                    return false;
                }
            }

            return true;
        }

        private boolean isCyclic(Map<Integer, Boolean> processed, List<Integer>[] graph, int curr) {

            if (processed.containsKey(curr)) {
                return !processed.get(curr);
            }

            processed.put(curr, false);

            if (graph[curr] != null) {
                for (int child : graph[curr]) {
                    if (isCyclic(processed, graph, child)) {
                        return true;
                    }
                }
            }

            processed.put(curr, true);

            return false;
        }
    }
}
