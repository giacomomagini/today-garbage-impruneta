package garu.chesibuttastaseraadimpruneta.schedule.providers;

import garu.chesibuttastaseraadimpruneta.schedule.GarbageSchedule;
import garu.chesibuttastaseraadimpruneta.schedule.GarbageType;

/**
 * Created by garu on 08/09/17.
 */

public interface GarbageScheduleProvider {
    GarbageType[] getGarbageTypes(long epoch, GarbageSchedule schedule);
}
