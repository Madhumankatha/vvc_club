package com.madhumankatha.kuvempuuniv.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.madhumankatha.kuvempuuniv.BR;

public class Event extends BaseObservable {

    @SerializedName("id")
    private long id;

    @SerializedName("title")
    private String title;

    @SerializedName("date")
    private String date;

    @SerializedName("author")
    private String author;

    @SerializedName("pdf")
    private String pdf;

    @SerializedName("img")
    private String img;

    @SerializedName("desc")
    private String desc;

    @SerializedName("category")
    private String category;

    @Bindable
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        notifyPropertyChanged(com.madhumankatha.kuvempuuniv.BR.id);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(com.madhumankatha.kuvempuuniv.BR.title);
    }

    @Bindable
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        notifyPropertyChanged(com.madhumankatha.kuvempuuniv.BR.date);
    }

    @Bindable
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
        notifyPropertyChanged(com.madhumankatha.kuvempuuniv.BR.author);
    }

    @Bindable
    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
        notifyPropertyChanged(com.madhumankatha.kuvempuuniv.BR.pdf);
    }

    @Bindable
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
        notifyPropertyChanged(com.madhumankatha.kuvempuuniv.BR.img);
    }

    @Bindable
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
        notifyPropertyChanged(com.madhumankatha.kuvempuuniv.BR.desc);
    }

    @Bindable
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
        notifyPropertyChanged(BR.category);
    }
}
