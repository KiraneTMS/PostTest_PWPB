package com.example.posttest_pwpb;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {

    String tanggal;
    String dataid;
    String datatitle;
    String dataisi;


    public Data(){

    }

    public Data(String tanggal, String dataid, String datatitle, String dataisi) {
        this.tanggal = tanggal;
        this.dataid = dataid;
        this.datatitle = datatitle;
        this.dataisi = dataisi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getDataid() {
        return dataid;
    }

    public String getDatatitle() {
        return datatitle;
    }

    public String getDataisi() {
        return dataisi;
    }

    //aaaaaaaaaaaaaaaaaaaaaaaa

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tanggal);
        dest.writeString(this.dataid);
        dest.writeString(this.datatitle);
        dest.writeString(this.dataisi);
    }

    protected Data(Parcel in) {
        this.tanggal = in.readString();
        this.dataid = in.readString();
        this.datatitle = in.readString();
        this.dataisi = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel source) {
            return new Data(source);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };
}
