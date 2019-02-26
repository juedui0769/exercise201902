package com.wxg.daily.okhttp.util;

import okhttp3.OkHttpClient;

public class CommonOkClients {
    private static OkHttpClient client;

    public static synchronized OkHttpClient getClient() {
        if (client == null) {
            client = new OkHttpClient();
        }
        return client;
    }

    public static synchronized void destroy() {
        if (client != null) {
            client.dispatcher().executorService().shutdown();   //清除并关闭线程池
            client.connectionPool().evictAll();                 //清除并关闭连接池

            // update 2019年2月26日09:53:04 , 感觉加上下面这句更保险一些！
            client = null;
        }
    }
}
