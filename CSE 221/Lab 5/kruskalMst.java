
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pollock
 */
public class kruskalMst {

    static int n = 6;
    static int e = 36;
    static int adj[][] = new int[n][n];
    static int weight[] = new int[e];
    static int parent[] = new int[n];
    static int key[] = new int[n];
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    //static  String city[]= {"NY","WDC","Califo"};
    static String city[] = {"Dhaka", "Chittagong", "Barisal", "Sylhet", "Rajshahi", "Khulna"};

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
        mst_kruskal();
    }

    static class Edge {

        // therse an edge between u and v of weight w
        int u, v, w;
    }

    boolean operator(Edge A, Edge B) {
        // sort edges accoeding to edges
        return A.w < B.w;
    }

    static Vector<Edge> E;
    
    
    //Array to keep track of parent fr union find;
    static int p[] = new int[100];

    static int find(int x) {
        if (p[x] == x) {
            return x;
        }
        return p[x] = find(p[x]);
    }

    static void mst_kruskal() {
       //   Collections.sort(E.firstElement(),E.lastElement());
       //  Collections.sort(E);
        //Collections.sort(E.firstElement(), E.lastElement());
        //Arrays.sort(E.firstElement(), E.lastElement());
         Arrays.sort(adj);
         // Arrays.sort(E.firstElement(),E.lastElement());
       // int sz = E.size();
        
         int sz = adj.length;
         int ans = 0;
        for (int i = 0; i < sz; i++) {
            if (find(adj[i].u) == find(adj[i].v)) {
            } else {
                //Union
                p[adj[i].u]] = p[adj[i].v];
                ans = ans + adj[i].w;
            }
        }
        System.out.println(ans + "ans");
    }
}

