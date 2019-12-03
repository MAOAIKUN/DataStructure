package com.mak.sort;

import java.util.Arrays;

public class InsertSort {

    public void insertSort(int[] arr){

        for (int i = 1; i < arr.length ; i++) {
            int insertIndex = i-1;
            int insertValue = arr[i];
            while (insertIndex>=0 && insertValue<arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertValue;

        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,7,5,9,1,23,3};
        InsertSort is = new InsertSort();
        is.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
