class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> large = new PriorityQueue<>((a,b)-> (Integer.compare(a,b)));
        for(int num : nums){
            large.add(num);
            if(large.size() > k){
                large.poll();
            }
        }
        return large.poll();
    }
}
