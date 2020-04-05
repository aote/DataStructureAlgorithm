package com.aote.tree.heapSort;

import sun.security.util.Length;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 编写一个堆排序的方法
    public static void heapSort(int[] arr){
        int temp = 0;
        /**
         * 将一个无序的数组构建成一个大顶堆
         * 可以根据需求选择大顶堆或小顶堆
         */
        for(int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        System.out.println("大顶堆="+Arrays.toString(arr));
        /**
         * 将堆顶元素与末尾元素交换，最大元素沉到数组末端
         * 重新调整结构，使其满足堆定义，然后继续交换堆顶与末尾元素
         * 反复执行调整+交换步骤，知道整个序列有序
         */
        for(int i=arr.length-1;i>0;i--){
            // 交换
            temp = arr[i];
            // arr[0]是最大值，与i交换
            arr[i] = arr[0];
            arr[0] = temp;
            // 这里需要进行反复的调整
            adjustHeap(arr,0,i);
        }
    }

    /**
     * 将一个数组(二叉树)调整成一个打顶堆
     * 功能：完成以i为根节点的树调整成打顶堆
     * 举例：{4,6,8,5,9}-> i=1 ->{4,9,8,5,6}
     * 如果再次调用adjustHeap，传入的就是i=0，{4,9,8,5,6}->{9,6,8,5,4}
     * @param arr 待调整的数组
     * @param i 表示飞叶子节点在数组中的索引
     * @param Length 表示对多少个元素进行调整，length是在逐渐减少
     */
    public static void  adjustHeap(int[] arr,int i,int Length){
        // 先取出当前元素的值，保存在临时变量中
        int temp = arr[i];
        /**
         * 开始调整
         * 说明：1.k = i*2+1
         *      2.k是i节点的左子节点
         */
        for(int k=i*2+1;k<Length;k=k*2+1){
            // arr[k] < arr[k]+1 说明左子节点小于右子节点的值
            if(k+1 < Length && arr[k] < arr[k+1]){
                // k指向右子节点
                k++;
            }
            // 如果子节点大于父节点
            if(arr[k] > temp) {
                // 把较大的值付给当前节点
                arr[i] = arr[k];
                // i指向k，继续循环比较!!!
                i = k;
            } else {
                break;
            }
        }
        // 当for循环结束后，已经将以i为父节点的树的最大值放在最顶上
        arr[i] = temp;

    }


}
