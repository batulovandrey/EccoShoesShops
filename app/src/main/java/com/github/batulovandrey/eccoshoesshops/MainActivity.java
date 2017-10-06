package com.github.batulovandrey.eccoshoesshops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.batulovandrey.eccoshoesshops.bean.BaseResponse;
import com.github.batulovandrey.eccoshoesshops.bean.ShopItem;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
    }

    private void getData() {
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://app.ecco-shoes.ru/shops/list").newBuilder();
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
                // TODO: 06.10.2017 handle failure
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    ObjectMapper mapper = new ObjectMapper();
                    final BaseResponse baseResponse = mapper.readValue(response.body().bytes(), BaseResponse.class);
                    for (ShopItem item : baseResponse.getShops())
                        System.out.println(item);
                    // TODO: 06.10.2017 throw into fragment
                } else {
                    System.out.println("it was not successful");
                    // TODO: 06.10.2017 handle error
                }
            }
        });
    }
}
