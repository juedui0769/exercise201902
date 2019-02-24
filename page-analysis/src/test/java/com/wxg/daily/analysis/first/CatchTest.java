package com.wxg.daily.analysis.first;


import com.wxg.daily.pagecatch.PageCatcher;
import org.junit.AfterClass;
import org.junit.Test;

/**
 *
 * 2019年2月24日16:18:08
 */
public class CatchTest {

    String storeDir = "D:\\wxg_test\\01";

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
}
