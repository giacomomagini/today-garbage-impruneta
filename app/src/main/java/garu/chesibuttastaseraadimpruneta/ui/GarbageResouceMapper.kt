package garu.chesibuttastaseraadimpruneta.ui

import garu.chesibuttastaseraadimpruneta.R
import garu.chesibuttastaseraadimpruneta.schedule.GarbageType

/**
 * Created by garu on 10/09/17.
 */

 object GarbageResouceMapper {

    val map = hashMapOf(
            GarbageType.NONE to GarbageTypeRes(textRes = R.string.garbage_none, iconRes = R.drawable.ic_garbage_truck),
            GarbageType.MIXED to GarbageTypeRes(textRes = R.string.garbage_mixed, iconRes = R.drawable.ic_garbage_mixed), // TODO Add
            GarbageType.PLASTIC_GLASS to GarbageTypeRes(textRes = R.string.garbage_plastic, iconRes = R.drawable.ic_garbage_plastic),
            GarbageType.ORGANIC to GarbageTypeRes(textRes = R.string.garbage_organic, iconRes = R.drawable.ic_garbage_organic),
            GarbageType.PAPER to GarbageTypeRes(textRes = R.string.garbage_paper, iconRes = R.drawable.ic_garbage_paper)

    )

    fun get(garbageType: GarbageType): GarbageTypeRes {
        return map[garbageType] as GarbageTypeRes
    }

}
