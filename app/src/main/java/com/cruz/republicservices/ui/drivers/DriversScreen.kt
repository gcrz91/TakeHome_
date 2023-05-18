package com.cruz.republicservices.ui.drivers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cruz.republicservices.R
import com.cruz.republicservices.domain.model.Driver
import com.cruz.republicservices.ui.previewprovider.DriverPreviewProvider
import com.cruz.republicservices.ui.theme.RepublicServicesTheme

@Composable
internal fun DriversScreen(
    viewModel: DriverViewModel = hiltViewModel(),
    onDriverClick: (Int) -> Unit
) {
    val viewState = viewModel.viewState.collectAsState()
    Surface {
        DriversScreenContent(
            drivers = viewState.value.drivers,
            onDriverClick = onDriverClick,
            onSortDriversClick = viewModel::sortByLastName
        )
    }
}

@Composable
private fun DriversScreenContent(
    drivers: List<Driver>,
    onDriverClick: (Int) -> Unit,
    onSortDriversClick: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Button(onClick = onSortDriversClick) {
                    Text(text = stringResource(id = R.string.sort_drivers))
                }
            }
        }
        items(items = drivers, key = { driver -> driver.id }) { driver ->
            DriverListItem(driver = driver, onDriverClick = onDriverClick)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DriverScreenContent_Preview(
    @PreviewParameter(DriverPreviewProvider::class) driver: Driver
) {
    val driverList = (0..10).mapIndexed { index, _ -> driver.copy(id = index) }
    RepublicServicesTheme {
        Surface {
            DriversScreenContent(drivers = driverList, onDriverClick = {}, onSortDriversClick = {})
        }
    }
}
