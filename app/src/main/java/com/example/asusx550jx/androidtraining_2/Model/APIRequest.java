package com.example.asusx550jx.androidtraining_2.Model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Asus X550JX on 12/20/2017.
 */

public interface APIRequest {
    @FormUrlEncoded
    @POST("insertbiodata.php")
    Call<ResponseModel> sendBiodata(@Field("fullname")String fullname,
                                    @Field("name")String name,
                                    @Field("borndate")String borndate,
                                    @Field("bornplace")String bornplace,
                                    @Field("gender")String gender,
                                    @Field("address")String address,
                                    @Field("phone")String phone,
                                    @Field("email")String email);
}
