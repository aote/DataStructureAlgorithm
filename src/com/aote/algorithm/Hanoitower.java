package com.aote.algorithm;

/**
 * 使用分治算法解决汉诺塔问题
 */
public class Hanoitower {

    public static void main(String[] args) {
        hanoitowe(3,'A','B','C');
    }

    /**
     * 分治算法汉诺塔
     * @param num
     * @param a
     * @param b
     * @param c
     */
    public static void hanoitowe(int num,char a,char b,char c){
        if(num == 1){
            System.out.println("plate 1 从"+a+"->"+c);
        } else {
            /**
             * 如果我们有n>=2的情况，我们总是可以看做两个盘。
             * 最下面的一个盘和上面所有的盘
             * 1.先把最上面所有的盘a->b，移动过程中使用到c
             */
            hanoitowe(num-1,a,c,b);
            System.out.println("plate "+num+"从"+a+"->"+c);
            // 把b塔的所有盘移动到c，移动过程使用a塔
            hanoitowe(num-1,b,a,c);
        }
    }

}
