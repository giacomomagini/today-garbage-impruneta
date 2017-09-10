package garu.chesibuttastaseraadimpruneta.mvp.main;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;

import garu.chesibuttastaseraadimpruneta.BuildConfig;
import garu.chesibuttastaseraadimpruneta.rx.TaskObservable;
import garu.chesibuttastaseraadimpruneta.schedule.GarbageSchedule;
import garu.chesibuttastaseraadimpruneta.schedule.providers.GarbageScheduleProvider;
import garu.chesibuttastaseraadimpruneta.schedule.GarbageType;
import io.reactivex.Observable;
import timber.log.Timber;

/**
 * Created by garu on 08/09/17.
 */

public class MainModelFirebase implements MainModel {

    private GarbageScheduleProvider scheduleProvider;

    private FirebaseRemoteConfig remoteConfig;

    private Gson gson;

    private long configExpiration;

    public MainModelFirebase(GarbageScheduleProvider scheduleProvider, FirebaseRemoteConfig remoteConfig, long configExpiration, Gson gson) {
        this.scheduleProvider = scheduleProvider;
        this.remoteConfig = remoteConfig;
        this.configExpiration = configExpiration;
        this.gson = gson;
    }

    @Override
    public Observable<GarbageType[]> getGarbageSchedule(long epoch) {
        String json = remoteConfig.getString(BuildConfig.SCHEDULE_KEY);
        GarbageSchedule garbageSchedule = gson.fromJson(json, GarbageSchedule.class);
        return Observable.just(
                scheduleProvider.getGarbageTypes(epoch, garbageSchedule)
        );
    }

    @Override
    public void updateSchedule() {
        TaskObservable.from(remoteConfig.fetch(this.configExpiration))
                .subscribe(result -> {
                    Timber.i("Updated remote config, next update in %d ms", this.configExpiration);
                    remoteConfig.activateFetched();
                }, Timber::e);
    }
}
