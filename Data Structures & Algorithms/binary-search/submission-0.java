class Solution {
    public int search(int[] nums, int target) {
        int high = nums.length -1;
        int low = 0;
        int mid;
        boolean found = false;
        int result = -1;
        
        System.out.println("Target: "+ target + " High: " + high + " Low: " + low);

        while (!found && low <= high){
            mid = low +(high -low)/2;
            if (nums[mid] == target){
                found = true;
                result = mid;
            } else if (target < nums[mid]){
                System.out.println("Target: "+ target + " High: " + high + " Low: " + low);
                high = mid -1;
                System.out.println("Target: "+ target + " High: " + high + " Low: " + low);
            } else if (target > nums[mid]){
                System.out.println("Target: "+ target + " High: " + high + " Low: " + low);
                low = mid +1 ;
                System.out.println("Target: "+ target + " High: " + high + " Low: " + low);
            } else {
                    found = false;
                    result = -1;
                    break;
            }
        }
        
        return result;
    }
}
