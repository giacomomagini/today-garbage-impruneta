package garu.chesibuttastaseraadimpruneta.schedule;

import java.util.Map;

/**
 * Created by garu on 08/09/17.
 */

public class GarbageSchedule {

    private Map<Integer, GarbageType[]> defaults;

    private Map<String, GarbageType[]> additional;

    public GarbageSchedule(Map<Integer, GarbageType[]> defaults, Map<String, GarbageType[]> additional) {
        this.defaults = defaults;
        this.additional = additional;
    }

    public Map<String, GarbageType[]> getAdditional() {
        return additional;
    }

    public Map<Integer, GarbageType[]> getDefaults() {
        return defaults;
    }

}
