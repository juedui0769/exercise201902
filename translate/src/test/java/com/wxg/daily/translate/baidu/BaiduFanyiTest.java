package com.wxg.daily.translate.baidu;

import com.wxg.daily.okhttp.util.CommonOkClients;
import com.wxg.daily.translate.TranslateTests;
import com.wxg.daily.translate.baidu.info.BaiduTranslateResult;
import com.wxg.daily.translate.baidu.util.FanyiLang;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 对封装的百度翻译API的测试
 */
public class BaiduFanyiTest {

    private BaiduFanyi baiduFanyi;

    public BaiduFanyiTest() {
        String filepath = "D:\\wxg_test\\secretInfo\\translate\\baidu\\SecretInfo.txt";
        BaiduFanyi.setSecretInfoStorePath(filepath);
        baiduFanyi = BaiduFanyi.getInstance();
    }

    /**
     * output:
     * {"from":"zh","to":"en","trans_result":[{"src":"\u82f9\u679c","dst":"Apple"}]}
     */
    @Test
    public void invokeOfficial() {
        String query = "苹果";
        String s = baiduFanyi.invokeOfficial(query, FanyiLang.EN);
        System.out.println(s);
    }

    /**
     * output:
     * BaiduTranslateResult{from='zh', to='en', trans_result=[TransResult{src='梨', dst='Pear'}]}
     *
     * @see TranslateTests#translateByBaidu()
     */
    @Test
    @Ignore
    public void invokeByOkhttp() {
        String query = "梨";
        BaiduTranslateResult baiduTranslateResult = baiduFanyi.invokeByOkhttp(query, FanyiLang.EN);
        System.out.println(baiduTranslateResult);

        // 清理
        CommonOkClients.destroy();
    }
}