package com.example.asusx550jx.androidtraining_2.Interface;

import com.example.asusx550jx.androidtraining_2.Model.ResponseModel;

/**
 * Created by Asus X550JX on 12/20/2017.
 */

public interface BiodataViewInterface {
    void showLoading();
    void hideLoading();
    void onFinishinsert(ResponseModel res);
    void onFailureinsert();

    void log(String l);
}
