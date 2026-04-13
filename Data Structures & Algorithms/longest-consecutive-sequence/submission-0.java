class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        } else if (nums.length == 1){
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        int longest = 1;
        for(int num : set){
            if(set.contains(num-1)){
                continue;
            }
            int length =1;
            while(set.contains(num + length)){
                length++;
            }
            longest = Math.max(longest,length);
        }
        return longest;
        
        
    }
}
