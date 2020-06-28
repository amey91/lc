package javasolutions.bfsdfs.graph;

import java.util.*;

public class ReconstructItinerary {
    // 332. Reconstruct Itinerary
// https://leetcode.com/problems/reconstruct-itinerary/

    class Solution {

        // This is DFS in directed cyclic graph!!!!! Inspired by BRILLIANT solution
        // by StefanPochman https://leetcode.com/problems/reconstruct-itinerary/discuss/78768/Short-Ruby-Python-Java-C%2B%2B
        // We iterate over the graph in DFS and keep eliminating edges as we traverse to prevent same edge traversal multiple times
        // Cycles are handled by DFS that will automatically backtrack to node which has more unexplored edges!!!
        // I think I am in love with the idea of DFS functions handling all the complexity for me.
        // IMPORTANT: This problem actualy asks for an Eulerian path i.e. traversing each edge of graph exactly once!
        // There are Eulerian cycles in some graphs where the path starts and ends at same node. In this problem however, we
        // want Eulerian path since the start and end nodes will have odd incoming edge count. For a graph to be an Eulerian cycle,
        // the graph will have to have:
        //      1. for Undirected graphs: each node even degree
        //      2. For directed graphs:   each node even degree and same incoming and outgoing degrees for each node
        // For Eulerian cycles/paths, see: https://www-m9.ma.tum.de/graph-algorithms/hierholzer/index_en.html
        // time = O(E) for DFS and worst case ElogE for sorting airports lexicohraphically assuming one aripot is the bottle next and handles half i.e. E/2 of the flights. Average case is when each node has E/2/V number of flights thus complexity becomes )(V nodes * (NlogN)) = )(V * E/2V * log (E/2V)) = O(Elog(E/V))
        // space = O(V + E)
        public List<String> findItinerary(List<List<String>> tickets) {

            // my initial INCORRECT algo:
            // map string -> pq <tring>  // since we need to be greedy while selecting lesast lexicographic string
            // curr = JFK
            // while map != empty
            //      next = map.get(curr).poll()
            //      result.add(curr, next)
            //      curr = next // this is iterative solution but it does not deal well with cycles since we need to backtrack to other solutions if current solution is not feasible

            //  Another solution is to do DFS and let DFS worry about the backtracking part
            //  IMPORTANT: The iterative solution will require stack to backtrack!!!

            List<String> result = new ArrayList<>();
            if (tickets == null || tickets.isEmpty()) {
                return result;
            }

            Map<String, PriorityQueue<String>> map = new HashMap<>();
            for (List<String> ticket : tickets) {
                if (!map.containsKey(ticket.get(0))) {
                    map.put(ticket.get(0), new PriorityQueue<>()); // min heap
                }

                map.get(ticket.get(0)).add(ticket.get(1));
            }

            String curr = "JFK"; // start is fixed for this problem
            visit(curr, map, result);
            return result;
        }

        private void visit(String curr, Map<String, PriorityQueue<String>> map, List<String> result) {
            while (map.containsKey(curr) && !map.get(curr).isEmpty()) {
                visit(map.get(curr).poll(), map, result);
            }

            // IMPORTANT: since this is DFS and the bottom node needs to be last, we keep inserting each node at start of list
            result.add(0, curr);
        }
    }
}
