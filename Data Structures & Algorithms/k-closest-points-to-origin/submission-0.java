class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair a, Pair b) {
        double dist1 = (double)Math.sqrt((a.x*a.x) + (a.y*a.y));
        double dist2 = (double)Math.sqrt((b.x*b.x) + (b.y*b.y));
        if (dist1 < dist2) return 1;
        else if (dist1 == dist2) return 0;
        else return -1;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        for (int i=0;i<points.length;i++) {
            pq.add(new Pair(points[i][0], points[i][1]));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int ans[][] = new int[k][2];
        for (int i=0;i<ans.length;i++) {
            Pair pair = pq.poll();
            ans[i][0] = pair.x;
            ans[i][1] = pair.y;
        }
        return ans;
    }
}
