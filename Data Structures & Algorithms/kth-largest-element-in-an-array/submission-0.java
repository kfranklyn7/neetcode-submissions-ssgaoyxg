class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> large = new PriorityQueue<>((a,b)-> (Integer.compare(b,a)));
        for(int num : nums){
            large.add(num);
        }
        for(int i = 0; i < k-1;i++){
            large.poll();
        }
        return large.poll();
    }
}
