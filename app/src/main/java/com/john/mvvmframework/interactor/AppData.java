package com.john.mvvmframework.interactor;


import com.google.gson.Gson;
import com.john.mvvmframework.repository.HostSelectionInterceptor;


import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * Created by john on 11/28/17.
 */

@Singleton
public class AppData implements DataManager{

    private Gson gson;

    @Inject
    HostSelectionInterceptor interceptor;

    @Inject
    AppData(Gson gson) {

        this.gson = gson;

    }

}
