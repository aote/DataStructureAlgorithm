package com.aote.sort;

import sun.font.TrueTypeFont;

import java.util.Arrays;

/**
 * 冒泡排序（Bubble Sorting）的基本思想是：通过对待
 * 排序序列从前向后（从下标较小的元素开始）,依次比较
 * 相邻元素的值，若发现逆序则交换，使值较大
 * 的元素逐渐从前移向后部，就象水底下的气泡一样逐渐
 * 向上冒。
 */
public class BubbleSort {

    public static void main(String[] args) {

        // 初始化数组
        int[] arr = InitArray.initArr(5,100);
        bubbleSort(arr);

    }

    public static void bubbleSort(int[] arr){
        // 排序逻辑
        for(int i=0;i<arr.length;i++){
            boolean flag = true;
            for(int j=i+1;j<arr.length;j++){
                int t;
                if(arr[i]>arr[j]){
                    flag = false;
                    t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
            }
            if (flag)
                break;
        }
        // 打印排序后的数组
        System.out.println(Arrays.toString(arr));
    }

}
