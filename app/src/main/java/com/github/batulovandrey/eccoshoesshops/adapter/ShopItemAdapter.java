package com.github.batulovandrey.eccoshoesshops.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.batulovandrey.eccoshoesshops.R;
import com.github.batulovandrey.eccoshoesshops.bean.ShopItem;

import java.util.List;

/**
 * @author Andrey Batulov on 08/10/2017
 */

public class ShopItemAdapter extends RecyclerView.Adapter<ShopItemViewHolder> {

    private final List<ShopItem> mShops;
    private final OnShopItemClickListener mClickListener;

    public ShopItemAdapter(List<ShopItem> shops, OnShopItemClickListener clickListener) {
        mShops = shops;
        mClickListener = clickListener;
    }

    @Override
    public ShopItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item, parent, false);
        return new ShopItemViewHolder(view, mClickListener);
    }

    @Override
    public void onBindViewHolder(ShopItemViewHolder holder, int position) {
        ShopItem item = mShops.get(position);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(item.getName()).append(" ")
                .append(item.getTown()).append(" ")
                .append(item.getMetro()).append(" ")
                .append(item.getAddress()).append(" ")
                .append(item.getPhone());
        holder.setAddress(stringBuilder.toString());
    }

    @Override
    public int getItemCount() {
        return mShops.size();
    }
}