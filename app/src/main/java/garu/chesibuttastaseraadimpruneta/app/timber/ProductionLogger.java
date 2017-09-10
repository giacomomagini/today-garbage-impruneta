package garu.chesibuttastaseraadimpruneta.app.timber;

import android.util.Log;

import com.google.firebase.crash.FirebaseCrash;

import timber.log.Timber;

/**
 * Created by garu on 08/09/17.
 */

public class ProductionLogger extends Timber.Tree {

    public static Timber.Tree create() {
        return new ProductionLogger();
    }

    @Override
    protected void log(int priority, String tag, String message, Throwable throwable) {
        if (priority == Log.INFO) {
            Log.i(tag, message);
        } else if (priority == Log.WARN) {
            Log.w(tag, message);
        } else if (priority == Log.ERROR) {
            handleError(tag, message, throwable);
        }
    }

    private void handleError(String tag, String message, Throwable throwable) {
        if (throwable != null) {
            Log.e(tag, message, throwable);
            FirebaseCrash.report(throwable);
        } else {
            Log.e(tag, message);
            FirebaseCrash.log(message);
        }
    }

}
