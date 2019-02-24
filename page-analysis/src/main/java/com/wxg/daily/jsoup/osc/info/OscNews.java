package com.wxg.daily.jsoup.osc.info;

/**
 * 2019年2月24日18:12:07
 *
 * 此类代表： oschina.net的新闻
 */
public class OscNews {

    public OscNews() {}

    public OscNews(String href, String title) {
        this.href = href;
        this.title = title;
    }

    private String href;
    private String title;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
