class MedianFinder {
    List<Integer> stream;
    public MedianFinder() {
        stream = new ArrayList<>();
    }
    
    public void addNum(int num) {   
        stream.add(num);
    }
    
    public double findMedian() {
        int mid;
        Collections.sort(stream);
        if (stream.size() % 2 != 0) {
            mid = stream.size()/2;
            return (double)stream.get(mid);
        } else {
            int i1 = stream.size()/2;
            int i2 = stream.size()/2 - 1;
            double ans = (double)((double)stream.get(i1) + (double)stream.get(i2))/2.0;
            return ans;
        }
    }
}
