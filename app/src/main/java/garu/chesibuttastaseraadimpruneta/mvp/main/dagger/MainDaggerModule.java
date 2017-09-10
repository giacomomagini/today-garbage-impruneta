package garu.chesibuttastaseraadimpruneta.mvp.main.dagger;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import garu.chesibuttastaseraadimpruneta.mvp.main.MainModel;
import garu.chesibuttastaseraadimpruneta.mvp.main.MainModelFirebase;
import garu.chesibuttastaseraadimpruneta.mvp.main.MainPresenter;
import garu.chesibuttastaseraadimpruneta.schedule.providers.GarbageScheduleProvider;

/**
 * Created by garu on 09/09/17.
 */

@Module
public class MainDaggerModule {

    @Provides
    public MainModel provideMainModel(
            GarbageScheduleProvider scheduleProvider,
            FirebaseRemoteConfig config,
            @Named("config_expiration") long configExpiration,
            Gson gson) {
        return new MainModelFirebase(scheduleProvider, config, configExpiration, gson);
    }

    @Provides
    public MainPresenter provideMainPresenter(MainModel model) {
        return new MainPresenter(model);
    }

}
