package com.donbusline;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MIME;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class TelegramService {
    private String botToken;

    public TelegramService(String botToken){
        this.botToken = botToken;
    }

    public void sendMessage(String chatId, String text)throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost uploadFile = new HttpPost("https://api.telegram.org/bot"+botToken+"/sendMessage");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody("chat_id", chatId, ContentType.TEXT_PLAIN);
        builder.addTextBody("text", text, ContentType.create("text/plain", MIME.UTF8_CHARSET));
        HttpEntity multipart = builder.build();
        uploadFile.setEntity(multipart);
        CloseableHttpResponse httpResponse =  httpClient.execute(uploadFile);
        System.out.println(httpResponse.toString());

    }
}
