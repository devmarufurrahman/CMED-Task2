package com.maruf.cmedtask2.viewmodels;


import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.maruf.cmedtask2.api.APIServices;
import com.maruf.cmedtask2.api.RetroInstance;
import com.maruf.cmedtask2.model.CharactersModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharactersListViewModel  extends ViewModel {
    private MutableLiveData<List<CharactersModel>> characterslist;

    public CharactersListViewModel(){
        characterslist=new MutableLiveData<>();
    }

    public MutableLiveData<List<CharactersModel>> getCharacterslistObserver()
    {
        return characterslist;
    }

    public void makeApiCall()
    {
        APIServices apiServices= RetroInstance.getRetroClient().create(APIServices.class);
        Call<List<CharactersModel>> call=apiServices.getCharacterList();
        call.enqueue(new Callback<List<CharactersModel>>() {
            @Override
            public void onResponse(Call<List<CharactersModel>> call, Response<List<CharactersModel>> response) {
                characterslist.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<CharactersModel>> call, Throwable t) {
                characterslist.postValue(null);
                Log.e("Error :",t.getMessage().toString());
            }
        });


    }
}
