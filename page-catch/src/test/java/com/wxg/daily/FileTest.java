package com.wxg.daily;

import org.junit.Test;

import java.io.File;

public class FileTest {

    @Test
    public void test01() {
        String pathSeparator = File.pathSeparator;
        String separator = File.separator;

        System.out.println(pathSeparator);
        System.out.println(separator);
    }
}
