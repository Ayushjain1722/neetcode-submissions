class Solution {
    Stack<Integer> st = new Stack<>();
    public boolean dfs(List<List<Integer>> arr, int visited[], int i) {
        if(visited[i] == 2) return false;
        if (visited[i] == 1) return true;
        visited[i] = 2;
        for (int j=0;j<arr.get(i).size();j++) {
            if (!dfs(arr, visited, arr.get(i).get(j)))  return false;
        }
        st.push(i);
        visited[i] = 1;
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> arr = new ArrayList<>();
        for (int i=0;i<numCourses;i++) {
            List<Integer> temp = new ArrayList<>();
            arr.add(temp);
        }
        for (int i=0;i<prerequisites.length;i++) {
            arr.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int visited[] = new int[numCourses];

        for (int i=0;i<numCourses;i++) {
            if (visited[i] == 0) {
                if (!dfs(arr, visited, i)) return new int[]{};
            }
        }
        int[] ans = new int[numCourses];
        int i = numCourses-1;
        while (!st.isEmpty()) {
            int index = st.peek();
            st.pop();
            ans[i--] = index;
        }
        return ans;
    }
}
