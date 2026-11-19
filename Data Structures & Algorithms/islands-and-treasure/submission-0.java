class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int visited[][] = new int[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++) {
            Arrays.fill(visited[i], -1);
        }

        List<Integer> pos =  null;
        Queue<List<Integer>> q = new LinkedList<>();
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                if (grid[i][j] == 0) {
                    pos = new ArrayList<>();
                    pos.add(i);
                    pos.add(j);
                    q.add(pos);
                }
            }
        }
        while (!q.isEmpty()) {
            List<Integer> p = q.poll();
            int i = p.get(0);
            int j = p.get(1);
            // Up
            if (i -1 >= 0 && grid[i-1][j] == Integer.MAX_VALUE) {
                grid[i-1][j] = 1 + grid[i][j];
                pos = new ArrayList<>();
                pos.add(i-1);
                pos.add(j);
                q.add(pos);
            }
            //Down
            if (i+1 < grid.length && grid[i+1][j] == Integer.MAX_VALUE) {
                grid[i+1][j] = 1 + grid[i][j];
                pos = new ArrayList<>();
                pos.add(i+1);
                pos.add(j);
                q.add(pos);
            }
            // Left
            if (j-1 >= 0 && grid[i][j-1] == Integer.MAX_VALUE)  {
                grid[i][j-1] = 1 + grid[i][j];
                pos = new ArrayList<>();
                pos.add(i);
                pos.add(j-1);
                q.add(pos);
            }
            //Right
            if (j+1 < grid[0].length && grid[i][j+1] == Integer.MAX_VALUE)  {
                grid[i][j+1] = 1 + grid[i][j];
                pos = new ArrayList<>();
                pos.add(i);
                pos.add(j+1);
                q.add(pos);
            }
        }
    }
}
