package edu.sdust.ssmstudy.vo;

import java.awt.*;

public class testclass {
    public int add (int a,int b){
        return a+b;

    }
    public int sub (int a,int b){
        return a-b;

    }

    public String context(String a,String b){
        return a+" "+b;
    }
    //数组测试
    public String[] Stringtest(String a[]){
        String b[]=new String[a.length];
        for (int i=0;i<a.length;i++){
            b[i]=a[i];
        }
        return b;
    }



}
