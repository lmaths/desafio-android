package com.rightside.tembicimatheuslima.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
    public static void showCircleImage(Context context, ImageView imageView, String url){
        Glide.with(context).load(url).circleCrop().into(imageView);
    }

    public static String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String data = format.format(date);
        return data;
    }

    public static void showAlert(String tittle, String message, Context context, Activity activity) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle(tittle).setMessage(message).setNeutralButton("Ok", (dialogInterface, i) -> {
            dialogInterface.dismiss();
            activity.finish();
        }).show();
    }
}
