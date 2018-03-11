package com.john.mvvmframework.view_model;

import com.john.mvvmframework.di.scope.PerActivity;
import com.john.mvvmframework.model.ui_request.BookEvent;
import com.john.mvvmframework.model.ui_response.BookUiModel;

import io.reactivex.ObservableTransformer;

public interface SplashHandler extends BaseHandler {

    ObservableTransformer<BookEvent,BookUiModel> bookEvent();
}
