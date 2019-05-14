package com.coco.crawler;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author cocoyang
 * @date 2019/4/29
 */
public class HttpGet01 {

    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //HttpGet httpGet = new HttpGet("https://www.vinycoco.com/articleandcomment?page=1&limit=5");
        HttpGet httpGet = new HttpGet("https://s.weibo.com/top/summary?Refer=top_hot&topnav=1&wvr=6");

        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                String string = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(string);
            }

            response.close();
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
