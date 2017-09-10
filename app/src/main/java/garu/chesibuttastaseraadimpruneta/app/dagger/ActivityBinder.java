package garu.chesibuttastaseraadimpruneta.app.dagger;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import garu.chesibuttastaseraadimpruneta.MainActivity;

/**
 * Created by garu on 08/09/17.
 */

@Module
public abstract class ActivityBinder {
    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivityInjector();
}
