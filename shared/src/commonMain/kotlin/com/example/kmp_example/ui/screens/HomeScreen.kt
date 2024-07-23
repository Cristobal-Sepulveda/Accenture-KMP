package com.example.kmp_example.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.kmp_example.presentation.viewmodels.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val NEXT = "Siguiente"
private const val TWO_THOUSAND_LONG = 2000L

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    navigateToSecondScreen: () -> Unit
) {
    val isButtonEnabled = remember { mutableStateOf(true) }

    DisposableEffect(Unit) {
        onDispose { homeViewModel.resetState() }
    }
    val textInScreen = homeViewModel.textInScreen.collectAsState()

    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Text(text = textInScreen.value)
            if(isButtonEnabled.value){
                Button(
                    onClick = {
                        initNavigation(
                            scope = scope,
                            isButtonEnabled = isButtonEnabled,
                            homeViewModel = homeViewModel,
                            navigateToSecondScreen = navigateToSecondScreen
                        )
                    },
                    content = { Text(NEXT) },
                    modifier = Modifier
                )
            }
        }
    }
}

private fun initNavigation(
    scope: CoroutineScope,
    isButtonEnabled: MutableState<Boolean>,
    homeViewModel: HomeViewModel,
    navigateToSecondScreen: () -> Unit
) {
    scope.launch {
        isButtonEnabled.value = false
        homeViewModel.showMessage()
        delay(TWO_THOUSAND_LONG)
        navigateToSecondScreen()
    }
}