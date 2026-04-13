class Solution {
    public int maxProfit(int[] prices) {
        //nested for loop to use sliding window technique
        // use max function to
        int profit = 0;
        int leftPointer = 0;
        int rightPointer = 1;
        while (rightPointer < prices.length ){
            if(prices[leftPointer] < prices[rightPointer]){
                profit = Math.max(profit,prices[rightPointer] - prices[leftPointer]);
            }else{
                leftPointer = rightPointer;
            }
            rightPointer++;
        }
     
    return profit;
    }
}
//prices=[5,1,5,6,7,1,10]
//        l r                buy 5 sell 1 profit -1
//          l r            buy 1 sell  profit 1
//          l   r           
//          l     r
//                  l  r
//                  
//
//
//
