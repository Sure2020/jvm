/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : OOMObject
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

package com.example.jvm.chapter4_3_1.code4_7;

/**
 * @program: com.example.jvm.chapter4_3_1.code4_7
 * @description: xxx
 * @author: w15021
 * @create: 2022-07-26
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 内存占位符对象， 一个OOMObject大约占64KB
 */
class OOMObject {
    public byte[] placeholder = new byte[64 * 1024];
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
// 稍作延时， 令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
            System.out.println(i);
        }
        System.gc();
    }
    public static void main(String[] args) throws Exception {
        fillHeap(1000);
    }
}


