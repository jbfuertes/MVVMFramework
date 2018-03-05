package com.john.mvvmframework.view_model;

import com.john.mvvmframework.presenter.SplashPresenter;
import com.john.mvvmframework.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SplashHandlerImpl extends BaseHandlerImpl
        implements SplashHandler{

    @Inject
    SplashPresenter presenter;

    @Inject
    SplashHandlerImpl(SchedulerProvider schedulerProvider,
                      CompositeDisposable compositeDisposable) {
        super(schedulerProvider, compositeDisposable);
    }




}
