package com.wxg.daily.pagecatch;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.wxg.daily.okhttp.util.GetUtils;
import com.wxg.daily.pagecatch.info.SaveInfo;
import com.wxg.daily.pagecatch.util.FileNameUtil;
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
     * 抓取url保存到本地文件中，文件位置及url以json形式返回（方便调用者进一步处理，比如保存到数据库等）
     *
     * @param storeDirectory
     * @param url
     * @return
     */
    public String getAndSave(String storeDirectory, String url) {
        if (storeDirectory == null) {
            throw new CatchException("没有提供`storeDirectory`");
        }

        if (url == null || url.trim().length() == 0) {
            throw new CatchException("没有提供`url`");
        }

        File genFile = new File(storeDirectory, FileNameUtil.now() + SUFFIX);

        String body = getBodyFromAurl(url);

        try {
            // 将`body`内容保存到本地文件中 (使用 guava API)
            Files.write(body.getBytes(Charsets.UTF_8), genFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SaveInfo saveInfo = new SaveInfo();
        saveInfo.setUrl(url);
        saveInfo.setLocalPath(genFile.getAbsolutePath());

        // 将结果以 json 形式返回
        return JSON.toJSONString(saveInfo);
    }

    /**
     * 从一个 `url` 获取内容，并存储到本地
     *
     * 请使用 {@link PageCatcher#getAndSave(String, String)}
     *
     * @param url
     */
    @Deprecated
    public String getBodyAndSave(String url) {
        if (config == null) {
            throw new CatchException("没有 `CatchConfig` ");
        }

        if (url == null || url.trim().length() == 0) {
            throw new CatchException("`url`不正确");
        }

        String storeDir = config.getStoreDir();

        File genFile = new File(storeDir, TimeUtil.now() + SUFFIX);
        String genFilePath = genFile.getAbsolutePath();

        String body = getBodyFromAurl(url);

        try {
            // 将`body`内容保存到本地文件中 (使用 guava API)
            Files.write(body.getBytes(Charsets.UTF_8), genFile);
        } catch (IOException e) {
            e.printStackTrace();
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
    @Deprecated
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
