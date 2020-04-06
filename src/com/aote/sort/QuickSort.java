package com.aote.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = InitArray.initArr(1000000,100000);
        long start = System.currentTimeMillis();
        quickSort(arr,0,arr.length-1);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    /**
     * left不能大于right
     * @param arr
     * @param left 左边索引位置
     * @param right 右边索引位置
     */
    public static void quickSort(int[] arr,int left,int right){
        // 如果left大于right，是不合法的，直接return
        if(left > right){
            return;
        }

        // 定义变量保存基准数 最左边的数作为基准数
        int base = arr[left];
        // 定义变量i，指向最左边
        int i = left;
        // 定义变量j，指向最右边
        int j = right;
        //当i和j不相遇的时候，循环检索
        while(i != j){
            // 由j从右往左检索比基准数小的数，如果检索到比基准数小的就停下。
            // 如果检索到比基准数大的或相等的继续检索。
            while(arr[j] >= base && i<j) {
                j--; // j从右往左移动
            }
            // i从左往右检索
            while (arr[i] < base && i<j){
                i++; //i从左往右移动
            }

            // 代码到这，说明i停下，j也停下了，然后交换i和j位置的元素
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // 如果上面的while循环条件不成立，会跳出循环，往下执行。
        // 如果条件不成立，说明i和j相遇了
        // 如果i和j相遇了，就交换基准数这个元素和相遇位置的元素
        // 把相遇位置的元素赋值给基准数这个位置的元素
        arr[left] = arr[i];
        // 把基准数赋值给相遇位置的元素
        arr[i] = base;

        // 基准数在这里归为，左边的比他小，右边的都比他大
        // 排基准数的左边
        quickSort(arr,left,i-1);
        // 排基准数右边
        quickSort(arr,i+1,right);
    }

}
