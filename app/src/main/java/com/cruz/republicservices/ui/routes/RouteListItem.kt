package com.cruz.republicservices.ui.routes

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.cruz.republicservices.domain.model.Route
import com.cruz.republicservices.ui.previewprovider.RoutePreviewProvider
import com.cruz.republicservices.ui.theme.RepublicServicesTheme

@Composable
internal fun RouteListItem(route: Route) {
    Card {
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Text(text = route.type, style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = route.name, style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DriverListItem_Preview(@PreviewParameter(RoutePreviewProvider::class) route: Route) {
    RepublicServicesTheme {
        Surface {
            RouteListItem(route = route)
        }
    }
}
