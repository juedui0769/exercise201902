package com.wxg;

import com.wxg.daily.translate.tencent.exception.TencentFanyiException;
import org.junit.Test;

/**
 * 2019年3月8日17:41:44
 */
public class RuntimeExceptionTest {

    private static final int CONST_INT = 0;

    /**
     * 这个例子说明，`RuntimeException`是会终止代码的执行的，所以不同担心后面的代码会在错误的状态下继续运行。
     */
    @Test(expected = RuntimeException.class)
    public void test01() {

        if (foo() == CONST_INT) {
            throw new TencentFanyiException("抛出RuntimeException, 终止代码的运行，后面的代码将不会执行！");
        }

        System.out.println("1111");
    }

    private int foo() {
        return CONST_INT;
    }
}
