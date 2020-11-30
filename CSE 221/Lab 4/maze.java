/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Pollock
 */
public class maze {

    static final int BLACK = -1;
    static final int WHITE = 0;
    static final int GRAY = 1;
    static int time;
    static int adj[][];
    static int colour[];
    static int parent[];
    static int[] d;
    static int[] f;
    static int n = 0;
    static int a1[];
    static int a2[];
    static int i = 0;
    static int j = 0;

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\Pollock\\Desktop\\maze.txt");
        Scanner sc = new Scanner(file);

        n = sc.nextInt() + 1;

        adj = new int[n][n];
        colour = new int[n];
        parent = new int[n];
        d = new int[n];
        f = new int[n];
        a1 = new int[n];
        a2 = new int[n];
        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x][y] = 1;
        }
        /*System.out.println("ADJ MATRIX");
         for (int i = 1; i < adj.length; i++) {
         for (int j = 1; j < adj.length; j++) {
         System.out.print(adj[i][j] + " ");
         }
         System.out.println("");
         }*/

        /*System.out.println("\nDiscovered");
         dfs(adj, 1);
         System.out.println(Arrays.toString(a1));
         System.out.println("Processed");
         System.out.println(Arrays.toString(a2));*/
        System.out.println("\t     PATH:");
        dfs(adj, 1);
        path(parent, 9);

        //topologicalSort();
        //System.out.println(Arrays.toString(f));
    }

    public static void dfs(int[][] g, int k) {
        for (int i = 0; i < n; i++) {
            colour[i] = WHITE;
            parent[i] = -1;

        }
        time = 0;
        for (int i = 1; i < n; i++) {
            if (colour[i] == WHITE) {
                dfsVisit(g, i);
            }
        }
    }

    public static void dfsVisit(int[][] g, int x) {

        a1[i] = x;
        i++;

        colour[x] = GRAY;
        time = time + 1;

        d[x] = time;

        for (int i = 1; i < n; i++) {
            if (adj[x][i] == 1) {
                if (colour[i] == WHITE) {
                    colour[i] = GRAY;
                    parent[i] = x;
                    dfsVisit(g, i);
                }
            }
        }

        a2[j] = x;
        j++;
        colour[x] = BLACK;

        time = time + 1;
        f[x] = time;
    }

    /*public static void topologicalSort() {
     System.out.println("\nAfter Topological Sort: Nodes: ");
     for (int i = a2.length - 2; i >= 1; i--) {
     System.out.print(a2[i] + "-->");
     }
     System.out.println(a2[0]);

     Arrays.sort(f);
     for (int i = f.length - 1; i >= 2; i--) {
     System.out.print(f[i] + "-->");
     }
     System.out.println(f[1]);

     }*/
    public static void path(int[] parent, int endingNode) {
     String s = "";
     int temp = endingNode;
     while (parent[endingNode] != -1) {
     String q = " " + parent[endingNode];
     s = q + "-->" + s;
     endingNode = parent[endingNode];
     }
     s = s + temp;
     System.out.println(s);
     }

}

