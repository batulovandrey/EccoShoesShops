package com.github.batulovandrey.eccoshoesshops;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.batulovandrey.eccoshoesshops.adapter.OnShopItemClickListener;
import com.github.batulovandrey.eccoshoesshops.adapter.ShopItemAdapter;
import com.github.batulovandrey.eccoshoesshops.bean.ShopItem;

import java.util.ArrayList;
import java.util.List;

public class ShopsFragment extends Fragment implements OnShopItemClickListener {

    private static final String EXTRA_SHOPS  = "shops";

    private List<ShopItem> mShops;
    private ShopItemAdapter mAdapter;
    private OnShopItemClickListener mClickListener;

    public ShopsFragment() {
        // Required empty public constructor
    }

    public static ShopsFragment newInstance(List<ShopItem> shops) {
        ShopsFragment fragment = new ShopsFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(EXTRA_SHOPS, (ArrayList<? extends Parcelable>) shops);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mShops = getArguments().getParcelableArrayList(EXTRA_SHOPS);
            mAdapter = new ShopItemAdapter(mShops, this);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shops, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
            mClickListener = (OnShopItemClickListener) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mClickListener = null;
    }

    @Override
    public void onItemClick(int position) {
        if (mClickListener != null) {
            mClickListener.onFragmentInteraction(mShops.get(position));
        }
    }

    public interface OnShopItemClickListener {
        void onFragmentInteraction(ShopItem item);
    }
}