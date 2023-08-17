import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, color))
                result.add(i);
        }

        return result;
    }

    private boolean dfs(int node, int[][] graph, int[] color) {
        if (color[node] != 0) {
            return color[node] == 1;
        }

        color[node] = 2;
        for (int neighbor : graph[node]) {
            if (!dfs(neighbor, graph, color))
                return false;
        }
        color[node] = 1;

        return true;
    }
}
