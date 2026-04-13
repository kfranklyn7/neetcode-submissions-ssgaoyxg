class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> seen = new HashMap<>();
        
        for (int index = 0; index < numbers.length;index++){
            int complement = target-numbers[index];
            if (seen.containsKey(complement) && target == numbers[index] + complement){
                return new int[] {seen.get(complement),index + 1};
            }
            seen.put(numbers[index],index + 1);
        }
        
        return new int[] {,};
    }
}
