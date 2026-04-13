class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> found = new HashMap<>();
        for (int index =0 ; index < nums.length;index++){
            int complement = target - nums[index]; 
            if (found.containsKey(complement)){
                return new int[] {found.get(complement),index};
            }
            found.put(nums[index],index);
           
        }
        return new int[] {,};
       }
}
    
