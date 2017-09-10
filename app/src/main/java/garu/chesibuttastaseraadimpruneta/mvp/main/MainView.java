package garu.chesibuttastaseraadimpruneta.mvp.main;

import garu.chesibuttastaseraadimpruneta.schedule.GarbageType;

/**
 * Created by garu on 08/09/17.
 */

public interface MainView {

    void showSchedule(GarbageType[] garbageTypes);

    void showError(Throwable throwable);

}
