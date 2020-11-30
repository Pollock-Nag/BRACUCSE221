/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Pollock
 */
public class Lab1Task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();
        
        s.push(sc.nextInt());
        System.out.println("Pushing " + s.peek() + "...." + "\nPrinting top:\n" + s.peek());

        s.push(sc.nextInt());
        System.out.println("Pushing " + s.peek() + "...." + "\nPrinting top:\n" + s.peek());

        s.push(sc.nextInt());
        System.out.println("Pushing " + s.peek() + "...." + "\nPrinting top:\n" + s.peek());

        s.pop();
        System.out.println("Popping...." + "\nPrinting top:\n" + s.peek());
       
        s.push(sc.nextInt());
        System.out.println("Pushing " + s.peek() + "...." + "\nPrinting top:\n" + s.peek());

        s.push(sc.nextInt());
        System.out.println("Pushing " + s.peek() + "...." + "\nPrinting top:\n" + s.peek());
        
        s.push(sc.nextInt());
        System.out.println("Pushing " + s.peek() + "...." + "\nPrinting top:\n" + s.peek());

        s.pop();
        System.out.println("Popping...." + "\nPrinting top:\n" + s.peek());
       
        s.pop();
        System.out.println("Popping...." + "\nPrinting top:\n" + s.peek());
       
    }
}
