package com.john.mvvmframework.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.john.mvvmframework.di.qualifier.ActivityContext;
import com.john.mvvmframework.di.scope.PerActivity;
import com.john.mvvmframework.presenter.SplashPresenter;
import com.john.mvvmframework.presenter.SplashPresenterImpl;
import com.john.mvvmframework.utils.rx.AppSchedulerProvider;
import com.john.mvvmframework.utils.rx.SchedulerProvider;
import com.john.mvvmframework.view_model.SplashHandler;
import com.john.mvvmframework.view_model.SplashHandlerImpl;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by john on 3/5/18.
 */

@Module
public class ActivityModule {

    private AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return activity;
    }

    @Provides
    AppCompatActivity provideActivity(){
        return activity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable(){
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider(){
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashPresenter provideSplashPresenter(SplashPresenterImpl presenter){
        return presenter;
    }

    @Provides
    @PerActivity
    SplashHandler provideSplashHandler(SplashHandlerImpl handler){
        return handler;
    }

    /*

     @Provides
    @PerActivity
    PromotionsAdapter providePromotionsAdapter(AppCompatActivity context,Picasso picasso){
        return new PromotionsAdapter(new ArrayList<>(),context,picasso);
    }
    */

}
