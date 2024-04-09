package leetcode.medium;

import java.util.HashMap;

public class _146LRUCache {
}

class Node1 {
    int key;
    int value;
    Node1 next;
    Node1 prev;

    public Node1(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    int cap;
    Node1 head;
    Node1 tail;
    HashMap<Integer, Node1> nodes;

    public LRUCache(int capacity) {
        cap = capacity;
        head = new Node1(-1, -1);
        tail = new Node1(-1, -1);
        head.next = tail;
        tail.prev = head;
        nodes  = new HashMap<>();
    }

    private void addNode(Node1 newnode) {
        Node1 temp = head.next;

        newnode.next = temp;
        newnode.prev = head;

        head.next = newnode;
        temp.prev = newnode;
    }

    private void remove(Node1 node1){
        Node1 nextt = node1.next;
        Node1 prevv = node1.prev;
       nextt.prev = prevv;
       prevv.next = nextt;

    }
    public int get(int key) {
        if (nodes.containsKey(key)) {
            Node1 resNode = nodes.get(key);
            int ans = resNode.value;

            nodes.remove(key);
            remove(resNode);
            addNode(resNode);

            nodes.put(key, head.next);
            return ans;
        }
        return -1;
    }
    public void put(int key, int value) {

        if (nodes.containsKey(key)){
            Node1 curr = nodes.get(key);
            remove(curr);
            nodes.remove(key);

        }

        //remove least used
        if (nodes.size() == cap){
            remove(tail.prev);
            nodes.remove(key);
        }

        Node1 node1 = new Node1(key, value);
        addNode(node1);
        nodes.put(key, head.next);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
