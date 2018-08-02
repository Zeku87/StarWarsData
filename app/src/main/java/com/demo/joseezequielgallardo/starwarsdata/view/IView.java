package com.demo.joseezequielgallardo.starwarsdata.view;

import com.demo.joseezequielgallardo.starwarsdata.model.CharactersResponse;

public interface IView {
    public void onFetchDataStarted();
    public void onFetchDataCompleted();
    public void onFetchDataSuccess(CharactersResponse charactersResponse);
    public void onFetchDataError(Throwable e);
}
