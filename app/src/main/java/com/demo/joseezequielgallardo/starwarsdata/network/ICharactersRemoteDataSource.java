package com.demo.joseezequielgallardo.starwarsdata.network;

import com.demo.joseezequielgallardo.starwarsdata.model.CharactersResponse;

import retrofit2.http.GET;

public interface ICharactersRemoteDataSource {

    @GET("people/")
    rx.Observable<CharactersResponse> getCharacters();
}
