/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pollock
 */
import java.util.*;

class Key implements Comparable<Key> {

    int vertexIndex;
    int key;

    public Key(int index, int key) {
        vertexIndex = index;
        this.key = key;
    }

    public int compareTo(Key k) {
        if (key < k.key) {
            return -1;
        } else if (key > k.key) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class PriorityQueueExample {

    public static void main(String[] args) {
        PriorityQueue<Key> queue = new PriorityQueue<>();
        //Creating Key array 
        for (int i = 0; i < 5; i++) {
            Key k = new Key(i, 50 * (i + 175) % 500);
            queue.add(k);
        }

        System.out.println("Traversing the queue elements:");
        //Traversing queue elements  
        for (Key k : queue) {
            System.out.println("vertexId: " + k.vertexIndex + " key: " + k.key + " ");
        }
        System.out.println();

        System.out.println("peek: " + queue.peek().key + " vertexId: " + queue.peek().vertexIndex);
        queue.remove();
        System.out.println();
        System.out.println("After removing one record:");
        for (Key k : queue) {
            System.out.println(k.key + " ");
        }

        System.out.println("peek: " + queue.peek().key + " vertexId: " + queue.peek().vertexIndex);
        queue.remove();
        System.out.println();
        System.out.println("After removing one record:");
        for (Key k : queue) {
            System.out.println(k.key + " ");
        }

        System.out.println();
        System.out.println("peek: " + queue.peek().key + " vertexId: " + queue.peek().vertexIndex);
        queue.remove();
        System.out.println();
        System.out.println("After removing one record:");
        for (Key k : queue) {
            System.out.println(k.key + " ");
        }

        System.out.println();
        System.out.println("peek: " + queue.peek().key + " vertexId: " + queue.peek().vertexIndex);
        queue.remove();
        System.out.println();
        System.out.println("After removing one record:");
        for (Key k : queue) {
            System.out.println(k.key + " ");
        }

        System.out.println();
        System.out.println("peek: " + queue.peek().key + " vertexId: " + queue.peek().vertexIndex);
        queue.remove();
        System.out.println();
        System.out.println("After removing one record:");
        for (Key k : queue) {
            System.out.println(k.key + " ");
        }

    }

    boolean contains(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int element() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void add(int i) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
