class Solution {
    public int maxProfit(int[] prices) {
        //nested for loop to use sliding window technique
        // use max function to
        int leftPointer = 0;
        int rightPointer = 1;
        int profit = 0;
        while (rightPointer < prices.length){
            if (prices[leftPointer] < prices[rightPointer]){
                int currentProfit = prices[rightPointer]-prices[leftPointer];
                profit = Math.max(profit,currentProfit);
            }else{
                leftPointer = rightPointer;
            }
            rightPointer++;

        
    }
    return profit;
    }
}
//prices=[5,1,5,6,7,1,10]
//        l            r     buy 5 sell 10 profit 5
//          l                buy 1 sell 10 profit 9
//            l        r     
//              l
//                l
//                  l
//
//
//
