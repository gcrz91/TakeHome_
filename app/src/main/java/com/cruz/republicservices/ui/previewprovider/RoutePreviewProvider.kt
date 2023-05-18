package com.cruz.republicservices.ui.previewprovider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.cruz.republicservices.domain.model.Route

class RoutePreviewProvider : PreviewParameterProvider<Route> {
    override val values: Sequence<Route>
        get() = sequenceOf(Route(1, "I", "South Side Industrial Route"))
}
