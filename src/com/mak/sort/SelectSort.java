package com.mak.sort;

import java.util.Arrays;

public class SelectSort {

    public void selectSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }

            }
            arr[index] = arr[i];
            arr[i] = min;

        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,7,5,9,1};
        SelectSort ss = new SelectSort();
        ss.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
