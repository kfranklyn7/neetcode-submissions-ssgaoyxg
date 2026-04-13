class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int index = 0; index < nums.length; index++){
            int complement = target - nums[index];
            if (map.containsKey(complement)){
                return new int[] {map.get(complement),index};
            } else {
                map.put(nums[index],index);
            }
        }
        return new int[] {,};
        }
       }
    
