package com.mak.sort;

import java.util.Arrays;

public class BubbleSort {

    public void bubbleSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            boolean flag = false;
            for (int j = arr.length - 1; j >= i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag)
                break;
            ;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,8,7,6,5,4};
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }


}
