package jsoup;

import com.google.common.base.Charsets;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * create at 2019年4月7日10:48:34
 */
public class SpringBootReferenceGuideTest01 {

    private static Document doc;

    @BeforeClass
    public static void init() {
        File file = new File("F:\\wxgtest\\66", "SpringBootReferenceGuide.html");

        try {
            doc = Jsoup.parse(file, Charsets.UTF_8.name());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取 Table Contents
     */
    @Test
    public void GetTableOfContents() {
        int count = 0;
        Elements divs = doc.select("div.toc");
        for (Element div : divs) {
            Elements spans = div.getElementsByTag("span");
            for (Element span : spans) {
                System.out.println(span.text());
                count ++;
            }
        }
        System.out.println("count : " + count);
    }

    @Test
    public void howManyChapters() {
        Elements chapters = doc.select("div.chapter");
        int size = chapters.size();
        System.out.println("size : " + size);
    }


}
