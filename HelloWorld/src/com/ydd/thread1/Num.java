package com.ydd.thread1;

/**
 * 共享数字资源
 * @author YDD
 *
 */
public class Num {
        int i = 0;  //加法操作对象
        boolean flag = true; //进程调用wait()标识
}
