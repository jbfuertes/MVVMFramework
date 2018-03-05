package com.john.mvvmframework.ui.activities;

import android.os.Bundle;


import com.john.mvvmframework.R;
import com.john.mvvmframework.ui.views.SplashView;
import com.john.mvvmframework.view_model.SplashHandler;

import javax.inject.Inject;


public class ActivitySplash extends BaseActivity implements SplashView {


    @Inject
    SplashHandler handler;

    @Override
    protected void setUp() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO:
        setContentView(R.layout.activity_main);

       /* getActivityComponent().inject(this);*/

    }

    @Override
    public void userLoggedIn() {

    }

    @Override
    public void userLoggedOut() {

    }

    @Override
    public void onReloadUserData() {

    }

    /*@Override
    protected void onResume() {
        super.onResume();
        handler.onAttach(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.onDetach();
    }

    @Override
    public void userLoggedIn() {
        Intent intent = new Intent(ActivitySplash.this,ActivityMain.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void userLoggedOut() {
        Intent intent = new Intent(ActivitySplash.this,ActivityLogIn.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        handler.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onReloadUserData() {

    }*/



}
