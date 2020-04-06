package com.aote.sort;


import java.util.Arrays;

/**
 * 归并排序
 */
public class MargeSort {

    public static void main(String[] args) {

        int[] arr = {8,4,5,7,1,3,6,2};
        // 归并排序需要一个额外的空间
        int[] temp = new int[arr.length];
        margeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 分+合的方法
     * @param arr
     */
    public static void margeSort(int[] arr,int left,int right,int[] temp){
        if(left < right) {
            // 中间索引
            int mid = (left + right) / 2;
            // 向左递归进行分解
            margeSort(arr,left,mid,temp);
            // 向右递归进行分解
            margeSort(arr,mid+1,right,temp);
            // 合并
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     * 合并方法
     * @param arr 原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 做中转的索引
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        // 初始化i，左边有序序列的初始索引
        int i = left;
        //初始化j，右边有序序列的初始索引
        int j = mid + 1;
        // 指向temp数组的当前索引
        int t = 0;

        /**
         * (1)先把左右两边(有序)的数据按照规则填充到temp数组
         * 直到左右两边的有序序列又一边处理完为止
         */
        while(i<=mid && j<=right) { // 满足条件继续
            // 如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            // 将左边元素的当前元素拷贝到temp数据，然后t后移，i后移
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else { // 反之，右边元素小于左边
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        /**
         * (2)把有剩余数据的数据一次全部填充到temp
         */
        // 左边有序序列还剩余元素，全部填充到temp
        while(i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        // 如果右边有序数列剩余
        while(j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }


        /**
         * (3)将temp数组拷贝到arr数组
         * 这里并不是一次拷贝所有
         */
        t = 0;
        int tempLeft = left;
        while(tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }


    }

}
