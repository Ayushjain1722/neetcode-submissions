class Solution {
    public boolean dfs(List<List<Integer>> arr, int[] visited, int i) {
        if (visited[i] == 2)    return false; // Cycle detected!
        if (visited[i] == 1)    return true;
        visited[i] = 2;
        for (int j=0;j<arr.get(i).size();j++) {
            if (!dfs(arr, visited, arr.get(i).get(j))) return false;
        }
        visited[i] = 1;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> arr = new ArrayList<>();
        for (int i=0;i<numCourses;i++) {
            List<Integer> temp = new ArrayList<>();
            arr.add(temp);
        }

        for (int[] course: prerequisites) {
            int i = course[0];
            int j = course[1];
            arr.get(i).add(j);
        }
        int visited[] = new int[numCourses];
        // 0 -> unvisited
        // 1 -> Visited
        // 2 -> Visited in the current dfs traversal
        for (int i=0;i<numCourses;i++) {
            if (visited[i] == 0)
                if(!dfs(arr, visited, i)) return false;
        }
        return true;
    }
}
