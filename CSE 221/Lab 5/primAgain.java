
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
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
public class primAgain {

    public static int[][] graph;
    public static int[] weight;
    public static int[] parent;
    public static int[] key;
       static String cities[] = {"Dhaka", "Chittagong", "Barisal", "Sylhet", "Rajshahi", "Khulna"};

    public static void main(String[] args) throws Exception {

        int numberOfVerteces = 6;
        int numberOfEdges = 36;
        graph = new int[numberOfVerteces][numberOfVerteces];
        parent = new int[numberOfVerteces];
        weight = new int[numberOfEdges];
        //cities = new String[numberOfVerteces];
        key = new int[numberOfVerteces];

        File file = new File("C:\\Users\\Pollock\\Desktop\\mst2.txt");
        Scanner sc = new Scanner(file);

        int temp = 0;
        int tempString = 0;
        int temp1 = 0;

        
        while (sc.hasNextInt()) {

            weight[temp] = sc.nextInt();
            temp++;

        }

        for (int i = 0; i < numberOfVerteces; i++) {
            for (int j = 0; j < numberOfVerteces; j++) {
                graph[i][j] = weight[temp1];
                temp1++;
            }
        }

        System.out.println("Weight Array");
        System.out.println(Arrays.toString(weight));
        System.out.println("");
        //System.out.println("Distance Matrix");
        System.out.println("");
        System.out.println("Cities");
        System.out.println(Arrays.toString(cities));
        System.out.println("");
        for (int i = 0; i < numberOfVerteces; i++) {
            for (int j = 0; j < numberOfVerteces; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        primsMst(numberOfVerteces, 0);
        //queueExercise();
    }

    static PriorityQueue<Integer> pq = new PriorityQueue<>();
//    static PriorityQueue<Integer> pqMaxFirst = new PriorityQueue<Integer>((Collection<? extends Integer>) Collections.reverseOrder());

    /* public static void queueExercise() {

        for (int i : weight) {
            pq.add(i);
        }

        //PRIORITY QUEUE ADD TEST
         pq.add(10);
         pq.add(15);
         pq.add(9);
         pq.add(1017);
         pq.add(117);
        pqMaxFirst.add(1202);
        pqMaxFirst.add(2020);
        pqMaxFirst.add(102);
        pqMaxFirst.add(0);

        //USING ITERATOR FOR PRINTING MAX FIRST PQ
        System.out.println("\nMax First Priority Queue Output");
        Iterator<Integer> it = pqMaxFirst.iterator();

        while (it.hasNext()) {
            System.out.print(it.next() + " , ");
        }

        //Contains Checker
        System.out.println("\n");
        System.out.println(pq.contains(1017));

        //SIMPLEY PRINT SIMPLE PQ
        System.out.println("\n\nSimple Priority Queue Output");
        while (!pq.isEmpty()) {
            System.out.print(pq.remove() + " , ");
        }

    }*/

    public static void primsMst(int n, int r) {// r == Source Node

        for (int i = 0; i < n; i++) {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        key[r] = 0;
        for (int i = 0; i < graph.length; i++) {
            pq.add(i);
        }
        while (!pq.isEmpty()) {
            int x;
            x = pq.element();
            pq.remove();

            for (int i = 0; i < graph.length; i++) {

                if (pq.contains(i) && graph[x][i] < key[i]) {

                    parent[i] = x;
                    key[i] = graph[x][i];

                }
            }
        }
        int i = 0;

        for (int j = 1; j < n; j++) {
            System.out.println(cities[i] + " --> " + cities[j] + " {" + key[j] + "} ");
            i++;
        }
        System.out.println("New key");
        System.out.println(Arrays.toString(key));
        int sum = 0;

        for (int j = 0; j < key.length; j++) {
            sum = sum + key[j];
        }

        System.out.println("Minimum Cost = " + sum);
    }

}
