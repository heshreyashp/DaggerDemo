package com.example.daggerdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductResponse implements Parcelable {

    @SerializedName("products")
    private List<ProductList> products;

    @SerializedName("total")
    private String total;
    @SerializedName("limit")
    private int limit;
    @SerializedName("skip")
    private int skip;


    protected ProductResponse(Parcel in) {
        products = in.createTypedArrayList(ProductList.CREATOR);
        total = in.readString();
        limit = in.readInt();
        skip = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(products);
        dest.writeString(total);
        dest.writeInt(limit);
        dest.writeInt(skip);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProductResponse> CREATOR = new Creator<ProductResponse>() {
        @Override
        public ProductResponse createFromParcel(Parcel in) {
            return new ProductResponse(in);
        }

        @Override
        public ProductResponse[] newArray(int size) {
            return new ProductResponse[size];
        }
    };

    public List<ProductList> getProducts() {
        return products;
    }

    public void setProducts(List<ProductList> products) {
        this.products = products;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }
}
