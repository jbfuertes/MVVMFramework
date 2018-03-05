package com.john.mvvmframework.presenter;


import com.john.mvvmframework.interactor.DataManager;

import javax.inject.Inject;

/**
 * Created by john on 11/29/17.
 */

public class SplashPresenterImpl extends BasePresenterImpl implements SplashPresenter {


    @Inject
    SplashPresenterImpl(DataManager dataManager) {
        super(dataManager);
    }



}
