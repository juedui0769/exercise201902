package com.wxg.daily.study.binary;

import org.junit.Test;

/**
 * create at 2019年4月14日09:54:17，
 */
public class BinarySystemTest {

    @Test
    public void test01() {
        int a = Integer.MAX_VALUE;
        int a1 = a >> 16;
        System.out.printf("a : %d, ", a);
        System.out.printf("a1 : %d\r\n", a1);
        int b1 = a ^ a1;
        System.out.printf("b1 : %d, ", b1);
    }
}
