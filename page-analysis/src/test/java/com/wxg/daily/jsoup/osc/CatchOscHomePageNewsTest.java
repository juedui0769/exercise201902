package com.wxg.daily.jsoup.osc;

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
}