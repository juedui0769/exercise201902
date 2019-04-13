package com.wxg.daily.study.statictest;

public class StChild extends StaticTestParent{
    static {
        System.out.println("'StChild' print");
    }

    public StChild() {
        System.out.println("'StChild' 构造方法-打印输出");
    }
}
