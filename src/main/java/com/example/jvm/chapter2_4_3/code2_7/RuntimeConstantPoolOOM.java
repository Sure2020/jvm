/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : RuntimeConstantPoolOOM
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

package com.example.jvm.chapter2_4_3.code2_7;

/**
 * @program: com.example.jvm.chapter2_4_3.code2_7
 * @description: xxx
 * @author: w15021
 * @create: 2022-07-06
 **/

import java.util.HashSet;
import java.util.Set;

/**
 * VM Args：-XX:PermSize=6M -XX:MaxPermSize=6M
 * @author zzm
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
// 使用Set保持着常量池引用，避免Full GC回收常量池行为
        Set<String> set = new HashSet<String>();
// 在short范围内足以让6MB的PermSize产生OOM了
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}

/*
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.base/java.util.HashMap.newNode(HashMap.java:1797)
	at java.base/java.util.HashMap.putVal(HashMap.java:637)
	at java.base/java.util.HashMap.put(HashMap.java:607)
	at java.base/java.util.HashSet.add(HashSet.java:220)
	at com.example.jvm.chapter2_4_3.code2_7.RuntimeConstantPoolOOM.main(RuntimeConstantPoolOOM.java:42)

Process finished with exit code 1
 */