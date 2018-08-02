package com.demo.joseezequielgallardo.starwarsdata.presenter;

public interface IPresenter {
    public void loadData();
    public void subscribe();
    public void unsubscribe();
    public void onDestroy();
}
