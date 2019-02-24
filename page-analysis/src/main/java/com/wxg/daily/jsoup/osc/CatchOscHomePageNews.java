package com.wxg.daily.jsoup.osc;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.wxg.daily.jsoup.osc.info.OscNews;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CatchOscHomePageNews {

    public static enum Type {
        URL, LOCAL_FILE
    }

    private int timeoutMillis = 1000;

    private String utf8 = Charsets.UTF_8.name();

    private Document doc = null;

    private String filepath = null;

    private URL url = null;

    public CatchOscHomePageNews(Type type, String val) {
        if (type.equals(Type.URL)) {
            try {
                url = new URL(val);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            if (url != null) {
                try {
                    doc = Jsoup.parse(url, timeoutMillis);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (type.equals(Type.LOCAL_FILE)) {
            filepath = val;
            try {
                doc = Jsoup.parse(new File(filepath), utf8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<OscNews> listNews() {

        ArrayList<OscNews> lists = Lists.newArrayList();

        Elements mainNews = doc.select("div.box.vertical.head-news");
        if (mainNews != null) {
            for (Element element : mainNews) {
                Elements links = element.select("a");

                if (links != null) {
                    for (Element link : links) {
                        OscNews oscNews = new OscNews(link.attr("href"),
                                link.attr("title"));
                        lists.add(oscNews);
                    }
                }
            }
        }

        Elements elements = doc.select("div.page");

        if (elements != null) {
            for (Element element : elements) {
                Elements links = element.select("a");
                if (links != null) {
                    for (Element link : links) {
                        OscNews oscNews = new OscNews(link.attr("href"),
                                link.attr("title"));
                        lists.add(oscNews);
                    }
                }
            }
        }

        return lists;
    }

    public String jsonNews() {
        List<OscNews> lists = listNews();
        if (lists != null) {
            return JSON.toJSONString(lists);
        }
        return "";
    }

}
