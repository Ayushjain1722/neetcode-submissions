class Solution {
    public void dfs(char grid[][], int i, int j, boolean visited[][]) {
        if (i >= grid.length || j >= grid[0].length) return;
        if(visited[i][j]) return;
        visited[i][j] = true;

        if (i+1 < grid.length && grid[i+1][j] == '1')
            dfs(grid, i+1, j, visited);
        if (j+1 < grid[i].length && grid[i][j+1] == '1')
            dfs(grid, i, j+1, visited);
        if (i-1>=0 && grid[i-1][j] == '1')
            dfs(grid, i-1, j, visited);
        if (j-1 >=0 && grid[i][j-1] == '1')
            dfs(grid, i, j-1, visited);
    }
    public int numIslands(char[][] grid) {
        int islands = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, visited);
                    islands++;
                }
            }
        }

        return islands;
    }
}
