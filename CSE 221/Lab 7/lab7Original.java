
import java.io.File;
import java.util.Arrays;
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
public class lab7Original {

    public static String city[];
    public static int v;
    public static int graph[][];
    public static int d[];
    public static int p[];
    public static boolean check[];

    public static void main(String[] args) throws Exception {

        File file = new File("C:\\Users\\Pollock\\Desktop\\lab 7 graph\\graph.txt");
        Scanner sc = new Scanner(file);
        String source[] = sc.nextLine().split(" ");

        String s = source[0];

        city = sc.nextLine().split(" ");
        v = city.length;
        graph = new int[v][v];
        p = new int[v];
        d = new int[v];
        check = new boolean[v];
        //System.out.println(Arrays.toString(city));

        while (sc.hasNext()) {

            String from = sc.next();
            int fromI = 0;
            for (int i = 0; i < city.length; i++) {
                if (from.equals(city[i])) {
                    fromI = i;
                }
            }

            String to = sc.next();
            int toI = 0;
            for (int i = 0; i < city.length; i++) {
                if (to.equals(city[i])) {
                    toI = i;
                }
            }

            graph[fromI][toI] = sc.nextInt();
        }
        /*for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println("");
        }*/

        dijstra(s);

    }

    public static void dijstra(String s) {

        for (int v = 0; v < graph.length; v++) {
            d[v] = Integer.MAX_VALUE;
            p[v] = -1;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < city.length; i++) {
            if (s.equals(city[i])) {
                start = i;
            }
        }

        for (int i = 0; i < city.length; i++) {
            if (city[city.length - 1].equals(city[i])) {
                end = i;
            }
        }

        d[start] = 0;

        for (int i = 0; i < graph.length; i++) {
            int u = findMin(d, check); //find Min for finding min Index
            check[u] = true;
            for (int v = 0; v < graph.length; v++) {
                if (!check[v] && graph[u][v] != 0 && d[v] > d[u] + graph[u][v]) {
                    d[v] = d[u] + graph[u][v];
                    p[v] = u;
                }
            }
        }

        //System.out.println(Arrays.toString(d));
        //System.out.println(start + " S ");
        //System.out.println(end + " E ");
        printPath(start, end);
    }

    public static int findMin(int[] d, boolean[] check) {
        int min = Integer.MAX_VALUE;//except 0th index all index value of d is Infinite
        int minIndex = -1;

        for (int i = 0; i < d.length; i++) {
            if (!check[i] && d[i] < min) {
                min = d[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void printPath(int start, int end) {
        int temp = end;
        String s = "";
        while (start != end) {
            s = s + " " + city[end];
            end = p[end];
        }
        //System.out.println(s+"00000");
        String[] print = s.split(" ");
        
        System.out.print(city[start]+" --> ");
        for (int i = print.length - 1; i > 1; i--) {
            System.out.print(print[i] + " --> ");
        }
        System.out.println(print[1]);
        System.out.println("Cost: "+ d[temp]);
    }
    
    

}
