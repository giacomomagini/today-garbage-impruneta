package garu.chesibuttastaseraadimpruneta.schedule.providers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import garu.chesibuttastaseraadimpruneta.schedule.GarbageSchedule;
import garu.chesibuttastaseraadimpruneta.schedule.GarbageType;

/**
 * Created by garu on 09/09/17.
 */

public class RandomGarbageSchedulerProvider implements GarbageScheduleProvider {

    public static RandomGarbageSchedulerProvider create() {
        return new RandomGarbageSchedulerProvider();
    }

    private final Random random;

    private RandomGarbageSchedulerProvider() {
        this.random = new Random();
    }

    @Override
    public GarbageType[] getGarbageTypes(long epoch, GarbageSchedule schedule) {
        List<GarbageType> types = new ArrayList<>();

        for (int i=0;i<random.nextInt(3); i++)
            types.add(randomType());

        return types.toArray(new GarbageType[types.size()]);
    }

    private GarbageType randomType() {
        return GarbageType.values()[random.nextInt(GarbageType.values().length)];
    }

}
