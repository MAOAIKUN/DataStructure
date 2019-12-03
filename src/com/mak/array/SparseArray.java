package com.mak.array;

import java.sql.SQLOutput;
import java.util.Arrays;

public class SparseArray {

    public int[][] getSparseArray(int[][] arr){
        //行列值一共三列
        int count = 0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                if(arr[i][j]!=0)
                    count++;

            }

        }
        int[][] spareArray = new int[count+1][3];
        spareArray[0][0] = arr.length;
        spareArray[0][1] = arr[0].length;
        spareArray[0][2] = count;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length; j++) {
                if(arr[i][j] != 0){
                    spareArray[i+1][0] = i;
                    spareArray[i+1][1] = j;
                    spareArray[i+1][2] = arr[i][j];
                }

            }

        }

        return spareArray;

    }


    public int[][] previousArray(int[][] sparseArr){
        if (sparseArr[0].length !=3)
            throw new RuntimeException("not a spareArray");
        int[][] previousArr = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
                previousArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];


        }
        return previousArr;
    }

    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        arr[0][1] = 1;
        arr[1][0] = 2;

        for (int[] row: arr) {
                for (int i: row) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }

        SparseArray sparseArray = new SparseArray();
        int[][] sparseArr = sparseArray.getSparseArray(arr);
        for (int i = 0; i <sparseArr.length ; i++) {
            for (int j = 0; j <sparseArr[i].length ; j++) {
                System.out.print(sparseArr[i][j]+"\t");

            }
            System.out.println();

        }

        System.out.println();

        int[][] previousArr = sparseArray.previousArray(sparseArr);
        for (int i = 0; i < previousArr.length; i++) {
            for (int j = 0; j < previousArr[i].length; j++) {
                System.out.print(previousArr[i][j]+"\t");

            }
            System.out.println();

        }

    }
}
