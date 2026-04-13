class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Map<Integer,Integer> map = new HashMap<>();
        // List<Integer> list = new ArrayList<>();
        // for (int index = 0; index < nums.length;index++){
        //     if (map.containsKey(nums[index])){
        //         map.put(nums[index],map.get(nums[index])+1);
        //     } else{
        //         map.put(nums[index],1);
        //     }
        //     }
        //     for (Map.Entry<Integer,Integer> entry : map.entrySet()){
        //         if(entry.getValue() >= k){
        //             list.add(entry.getKey());
        //         }
        //     }
        //     int[] result = list.stream().mapToInt(i->i).toArray();
        //     return result;
        
        //Initial thoughts: We could use a hashmap to add each number on an initial encounter then increment their count for each subsequent
        Map<Integer,Integer> frequency = new HashMap<>();
        
        for (int index = 0; index <nums.length;index++){
            frequency.put(nums[index],frequency.getOrDefault(nums[index],0) + 1);
        }
        // as we do need to return the "top" K elements we can place them into a heap
        Queue<Integer> elements = new PriorityQueue<>(((a,b)-> frequency.get(b) - frequency.get(a)   ));

        for (Integer num : frequency.keySet()){
            elements.add(num);
        }
        int[] result = new int[k];
        for (int index = 0; index < k;index++) result[index] = elements.remove();

        return result;
        }
        
        
        
    }
