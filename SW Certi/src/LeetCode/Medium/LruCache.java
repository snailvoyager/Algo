package LeetCode.Medium;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LruCache {
}

class LRUCache_TimeExceeded {

    static Deque<Integer> deque;
    static HashMap<Integer, Integer> hashMap;
    static int capacity;

    public LRUCache_TimeExceeded(int capacity) {
        hashMap = new HashMap<>();
        deque = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            deque.remove(key);      //O(N), Time Limit Exceeded
            deque.push(key);        //move to head

            return hashMap.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            deque.remove(key);
        } else {
            if (deque.size() == capacity) {
                int lastKey = deque.getLast();
                hashMap.remove(lastKey);
                deque.removeLast();
            }
        }

        deque.push(key);
        hashMap.put(key, value);
    }
}

class LRUCache {
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = new Node(0, 0);     //head, tail은 node를 가리키기만 한다
    Node tail = new Node(0, 0);
    int capacity;

    class Node {        //Double LinkedList Node
        Node prev;
        Node next;
        int key;
        int value;

        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);       //O(1)
            remove(node);                   //O(1)
            insert(node);       //move to head

            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);

        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            remove(oldNode);
        } else if (map.size() == this.capacity) {
            map.remove(tail.prev.key);
            remove(tail.prev);
        }

        map.put(key, node);
        insert(node);
    }

    public void insert(Node node) {
        node.next = head.next;
        head.next.prev = node;

        node.prev = head;
        head.next = node;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
