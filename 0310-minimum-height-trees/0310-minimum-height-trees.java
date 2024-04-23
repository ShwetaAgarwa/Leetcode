import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> indegree = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            indegree.add(0);
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            indegree.set(u, indegree.get(u) + 1);
            indegree.set(v, indegree.get(v) + 1);
        }

        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree.get(i) == 1)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int size = q.size();
            ans.clear();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                ans.add(curr);
                for (int child : graph.get(curr)) {
                    indegree.set(child, indegree.get(child) - 1);
                    if (indegree.get(child) == 1)
                        q.offer(child);
                }
            }
        }

        
        if (n == 1)
            ans.add(0);
        
        return ans; 
    }
}