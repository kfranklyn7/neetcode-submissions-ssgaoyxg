class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heaviest = new PriorityQueue<>((a,b)->(b-a));
        for (int i : stones){
            heaviest.offer(i);
        }
        heaviest.offer(0);
        while(heaviest.size() > 1){
            int largest = heaviest.poll();
            int second = heaviest.poll();
            if (largest == second){
                continue;
            } else {
                heaviest.offer(largest-second);
            }
        } 
       return heaviest.peek(); 
    }
}
