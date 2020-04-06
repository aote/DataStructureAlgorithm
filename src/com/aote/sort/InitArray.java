package com.aote.sort;

import java.util.Arrays;

public class InitArray {

    /**
     *
     * @param length arr.length
     * @param basicValue 基数
     * @return
     */
    public static int[] initArr(int length,int basicValue){
        int[] arr = new int[length];
        for(int i=0;i<arr.length;i++){
            double d = basicValue*Math.random();
            arr[i] = (int)d;
        }
        // 打印排序前的数组
        System.out.println(Arrays.toString(arr));
        return arr;
    }

}
