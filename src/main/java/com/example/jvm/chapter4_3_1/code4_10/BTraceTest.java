/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : BTraceTest
 * Date Created : 2022-07-26
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-07-26       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.jvm.chapter4_3_1.code4_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * @program: com.example.jvm.chapter4_3_1.code4_10
 * @description: xxx
 * @author: w15021
 * @create: 2022-07-26
 **/
public class BTraceTest{
    public int add(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) throws IOException {
        BTraceTest test = new BTraceTest();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            reader.readLine();
            int a = (int) Math.round(Math.random() * 1000);
            int b = (int) Math.round(Math.random() * 1000);
            System.out.println(test.add(a, b));
        }
        TreeSet ts = new TreeSet();
        ts.subSet("a",true, "b",true);
    }
}