package garu.chesibuttastaseraadimpruneta.firebase.dagger;

import android.content.Context;

import com.google.firebase.analytics.FirebaseAnalytics;

import dagger.Module;
import dagger.Provides;
import garu.chesibuttastaseraadimpruneta.firebase.FirebaseAnalyticsHelper;

/**
 * Created by garu on 10/09/17.
 */

@Module
public class FirebaseAnalyticsDaggerModule {

    @Provides
    public FirebaseAnalytics provideFirebaseAnalytics(Context context){
        return FirebaseAnalytics.getInstance(context);
    }

    @Provides
    public FirebaseAnalyticsHelper provideAnalyticsHelper(FirebaseAnalytics analytics){
        return new FirebaseAnalyticsHelper(analytics);
    }

}
