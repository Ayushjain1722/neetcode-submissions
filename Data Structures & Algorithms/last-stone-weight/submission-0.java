class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int i=0;i<stones.length;i++) {
            pq.add(stones[i]);
        }

        while (pq.size()>1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if (stone1 == stone2)   continue;
            else {
                pq.add(Math.abs(stone1 - stone2));
            }
        }
        return pq.size() == 0? 0: pq.peek();
    }
}
