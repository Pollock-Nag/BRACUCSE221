/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Pollock
 */
public class Lab1Task3b {

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\Pollock\\Desktop\\test.txt");
        Scanner sc = new Scanner(file);
        int i = sc.nextInt();//take 6 as vertices
        int[][] matrixDirected = new int[i][i];
        System.out.println("Directed Graph Adjacency Matrix");
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            matrixDirected[a][b] = 1;

        }
      
        System.out.print(" ");
        for (int k = 0; k < matrixDirected.length; k++) {
            System.out.print(" " + k + "");
        }
        System.out.println();
        for (int j = 0; j < matrixDirected.length; j++) {
            System.out.print(j + " ");
            for (int k = 0; k < matrixDirected.length; k++) {
                System.out.print(matrixDirected[j][k] + " ");
            }
            System.out.println();

        }
    }

}
