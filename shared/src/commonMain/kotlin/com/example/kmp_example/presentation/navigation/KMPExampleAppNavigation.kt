package com.example.kmp_example.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kmp_example.presentation.viewmodels.HomeViewModel
import com.example.kmp_example.ui.screens.HomeScreen
import com.example.kmp_example.ui.screens.SecondScreen
import org.koin.compose.koinInject

@Composable
fun KMPExampleAppNavigation(
    navController: NavHostController,
    modifier: Modifier
) {
    val homeViewModel: HomeViewModel = koinInject()

    NavHost(
        navController = navController,
        startDestination = HomeScreen.route,
        modifier = modifier,
    ) {
        composable(route = HomeScreen.route){
            HomeScreen(
                navigateToSecondScreen = {
                    navController.navigate(SecondScreen.route)
                }
            )
        }

        composable(route = SecondScreen.route) {
            SecondScreen(
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}