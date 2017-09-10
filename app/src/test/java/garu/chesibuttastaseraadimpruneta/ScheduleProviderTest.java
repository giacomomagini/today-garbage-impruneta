package garu.chesibuttastaseraadimpruneta;

import org.junit.Test;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import garu.chesibuttastaseraadimpruneta.schedule.GarbageSchedule;
import garu.chesibuttastaseraadimpruneta.schedule.GarbageType;
import garu.chesibuttastaseraadimpruneta.schedule.providers.DefaultGarbageSchedulerProvider;

import static org.junit.Assert.assertEquals;

/**
 * Created by garu on 09/09/17.
 */

public class ScheduleProviderTest {

    @Test
    public void testScheduleProvider() {
        DefaultGarbageSchedulerProvider provider = DefaultGarbageSchedulerProvider.create();

        long epoch = System.currentTimeMillis();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(epoch);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        Map<Integer, GarbageType[]> defaultSchedule = new HashMap<>();

        defaultSchedule.put(dayOfWeek, new GarbageType[]{GarbageType.ORGANIC});

        GarbageSchedule schedule = new GarbageSchedule(defaultSchedule, Collections.emptyMap());

        GarbageType[] garbageType = provider.getGarbageTypes(epoch, schedule);

        assertEquals(garbageType, new GarbageType[]{GarbageType.ORGANIC});
    }

    @Test
    public void testScheduleProviderAdditional() {
        DefaultGarbageSchedulerProvider provider = DefaultGarbageSchedulerProvider.create();

        long epoch = System.currentTimeMillis();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(epoch);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        Map<Integer, GarbageType[]> defaultSchedule = new HashMap<>();

        defaultSchedule.put(dayOfWeek, new GarbageType[]{GarbageType.ORGANIC});

        Map<String, GarbageType[]> additional = new HashMap<>();

        additional.put(
                calendar.get(Calendar.DAY_OF_MONTH) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.YEAR),
                new GarbageType[]{GarbageType.NONE});

        GarbageSchedule schedule = new GarbageSchedule(defaultSchedule, additional);

        GarbageType[] garbageType = provider.getGarbageTypes(epoch, schedule);

        assertEquals(garbageType, new GarbageType[]{GarbageType.NONE});
    }


}
