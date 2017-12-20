package com.example.asusx550jx.androidtraining_2.Presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.asusx550jx.androidtraining_2.Interface.BiodataPresenterInterface;
import com.example.asusx550jx.androidtraining_2.Interface.BiodataViewInterface;
import com.example.asusx550jx.androidtraining_2.Model.APIRequest;
import com.example.asusx550jx.androidtraining_2.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Asus X550JX on 12/20/2017.
 */

public class BiodataPresenter implements BiodataPresenterInterface {
    private BiodataViewInterface BVI;
    private APIRequest api;

    public BiodataPresenter(BiodataViewInterface BVI, APIRequest api) {
        this.BVI = BVI;
        this.api = api;
    }

    @Override
    public void doBiodata(String fullname, String name, String borndate, String bornplace, String gender, String address, String phone, String email) {
        BVI.showLoading();
        BVI.log("init");

        Call<ResponseModel> send = api.sendBiodata(fullname,name,borndate,bornplace,gender,address,phone,email);
        send.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                ResponseModel res = response.body();
                if(res.getCode()==1){
                    BVI.onFailureinsert();
                } else {
                    BVI.onFinishinsert(res);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                BVI.hideLoading();
                Log.d("Base", "Failure"+"Gagal mengirim request");

                //Toast.makeText(BiodataPresenter.this, "Failure", Toast.LENGTH_LONG).show();
            }
        });
    }
}
