package garu.chesibuttastaseraadimpruneta.mvp.main;

import garu.chesibuttastaseraadimpruneta.schedule.GarbageType;
import io.reactivex.Observable;

/**
 * Created by garu on 08/09/17.
 */

public interface MainModel {
    Observable<GarbageType[]> getGarbageSchedule(long epoch);

    void updateSchedule();
}
