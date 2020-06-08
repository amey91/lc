package javalang.unionfind;

public class FindNumberOfConnectedComponentsInGraph {

    // 323. Number of Connected Components in an Undirected Graph
// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

    // implement union find and then calculate the number of unique components by iterating over array.
    class Solution {

        public int countComponents(int n, int[][] edges) {
            int[] uf = new int[n];

            int components = n;
            for (int i = 0; i < uf.length; i++) {
                uf[i] = i;
            }
            for (int[] edge : edges) {
                if (find(uf, edge[0]) != find(uf, edge[1])) {
                    // we are going to merge these 2 components, so one less individual component
                    components--;
                }
                uf(uf, edge);
            }

            // can get rid of this set by maintaining a running count of connected components. Start with "n" individual components.
            // whenever you merge components, you decrease count. Merging means that before union, you find if (find(edge[0]) != find(edge[1])) then n--
//         Set<Integer> set = new HashSet<>(n/2);

//         for (int num : uf) {
//             set.add(find(uf, num));
//         }
            // return set.size();

            return components;
        }

        private int uf(int[] uf, int[] edge) {
            int smaller = Math.min(edge[0], edge[1]);
            int bigger = Math.max(edge[0], edge[1]);

            if (uf[bigger] != bigger) {
                // mapping for this number already exists
                int alreadyInArray = uf[bigger];

                //recurse into union-ing the already existing mapping
                // this is path compression. This means that we merge all indirect dependencies for this bigger number into directly  pointing to the smallest number
                smaller = uf(uf, new int[]{alreadyInArray, smaller});
            }

            // this is path compression. This means that we merge all indirect dependencies for this bigger number into directly  pointing to the smallest number
            uf[bigger] = smaller;
            return smaller;
        }

        private int find(int[] uf, int num) {
            while (uf[num] != num) {
                num = uf[num];
            }
            return num;
        }
    }
}
