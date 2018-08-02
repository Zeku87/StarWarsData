package com.demo.joseezequielgallardo.starwarsdata.network;

import com.demo.joseezequielgallardo.starwarsdata.model.CharactersResponse;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class CharactersRemoteDataSource implements ICharactersRemoteDataSource {

    private ICharactersRemoteDataSource api;
    private final String URL = "http://swapi.co/api/";

    public CharactersRemoteDataSource(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        this.api = retrofit.create(ICharactersRemoteDataSource.class);
    }

    @Override
    public Observable<CharactersResponse> getCharacters() {
        return this.api.getCharacters();
    }
}
