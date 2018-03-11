package com.john.mvvmframework.presenter;


import com.john.mvvmframework.interactor.DataManager;
import com.john.mvvmframework.model.action.CheckTimeAction;
import com.john.mvvmframework.model.action.SubmitAction;
import com.john.mvvmframework.model.result.BookResult;
import com.john.mvvmframework.utils.AppConstants;
import com.john.mvvmframework.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import timber.log.Timber;

/**
 * Created by john on 11/29/17.
 */

public class SplashPresenterImpl extends BasePresenterImpl implements SplashPresenter {

    private List<BookResult.BookDate> cachedList = new ArrayList<>();


    @Inject
    SplashPresenterImpl(DataManager dataManager) {
        super(dataManager);
    }


    @Override
    public ObservableTransformer<CheckTimeAction, BookResult> checkTimeAction() {
        return checkTimeAction -> checkTimeAction
                .flatMap(action -> {
                    if (TimeUtils.compareTime(
                            AppConstants.DATE_FORMAT_3,
                            action.bookTime,
                            action.checkOutTime) == 1){

                        return Observable.just(new BookResult(
                                false,
                                true,
                                cachedList,
                                "Invalid Time"));

                    }else {
                        return Observable.fromIterable(cachedList)
                                .map(item ->
                                        TimeUtils.isDateOverlap(
                                                item.bookTime,
                                                item.checkOutTime,
                                                action.bookTime,
                                                action.checkOutTime,
                                                AppConstants.DATE_FORMAT_3))
                                .defaultIfEmpty(false)
                                .map(isOccupied ->
                                        new BookResult(false,isOccupied,cachedList,isOccupied?"Time Occupied":null))
                                .startWith(new BookResult(true,false,cachedList,null));
                    }
                });
    }

    @Override
    public ObservableTransformer<SubmitAction, BookResult> submitAction() {
        return submitAction -> submitAction
                .flatMap(action ->
                    Observable.just(action)
                            .map(action1 -> {
                                cachedList.add(
                                        new BookResult.BookDate(
                                                action.checkInTime,
                                                action.checkOutTime,
                                                action.user));
                                return new BookResult(false,false,cachedList,null);
                            })
                            .startWith(new BookResult(true,false,cachedList,null)));
    }
}
