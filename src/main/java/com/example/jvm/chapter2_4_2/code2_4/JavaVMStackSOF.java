/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : JavaVMStackSOF
 * Date Created : 2022-07-06
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-07-06       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.jvm.chapter2_4_2.code2_4;

/**
 * @program: com.example.jvm.chapter2_4_2.code2_4
 * @description: xxx
 * @author: w15021
 * @create: 2022-07-06
 **/
/**
 * VM Args：-Xss128k
 * @author zzm
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}

/*
stack length:1553
Exception in thread "main" java.lang.StackOverflowError
	at com.example.jvm.chapter2_4_2.code2_4.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:34)
	at com.example.jvm.chapter2_4_2.code2_4.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:35)
	at com.example.jvm.chapter2_4_2.code2_4.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:35)
 */