package com.iteso.tarea4.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemProduct implements Parcelable{

    private int image;
    private String title;
    private String store;
    private String location;
    private String phone;
    private String description;
    private int code;

    public ItemProduct(){
        setImage(0);
        setTitle("");
        setStore("");
        setLocation("");
        setPhone("");
        setDescription("");
        setCode(0);

    }

    public ItemProduct(int image, String title, String store, String location, String phone, String description, int code) {
        setTitle(title);
        setImage(image);
        setStore(store);
        setLocation(location);
        setPhone(phone);
        setDescription(description);
        setCode(code);
    }

    protected ItemProduct(Parcel in) {
        image = in.readInt();
        title = in.readString();
        store = in.readString();
        location = in.readString();
        phone = in.readString();
        description = in.readString();
        code = in.readInt();
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCode() { return code; }

    public void setCode(int code) { this.code = code; }

    public static Creator<ItemProduct> getCreator() {return CREATOR; }

    public static final Parcelable.Creator<ItemProduct> CREATOR = new Parcelable.Creator<ItemProduct>() {

        @Override
        public ItemProduct createFromParcel(Parcel source) {
            return new ItemProduct(source);
        }

        @Override
        public ItemProduct[] newArray(int size) {
            return new ItemProduct[size];
        }
    };

    @Override
    public String toString() {
        return "ItemProduct{" +
                "title='" + title + '\'' +
                ", store='" + store + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image  +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(title);
        dest.writeString(store);
        dest.writeString(location);
        dest.writeString(phone);
        dest.writeString(description);
        dest.writeInt(code);
    }
}