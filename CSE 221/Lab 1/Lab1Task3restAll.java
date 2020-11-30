/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Pollock
 */
public class Lab1Task3restAll {
      public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\Pollock\\Desktop\\test.txt");
        Scanner sc = new Scanner(file);
        int i = sc.nextInt();//take 6 as vertices
        LinkedList list[] = new LinkedList[i];
        int check[] = new int[list.length];
        int out[] = new int[list.length];
        int in[] = new int[list.length];
        
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
        
            int b = sc.nextInt();
           
            if (check[a] == 0) {
                list[a] = new LinkedList();
                list[a].add(b);
                check[a]++;
                out[a]++;
                in[b]++;
                
                }
             else {
                list[a].add(b);
                check[a]++;
                out[a]++;
                in[b]++;

                
                }

            }
        
        System.out.println("\n" + "Adjacency List");
        for (int p = 0; p < list.length; p++) {
            System.out.println(p + "--->" + list[p]);
        }
        System.out.println("\n"+"Out / In degree:");
        for (int k = 0; k < list.length; k++) {
            System.out.println(k + "--->" + check[k]);
        }

    }
}
