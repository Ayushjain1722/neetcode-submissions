class Solution {
    public void dfs(List<List<Integer>> adj, boolean[] visited, int i) {
        if(visited[i])  return;
        visited[i] = true;
        for(int j=0;j<adj.get(i).size();j++) {
            dfs(adj, visited, adj.get(i).get(j));
        }
    }
    public int countComponents(int n, int[][] edges) {
        int components = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i =0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<edges.length;i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                components++;
                dfs(adj, visited, i);
            }
        }

        return components;
    }
}
