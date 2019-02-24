package com.wxg.daily.pagecatch.info;

public class SaveInfo {

    // 抓取的url地址
    private String url;

    // 保存的本地文件绝对地址
    private String localPath;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }
}
