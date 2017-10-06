package com.github.batulovandrey.eccoshoesshops.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * @author Andrey Batulov on 06/10/2017
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopItem {

    @JsonProperty("name")
    private String mName;

    @JsonProperty("town")
    private String mTown;

    @JsonProperty("address")
    private String mAddress;

    @JsonProperty("metro")
    private String mMetro;

    @JsonProperty("phone")
    private String mPhone;

    @JsonProperty("worktime")
    private String mWorkTime;

    @JsonProperty("longtitude")
    private double mLongitude;

    @JsonProperty("latitude")
    private double mLatitude;

    public ShopItem() {
    }

    public String getName() {
        return mName;
    }

    public String getTown() {
        return mTown;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getMetro() {
        return mMetro;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getWorkTime() {
        return mWorkTime;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public double getLatitude() {
        return mLatitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopItem shopItem = (ShopItem) o;
        return Double.compare(shopItem.mLongitude, mLongitude) == 0 &&
                Double.compare(shopItem.mLatitude, mLatitude) == 0 &&
                Objects.equal(mName, shopItem.mName) &&
                Objects.equal(mTown, shopItem.mTown) &&
                Objects.equal(mAddress, shopItem.mAddress) &&
                Objects.equal(mMetro, shopItem.mMetro) &&
                Objects.equal(mPhone, shopItem.mPhone) &&
                Objects.equal(mWorkTime, shopItem.mWorkTime);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mName, mTown, mAddress, mMetro, mPhone, mWorkTime, mLongitude, mLatitude);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("mName", mName)
                .add("mTown", mTown)
                .add("mAddress", mAddress)
                .add("mMetro", mMetro)
                .add("mPhone", mPhone)
                .add("mWorkTime", mWorkTime)
                .add("mLongitude", mLongitude)
                .add("mLatitude", mLatitude)
                .toString();
    }
}