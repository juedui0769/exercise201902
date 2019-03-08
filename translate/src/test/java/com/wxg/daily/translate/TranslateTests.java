package com.wxg.daily.translate;

import com.wxg.daily.okhttp.util.CommonOkClients;
import com.wxg.daily.translate.baidu.BaiduFanyi;
import com.wxg.daily.translate.baidu.info.BaiduTranslateResult;
import com.wxg.daily.translate.baidu.util.FanyiLang;
import com.wxg.daily.translate.tencent.TencentFanyi;
import org.junit.AfterClass;
import org.junit.Test;

public class TranslateTests {

    private BaiduFanyi baiduFanyi;

    private TencentFanyi tencentFanyi;

    @AfterClass
    public static void tearDown() {
        // 清理
        CommonOkClients.destroy();
    }

    public TranslateTests() {
        String filepath = "D:\\wxg_test\\secretInfo\\translate\\baidu\\SecretInfo.txt";
        BaiduFanyi.setSecretInfoStorePath(filepath);
        baiduFanyi = BaiduFanyi.getInstance();
        // ====
        TencentFanyi.setCredentialInfoStorePath("D:\\wxg_test\\secretInfo\\translate\\tencent\\SecretInfo.txt");
        tencentFanyi = TencentFanyi.getInstance();
    }

    @Test
    public void translateByBaidu() {
        String query = "梨";
        BaiduTranslateResult baiduTranslateResult = baiduFanyi.invokeByOkhttp(query, FanyiLang.EN);
        System.out.println(baiduTranslateResult);
    }

    @Test
    public void translantByTencent() {
        long start = System.currentTimeMillis();
        String query = "apple";
        String translant = tencentFanyi.translant(query, FanyiLang.EN, FanyiLang.ZH);

        System.out.println(translant);

        long end = System.currentTimeMillis();

        System.out.println((end - start));
    }
}
