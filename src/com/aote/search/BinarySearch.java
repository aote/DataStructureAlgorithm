package com.aote.search;

/**
 * 二分法查找
 * 要求数据必须是有序的
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,6,9,16,18,22,36,78,99};
        int index = search(arr,10,0,arr.length-1);
        System.out.println(index);

    }

    public static int search(int[] arr,int value,int left,int right){
        // 当left大于right结束递归
        if(left > right){
            return -1;
        }
        // 取中间值
        int mid = (left+right)/2;
        int midValue = arr[mid];

        if (value > midValue){
            return search(arr , value, mid+1, right); // 向右递归
        } else if (value < midValue){
            return search(arr , value, left, mid-1); // 向左递归
        } else {
            return mid;

            // 与结果相等的值也查找出来，两个while循环，分别往两边查找
        }
    }

}
