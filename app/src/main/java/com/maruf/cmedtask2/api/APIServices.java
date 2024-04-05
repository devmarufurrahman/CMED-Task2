package com.maruf.cmedtask2.api;

import com.maruf.cmedtask2.model.CharactersModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServices {
    @GET("getAllMemberData.php")
    Call<List<CharactersModel>> getCharacterList();
}
