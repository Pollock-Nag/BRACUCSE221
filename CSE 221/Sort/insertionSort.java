/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pollock
 */
public class insertionSort {

   public static void main(String[] args) {
        
        int a[] = {15, 5, 7, 108, 90, 207, 1, 184, 73, 84};
        insertionSort is = new insertionSort();
        is.insertSort(a);
    }    

    public void insertSort(int a[]) {
        for (int j = 1; j < a.length; j++) {
            int key = a[j];
            int i = j - 1;
            while (i >= 0 && a[i] > key) {
                a[i + 1] = a[i];
                i = i - 1;
            }
            a[i + 1] = key;
        }
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
