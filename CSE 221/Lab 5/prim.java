
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pollock
 */
public class prim {

    static int n = 6;
    static int e = 36;
    static int adj[][] = new int[n][n];
    static int weight[] = new int[e];
    static int parent[] = new int[n];
    static int keyy[] = new int[n];
    // static int keyy[] = {115, 5, 12, 7, 3, 1};
    public static String[] cities = {"Dhaka", "Chittagong", "Barisal", "Sylhet", "Rajshahi", "Khulna"};

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\Pollock\\Desktop\\mst2.txt");
        // File file = new File("C:\\Users\\Pollock\\Desktop\\mst2.txt");
        Scanner sc = new Scanner(file);
        int temp1 = 0;
        int temp2 = 0;

        while (sc.hasNextInt()) {
            weight[temp1] = sc.nextInt();
            temp1++;
        }
        //  System.out.println(Arrays.toString(weight));

        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++) {
                adj[i][j] = weight[temp2];
                temp2++;
            }
        }

        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        //check_pq();
        primsMst(n, 0);
        // System.out.println(Arrays.toString(keyy));
    }
    static PriorityQueue<Key> pq = new PriorityQueue<>();

    /*  static class Key implements Comparable<Key> {

     int vertexIndex;
     int key;

     int u;
     int cost;
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
     }*/
    static class Key implements Comparable<Key> {

        int u, cost;

        Key() {
        }

        ;
        Key(int u, int cost) {
            u = this.u;
            cost = this.cost;
        }

        /* public boolean operator(Key a, Key b) {
         return a.cost > b.cost;
         }*/
        public int compareTo(Key k) {
            if (cost < k.cost) {
                return -1;
            } else if (cost > k.cost) {
                return 1;
            } else {
                return 0;
            }
        }

        /*private Key compareTo(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }*/

    }

    /* public static void check_pq() {

     for (int i = 0; i < keyy.length; i++) {
     pq.add(new Key(i, keyy[i]));
     }
     while (!pq.isEmpty()) {
     System.out.println(pq.remove().key + " , ");
     }

     }*/
    static int taken[] = new int[100];

    public static void primsMst(int n, int r) {// r == Source Node

        for (int i = 0; i < n; i++) {
            keyy[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            taken[i] = 0;
        }
        keyy[r] = 0;

        
        for(int i=0;i<adj.length;i++){
        
       
        pq.add(new Key(i,keyy[i]));
           // pq.add(new Key(r, 0).compareTo(k));
        }
        int ans = 0;

        while (!pq.isEmpty()) {
             Key x= new Key(r,0);
             x = pq.element();
            pq.remove();

            if (taken[x.u]!=0) {
                continue;
            }
            taken[x.u]=1;
            
            ans= ans+x.cost;

            for (int i = 0; i < adj.length; i++) {
                

                if (pq.contains(i) && adj[x.u][i] < keyy[i]) {

                    parent[i] = x.u;
                    keyy[i] = adj[x.cost][i];

                }
            }
        }
        int i = 0;

        for (int j = 1; j < n; j++) {
            System.out.println(cities[i] + " --> " + cities[j] + " {" + keyy[j] + "} ");
            i++;
        }
        System.out.println("New key\n");
        System.out.println(Arrays.toString(keyy));
        int sum = 0;

        for (int j = 0; j < keyy.length; j++) {
            sum = sum + keyy[j];
        }

        System.out.println("Minimum Cost = " + sum);
    }

}
