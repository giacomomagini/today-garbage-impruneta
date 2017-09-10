package garu.chesibuttastaseraadimpruneta.mvp.main;

import garu.chesibuttastaseraadimpruneta.mvp.common.Presenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by garu on 08/09/17.
 */

public class MainPresenter extends Presenter<MainModel, MainView> {

    public MainPresenter(MainModel model, MainView view) {
        super(model, view);
    }

    public MainPresenter(MainModel model) {
        super(model);
    }

    public void onCreate(){
        getModel().updateSchedule();
    }

    public void showTodaySchedule() {
        showSchedule(System.currentTimeMillis());
    }

    public void showSchedule(long epoch) {
        getModel().getGarbageSchedule(epoch)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getView()::showSchedule, getView()::showError);
    }

}
