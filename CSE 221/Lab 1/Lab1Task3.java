/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Pollock
 */
public class Lab1Task3 {

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\Pollock\\Desktop\\test.txt");
        Scanner sc = new Scanner(file);
        int i = sc.nextInt();//take 6 as vertices
        int[][] matrixUndirected = new int[i][i];
        System.out.println("Undirected Graph Adjacency Matrix");
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            matrixUndirected[a][b] = 1;
            matrixUndirected[b][a] = 1;
        }
        /*  
         for (int j = 0; j < matrixUndirected.length; j++) {
         for (int k = 0; k < matrixUndirected.length; k++) {
         System.out.print(matrixUndirected[j][k]+" ");
         }
         System.out.println();
         }*/

        System.out.print(" ");
        for (int k = 0; k < matrixUndirected.length; k++) {
            System.out.print(" " + k + "");
        }
        System.out.println();
        for (int j = 0; j < matrixUndirected.length; j++) {
            System.out.print(j + " ");
            for (int k = 0; k < matrixUndirected.length; k++) {
                System.out.print(matrixUndirected[j][k] + " ");
            }
            System.out.println();

        }
    }
}
