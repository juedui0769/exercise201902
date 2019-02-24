package jsoup;

import com.google.common.base.Charsets;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class JsoupTest {




    @Test
    public void test02() {

        File file = new File("D:\\wxg_test\\01", "20190224_161747.603.html");
        Document doc = null;
        try {
            doc = Jsoup.parse(file, Charsets.UTF_8.name());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(doc.body().outerHtml());
    }


    /**
     * 2019年2月24日16:49:11
     * 只使用 `jsoup` 就可以提取单个页面的信息了，并不需要使用 `okhttp` 下载页面
     *
     * 但是使用 `okhttp` 可以批量延时下载页面保存到本地，然后在未来任何时间解析
     */
    @Test
    public void test01() {
        URL url = null;

        try {
            url = new URL("http://www.oschina.net");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Document document = null;

        try {
            if (url != null) {
                document = Jsoup.parse(url, 5000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element body = document.body();

        String outerHtml = body.outerHtml();

        System.out.println(outerHtml);
    }
}
