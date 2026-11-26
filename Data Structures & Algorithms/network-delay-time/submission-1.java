class Edge {
    // int src;
    int dest;
    int time;
    Edge( int dest, int time) {
        // this.src = src;
        this.dest = dest;
        this.time = time;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<times.length;i++) {
            adj.get(times[i][0]-1).add(new Edge(times[i][1]-1, times[i][2]));
        }

        int dist[] = new int[n];
        dist[k-1] = 0; // Initialize src node to 0
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        pq.add(new Edge(k-1, 0));
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            for(int i=0;i<adj.get(edge.dest).size();i++) {
                Edge next = adj.get(edge.dest).get(i);
                int totalTime = edge.time + next.time;
                if (dist[next.dest] > totalTime) {
                    dist[next.dest] = totalTime;
                    pq.add(new Edge(next.dest, totalTime));
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++) {
            // System.out.println(i + " " + dist[i]);
            if(i == k-1) continue;
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
       return ans;
    }
}
