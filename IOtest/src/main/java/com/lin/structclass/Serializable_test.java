package com.lin.structclass;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/20.
 */
public class Serializable_test  implements Serializable {
    private String name;
    private int age;

    public Serializable_test(String name , int age){
        System.out.println("有参数构造器");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
