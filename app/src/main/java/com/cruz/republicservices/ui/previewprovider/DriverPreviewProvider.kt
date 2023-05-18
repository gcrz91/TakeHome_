package com.cruz.republicservices.ui.previewprovider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.cruz.republicservices.domain.model.Driver

class DriverPreviewProvider : PreviewParameterProvider<Driver> {
    override val values: Sequence<Driver>
        get() = sequenceOf(Driver(1, "Jenny Lowe"))
}
