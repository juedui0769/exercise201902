package com.wxg.daily.okhttp.util;

import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;

public class GetUtilsTest {

    static GetUtils g = new GetUtils();

    @AfterClass
    public static void destroy() {
        g.destroy();
    }

    /**
     * http://localhost:8088/hello （本地搭建，请替换 url或者 @Ignore）
     *
     * 本地搭建 server 的方法参考：
     * https://github.com/juedui0769/StudyNotes2018/blob/master/129_Server_Moco.md
     *
     *
     * @throws InterruptedException
     */
    @Test
    @Ignore
    public void test01() throws InterruptedException {
        for (int i=0;i<5;i++){
            String local_url = "http://localhost:8088/hello";
            String body = g.run(local_url);
            System.out.println(body);
            System.out.println("  --  ");

            Thread.sleep(1030);
        }
    }
}