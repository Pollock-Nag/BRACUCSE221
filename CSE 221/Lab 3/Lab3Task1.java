
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 18101114
 */
public class Lab3Task1 {

    static final int WHITE = -1;
    static final int GRAY = 0;
    static final int BLACK = 1;

    static int adj[][];
    static int[] colour;
    static int[] parent;
    static int[] d; //d== Distance

    public static void main(String[] args) throws Exception {

        /*  final int WHITE = -1;
        final int GRAY = 0;
        final int BLACK = 1;*/
        File file = new File("C:\\Users\\Pollock\\Desktop\\opo.txt");
        Scanner sc = new Scanner(file);

        int n = sc.nextInt();
        adj = new int[n + 1][n + 1];

        colour = new int[n + 1];
        parent = new int[n + 1];
        d = new int[n + 1]; //d== Distance

        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            adj[a][b] = 1;
            adj[b][a] = 1;
        }

        /*for (int i = 1; i < adj.length; i++) {
            for (int j = 1; j < adj.length; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println("");
        }*/
        //Lab3Task1 bfs = new Lab3Task1();
        BFS(1);
        printPath(adj,1,3 );

        /*for (int i = 1; i < d.length; i++) {

            System.out.print(d[i] + " ");
        }*/

    }

    public static void BFS(int startingNode) {
        for (int i = 1; i < colour.length; i++) {
            colour[i] = WHITE;
            d[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        colour[startingNode] = GRAY;
        d[startingNode] = 0;
        parent[startingNode] = -1;

        Queue<Integer> q = new LinkedList<>();
        q.clear();
        q.add(startingNode);

        while (!q.isEmpty()) {
            int x;
            x = q.element();
            q.remove();

            for (int i = 1; i < colour.length; i++) {
                if (adj[x][i] == 1) {
                    if (colour[i] == WHITE) {
                        // x node ta i node er parent
                        colour[i] = GRAY;
                        d[i] = d[x] + 1;
                        parent[i] = x;
                        q.add(i);

                    }

                }
            }
            colour[x] = BLACK;
        }
    }

    public static void printPath(int adj[][],int s, int v) {
        if (v == s) {
            System.out.println(s);
        } 
        
        else if (parent[v] == -1) {
            System.out.println("No path from " + s + " to " + v + " exists");
        }
        
        else {
            printPath(adj,s, parent[v]);
        }
        System.out.println(v);
    }
}
