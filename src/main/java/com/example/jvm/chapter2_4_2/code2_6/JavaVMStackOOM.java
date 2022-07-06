/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : JavaVMStackOOM
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

package com.example.jvm.chapter2_4_2.code2_6;

/**
 * @program: com.example.jvm.chapter2_4_2.code2_6
 * @description: xxx
 * @author: w15021
 * @create: 2022-07-06
 **/
/**
 * VM Args：-Xss2M （这时候不妨设大些，请在32位系统下运行）
 * @author zzm
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {
        }
    }
    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}

/*
[20.463s][warning][os,thread] Failed to start thread - _beginthreadex failed (EACCES) for attributes: stacksize: 2048k, flags: CREATE_SUSPENDED STACK_SIZE_PARAM_IS_A.
Exception in thread "main" java.lang.OutOfMemoryError: unable to create native thread: possibly out of memory or process/resource limits reached
	at java.base/java.lang.Thread.start0(Native Method)
	at java.base/java.lang.Thread.start(Thread.java:798)
	at com.example.jvm.chapter2_4_2.code2_6.JavaVMStackOOM.stackLeakByThread(JavaVMStackOOM.java:44)
	at com.example.jvm.chapter2_4_2.code2_6.JavaVMStackOOM.main(JavaVMStackOOM.java:49)

Process finished with exit code -1
 */