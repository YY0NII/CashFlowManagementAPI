package com.codediff.ocr.api.CashFlowManagementAPI.services;

import java.io.File;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import org.apache.http.client.methods.*;
import org.apache.http.entity.mime.*;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class OCRService {
    public static JsonElement getResponse() throws IOException { // <- returns receipt as Json object :)
        String receiptEndpoint = "http://ocr.asprise.com/api/v1/receipt";
        File img = new File("receipt1.jpeg");
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(receiptEndpoint);
            post.setEntity(MultipartEntityBuilder.create()
                    .addTextBody("client_id", "TEST")
                    .addTextBody("recognizer", "auto")
                    .addTextBody("ref_no", "ocr_java_125")
                    .addPart("file", new FileBody(img))
                    .build());
            CloseableHttpResponse response = client.execute(post);
            return JsonParser.parseString(EntityUtils.toString(response.getEntity()));
        }
    }
    public static String testMethod() throws IOException {
        JsonElement address = new JsonParser().parse(getResponse().toString())
                .getAsJsonObject().get("receipts");
        return address.getAsString();
    }

    public static void main(String[] args) throws IOException {
        System.out.print(testMethod());
    }
}
