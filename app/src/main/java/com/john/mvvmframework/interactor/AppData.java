package com.john.mvvmframework.interactor;


import com.google.gson.Gson;
import com.john.mvvmframework.repository.HostSelectionInterceptor;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by john on 11/28/17.
 */

@Singleton
public class AppData implements DataManager{


    private Gson gson;

    private Map<String,Integer > orderMap;

    @Inject
    HostSelectionInterceptor interceptor;

    @Inject
    AppData(/*PromotionManager promotionManager,*/ Gson gson) {

        this.gson = gson;

    }

}
