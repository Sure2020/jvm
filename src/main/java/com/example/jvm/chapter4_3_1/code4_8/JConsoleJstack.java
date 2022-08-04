/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : JConsoleJstack
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

package com.example.jvm.chapter4_3_1.code4_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @program: com.example.jvm.chapter4_3_1.code4_8
 * @description: xxx
 * @author: w15021
 * @create: 2022-07-26
 **/
public class JConsoleJstack {
    /**
     * 线程死循环演示
     */
    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) // 第41行
                    ;
            }
        }, "testBusyThread");
        thread.start();
    }
    /**
            * 线程锁等待演示
*/
    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        Object obj = new Object();
        createLockThread(obj);
    }
}