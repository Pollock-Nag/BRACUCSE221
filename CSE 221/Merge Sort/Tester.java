/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Pollock
 */
public class Tester {
  
  int[] a;
  int[] tempMergeArray;
  int length;
  
  /**
   *
   * @param args
   */
 
    public static void main(String[] args) {
      int inputArray[] = {5, 15, 7, 108, 90, 207, 1, 184, 73, 84};
      mergeSort MS = new mergeSort();
      MS.sort(inputArray);
      
      for(int i: inputArray){
        System.out.print(i+" ");
      }
    }
    
  }
