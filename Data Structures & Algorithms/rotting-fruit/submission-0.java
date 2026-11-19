class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0;
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == 2) {
                    arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(j);
                    q.add(arr);
                }
            }
        }
        int dirs[][] = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotted = false;
            for (int i=0;i<size;i++) {
                List<Integer> curr = q.poll();
                for (int[] dir: dirs) {
                    int r = dir[0] + curr.get(0);
                    int c = dir[1] + curr.get(1);

                    if (r <0 || c < 0 || r > grid.length-1 || c > grid[0].length -1 
                        || grid[r][c] == 0 || grid[r][c] == 2)
                        continue;
                    
                    if(grid[r][c] == 1){
                        grid[r][c] = 2;
                        arr = new ArrayList<>();
                        arr.add(r);
                        arr.add(c);
                        q.add(arr);
                        rotted = true;
                    }
                }
            }
            if (rotted) 
                time++;
        }

        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == 1)    return -1;
            }
        }
        return time;
    }
}
