
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
public class mst {

    /**
     *
     * @param args
     */
    static int n = 6;
    static int e = 36;
    static int adj[][] = new int[n][n];
    static int weight[] = new int[e];
    static int parent[] = new int[n];
    static int key[] = new int[n];

    public static void main(String[] args) throws FileNotFoundException {
        //  File file = new File("C:\\Users\\Pollock\\Desktop\\MST.txt");
        File file = new File("C:\\Users\\Pollock\\Desktop\\mst2.txt");
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
        mst_prim(0);
    }
    static PriorityQueue<Key> pq = new PriorityQueue<>();
    //static  String city[]= {"NY","WDC","Califo"};
    static String city[] = {"Dhaka", "Chittagong", "Barisal", "Sylhet", "Rajshahi", "Khulna"};

    static void mst_prim(int r) { // r == Source Node
        for (int i = 0; i < n; i++) {
            //key[i] = i+2;
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        key[r] = 0;
        //Key k ;
        for (int i = 0; i < key.length; i++) {
            // k = new Key(i,key[i]);
            pq.add(new Key(i, key[i]));
        }

        /*while (!pq.isEmpty()) {
         // int x;
         // x = pq.peek().key;
         int x= pq.remove().key;

         for (int i = 0; i < adj.length; i++) {

         if (pq.contains(key[i])&& adj[x][i]!=0 && adj[x][i] < key[i]) {

         parent[i] = x;
         key[i] = adj[x][i];

         }
         }
         }*/
        int i = 0;

        for (int j = 1; j < n; j++) {
            System.out.println(city[i] + " --> " + city[j] + " {" + key[j] + "} ");
            i++;
        }

        System.out.println(Arrays.toString(key));
        int sum = 0;

        for (int j = 0; j < key.length; j++) {
            sum = sum + key[j];
        }
        System.out.println("Minimum Cost = " + sum);

        System.err.println(Arrays.toString(key));
        System.err.println(Arrays.toString(parent));
    }

    static class Key implements Comparable<Key> {

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
}
