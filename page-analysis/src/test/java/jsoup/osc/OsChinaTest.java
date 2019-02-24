package jsoup.osc;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.wxg.daily.jsoup.osc.info.OscNews;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class OsChinaTest {

    private static String filepath = "D:\\wxg_test\\01\\20190224_161747.603.html";

    private static Document doc = null;


    /**
     * 多个 class 可以用 `.` 连起来，表示！
     */
    @Test
    public void test02() {
        Elements elements = doc.select("div.box.vertical.head-news");
        if (elements != null) {
            for (Element element : elements) {
                System.out.println("\n===\n");
                System.out.println(element.outerHtml());
            }
        }
    }

    /**
     * 抓取 oschina 的新闻资讯, 可返回json
     *
     */
    @Test
    public void test01() {
        ArrayList<OscNews> lists = Lists.newArrayList();

        Elements mainNews = doc.select("div.box.vertical.head-news");
        if (mainNews != null) {
            for (Element element : mainNews) {
//                System.out.println("\n===\n");
//                System.out.println(element.outerHtml());
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
//                System.out.println(element.outerHtml());
//                System.out.println("\n=====\n");
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

        if (!lists.isEmpty()) {
            System.out.println(JSON.toJSONString(lists));
        }
    }



    @BeforeClass
    public static void init() {
        try {
            doc = Jsoup.parse(new File(filepath), Charsets.UTF_8.name());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
