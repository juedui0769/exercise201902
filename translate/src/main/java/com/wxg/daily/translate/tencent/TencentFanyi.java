package com.wxg.daily.translate.tencent;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
//import com.tencentcloudapi.common.Credential;
//import com.tencentcloudapi.common.exception.TencentCloudSDKException;
//import com.tencentcloudapi.tmt.v20180321.TmtClient;
//import com.tencentcloudapi.tmt.v20180321.models.TextTranslateRequest;
//import com.tencentcloudapi.tmt.v20180321.models.TextTranslateResponse;
import com.wxg.daily.translate.baidu.util.FanyiLang;
import com.wxg.daily.translate.tencent.common.Credential;
import com.wxg.daily.translate.tencent.common.exception.TencentCloudSDKException;
import com.wxg.daily.translate.tencent.exception.TencentFanyiException;
import com.wxg.daily.translate.tencent.v20180321.TmtClient;
import com.wxg.daily.translate.tencent.v20180321.models.TextTranslateRequest;
import com.wxg.daily.translate.tencent.v20180321.models.TextTranslateResponse;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 2019年3月8日17:59:23 使用官方提供的SDK开发，但是觉得`okhttp`不在自己的掌控中（有些担心）
 *
 */
public class TencentFanyi {

    private TencentFanyi() {}

    private static volatile TencentFanyi instance;

    private static String localFilePath;

    private transient Credential credential;

    private String region = "ap-guangzhou";

    private TmtClient tmtClient;

    public static void setCredentialInfoStorePath(String secretInfoStorePath) {
        localFilePath = secretInfoStorePath;
    }

    public synchronized static TencentFanyi getInstance() {
        if (instance == null) {
            instance = new TencentFanyi();
            instance.loadCredential();

            // 感觉这样写,怪怪的！虽然`instance`只有一份
            instance.buildTmtClient();
        }
        return instance;
    }

    private void loadCredential() {
        if (localFilePath == null) {
            throw new TencentFanyiException("没有提供API密钥的本地存放地址！");
        }
        List<String> lines = null;
        try {
            lines = Files.readLines(new File(localFilePath), Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (lines != null && lines.size() >= 2) {
            credential = new Credential(lines.get(0), lines.get(1));
        }
    }

    private void buildTmtClient() {
        tmtClient = new TmtClient(credential, region);
    }

    public String translant(String query, String languageFrom, String languageTo) {
        TextTranslateRequest request = new TextTranslateRequest();
        request.setProjectId(101);
        request.setSource(languageFrom);
        request.setTarget(languageTo);
        request.setSourceText(query);
        TextTranslateResponse translateResponse = null;
        try {
            translateResponse = tmtClient.TextTranslate(request);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return translateResponse.getTargetText();
    }

    public static void main(String[] args) throws TencentCloudSDKException {
        long start = System.currentTimeMillis();

        TencentFanyi.setCredentialInfoStorePath("D:\\wxg_test\\secretInfo\\translate\\tencent\\SecretInfo.txt");
        TencentFanyi tencentFanyi = TencentFanyi.getInstance();

//        String secretId = "XXXX";
//        String secretKey = "YYYY";
//        Credential credential = new Credential(secretId, secretKey);
//        String region = "ap-guangzhou";
//
//        TmtClient tmtClient = new TmtClient(credential, region);
//        TextTranslateRequest request = new TextTranslateRequest();
//        request.setProjectId(101);
//        request.setSource("en");
//        request.setTarget("zh");
//        request.setSourceText("Hibernate ORM enables developers to more easily write applications whose data outlives the application process. As an Object/Relational Mapping (ORM) framework, Hibernate is concerned with data persistence as it applies to relational databases (via JDBC). Unfamiliar with the notion of ORM?");
//        TextTranslateResponse translateResponse = tmtClient.TextTranslate(request);
//        String outPrintStr = String.format("RequestId: %s, TargetText: %s",
//                translateResponse.getRequestId(), translateResponse.getTargetText());
//        System.out.println(outPrintStr);

        String query = "Hibernate ORM enables developers to more easily write applications whose data outlives the application process. As an Object/Relational Mapping (ORM) framework, Hibernate is concerned with data persistence as it applies to relational databases (via JDBC). Unfamiliar with the notion of ORM?";
        String translant = tencentFanyi.translant(query, FanyiLang.EN, FanyiLang.ZH);

        System.out.println(translant);

        long end = System.currentTimeMillis();

        System.out.println((end - start));
    }
}
