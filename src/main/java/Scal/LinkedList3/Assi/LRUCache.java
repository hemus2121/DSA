package Scal.LinkedList3.Assi;

import java.util.HashMap;
import java.util.Map;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

   get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
   set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.

The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.
NOTE: If you are using any global variables, make sure to clear them in the constructor.

 */
public class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        //constructor
        Node(int key, int value){
            this.key= key;
            this.value = value;
            this.prev=null;
            this.next=null;
        }
    }

    Map<Integer, Node> dataMap= new HashMap<Integer, Node>();
    Node head =new Node(-1,-1), tail= new Node(-1,-1);
    int size=0, capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // set the new initial connection between nodes
        tail.prev=head;
        head.next=tail;
    }

    public int get(int key) {
        if (!dataMap.containsKey(key)) return -1;
        //if present get from Map and reset it position in DLL
        Node current = dataMap.get(key);
        removeFromHead(current);
        addToTail(current);
        return dataMap.get(key).value;
    }

    public void set(int key, int value) {
        // cache hit flow which is equivalent of get but update value in map
        if (get(key) !=-1){
            dataMap.get(key).value = value;
            return;
        }

        //handle cache miss flow
        // 1. check capacity if full remove from map and head
        if (size == capacity){
            dataMap.remove(head.next.key);
            removeFromHead(head.next);
            size--;
        }
        //create and insert to map and list
        Node newNode = new Node(key,value);
        dataMap.put(key, newNode);
        addToTail(newNode);
        size++;
    }
    // keep adding from Tail side - latest element is always left of tail element
    public void addToTail(Node x){
        x.next =tail;
        x.prev = tail.prev;
        x.prev.next=x;
        tail.prev=x;
    }
    // remove from head side  - last accessed element is denoted by Head
    public void removeFromHead(Node node){
        node.prev.next= node.next;
        node.next.prev = node.prev;
    }
}
