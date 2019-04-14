package com.wxg.daily.study;

import com.wxg.daily.study.statictest.StChild;

/**
 * create at 2019年4月13日12:41:47，
 * 验证 《JAVA面试题总览》 5. 类的实例化顺序
 * <ul>
 * <li>1. 先父类再子类</li>
 * <li>2. 先`static`再非static</li>
 * </ul>
 */
public class StaticInitOrderTest {
    public static void main(String[] args) {
        new StChild();
    }
}
