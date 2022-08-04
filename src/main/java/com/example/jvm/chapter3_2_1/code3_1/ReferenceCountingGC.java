/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ReferenceCountingGC
 * Date Created : 2022-07-08
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-07-08       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.jvm.chapter3_2_1.code3_1;

/**
 * @program: com.example.jvm.chapter3_2_1.code3_1
 * @description: xxx
 * @author: w15021
 * @create: 2022-07-08
 **/

import java.util.HashSet;
import java.util.Set;

/**
 * testGC()方法执行后，objA和objB会不会被GC呢？
 * @author zzm
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    /**
     * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否有回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];
    public static void main(String[] args) {
        testGC();
    }
    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
// 假设在这行发生GC，objA和objB是否能被回收？
        System.gc();
    }
}