class Solution {
    public boolean dfs(List<List<Integer>> adj, int[] visited, int i, int parent) {
        visited[i] = 1;
        for (int j=0;j<adj.get(i).size();j++) {
            int neighbor = adj.get(i).get(j);
            if(neighbor == parent) continue;
            if (visited[neighbor] == 1 ) return true;
            if (dfs(adj, visited, adj.get(i).get(j), i))   return true;
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0;i<n;i++) {
            List<Integer> temp = new ArrayList<>();
            adj.add(temp);
        }
        for (int i=0;i<edges.length;i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }
        int visited[] = new int[n];
        if (dfs(adj, visited, 0, -1))  return false; // If there is a cycle
        for (int i=0;i<n;i++) {
            if (visited[i] == 0)    return false; // if any node is left unvisited after traversal
        }
        return true;
    }
}
