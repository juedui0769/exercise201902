package com.wxg.daily.study.statictest;

/**
 * create at 2019年4月13日12:44:02,
 */
public class StaticTestParent {
    static {
        System.out.println("'StaticTestParent' print");
    }

    public StaticTestParent() {
        System.out.println("'StaticTestParent' 构造方法-打印输出");
    }
}
