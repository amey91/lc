package javalang.unionfind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {


    // 690. Employee Importance
// https://leetcode.com/problems/employee-importance/


    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }


    class Solution {

        public int getImportance(List<Employee> employees, int id) {
            if (employees == null) {
                return 0;
            }

            Map<Integer, Employee> map = new HashMap<>(2001);
            for (Employee e : employees) {
                map.put(e.id, e);
            }

            Employee boss = map.get(id);
            List<Integer> subordinates = boss.subordinates;
            int importance = boss.importance;

            while (!subordinates.isEmpty()) {
                int eId = subordinates.remove(0);
                Employee e = map.get(eId);
                importance += e.importance;
                if (e.subordinates != null && !e.subordinates.isEmpty()) {
                    subordinates.addAll(e.subordinates);
                }
            }
            return importance;
        }

        // IMP my solution was not good because it was using uniion find which makes things much trickier
//     public int getImportance(List<Employee> employees, int id) {
//         int[] subordinates = new int[2001];
//         int[] importance = new int[2001];
//         boolean[] visited = new boolean[2001];

//         for (int i = 0; i<subordinates.length; i++) {
//             subordinates[i] = i;
//         }

//         Employee toFind = null;
//         for (Employee e : employees) {
//             union(e.id, e.subordinates, subordinates);
//             importance[e.id] = e.importance;
//             if (e.id == id) {
//                 toFind = e;
//             }
//         }
//         int sum = 0;

//         for (int i: toFind.subordinates) {
//             sum += find(importance, subordinates, visited, i);
//         }
//         return sum;
//     }

//     private void union(int id, List<Integer> subordinates, int[] graph) {
//         for (int i: subordinates) {
//             graph[i] = id;
//         }
//     }

//     private int find(int[] importance, int[] subordinates, boolean[] visited, int index) {
//         int sum = 0;

//         for (int i = 0; i < importance.length; i++) {
//             int currSum = 0;
//             int parentIndex = i;
//             while (subordinates[parentIndex] != parentIndex) {
//                 currSum += importance[parentIndex];
//                 parentIndex = subordinates[parentIndex];
//             }

//             if (parentIndex == index) {
//                 sum += currSum;
//                 parentIndex = i;
//                 while (subordinates[parentIndex] != parentIndex) {
//                     visited[parentIndex] = true;
//                     parentIndex = subordinates[parentIndex];
//                 }
//             }
//         }

//         return sum;
//     }
    }
}
