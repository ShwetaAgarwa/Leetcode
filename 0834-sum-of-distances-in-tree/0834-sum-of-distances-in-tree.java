
import java.util.*;

class Solution {
    List<List<Integer>> graph;
    int[] counter, res;
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        graph = new ArrayList<>();
        counter = new int[n];
        res = new int[n];
        
        // Initialize adjacency list for the tree
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the tree from edges
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        dfs(0, -1); // Start DFS from node 0 with no parent
        dfs2(0, n, -1); // Start DFS from node 0 with no parent
        
        return res;
    }
    
    private void dfs(int i, int p) {
        for (int u : graph.get(i)) {
            if (u == p) continue;
            dfs(u, i);
            counter[i] += counter[u];
            res[i] += res[u] + counter[u];
        }
        counter[i] += 1;
    }

    private void dfs2(int i, int n, int p) {
        for (int u : graph.get(i)) {
            if (u == p) continue;
            res[u] = res[i] - counter[u] + n - counter[u];
            dfs2(u, n, i);
        }
    }
}
