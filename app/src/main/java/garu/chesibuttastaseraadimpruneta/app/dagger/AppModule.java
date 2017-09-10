package garu.chesibuttastaseraadimpruneta.app.dagger;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Created by garu on 08/09/17.
 */

@Module
public class AppModule {

    public static AppModule create(Application application) {
        return new AppModule(application);
    }

    private final Application application;

    private AppModule(Application application) {
        this.application = application;
    }

    @Provides
    public Application provideApplication() {
        return application;
    }


}
