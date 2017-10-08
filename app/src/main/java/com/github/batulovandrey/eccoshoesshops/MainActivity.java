package com.github.batulovandrey.eccoshoesshops;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.batulovandrey.eccoshoesshops.bean.BaseResponse;
import com.github.batulovandrey.eccoshoesshops.bean.ShopItem;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ShopsFragment.OnShopItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
    }

    @Override
    public void onFragmentInteraction(ShopItem item) {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.map_container, MapFragment.newInstance(item.getLatitude(), item.getLongitude()))
                .commit();
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
                    showShopFragment(baseResponse.getShops());
                } else {
                    System.out.println("it was not successful");
                    // TODO: 06.10.2017 handle error
                }
            }
        });
    }

    private void showShopFragment(List<ShopItem> shops) {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.items_container,
                ShopsFragment.newInstance(shops)).commit();
    }
}