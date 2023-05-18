package com.cruz.republicservices.ui.drivers

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.cruz.republicservices.domain.model.Driver
import com.cruz.republicservices.ui.previewprovider.DriverPreviewProvider
import com.cruz.republicservices.ui.theme.RepublicServicesTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun DriverListItem(driver: Driver, onDriverClick: (Int) -> Unit) {
    Card(
        onClick = {
            onDriverClick(driver.id)
        }
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Icon(
                painter = rememberVectorPainter(image = Icons.Default.Person),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = driver.name, style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DriverListItem_Preview(@PreviewParameter(DriverPreviewProvider::class) driver: Driver) {
    RepublicServicesTheme {
        Surface {
            DriverListItem(driver = driver, onDriverClick = {})
        }
    }
}
