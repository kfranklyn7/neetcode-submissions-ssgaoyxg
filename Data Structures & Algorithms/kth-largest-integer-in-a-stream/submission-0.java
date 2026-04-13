class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k; 
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int num : nums){
            minHeap.offer(num);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
// we remove the smallest elements up to k in a minheap
// whenever we return the top of the minheap, we're returning the k-th largest element