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

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        int inputArray[] = {5, 15, 7, 108, 90, 207, 1, 184, 73, 84};
        int len = inputArray.length;
        
        mergeSort MS = new mergeSort();
        MS.sort(inputArray);
        QuickSort QS = new QuickSort();
        QS.QuickSortApply(inputArray, 0, len - 1);
        insertionSort is = new insertionSort();
        System.out.println("******* Insertion Sort Output *******");
        is.insertSort(inputArray);
        
        System.out.println("\n");

        System.out.println("******* Merge Sort Output *******");
        for (int i : inputArray) {
            System.out.print(i + " ");
        }
        
        System.out.println("\n");
        System.out.println("******* Quick Sort Output *******");
        for (int i : inputArray) {
            System.out.print(i + " ");
        }
        System.out.println("");

        
        

    }

}
