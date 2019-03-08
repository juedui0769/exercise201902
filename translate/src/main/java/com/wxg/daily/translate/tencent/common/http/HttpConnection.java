/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.wxg.daily.translate.tencent.common.http;

import com.wxg.daily.okhttp.util.CommonOkClients;
import com.wxg.daily.translate.tencent.common.exception.TencentCloudSDKException;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

;

/**
 * http连接类
 */
public class HttpConnection {
	
	private OkHttpClient client;
	
    public HttpConnection(Integer connTimeout, Integer readTimeout, Integer writeTimeout) {
//    	this.client = new OkHttpClient();

		// 使用我自己封装的`client`获取方法，便于统一管理
		this.client = CommonOkClients.getClient();

    	// 2019年3月8日18:24:55，okhttp3中已经没有下面的API了。
//    	this.client.setConnectTimeout(connTimeout, TimeUnit.SECONDS);
//    	this.client.setReadTimeout(readTimeout, TimeUnit.SECONDS);
//    	this.client.setWriteTimeout(writeTimeout, TimeUnit.SECONDS);
    	
    }
    
    
    public Response doRequest(Request request) throws TencentCloudSDKException {
    	Response response = null;
    	try {
    		response = this.client.newCall(request).execute();
    	} catch (IOException e) {
    		throw new TencentCloudSDKException(e.getMessage());
    	}
    	return response;
    }
    
    public Response getRequest(String url) throws TencentCloudSDKException {
    	Request request = null;
    	try {
        	request = new Request.Builder()
        			.url(url)
        			.get()
        			.build();
    	} catch (IllegalArgumentException e) {
    		throw new TencentCloudSDKException(e.getMessage());
    	}

    	return this.doRequest(request); 	
    }
    
    public Response postRequest(String url, String body) throws TencentCloudSDKException {
    	MediaType contentType = MediaType.parse("application/x-www-form-urlencoded");
    	Request request = null;
    	try {
    		request = new Request.Builder()
                    .url(url)
                    .post(RequestBody.create(contentType, body))
                    .build();
    	} catch (IllegalArgumentException e) {
    		throw new TencentCloudSDKException(e.getMessage());
    	}

        return this.doRequest(request);   		
    }
}

