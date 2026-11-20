class Solution {
    int[] ans = new int[2];
    public boolean isCycle (List<List<Integer>> adj, int i, int parent, boolean visited[]) {
        if (visited[i]) return true;
        visited[i] = true;
        for (int j = 0;j<adj.get(i).size();j++) {
            int neighbor = adj.get(i).get(j);
            if (neighbor == parent) continue;
            if(isCycle(adj, neighbor, i, visited)) return true;
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0;i<edges.length;i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<edges.length;i++) {
            int v1 = edges[i][0] - 1;
            int v2 = edges[i][1] - 1;
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
            boolean[] visited = new boolean[edges.length];
            if(isCycle(adj, v1, -1, visited)) {
                ans[0] = v1 + 1;
                ans[1] = v2 + 1;
                return ans;
            }

        }
        return new int[0];
    }
}
