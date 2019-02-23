package com.wxg.daily.pagecatch;

import com.wxg.daily.pagecatch.exception.CatchConfigException;

public class CatchConfig {

    // 存放位置
    private String storeDir;

    public String getStoreDir() {
        if (storeDir == null) {
            throw new CatchConfigException("没有配置`storeDir`");
        }
        return storeDir;
    }

    public void setStoreDir(String storeDir) {
        this.storeDir = storeDir;
    }
}
