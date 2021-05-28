package com.ClaVis.clavis.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Stats implements Serializable {
    private String name;
    private String info;
    private String photo;
    private Bitmap bitmap;
    private List<Stats> list;

    @Override
    public String toString() {
        return "Stats{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", photo='" + photo + '\'' +
                ", list=" + list +
                '}';
    }

    public Stats(String name, String info, String photo) {
        this.name = name;
        this.info = info;
        this.photo = photo;
        list = new ArrayList<>();
    }

    public Stats(String name, String info, String photo, Context context, Integer res) {
        this.name = name;
        this.info = info;
        this.photo = photo;
        list = new ArrayList<>();
        this.bitmap = BitmapFactory.decodeResource(context.getResources(),
                res);
    }

    public void setBitmap(Context context, Integer res) {
        this.bitmap = BitmapFactory.decodeResource(context.getResources(),
                res);
    }



    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public String getPhoto() {
        return photo;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public List<Stats> getList() {
        return list;
    }

    public void setList(List<Stats> list) {
        this.list = list;
    }
}
