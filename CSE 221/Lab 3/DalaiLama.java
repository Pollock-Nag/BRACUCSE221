/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dalailama;

import java.util.*;

/**
 *
 * @author Pollock
 */
public class DalaiLama {

    /**
     * @param args the command line arguments
     */
    static int adj[][];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int counterOft = 0;
        for (int p = 0; p < test; counterOft = ++p) {
            int n = sc.nextInt();
            adj = new int[n + 1][n + 1];
            colour = new int[n + 1];
            parent = new int[n + 1];
            d = new int[n + 1];
            int m = sc.nextInt();

            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                adj[x][y] = 1;
                adj[y][x] = 1;
            }
        }
        /*for (int i = 1; i < adj.length; i++) {
            for (int j = 1; j < adj.length; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println(" ");
        }*/
        bfs(1, test, 3, 4);
        //  printPath(adj, 1, 3);
        System.out.println(path(parent, 3));
        //System.out.println("test case : " + counterOft);
    }

    static int colour[];
    static int parent[];
    static int d[];

    static final int WHITE = 0;
    static final int GRAY = -1;
    static final int BLACK = 1;

    public static void bfs(int s, int test, int a1, int a2) {
        for (int i = 0; i < adj.length; i++) {
            colour[i] = WHITE;
            parent[i] = -1;
            d[i] = Integer.MAX_VALUE;
        }
        colour[s] = GRAY;
        parent[s] = -1;
        d[s] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while (!q.isEmpty()) {
            int x = q.element();
            q.remove();

            for (int i = 0; i < colour.length; i++) {
                if (adj[x][i] == 1) {
                    if (colour[i] == WHITE) {
                        colour[i] = GRAY;
                        parent[i] = x;
                        d[i] = d[x] + 1;
                        q.add(i);
                    }
                }
            }
            colour[x] = BLACK;
        }
        print(parent,d,test,a1,a2);
    }

    
    public static String path(int parent[], int v) {
        String s = "";
        int temp = v;
        while (parent[v] != -1) {
            String q = "" + parent[v];
            s = q + " --> " + s;
            v = parent[v];
        }
        s = s + temp;
        return s;
    }

    public static void print(int[] p, int[] d, int test, int a1, int a2) {
        for (int i = 0; i < test; i++) {
            System.out.println("Test Case " + (i + 1) + "\nTotal Bridges: " + d[a1] + "\nPath: " + path(p, a1));
            a1 = a2;
        }
    }
}
