package com.wxg.daily.guava;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.wxg.daily.pagecatch.util.TimeUtil;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * guava
 *
 * {@link Files#write(byte[], File)}
 *
 */
public class TestFiles {

    @Test
    public void test02() {
        File file = new File("D:\\wxg_test\\02", TimeUtil.now() + ".txt");
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void test01() {
        String foo = "foo虚拟";
        try {
            File file = new File("D:\\wxg_test\\02", TimeUtil.now() + ".txt");
            Files.write(foo.getBytes(Charsets.UTF_8), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
