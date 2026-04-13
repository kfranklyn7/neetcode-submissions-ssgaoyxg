public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}



public class LRUCache {
    int capacity;
    HashMap<Integer,Node> cache;
    Node least;//least recent/left node
    Node most;// most recent/right node
    //seems like left and right are (0,0) are always adjacent to the actual most/least recent

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        least = new Node(0,0);
        most = new Node(0,0);
        least.next = most;
        most.prev = least;
    }
    private void insert(Node node){
        Node prev = most.prev;
        prev.next = node;
        node.prev = prev;
        node.next = most;
        most.prev = node;
    }

    private void remove(Node node){//basic removal by reassiging the previous and next nodes relative to the current
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
        
    }
    public int get(int key) {
        if (cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node node = new Node(key,value);
        cache.put(key,node);
        insert(node);
        if (cache.size() > capacity){
            Node lru = this.least.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
/*
LRUCache (int capacity): initializes the cache of the size of the int passed in
get(int key) returns the corresponding key if it exists, otherwise -1
update the value for the key if it exists, add it if it doesn't, remove the last used if capacity is exceeded

in terms of a linked list, we could insert new values at the beginning and remove the tail

this just seems like making a chained hashmap 











*/