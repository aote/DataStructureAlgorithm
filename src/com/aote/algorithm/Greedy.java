package com.aote.algorithm;

import java.util.*;

/**
 * 贪心算法
 */
public class Greedy {

    public static void main(String[] args) {
        //创建广播电台,放入到Map
        HashMap<String,HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        //将各个电台放入到broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");


        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        hashSet4.add("大连");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        hashSet5.add("重庆");

        //加入到map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        //allAreas 存放所有的地区
        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        allAreas.add("重庆");

        // 创建ArrayList，存放选择的电台集合
        List<String> selects = new ArrayList<>();

        // 定义一个临时的集合，在遍历过程中，存放遍历过程中的电台覆盖的地区和当前还没有覆盖地区的交集
        HashSet<String> tempSet = new HashSet<>();

        // 定义一个maxKey
        String maxKey = null;

        // 定义一个临时集合，存最大集合和总和的交集
        HashSet<String> selectsRetainMax = new HashSet<>();

        while(allAreas.size()!=0){ // 如果allAreas大于0，表示没有覆盖到所有地区
            // 每次while循环，需要置空
            maxKey = null;
            // 遍历broadcasts，取出对应的key
            for(String key : broadcasts.keySet()){
                // 每次for循环tempSet清空
                tempSet.clear();
                // 当前key能够覆盖的地区
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                // 求出当前覆盖的城市和allAreas的交集，retainAll结果会直接返回给tempSet
                tempSet.retainAll(allAreas);
                // 如果当前集合包含未覆盖地区的数量比maxKey指向的集合未覆盖的地区还多，maxKey就需要重置
                if(maxKey!=null)
                    broadcasts.get(maxKey).retainAll(allAreas);
                if(tempSet.size()>0
                        && (maxKey==null || tempSet.size()> broadcasts.get(maxKey).size())){
                    maxKey = key;
                }
            }
            // maxKey 不等于空，就将maxKey贾璐selects
            if(maxKey != null){
                selects.add(maxKey);
                // 将maxKey覆盖的地区从allAreas中去掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }

        System.out.println(selects);

    }

}
