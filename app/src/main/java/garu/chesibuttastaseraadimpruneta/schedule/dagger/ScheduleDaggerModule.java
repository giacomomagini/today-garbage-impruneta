package garu.chesibuttastaseraadimpruneta.schedule.dagger;

import dagger.Module;
import dagger.Provides;
import garu.chesibuttastaseraadimpruneta.schedule.providers.DefaultGarbageSchedulerProvider;
import garu.chesibuttastaseraadimpruneta.schedule.providers.GarbageScheduleProvider;

/**
 * Created by garu on 08/09/17.
 */

@Module
public class ScheduleDaggerModule {

    @Provides
    public GarbageScheduleProvider scheduleProvider() {
         return DefaultGarbageSchedulerProvider.create();
    }

}
