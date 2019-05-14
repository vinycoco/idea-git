package com.coco.crawler;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author cocoyang
 * @date 2019/5/5
 */
public class HttpClinentPoolTest {


    public static void main(String[] args) {

        PoolingHttpClientConnectionManager cm =new PoolingHttpClientConnectionManager();
        //总共最大的连接数
        cm.setMaxTotal(100);
        //主机的最大连接数
        cm.setDefaultMaxPerRoute(10);



        doGet(cm);
        doGet(cm);

    }

    private static void doPost(PoolingHttpClientConnectionManager cm) {


    }

    private static void doGet(PoolingHttpClientConnectionManager cm) {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

        HttpGet httpGet =new HttpGet("https://blog.csdn.net/qq_36819098/article/details/80006124");
        CloseableHttpResponse response =null;

        try {
            response = httpClient.execute(httpGet);

            if(response.getStatusLine().getStatusCode()==200){
                String content = EntityUtils.toString(response.getEntity(), "utf-8");

                System.out.println(content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
