package com.john.mvvmframework.presenter;


import com.john.mvvmframework.interactor.DataManager;

/**
 * Created by john on 11/29/17.
 */

class BasePresenterImpl implements BasePresenter {


    private DataManager dataManager;

    BasePresenterImpl(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    DataManager getDataManager(){
        return dataManager;
    }

}
