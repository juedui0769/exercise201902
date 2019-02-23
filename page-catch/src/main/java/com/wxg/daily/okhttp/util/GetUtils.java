package com.wxg.daily.okhttp.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class GetUtils {

    private OkHttpClient client = CommonOkClients.getClient();

    /**
     * 请使用 {@link GetUtils#body(String)} 方法
     *
     * @param url
     * @return
     */
    @Deprecated
    public String run(String url){
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void destroy() {
        CommonOkClients.destroy();
    }

    public String body(String url) {
        return run(url);
    }
}
