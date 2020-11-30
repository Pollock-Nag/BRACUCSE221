/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pollock
 */
public class mergeSort {

    int[] a;
    int[] tempMergeArray;
    int length;

 
    

    public void sort(int inputArray[]) {
        this.a = inputArray;
        this.length = inputArray.length;
        this.tempMergeArray = new int[length];
        divideArray(0, length - 1);
    }

    public void divideArray(int low, int high) {
        if (low < high) {
            int mid = (low +high ) / 2;
            divideArray(low, mid);
            divideArray(mid + 1, high);
            mergeArray(low, mid, high);
        }
    }

    public void mergeArray(int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            tempMergeArray[i] = a[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (tempMergeArray[i] <= tempMergeArray[j]) {
                a[k] = tempMergeArray[i];
                i++;
            } else {
                a[k] = tempMergeArray[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            a[k] = tempMergeArray[i];
            k++;
            i++;
        }
    }
}
