class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> distance = new PriorityQueue<>((a,b) -> Integer.compare((a[0]*a[0] + a[1]*a[1]), (b[0]*b[0] + b[1]*b[1])));
        for(int[] p : points) distance.add(p);
        int[][] result = new int[k][2];
        for(int i= 0;i < k;i++){
            int[] current = distance.poll();
            result[i][0] = current[0];
            result[i][1] = current[1];
        }
        return result;
    }
}