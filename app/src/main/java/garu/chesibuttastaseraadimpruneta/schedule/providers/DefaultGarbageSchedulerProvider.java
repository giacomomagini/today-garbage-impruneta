package garu.chesibuttastaseraadimpruneta.schedule.providers;

import java.util.Calendar;
import java.util.Locale;

import garu.chesibuttastaseraadimpruneta.schedule.GarbageSchedule;
import garu.chesibuttastaseraadimpruneta.schedule.GarbageType;

/**
 * Created by garu on 09/09/17.
 */

public class DefaultGarbageSchedulerProvider implements GarbageScheduleProvider {

    public static DefaultGarbageSchedulerProvider create() {
        return new DefaultGarbageSchedulerProvider();
    }

    private DefaultGarbageSchedulerProvider() {
    }

    @Override
    public GarbageType[] getGarbageTypes(long epoch, GarbageSchedule schedule) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(epoch);

        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        final String additionalKey = String.format(Locale.getDefault(), "%d-%d-%d", dayOfMonth, month, year);

        return (schedule.getAdditional().containsKey(additionalKey) ?
                schedule.getAdditional().get(additionalKey) :
                schedule.getDefaults().get(dayOfWeek)
        );
    }

}
