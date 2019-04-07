package jsoup;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.primitives.Bytes;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

public class JsoupTest {


    /**
     * create at 2019年4月7日10:27:45，
     * <p>
     * 从本地html文件中获取body，采用 Guava 保存到本地。
     * </p>
     */
    @Test
    public void test03() throws IOException {
        File file = new File("F:\\wxgtest\\66", "SpringBootReferenceGuide.html");
        Document doc = null;
        try {
            doc = Jsoup.parse(file, Charsets.UTF_8.name());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String body = doc.body().outerHtml();

        Files.write(body.getBytes(Charsets.UTF_8.name()),
                new File("F:\\wxgtest\\66", "body01.html"));
    }

    /**
     * comment at 2019年4月7日10:26:27，
     * <p>
     * 加载本地 html 文件，获取 body ，使用 utf8 编码(Guava)。
     * </p>
     */
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
