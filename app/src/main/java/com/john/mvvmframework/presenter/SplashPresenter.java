package com.john.mvvmframework.presenter;

import com.john.mvvmframework.model.action.CheckTimeAction;
import com.john.mvvmframework.model.action.SubmitAction;
import com.john.mvvmframework.model.result.BookResult;

import io.reactivex.ObservableTransformer;

/**
 * Created by john on 11/29/17.
 */

public interface SplashPresenter extends BasePresenter {


    ObservableTransformer<CheckTimeAction,BookResult> checkTimeAction();

    ObservableTransformer<SubmitAction,BookResult> submitAction();
}
