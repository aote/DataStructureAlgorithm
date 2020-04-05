package com.aote.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class Choose {

    public static void main(String[] args) {

        // 初始化数组
        int[] arr2 = InitArray.initArr(8,100);
        int[] arr = {18,12,7,15,6};
        chooseSort(arr);

    }
    // 选择排序思路：假设下标为0的为最小值，依次和后面的数比较，直到找到自己的位置
    public static void chooseSort(int[] arr){

        int minValue = arr[0];
        int minIndex = 0;

        for(int i=0;i<arr.length-1;i++) {
            minValue = arr[i];
            minIndex = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j] < minValue){
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = minValue;
        }


        System.out.println(Arrays.toString(arr));
    }


}

   /* int minValue = arr[0];
    int minIndex = 0;
        for(int i=0;i<arr.length-1;i++) {
        minValue = arr[i];
        minIndex = i;
        for (int j = i+1; j < arr.length; j++) {
        if (arr[j] < minValue) {
        minValue = arr[j];
        minIndex = j;
        }
        }
        arr[minIndex] = arr[i];
        arr[i] = minValue;
        }*/