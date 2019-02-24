package com.wxg.daily.pagecatch;

import com.wxg.daily.pagecatch.exception.CatchConfigException;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class PageCatcherTest {

    private CatchConfig catchConfig = new CatchConfig();

    String storeDir = "D:\\wxg_test\\01";

    public PageCatcherTest() {
        catchConfig.setStoreDir(storeDir);
    }

    @AfterClass
    public static void tearDown() {
        new PageCatcher().destroy();
    }

    @Test
    public void test_getAndSave() {
        PageCatcher pageCatcher = new PageCatcher();
        String url = "http://www.oschina.net";
        String json = pageCatcher.getAndSave(storeDir, url);
        System.out.println(json);
    }

    @Test
    public void testOsc() {
        PageCatcher pageCatcher = new PageCatcher(catchConfig);
        String storeFile = pageCatcher.getBodyAndSave("http://www.oschina.net");
        System.out.println(storeFile);
    }

    @Test
    @Ignore
    public void testLocal() {
        PageCatcher pageCatcher = new PageCatcher(catchConfig);
        String storeFile = pageCatcher.getBodyAndSave("http://localhost:8088/hello");
        System.out.println(storeFile);
    }

    @Test
    public void testBaidu() {
        PageCatcher pageCatcher = new PageCatcher(catchConfig);
        String storeFile = pageCatcher.getBodyAndSave("http://www.baidu.com");
        System.out.println(storeFile);
    }

    @Test(expected = CatchException.class)
    public void test03() {
        PageCatcher pageCatcher = new PageCatcher();
        pageCatcher.getBodyAndSave("");
    }

    @Test(expected = CatchException.class)
    public void test02() {
        CatchConfig catchConfig = new CatchConfig();
        PageCatcher pageCatcher = new PageCatcher(catchConfig);
//        System.out.println(pageCatcher.getBodyFromAurl("http://localhost:8088/hello"));
        pageCatcher.getBodyAndSave("");
    }


    @Test
    @Ignore
    public void test01() {
        PageCatcher pageCatcher = new PageCatcher();

        String url = "http://localhost:8088/hello";
//        url = "http://www.baidu.com";
        String body = pageCatcher.getBodyFromAurl(url);
        System.out.println(body);
    }
}