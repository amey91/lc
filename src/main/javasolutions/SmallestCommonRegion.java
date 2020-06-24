package javasolutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SmallestCommonRegion {
    // Approach 1: map and recurse back
// construct reverse map of smaller -> larger
// for region1, construct HashSet<region> for hierarchy
// for region2, traverse hierarchy and for each parent, if set contains parent return parent

// Approach 2: contruct n-ary tree (or is it enough with binary tree?) and LCA
// time = n for index creation + logn for set creation + logn for region2 contains = n
// space = n + logn = n

// Approach 3: [OPTIMAL] completes in constant space! This uses he fact that each parent occurs in the list only once as a parent. Thus, if you can converge 2 pointers so that they always point to their parent, then intersect parent is LCA
// time = n for input traversal
// space = O(1)

    // 1257. Smallest Common Region
// https://leetcode.com/problems/smallest-common-region/
    class Solution {
        public String findSmallestRegion_OPTIMAL_APPROACH3(List<List<String>> regions, String region1, String region2) {
            for (int i = regions.size() -1 ; i >= 0; i--) {
                List<String> currRegion = regions.get(i);
                for (String region: currRegion) {
                    if (region.equals(region1)) {
                        region1 = currRegion.get(0);
                    }
                    if (region.equals(region2)) {
                        region2 = currRegion.get(0);
                    }
                }
                if (region1 == region2) {
                    return region1;
                }
            }
            return null;
        }

        public String findSmallestRegion_Approach1(List<List<String>> regions, String region1, String region2) {
            // no need to check for null since smallest region exists

            // this is a reverse index for smaller -> larger
            Map<String, String> index = new HashMap<>(regions.size()*2);


            String ROOT = regions.get(0).get(0);
            for (List<String> region: regions) {
                String larger = region.get(0);
                for (int i = 1; i < region.size(); i++) {
                    index.put(region.get(i), larger);
                }
            }

            Set<String> r1S = new HashSet<>();
            String currNode = region1;
            while(currNode != ROOT) {
                r1S.add(currNode);
                currNode = index.get(currNode);
            }

            currNode = region2;
            while(currNode != ROOT) {
                if (r1S.contains(currNode)) {
                    return currNode;
                }
                currNode = index.get(currNode);
            }

            return ROOT;
        }
    }
}
