package com.wxg.daily.jsoup.osc;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;


public class CatchOscHomePageNewsTest {

    /**
     * 2019年2月24日19:15:37
     *
     * 测试： 从oschina首页获取资讯
     */
    @Test
    public void jsonNews() {

        String url = "http://www.oschina.net";
        CatchOscHomePageNews catchOscHomePageNews =
                new CatchOscHomePageNews(CatchOscHomePageNews.Type.URL, url);

        System.out.println(catchOscHomePageNews.jsonNews());
    }

    /**
     * 从本地的文件中获取资讯（可先使用 page-catch 抓取oschina的首页存储在本地，然后再解析）
     * `@Ignore` 必须加上这个注解，需要时再打开！
     */
    @Test
    @Ignore
    public void testFromLocalFile() {
        String filepath = "D:\\wxg_test\\01\\20190224_161747.603.html";
        CatchOscHomePageNews catchOscHomePageNews =
                new CatchOscHomePageNews(CatchOscHomePageNews.Type.LOCAL_FILE, filepath);

        System.out.println(catchOscHomePageNews.jsonNews());
    }
}