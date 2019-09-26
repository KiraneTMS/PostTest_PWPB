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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
