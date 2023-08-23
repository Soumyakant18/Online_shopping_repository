package com.example.soumyakant_menu_activity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class pojo implements Parcelable {
    String description;
    private int imageprd;
    private int imagecart;
    private String textbrand;
    private String textdesc;
    private String textprice;

    public pojo(int imageprd, int imagecart, String textbrand, String textdesc, String textprice) {
        this.imageprd = imageprd;
        this.imagecart = imagecart;
        this.textbrand = textbrand;
        this.textdesc = textdesc;
        this.textprice = textprice;
    }

    protected pojo(Parcel in) {
        description = in.readString ( );
        imageprd = in.readInt ( );
        imagecart = in.readInt ( );
        textbrand = in.readString ( );
        textdesc = in.readString ( );
        textprice = in.readString ( );
    }

    public static final Creator<pojo> CREATOR = new Creator<pojo> ( ) {
        @Override
        public pojo createFromParcel(Parcel in) {
            return new pojo (in);
        }

        @Override
        public pojo[] newArray(int size) {
            return new pojo[size];
        }
    };

    public int getImagecart() {
        return imagecart;
    }


    public void setImagecart(int imagecart) {
        this.imagecart = imagecart;
    }

    public int getImageprd() {
        return imageprd;
    }

    public void setImageprd(int imageprd) {
        this.imageprd = imageprd;
    }

    public String getTextbrand() {
        return textbrand;
    }

    public void setTextbrand(String textbrand) {
        this.textbrand = textbrand;
    }

    public String getTextdesc() {
        return textdesc;
    }

    public void setTextdesc(String textdesc) {
        this.textdesc = textdesc;
    }

    public String getTextprice() {
        return textprice;
    }

    public void setTextprice(String textprice) {
        this.textprice = textprice;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString (description);
        parcel.writeInt (imageprd);
        parcel.writeInt (imagecart);
        parcel.writeString (textbrand);
        parcel.writeString (textdesc);
        parcel.writeString (textprice);
    }
}