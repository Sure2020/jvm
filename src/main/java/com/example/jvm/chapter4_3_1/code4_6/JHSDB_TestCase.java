/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : JHSDB_TestCase
 * Date Created : 2022-07-25
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-07-25       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.jvm.chapter4_3_1.code4_6;

/**
 * @program: com.example.jvm.chapter4_3_1.code4_6
 * @description: xxx
 * @author: w15021
 * @create: 2022-07-25
 **/
/**
 * staticObj、instanceObj、localObj存放在哪里？
 */
public class JHSDB_TestCase {
    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();
        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done"); // 这里设一个断点
        }
    }
    private static class ObjectHolder {}
    public static void main(String[] args) {
        Test test = new JHSDB_TestCase.Test();
        test.foo();
    }
}