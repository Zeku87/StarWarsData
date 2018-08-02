package com.demo.joseezequielgallardo.starwarsdata;

import com.demo.joseezequielgallardo.starwarsdata.model.CharactersResponse;
import com.demo.joseezequielgallardo.starwarsdata.network.ICharactersRemoteDataSource;
import com.demo.joseezequielgallardo.starwarsdata.presenter.Presenter;
import com.demo.joseezequielgallardo.starwarsdata.view.IView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import rx.Observable;
import rx.schedulers.Schedulers;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Test cases
 *
 * Given the presenter has requested data and its data source has returned
 * the characters data successfully, I want to verify if the view receives it.
 *
 * Given the presenter has requested data and somehow the data source has returned error,
 * I want to verify if the view receives the proper feedback.
 */
public class PresenterTest {

    @Mock
    private ICharactersRemoteDataSource iCharactersRemoteDataSource;

    @Mock
    private IView view;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(PresenterTest.this);
    }

    @Test
    public void fetchDataAndLoadIntoView(){
        CharactersResponse charactersResponse =
                new CharactersResponse(0, null, null, null);

        when(iCharactersRemoteDataSource.getCharacters())
                .thenReturn(Observable.just(charactersResponse));

        Presenter presenter = new Presenter(
                this.iCharactersRemoteDataSource,
                Schedulers.immediate(),
                Schedulers.immediate(),
                this.view
        );

        presenter.loadData();

        InOrder inOrder = Mockito.inOrder(view);
        inOrder.verify(view, times(1)).onFetchDataStarted();
        inOrder.verify(view, times(1)).onFetchDataSuccess(charactersResponse);
        inOrder.verify(view, times(1)).onFetchDataCompleted();
    }

    //onFetchDataCompleted is never invoked
    @Test
    public void fetchErrorAndLoadIntoView(){
        Exception e = new Exception();

        when(iCharactersRemoteDataSource.getCharacters())
                .thenReturn(Observable.<CharactersResponse>error(e));

        Presenter presenter = new Presenter(
                iCharactersRemoteDataSource,
                Schedulers.immediate(),
                Schedulers.immediate(),
                view
        );

        presenter.loadData();

        InOrder inOrder = Mockito.inOrder(view);
        inOrder.verify(view, times(1)).onFetchDataStarted();
        inOrder.verify(view, times(1)).onFetchDataError(e);
        inOrder.verify(view, never()).onFetchDataCompleted();

    }
}