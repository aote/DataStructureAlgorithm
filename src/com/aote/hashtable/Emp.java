package com.aote.hashtable;

// 雇员类
public class Emp {

    public int id;
    public String name;
    public Emp next; // 默认为空

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
