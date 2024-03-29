package com.hfad.fortnitestats;

import android.os.Parcel;
import android.os.Parcelable;

public class Stat implements Parcelable {

    private String key;
    private String value;

    public Stat(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Stat{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }


    protected Stat(Parcel in) {
        key = in.readString();
        value = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(key);
        dest.writeString(value);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Stat> CREATOR = new Parcelable.Creator<Stat>() {
        @Override
        public Stat createFromParcel(Parcel in) {
            return new Stat(in);
        }

        @Override
        public Stat[] newArray(int size) {
            return new Stat[size];
        }
    };
}