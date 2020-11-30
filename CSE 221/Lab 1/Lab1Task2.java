/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Pollock
 */
public class Lab1Task2 {

    public static void main(String[] args) throws Exception {
        {
            File file = new File("C:\\Users\\Pollock\\Desktop\\test.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNextInt()== true){
                System.out.println(sc.nextInt());
            }
        }
    }

}
