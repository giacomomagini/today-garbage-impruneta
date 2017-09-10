package garu.chesibuttastaseraadimpruneta.app;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import garu.chesibuttastaseraadimpruneta.BuildConfig;
import garu.chesibuttastaseraadimpruneta.app.dagger.AppModule;
import garu.chesibuttastaseraadimpruneta.app.dagger.DaggerAppComponent;
import garu.chesibuttastaseraadimpruneta.app.timber.ProductionLogger;
import timber.log.Timber;

/**
 * Created by garu on 08/09/17.
 */

public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> androidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        setupDagger();
        setupTimber();
    }

    private void setupDagger() {
        DaggerAppComponent.builder()
                .appModule(AppModule.create(this))
                .build().inject(this);
    }

    private void setupTimber() {
        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }else{
            Timber.plant(ProductionLogger.create());
        }
    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return androidInjector;
    }

}
