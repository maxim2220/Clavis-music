package com.ClaVis.clavis.retrofit_util;

import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.GET;

public interface ClientAPI {
    @GET
    Callback<Void> getStringer(@Field("str")String str);
}
