class TimeMap {
        private Map<String, List<Pair<Integer,String>>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp,value)); //if there is no key,value entry then we map this key to a new value that is an arraylist of pairs
        //regardless we add the pair to the arraylist 
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer,String>> values = timeMap.getOrDefault(key,new ArrayList<>());// we retrieve the list or add a new array list
        String result = ""; // default result
        
        int leftPointer = 0, rightPointer = values.size() -1;
        while (leftPointer<=rightPointer){
            int mid = leftPointer + (rightPointer - leftPointer) / 2;
            if (values.get(mid).getKey() <= timestamp){
                result = values.get(mid).getValue();
                leftPointer = mid + 1;
            } else {
                rightPointer = mid -1;
            }
        }
        return result;
    }
     private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
