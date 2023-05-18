package com.cruz.republicservices.ui.routes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cruz.republicservices.domain.model.Route
import com.cruz.republicservices.ui.previewprovider.RoutePreviewProvider
import com.cruz.republicservices.ui.theme.RepublicServicesTheme

@Composable
internal fun RoutesScreen(
    viewModel: RouteViewModel = hiltViewModel()
) {
    val viewState = viewModel.viewState.collectAsState()
    Surface {
        RoutesScreenContent(routes = viewState.value.routes)
    }
}

@Composable
private fun RoutesScreenContent(routes: List<Route>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = routes, key = { route -> route.id }) { route ->
            RouteListItem(route = route)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DriversScreenContent(
    @PreviewParameter(RoutePreviewProvider::class) route: Route
) {
    val routeList = (0..10).mapIndexed { index, _ -> route.copy(id = index) }
    RepublicServicesTheme {
        Surface {
            RoutesScreenContent(routes = routeList)
        }
    }
}
