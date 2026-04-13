class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
         PriorityQueue<Integer[]> heap = new PriorityQueue<Integer[]>((a,b) -> (b[1] - a[1]  ));
         for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            heap.add(new Integer[]{entry.getKey(),entry.getValue()});
         }
         int[] result = new int[k];
         for(int i = 0; i < k; i++){
            result[i] = heap.poll()[0];
         }
         return result;

    }
}
