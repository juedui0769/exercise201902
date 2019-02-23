package com.wxg.daily.pagecatch;

import com.wxg.daily.pagecatch.exception.CatchConfigException;
import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class PageCatcherTest {

    private CatchConfig catchConfig = new CatchConfig();

    public PageCatcherTest() {
        catchConfig.setStoreDir("D:\\wxg_test\\01");
    }

    @AfterClass
    public static void tearDown() {
        new PageCatcher().destroy();
    }

    @Test
    public void test05() {
        PageCatcher pageCatcher = new PageCatcher(catchConfig);
        String storeFile = pageCatcher.getBodyAndSave("http://localhost:8088/hello");
        System.out.println(storeFile);
    }

    @Test
    public void test04() {
        PageCatcher pageCatcher = new PageCatcher(catchConfig);
        String storeFile = pageCatcher.getBodyAndSave("http://www.baidu.com");
        System.out.println(storeFile);
    }

    @Test(expected = CatchException.class)
    public void test03() {
        PageCatcher pageCatcher = new PageCatcher();
        pageCatcher.getBodyAndSave("");
    }

    @Test(expected = CatchConfigException.class)
    public void test02() {
        CatchConfig catchConfig = new CatchConfig();
        PageCatcher pageCatcher = new PageCatcher(catchConfig);
//        System.out.println(pageCatcher.getBodyFromAurl("http://localhost:8088/hello"));
        pageCatcher.getBodyAndSave("");
    }


    @Test
    public void test01() {
        PageCatcher pageCatcher = new PageCatcher();

        String url = "http://localhost:8088/hello";
//        url = "http://www.baidu.com";
        String body = pageCatcher.getBodyFromAurl(url);
        System.out.println(body);
    }
}