package garu.chesibuttastaseraadimpruneta.firebase.dagger;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import garu.chesibuttastaseraadimpruneta.BuildConfig;
import garu.chesibuttastaseraadimpruneta.R;

/**
 * Created by garu on 08/09/17.
 */

@Module
public class FirebaseRemoteConfigDaggerModule {

    @Named("config_expiration")
    @Provides
    public long provideConfigurationDuration() {
        if (BuildConfig.DEBUG) {
            return 0;
        } else {
            return TimeUnit.HOURS.toMillis(6);
        }
    }

    @Provides
    public FirebaseRemoteConfigSettings provideFirebaseRemoteSettings() {
        return new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();
    }

    @Named("config_defaults")
    @Provides
    public int provideDefaults() {
        return R.xml.firebase_config_defaults;
    }

    @Provides
    public FirebaseRemoteConfig provideFirebaseRemoteConfig(@Named("config_defaults") int defaults, FirebaseRemoteConfigSettings settings) {
        FirebaseRemoteConfig instance = FirebaseRemoteConfig.getInstance();
        instance.setConfigSettings(settings);
        if (defaults > 0)
            instance.setDefaults(defaults);
        return instance;
    }

}
