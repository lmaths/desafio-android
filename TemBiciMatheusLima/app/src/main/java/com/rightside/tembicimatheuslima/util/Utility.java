package com.rightside.tembicimatheuslima.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Utility {
    public static void showCircleImage(Context context, ImageView imageView, String url){
        Glide.with(context).load(url).circleCrop().into(imageView);
    }
}
