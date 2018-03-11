package com.john.mvvmframework.view_model;

import com.john.mvvmframework.model.action.CheckTimeAction;
import com.john.mvvmframework.model.action.SubmitAction;
import com.john.mvvmframework.model.result.BookResult;
import com.john.mvvmframework.model.ui_request.BookEvent;
import com.john.mvvmframework.model.ui_request.CheckTimeEvent;
import com.john.mvvmframework.model.ui_request.SubmitEvent;
import com.john.mvvmframework.model.ui_response.BookUiModel;
import com.john.mvvmframework.presenter.SplashPresenter;
import com.john.mvvmframework.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

public class SplashHandlerImpl extends BaseHandlerImpl
        implements SplashHandler{

    @Inject
    SplashPresenter presenter;

    private BookUiModel initialState = new BookUiModel(new ArrayList<>(),false,null);

    @Inject
    SplashHandlerImpl() {

    }


    @Override
    public ObservableTransformer<BookEvent, BookUiModel> bookEvent() {
        return bookEvent -> bookEvent.publish(shared ->
                Observable.merge(
                        shared.ofType(CheckTimeEvent.class)
                                .map(event -> new CheckTimeAction(event.time,event.timeOut))
                                .compose(presenter.checkTimeAction()),
                        shared.ofType(SubmitEvent.class)
                                .map(event -> new SubmitAction(event.time,event.timeOut,event.user))
                                .compose(presenter.submitAction())))
                .scan(initialState,(state,result) -> {
                    List<BookUiModel.BookDate> tempList = new ArrayList<>();
                    for (BookResult.BookDate date :result.bookDates){
                        tempList.add(new BookUiModel.BookDate(date.bookTime,date.checkOutTime,date.user));
                    }

                    return new BookUiModel(tempList,result.inFlight,result.errorMessage);


                }).doOnNext(model -> Timber.d(model.inProgress+""));
    }
}
