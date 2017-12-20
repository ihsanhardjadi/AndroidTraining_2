package com.example.asusx550jx.androidtraining_2.Model;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Asus X550JX on 12/20/2017.
 */

public class BaseActivity extends AppCompatActivity {
    private APIRequest api;
    private static final String URL = "http://192.168.137.1/Pelatihan/";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(interceptor);

        Retrofit base = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
        api = base.create(APIRequest.class);
    }

    public APIRequest getAPI() {
        return api;
    }

    public void makeErrorDialog(String msg){
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setMessage(msg);
        adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                arg0.dismiss();
            }
        });
        AlertDialog al = adb.create();
        al.show();
    }
    public void log(String log){
        if(true){
            Log.d("Biodata",log);
        }
    }
}

