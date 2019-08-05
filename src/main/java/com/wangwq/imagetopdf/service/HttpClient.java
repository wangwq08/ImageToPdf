package com.wangwq.imagetopdf.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * @Description: the client ot use url interface
 * @Author: wangwq
 * @CreateDate: 2019/08/04 21:43
 */
public class HttpClient {

    public HttpEntity getImageDataByGet(String url, String data) {
        CloseableHttpClient client =null;

        if(client == null) {
            client = new DefaultHttpClient();
            //HttpHost proxy = new HttpHost("",3128);
            //client.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY, proxy);
        }
        try {
            HttpGet get = new HttpGet(url);
            StringEntity stringEntity = new StringEntity("data="+data);
            get.setHeader("Content-Type", "application/javascript;charset=GBK");
            HttpResponse response = client.execute(get);
            HttpEntity httpEntity = response.getEntity();

            if (httpEntity != null) {
                return httpEntity;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
