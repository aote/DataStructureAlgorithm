package com.aote.sort;

/**
 * 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {

    }

    public static void radixSort(int[] arr){
        // 第一轮，针对每个元素的个位进行排序处理

        /**
         * 定义一个二维数组，表示10个桶，每个桶就是一个一维数组
         * 说明
         * 1.二维数组包含10个一维数组
         * 2.为了防止放入数的时候数据溢出，每个一维数组(桶)大小定位arr.length
         * 3.基数排序是用空间换时间的经典算法
         */
        int[][] bucket = new int[10][arr.length];

        // 定义一个数组，记录每个桶存放了多少数据
        int[] bucketElementCounts = new int[10];

        for(int i=0;i<arr.length;i++){
            // 取出每个原数的位数的值
            int digit = arr[i] % 10;
            // 放入到对应的桶中
            bucket[digit][bucketElementCounts[digit]] = arr[i];
            // 放到下一位
            bucketElementCounts[digit]++;
        }

    }

}
