/**
 * Copyright (C) 2015 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.hackvg.android;

import android.app.Application;

import com.hackvg.android.di.components.AppComponent;
import com.hackvg.android.di.components.DaggerAppComponent;
import com.hackvg.android.di.modules.ApplicationModule;
import com.hackvg.android.di.modules.DomainModule;


public class MoviesApp extends Application {

    private AppComponent mAppComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeDependencyInjector();
    }

    private void initializeDependencyInjector() {

        mAppComponent = DaggerAppComponent.builder()
            .applicationModule(new ApplicationModule(this))
            .domainModule(new DomainModule())
            .build();
    }

    public AppComponent getAppComponent() {

        return mAppComponent;
    }
}
