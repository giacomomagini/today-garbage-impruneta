package garu.chesibuttastaseraadimpruneta.rx;

import com.google.android.gms.tasks.Task;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by garu on 09/09/17.
 */

public class TaskObservable<T> extends Observable<T> {

    public static <T> TaskObservable<T> from(Task<T> task) {
        return new TaskObservable<>(task);
    }

    private TaskObservable(Task<T> task) {
        this.task = task;
    }

    private final Task<T> task;

    @Override
    protected void subscribeActual(Observer<? super T> observer) {
        task.addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                observer.onNext(task.getResult());
                observer.onComplete();
            } else {
                observer.onError(task.getException());
            }
        });
    }

}
