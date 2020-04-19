package com.aote.algorithm;

/**
 * @author: Weicf
 * @date: 2020-04-14 23:42
 * @description: 非递归二分法查找
 */
public class BinarySearchNoRecur {

    public static void main(String[] args) {
        int[] arr = {1,6,9,16,18,22,36,78,99};
        int index = binarySearch(arr,2);
        System.out.println(index);
    }

    /**
     *
     * @param arr 待查找的数据,arr是升序排列
     * @param target 需要找到的数
     * @return 返回对应的下标，-1标识没有找到
     */
    public static int binarySearch(int[] arr,int target){

        int left = 0;
        int right = arr.length - 1;
        // left 小于等于right就继续查找
        while (left<=right) {
            int mid = (left+right) / 2;
            if(arr[mid]==target){
                return mid;
            } else if(arr[mid] > target){
                // 向左边查找
                right = mid - 1;
            } else {
                // 向右边查找
                left = mid+1;
            }
        }
        return -1;
    }

}
