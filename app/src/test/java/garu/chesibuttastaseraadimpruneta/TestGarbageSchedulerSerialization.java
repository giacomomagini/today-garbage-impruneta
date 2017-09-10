package garu.chesibuttastaseraadimpruneta;

import com.google.gson.Gson;

import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import garu.chesibuttastaseraadimpruneta.schedule.GarbageSchedule;
import garu.chesibuttastaseraadimpruneta.schedule.GarbageType;

/**
 * Created by garu on 10/09/17.
 */

public class TestGarbageSchedulerSerialization {

    @Test
    public void testSerialization(){

        Map<Integer, GarbageType[]> schedule = new HashMap<>();
        Map<String, GarbageType[]> additionalSchedule = new HashMap<>();

        schedule.put(Calendar.MONDAY, new GarbageType[]{GarbageType.PLASTIC_GLASS});
        schedule.put(Calendar.TUESDAY, new GarbageType[]{GarbageType.ORGANIC});
        schedule.put(Calendar.WEDNESDAY, new GarbageType[]{GarbageType.PAPER});
        schedule.put(Calendar.THURSDAY, new GarbageType[]{GarbageType.ORGANIC});
        schedule.put(Calendar.FRIDAY, new GarbageType[]{GarbageType.MIXED});
        schedule.put(Calendar.SATURDAY, new GarbageType[]{GarbageType.ORGANIC});
        schedule.put(Calendar.SUNDAY, new GarbageType[]{});


        additionalSchedule.put("1-5-2018", new GarbageType[0]);
        additionalSchedule.put("2-5-2018", new GarbageType[]{GarbageType.ORGANIC, GarbageType.PLASTIC_GLASS});

        additionalSchedule.put("25-12-2017", new GarbageType[0]);
        additionalSchedule.put("26-12-2017", new GarbageType[]{GarbageType.ORGANIC, GarbageType.PLASTIC_GLASS});

        additionalSchedule.put("25-12-2018", new GarbageType[0]);
        additionalSchedule.put("26-12-2018", new GarbageType[]{GarbageType.ORGANIC, GarbageType.PLASTIC_GLASS});

        GarbageSchedule garbageSchedule = new GarbageSchedule(schedule, additionalSchedule);

        String json = new Gson().toJson(garbageSchedule);

        System.out.print(json);


    }
}
