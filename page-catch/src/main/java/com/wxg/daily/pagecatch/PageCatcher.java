package com.wxg.daily.pagecatch;

import com.google.common.base.Strings;
import com.google.common.io.Files;
import com.google.common.primitives.Bytes;
import com.wxg.daily.okhttp.util.GetUtils;
import com.wxg.daily.pagecatch.util.TimeUtil;

import java.io.*;

public class PageCatcher {

    private static final String SUFFIX = ".html";

    private CatchConfig config;

    static GetUtils get = new GetUtils();

    public PageCatcher() {}

    public PageCatcher(CatchConfig config) {
        this.config = config;
    }

    public CatchConfig getConfig() {
        return config;
    }

    public void setConfig(CatchConfig config) {
        this.config = config;
    }

    /**
     * 从一个 `url` 获取其 body 内容。
     * @param url
     * @return
     */
    public String getBodyFromAurl(String url) {
        String body = get.body(url);
        return body;
    }

    /**
     * 这个方法在何时调用是一个问题： 应该在大家都不使用之后再决定释放。
     * 或者，延时释放。（比如，在一段时间之后再释放）
     */
    public void destroy() {
        get.destroy();
    }


    /**
     * 从一个 `url` 获取内容，并存储到本地
     * @param url
     */
    public String getBodyAndSave(String url) {
        if (config == null) {
            throw new CatchException("没有 `CatchConfig` ");
        }


//        Files.write();

        if (url == null || url.trim().length() == 0) {
            throw new CatchException("`url`不正确");
        }

        String storeDir = config.getStoreDir();
        String SP = File.separator;

        String genFilePath = new File(storeDir).getAbsolutePath()
                + SP + TimeUtil.now() + SUFFIX;

//        System.out.println(genFilePath);

        String body = getBodyFromAurl(url);

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(genFilePath)));
            bw.write(body);
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return genFilePath;
    }

    /**
     * 从一个 `url` 获取内容，并存储到本地
     *
     * 这个方法使用了自己写的“繁琐”的API, 请使用 {@link PageCatcher#getBodyAndSave(String)}
     *
     * @param url
     */
    private String getBodyAndSaveOld(String url) {
        if (config == null) {
            throw new CatchException("没有 `CatchConfig` ");
        }

        if (url == null || url.trim().length() == 0) {
            throw new CatchException("`url`不正确");
        }

        String storeDir = config.getStoreDir();
        String SP = File.separator;

        String genFilePath = new File(storeDir).getAbsolutePath()
                + SP + TimeUtil.now() + SUFFIX;

//        System.out.println(genFilePath);

        String body = getBodyFromAurl(url);

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(genFilePath)));
            bw.write(body);
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return genFilePath;
    }

}
