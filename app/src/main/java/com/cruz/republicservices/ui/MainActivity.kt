package com.cruz.republicservices.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.cruz.republicservices.ui.navigation.DriverNavGraph
import com.cruz.republicservices.ui.theme.RepublicServicesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RepublicServicesTheme {
                val navController = rememberNavController()

                RepublicServicesTheme {
                    DriverNavGraph(navController = navController)
                }
            }
        }
    }
}
