
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class task1re {

    //define colors
    public static int WHITE = 1;
    public static int GRAY = 2;
    public static int BLACK = 3;

    //define resources
    public static int[] parent;
    public static int[] color;
    public static int[] d;
    public static int[] f;
    public static int numberOfVerteces;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\Pollock\\Desktop\\Lab4.txt");
        Scanner sc = new Scanner(file);

        //size
        numberOfVerteces = sc.nextInt() + 1;
        int[][] g = new int[numberOfVerteces][numberOfVerteces];

        while (sc.hasNextInt()) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            g[src][dest] = 1;
        }

        for (int i = 0; i < numberOfVerteces; i++) {
            for (int j = 0; j < numberOfVerteces; j++) {
                System.out.print(g[i][j] + " ");
            }
            System.out.println("");
        }
        color = new int[numberOfVerteces];
        d = new int[numberOfVerteces];
        f = new int[numberOfVerteces];
        parent = new int[numberOfVerteces];

            //write DFS code here
        //follow the pseudocode
        System.out.println("\nDiscovered Nodes:");
        DFS(g);
        /*while (!q1.isEmpty()) {
         System.out.print(q1.remove() + " ");
         }*/
        for (int i : q1) {
            System.out.print(i + " ");
        }

        System.out.println("");
        System.out.println("Visited Nodes:");
        for (int i : q2) {
            System.out.print(i + " ");
        }

        /*while (!q2.isEmpty()) {
         System.out.print(q2.remove() + " ");
         }*/
        System.out.println("");
        System.out.print(Arrays.toString(d) + " ");
        System.out.println("");
        System.out.print(Arrays.toString(f) + " ");

        System.out.println("");
        System.out.println("\nTopologicalSort:");
        topologicalSort();

        //DFS_visit(g,1);
            //output
        //print discovered nodes
        //print processed nodes
        //
        //print topologically sorted nodes (inverse order of processed nodes
        //end of code
    }
    public static int time;

    public static void DFS(int[][] graph) {
        // follow pseudocode

        for (int i = 0; i < numberOfVerteces; i++) {
            color[i] = WHITE;
            parent[i] = -1;
        }
        time = 0;
        for (int i = 1; i < numberOfVerteces; i++) {
            if (color[i] == WHITE) {
                DFS_visit(graph, i);
            }
        }

    }
    static LinkedList<Integer> q1 = new LinkedList<>();
    static LinkedList<Integer> q2 = new LinkedList<>();

    public static void DFS_visit(int[][] graph, int src) {
        //follow pseudocode
        q1.add(src);
        // System.out.print(src + " ");
        color[src] = GRAY;
        time = time + 1;
        d[src] = time;
        for (int i = 0; i < numberOfVerteces; i++) {
            if (graph[src][i] == 1) {
                if (color[i] == WHITE) {
                    parent[i] = src;
                    DFS_visit(graph, i);
                }
            }
        }
        q2.add(src);
        color[src] = BLACK;
        time = time + 1;
        f[src] = time;
    }

    static Stack<Integer> st = new Stack<>();

    public static void topologicalSort() {
        for (int i : q2) {
            st.push(i);
            // System.out.print(i+" ");
        }

        int a[] = new int[f.length];
        int k = 0;

        //System.out.println("\nNodes:1 ");
        while (!st.isEmpty()) {
            a[k] = st.pop();
            // System.out.print(st.pop()+"-->");
            k++;
        }

        /*    while (!st.isEmpty()) {
         a[k] = st.pop();
         k++;
         }*/
        System.out.println("Nodes: ");
        for (int i = 0; i < a.length - 2; i++) {
            System.out.print(a[i] + "-->");
        }
        System.out.print(a[a.length - 2]);

        System.out.println("\nFinish time: ");
        {
            Arrays.sort(f);
            for (int i = f.length - 1; i >= 2; i--) {
                System.out.print(f[i] + "-->");

            }
            System.out.println(f[1] + "");
        }

    }

}
