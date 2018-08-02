package com.demo.joseezequielgallardo.starwarsdata.presenter;

import com.demo.joseezequielgallardo.starwarsdata.model.CharactersResponse;
import com.demo.joseezequielgallardo.starwarsdata.network.ICharactersRemoteDataSource;
import com.demo.joseezequielgallardo.starwarsdata.view.IView;

import io.reactivex.annotations.NonNull;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class Presenter implements IPresenter {

    @NonNull
    private ICharactersRemoteDataSource iCharactersRemoteDataSource;

    @NonNull
    private rx.Scheduler backgroundScheduler;

    @NonNull
    private rx.Scheduler mainScheduler;

    @NonNull
    private CompositeSubscription compositeSubscription;

    private IView view;

    public Presenter(ICharactersRemoteDataSource iCharactersRemoteDataSource, rx.Scheduler backgroundScheduler, rx.Scheduler mainScheduler, IView view) {
        this.iCharactersRemoteDataSource = iCharactersRemoteDataSource;
        this.backgroundScheduler = backgroundScheduler;
        this.mainScheduler = mainScheduler;
        this.view = view;
        this.compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void loadData() {
        view.onFetchDataStarted();
        compositeSubscription.clear();

        Subscription subscription = iCharactersRemoteDataSource
                .getCharacters()
                .subscribeOn(backgroundScheduler)
                .observeOn(mainScheduler)
                .subscribe(new Observer<CharactersResponse>() {
                    @Override
                    public void onCompleted() {
                        view.onFetchDataCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onFetchDataError(e);
                    }

                    @Override
                    public void onNext(CharactersResponse charactersResponse) {
                        view.onFetchDataSuccess(charactersResponse);
                    }
                });

        compositeSubscription.add(subscription);

    }

    @Override
    public void subscribe() {
        loadData();
    }

    @Override
    public void unsubscribe() {
        compositeSubscription.clear();
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }
}
