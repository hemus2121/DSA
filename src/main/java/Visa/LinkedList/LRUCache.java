package Visa.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    //Doubly Linked List structure
    class Node{
        int key, value;
        Node prev, next;
        Node(int key, int value){
            this.key = key ;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    Map<Integer, Node> dataMap = new HashMap<>();
    int capacity =0, size;
    Node head = new Node(-1,-1);
    Node tail = new Node(-1, -1);

    public LRUCache(int cap){
        this.capacity = cap;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if (!dataMap.containsKey(key)) return -1;
        Node current = dataMap.get(key);
        removeFromHead(current);
        addToTail(current);
        return current.value;
    }

    public void put(int key, int value){
        //update already present node entry
        if (get(key) != -1){
            dataMap.get(key).value = value;
            return ;
        }

        // check for size - if full
        if (size == capacity){
            dataMap.remove(head.next.value);
            removeFromHead(head.next);
            size--;
        }
        // add incoming node
        Node newNode = new Node(key, value);
        dataMap.put(key, newNode);
        addToTail(newNode);
    }

    void addToTail(Node node){
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    void removeFromHead(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
