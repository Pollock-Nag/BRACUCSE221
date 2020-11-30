/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pollock
 */
public class QuickSort {


    public int partition(int a[], int low, int high) {
        int pivot = a[low];
        while (low <= high) {
            while (a[low] < pivot) {
                low++;
            }
            while (a[high] > pivot) {
                high--;
            }
            if (low <= high) {
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;
                low++;
                high--;
            }
        }
        return low;
    }

    public void QuickSortApply(int a[], int low, int high) {
        int pi = partition(a, low, high);
        if (low < pi - 1) {
            QuickSortApply(a, low, pi - 1);
        }
        if (pi < high) {
            QuickSortApply(a, pi, high);
        }
    }
}
