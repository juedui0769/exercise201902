package com.wxg.daily.translate.tencent;

import com.wxg.daily.okhttp.util.CommonOkClients;
import com.wxg.daily.translate.TranslateTests;
import com.wxg.daily.translate.baidu.util.FanyiLang;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class TencentFanyiTest {

    private TencentFanyi tencentFanyi;

    public TencentFanyiTest() {
        TencentFanyi.setCredentialInfoStorePath("D:\\wxg_test\\secretInfo\\translate\\tencent\\SecretInfo.txt");
        tencentFanyi = TencentFanyi.getInstance();
    }

    /**
     * @see TranslateTests#translantByTencent()
     */
    @Test
    @Ignore
    public void translant() {
        long start = System.currentTimeMillis();
        String query = "Hibernate ORM enables developers to more easily write applications whose data outlives the application process. As an Object/Relational Mapping (ORM) framework, Hibernate is concerned with data persistence as it applies to relational databases (via JDBC). Unfamiliar with the notion of ORM?";
        String translant = tencentFanyi.translant(query, FanyiLang.EN, FanyiLang.ZH);

        System.out.println(translant);

        long end = System.currentTimeMillis();

        System.out.println((end - start));


        CommonOkClients.destroy();

    }
}