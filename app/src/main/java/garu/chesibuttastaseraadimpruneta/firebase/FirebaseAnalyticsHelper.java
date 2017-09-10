package garu.chesibuttastaseraadimpruneta.firebase;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by garu on 10/09/17.
 */

public class FirebaseAnalyticsHelper {

    private FirebaseAnalytics analytics;

    public FirebaseAnalyticsHelper(FirebaseAnalytics analytics) {
        this.analytics = analytics;
    }

    public void logEvent(String event) {
        this.logEvent(event, new Bundle());
    }

    public void logEvent(String event, String payloadKey, String payloadValue) {
        Bundle bundle = new Bundle();
        bundle.putString(payloadKey, payloadValue);
        this.logEvent(event, bundle);
    }

    public void logEvent(String event, Bundle params) {
        this.analytics.logEvent(event, params);
    }

}
