package com.aote.hashtable;


import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add：添加雇员");
            System.out.println("find：查找雇员");
            System.out.println("list：显示雇员");
            System.out.println("exit：退出");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("input id");
                    int id = scanner.nextInt();
                    System.out.println("input name");
                    String name = scanner.next();
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "find":
                    System.out.println("input id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                        break;
            }
        }
    }

}
