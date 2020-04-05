package com.aote.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 假定第一个数是有序合集，后面都是无序合集，第一个数和后面每一位比较，并找到自己的位置
 */
public class Insert {

    public static void main(String[] args) {
        int[] arr = {18,12,7,15,6};
        insertSort(arr);
    }

    public static void insertSort(int[] arr){

        for(int i=1;i<arr.length;i++){

            int insertValue = arr[i];
            int insertIndex = i-1;
            while (insertIndex>=0 && arr[insertIndex]>insertValue){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertValue;

        }

        System.out.println(Arrays.toString(arr));

    }

}
