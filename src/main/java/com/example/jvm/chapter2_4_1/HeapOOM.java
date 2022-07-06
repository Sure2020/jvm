/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : HeapOOM
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

package com.example.jvm.chapter2_4_1;

/**
 * @program: com.example.jvm.chapter2_4_1
 * @description: xxx
 * @author: w15021
 * @create: 2022-07-06
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author zzm
 */
public class HeapOOM {
    static class OOMObject {
    }
    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        int count = 0;
        while (true) {
            System.out.println(count ++);
            //Thread.sleep(10);
            list.add(new OOMObject());
        }
    }
}

/*

810320
810321
810322
810323
810324
810325
java.lang.OutOfMemoryError: Java heap space
Dumping heap to java_pid5796.hprof ...
Heap dump file created [31036584 bytes in 0.101 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.base/java.util.Arrays.copyOf(Arrays.java:3720)
	at java.base/java.util.Arrays.copyOf(Arrays.java:3689)
	at java.base/java.util.ArrayList.grow(ArrayList.java:238)
	at java.base/java.util.ArrayList.grow(ArrayList.java:243)
	at java.base/java.util.ArrayList.add(ArrayList.java:486)
	at java.base/java.util.ArrayList.add(ArrayList.java:499)
	at com.example.jvm.chapter2_4_1.HeapOOM.main(HeapOOM.java:44)

Process finished with exit code 1

 */