class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // h is the number of hours you have to eat the bananas
        // piles[i] is the number of bananas in the ith pile
        // 1 4 3 2       9
        //we can probably calculate the total number of bananas first in each pile with a basic loop
        // 10/4 = 2 62/4 = 15.5  h/length = lowerBound
        // max.peek() = upperBound
        //binary search between both values
        // k = (max/h)...max 
        //psychotic intuition answer based on Hint 1
        // return k= (bananas/length of pile) - max pile
        // maybe we push them all to a heap, pop the highest value till idk
        //heap might be unnecessary, we need to manually check every value between 1 and the upper bound 

        int upperBound =0;
        for (int i = 0; i < piles.length; i++){
            upperBound = Math.max(upperBound,piles[i]);
            }
        int lowerBound = 1;
        int result = upperBound;
        while (upperBound >= lowerBound){// 
            int rate = (upperBound + lowerBound)/2;
            int hours = 0;
            for (int index = 0; index < piles.length; index++){
                hours +=  Math.ceil((double)piles[index]/rate);
            }
            if (hours <= h){
                result = rate;
                upperBound = rate -1;
            } else if (hours > h){
                lowerBound = rate +1;
            }
        }return result;
    }
    
}
