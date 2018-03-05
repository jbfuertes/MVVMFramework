package com.john.mvvmframework.di.component;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.john.mvvmframework.App;
import com.john.mvvmframework.di.module.ApplicationModule;
import com.john.mvvmframework.di.qualifier.ApplicationContext;
import com.john.mvvmframework.interactor.DataManager;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by john on 3/5/18.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(App app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager datamanager();

    Gson gson();

    Picasso picasso();

}
