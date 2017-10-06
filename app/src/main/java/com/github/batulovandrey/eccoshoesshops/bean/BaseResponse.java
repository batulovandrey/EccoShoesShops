package com.github.batulovandrey.eccoshoesshops.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import java.util.List;

/**
 * @author Andrey Batulov on 06/10/2017
 */

public class BaseResponse {

    @JsonProperty("meta")
    private Meta mMeta;

    @JsonProperty("data")
    private List<ShopItem> mShops;

    public BaseResponse() {}

    public Meta getMeta() {
        return mMeta;
    }

    public List<ShopItem> getShops() {
        return mShops;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseResponse that = (BaseResponse) o;
        return Objects.equal(mMeta, that.mMeta) &&
                Objects.equal(mShops, that.mShops);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mMeta, mShops);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("mMeta", mMeta)
                .add("mShops", mShops)
                .toString();
    }
}