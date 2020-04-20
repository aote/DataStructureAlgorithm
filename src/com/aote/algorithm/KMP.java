package com.aote.algorithm;

import javax.print.attribute.standard.Destination;
import java.util.Arrays;

/**
 * kmp匹配算法
 */
public class KMP {

    public static void main(String[] args) {
        String s1 = "AAAB146A436fwA";
        String s2 = "B146A";
        int next[] = kmpNext(s2);
        System.out.println(Arrays.toString(next));
        int index = kmpSearch(s1,s2,next);
        System.out.println(index);
    }

    /**
     * kmp搜索方法
     * @param s1 原字符串
     * @param s2 子串
     * @param next 子串对应的部分匹配表
     * @return 如果-1就没有匹配到，否则返回第一个匹配的位置
     */
    public static int kmpSearch(String s1,String s2,int[] next){
        // 遍历比较字符串
        for(int i=0,j=0;i<s1.length();i++){
            /**
             * 处理s1.charAt(i)不等于s2.charAt(j)的情况
             * kmp算法核心
             */
            while(j>0 && s1.charAt(i) != s2.charAt(j)){
                j = next[j-1];
            }

            // 考虑相等的情况
            if(s1.charAt(i)==s2.charAt(j)){
                j++;
            }
            if(j==s2.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    // 获取一个字符串的部分匹配值表(部分匹配值表)
    public static int[] kmpNext(String dest){
        // 创建一个next数据保存部分匹配值
        int[] next = new int[dest.length()];
        // 如果字符串长度为1，部分匹配值就是0
        next[0] = 0;
        for(int i=1,j=0;i<dest.length();i++){
            /**
             * 当dest.charAt(i)不等于dest.charAt(j)的时候，
             * 我们需要从next[j]-1从新获取j，
             * 直到发现有dest.charAt(i)==dest.charAt(j)时才退出。
             * 这是kmp算法的核心
             */
            while(j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j-1];
            }
            // 从字符串第一位开始比较
            if(dest.charAt(i)==dest.charAt(j)){
                // 如果比较相等j++
                j++;
            }
            // 把j的值赋值给匹配表的第i为
            next[i] = j;
        }
        return next;
    }

}
