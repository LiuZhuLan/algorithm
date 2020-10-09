package design;

import java.util.HashMap;

/**
 * 设计一个最近最少使用结构，使得插入和移除都是 O(1) 的时间复杂度
 * 思路：
 * 1、数组实现，数组的值存储时间戳，需要遍历数组，就算放在数组头和尾也要移动数组，移动数组就是O(n)
 * 2、链表实现，put的时候插入到一头即可，如果是get命中了另一头，要把它删了，并且插入到最近最少使用那一头；但是如果是命中在中间节点
 * 需要遍历找到该节点，并且要记录它的前一个节点，来改变指针指向
 * 3、使用HashMap存储，O(1)找到该节点，但是找到左边的元素，就需要双向链表
 *
 * @author LiuZhulan
 */
public class Lru {

    private HashMap<Integer, DoubleLinkedList> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DoubleLinkedList head, tail;


    public Lru(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DoubleLinkedList();
        tail = new DoubleLinkedList();
        head.next = tail;
        tail.pre = head;
    }

    public static void main(String[] args) {
        Lru lru=new Lru(3);
        lru.put(1,1);
        lru.put(2,22);
        lru.put(2,22);
        lru.put(3,3);
        lru.put(0,0);

        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
    }

    public void put(int key,int value) {
        DoubleLinkedList node = cache.get(key);
        if (node == null) {
            DoubleLinkedList temp=new DoubleLinkedList(key,value);
            cache.put(key,temp);
            addToHead(temp);
            size++;

            if(size>capacity){
                DoubleLinkedList res = removeFromTail();
                cache.remove(res.key);
            }
        } else {
            node.value=value;
            moveToHead(node);
        }
    }

    public void moveToHead(DoubleLinkedList node) {

        remove(node);
        addToHead(node);
    }


    public void remove(DoubleLinkedList node) {

        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(DoubleLinkedList node) {

        node.next=head.next;
        head.next.pre=node;

        node.pre=head;
        head.next=node;
    }

    public DoubleLinkedList removeFromTail(){

        DoubleLinkedList res=tail.pre;
        remove(tail.pre);
        return res;
    }


    public int get(int key) {

        DoubleLinkedList res = cache.get(key);
        if(res==null){
            return -1;
        }
        moveToHead(res);
        return res.value;
    }

    class DoubleLinkedList {
        int key;
        int value;
        DoubleLinkedList pre;
        DoubleLinkedList next;

        public  DoubleLinkedList(){}
        public DoubleLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }


}
