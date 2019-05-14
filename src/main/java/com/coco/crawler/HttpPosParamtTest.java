package com.coco.crawler;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.List;
import java.util.ArrayList;

/**
 * @author cocoyang
 * @date 2019/4/30
 */
public class HttpPosParamtTest {

    public static void main(String[] args) throws  Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://s.weibo.com/top/summary");
        //封装表单中的参数
        List<NameValuePair> params =new ArrayList<>();
        params.add(new BasicNameValuePair("Refer","top_hot"));
        params.add(new BasicNameValuePair("topnav","1"));
        params.add(new BasicNameValuePair("wvr","6"));
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params,"utf-8");


        //创建表单的实体对象

        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
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
