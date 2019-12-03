package com.mak.sort;

import java.util.Arrays;

public class ShellSort {

    public void shellSort(int[] arr){

        for (int gap = arr.length/2; gap >0 ; gap/=2) {
            for (int i = gap; i <arr.length ; i++) {
                for (int j = i-gap; j >= 0 ; j-=gap) {
                    if(arr[j]>arr[j+gap]){
                        int temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }


                }

            }

        }

    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] arr = new int[]{8,1,9,7,2,3};
        shellSort.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
