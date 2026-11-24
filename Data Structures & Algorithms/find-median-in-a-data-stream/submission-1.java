class MedianFinder {
    List<Integer> stream;
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        stream = new ArrayList<>();
        minHeap = new PriorityQueue<>(); // For larger elements
        maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a)); // For smaller elements
    }
    
    public void addNum(int num) {   
        stream.add(num);
        int minHeapSize = minHeap.size();
        int maxHeapSize = maxHeap.size();

        if (minHeapSize == maxHeapSize) {
             if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        } else if (minHeapSize > maxHeapSize) {
            if(minHeap.peek() < num) {
                int temp = minHeap.poll();
                minHeap.add(num);
                maxHeap.add(temp);
            } else {
                maxHeap.add(num);
            }
        } else {
            if(maxHeap.peek() > num) {
                int temp = maxHeap.poll();
                maxHeap.add(num);
                minHeap.add(temp);
            } else {
                minHeap.add(num);
            }
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if (maxHeap.size() > minHeap.size()) {
            return (double)maxHeap.peek();
        } else {
            return (double)minHeap.peek();
        }
    }
}
