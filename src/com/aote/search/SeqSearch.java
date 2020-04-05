package com.aote.search;

/**
 * 线性查找
 */
public class SeqSearch {

    public static void main(String[] args) {
        int[] arr = {18,12,7,15,6};
        int index = search(arr,12);
        System.out.println(index);
    }

    /**
     * 线性查找就是找到满足条件就返回
     * @param arr
     * @param value
     * @return
     */
    public static int search(int[] arr,int value){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }

}
