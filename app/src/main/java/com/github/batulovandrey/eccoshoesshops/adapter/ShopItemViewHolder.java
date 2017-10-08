package com.github.batulovandrey.eccoshoesshops.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.batulovandrey.eccoshoesshops.R;

/**
 * @author Andrey Batulov on 08/10/2017
 */

public class ShopItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private OnShopItemClickListener mClickListener;
    private TextView mAddressTextView;

    public ShopItemViewHolder(View itemView, OnShopItemClickListener listener) {
        super(itemView);
        mClickListener = listener;
        itemView.setOnClickListener(this);
        mAddressTextView = (TextView) itemView.findViewById(R.id.address_text_view);
    }

    public void setAddress(String text) {
        mAddressTextView.setText(text);
    }

    @Override
    public void onClick(View view) {
        mClickListener.onItemClick(getLayoutPosition());
    }
}