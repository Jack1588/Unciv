package com.unciv.ui.cityscreen

import com.unciv.ui.UncivStage
import com.unciv.ui.tilegroups.TileGroupMap
import com.unciv.ui.utils.ZoomableScrollPane

class CityMapHolder : ZoomableScrollPane(20f, 20f) {

    init {
        setupZoomPanListeners()
    }

    private fun setupZoomPanListeners() {

        fun setActHit() {
            val isEnabled = !isZooming() && !isPanning
            (stage as UncivStage).performPointerEnterExitEvents = isEnabled
            val tileGroupMap = actor as TileGroupMap<*>
            tileGroupMap.shouldAct = isEnabled
            tileGroupMap.shouldHit = isEnabled
        }

        onPanStartListener = { setActHit() }
        onPanStopListener = { setActHit() }
        onZoomStartListener = { setActHit() }
        onZoomStopListener = { setActHit() }
    }

}
