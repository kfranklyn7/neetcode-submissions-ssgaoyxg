/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> copyTo = new HashMap<>();
        Node curr = head;
        while (curr != null){// linear traversal copying each node and having it mapped to the original
            Node copy = new Node(curr.val);
            copyTo.put(curr,copy);
            curr = curr.next;
        }
        curr = head;
        while(curr !=null){// linear traversal again while mapping each copy node to the copy of the next and random nodes from the map
            Node copy = copyTo.get(curr);
            copy.next = copyTo.get(curr.next);
            copy.random = copyTo.get(curr.random);
            curr = curr.next;
        }
        return copyTo.get(head);
    }
}
