package garu.chesibuttastaseraadimpruneta.app.dagger;

import dagger.Component;
import garu.chesibuttastaseraadimpruneta.app.App;
import garu.chesibuttastaseraadimpruneta.firebase.dagger.FirebaseRemoteConfigDaggerModule;
import garu.chesibuttastaseraadimpruneta.mvp.main.dagger.MainDaggerModule;
import garu.chesibuttastaseraadimpruneta.schedule.dagger.ScheduleDaggerModule;

/**
 * Created by garu on 08/09/17.
 */

@Component(modules = {
        AppModule.class,
        ActivityBinder.class,
        FirebaseRemoteConfigDaggerModule.class,
        CommonsModule.class,
        ScheduleDaggerModule.class,
        MainDaggerModule.class
})
public interface AppComponent {
    void inject(App app);
}
