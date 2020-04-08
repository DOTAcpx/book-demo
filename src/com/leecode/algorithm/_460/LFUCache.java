package com.leecode.algorithm._460;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
 *
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
 *
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 *
 * 示例：
 *
 * LFUCache cache = new LFUCache( 2  capacity (缓存容量)  );
 *
 *cache.put(1,1);
 *cache.put(2,2);
 *cache.get(1);       // 返回 1
 *cache.put(3,3);    // 去除 key 2
 *cache.get(2);       // 返回 -1 (未找到key 2)
 *cache.get(3);       // 返回 3
 *cache.put(4,4);    // 去除 key 1
 *cache.get(1);       // 返回 -1 (未找到 key 1)
 *cache.get(3);       // 返回 3
 *cache.get(4);       // 返回 4
 *
 *来源：力扣（LeetCode）
 *链接：https://leetcode-cn.com/problems/lfu-cache
 *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/*
public class LFUCache {
    Node root = Node.root;
    Map<Integer, Node> map = new HashMap<>();
    int c;
    public LFUCache(int capacity) {
        this.c=capacity;
    }

    public int get(int key) {
        Node n = root.next;
        Node node = map.get(key);
        if(node != null){
            return node.getValue();
        }
        return -1;
    }

    public void put(int key, int value) {
        Node n = map.get(key);
        if(n == null){
            if(root.value == c){
                map.remove(root.next.key);
                root.pop();
            }
            Node node = new Node(key, value);
            root.put(node);
            map.put(key, node);
        }
    }
}
class Node{
    int count=0;
    int key, value;
    Node next;
    Node upper;

    private Node(){}
    static Node root = new Node();
    public void pop(){
        if(next!=null){
            next.upper=null;
            root.next=root.next.next;
            root.next.upper=root;
            root.value--;
        }
    }
    public void put(Node n){
        n.upper=root;
        n.next=root.next;
        root.next=n;
        root.value++;
    }

    Node(int key, int value){
        this.key=key;
        this.value=value;
    }
    public int getValue(){
        count++;
        while(next != null && count >= next.count){
            if(upper != null){
                upper.next=next;
                next.upper=upper;
            }
            upper=next;
            next=next.next;
            upper.next=this;
        }
        return value;
    }

}
*/

public class LFUCache {
    Map<Integer, Node> map;
    int length;
    public LFUCache(int capacity) {
        length=capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node != null){
            node.count++;
            node.createTime=System.nanoTime();
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.size() == length){
            Node node = map.get(key);
            if(node != null){
                node.value=value;
                node.count++;
                node.createTime= System.nanoTime();
            }else {
                if(removeMin()){
                    putValue(key, value);
                }
            }
        }else if(map.size() < length){
            putValue(key, value);
        }
    }

    public boolean removeMin(){
        Node min=null;
        for (Node n : map.values()) {
            if(min != null){
                if(n.count < min.count){
                    min=n;
                }else if(n.count == min.count){
                    if(n.createTime < min.createTime){
                        min=n;
                    }
                }
            }else {
                min=n;
            }
        }
        if(min!=null){
            map.remove(min.key);
        }
        return min!=null;
    }

    private void putValue(int key, int value){
        Node node = map.get(key);
        if(node != null){
            node.value=value;
            node.count++;
            node.createTime=System.nanoTime();
        }else {
            node = new Node(key, value);
            map.put(key, node);
        }
    }
/*["LFUCache","put","put","get","get","put","get","get","get"]
[[2],]
* */
    public static void main(String[] args) {
        LFUCache c = new LFUCache(2);
        c.put(2,1);
        c.put(3,2);
        System.out.println(c.get(3));
        System.out.println(c.get(2));
        c.put(4,3);
        System.out.println(c.get(2));
        System.out.println(c.get(3));
        System.out.println(c.get(4));


//        String str = "[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]";
//        System.out.println(str.replace("[","{").replace("]", "}"));
//        int[][] nums={{2,1},{3,2},{3},{2},{4,3},{2},{3},{4}};
//        for (int[] num : nums) {
//            if(num.length == 2){
//                System.out.println("c.put("+num[0]+","+num[1]+");");
//            }else {
//                System.out.println("System.out.println(c.get("+num[0]+"));");
//            }
//        }
    }
}
class Node{
    int key;
    int value;
    int count=0;
    long createTime=System.nanoTime();
    Node(int key, int value){
        this.key=key;
        this.value=value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                ", count=" + count +
                ", createTime=" + createTime +
                '}';
    }
}