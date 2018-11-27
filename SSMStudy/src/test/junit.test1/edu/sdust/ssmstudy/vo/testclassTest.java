package edu.sdust.ssmstudy.vo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class testclassTest {

    private testclass tc=null;
    @Before
    public void testBeforeClass(){
        tc = new testclass();
    }

    @Test
    public void add() {

        int result=  tc.add(1,2);

        Assert.assertEquals(result,3);
    }

    @Test
    public void sub() {

        int result = tc.sub(2,1);
        int result1 = tc.sub(3,3);
        int result2 = tc.sub(4,1);

        Assert.assertEquals(result,1);
        Assert.assertEquals(result1,0);
        Assert.assertEquals(result2,3);
    }


    @Test
    public void context(){

        String result = tc.context("hello","world");

        Assert.assertEquals(result,"hello world");
    }

    @Test
    public void Stringtest(){

        String a[] = {"tom","marry","json"};
        String result[] = tc.Stringtest(a);

        String[] c = {"tom","marry","json"};
        Assert.assertArrayEquals(result,c);
    }


}