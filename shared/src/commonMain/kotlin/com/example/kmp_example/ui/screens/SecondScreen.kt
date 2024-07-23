package com.example.kmp_example.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

private const val SECOND_SCREEN_TITLE = "SecondScreen"
private const val RETURN = "Volver"

@Composable
fun SecondScreen(
    navigateBack: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Text(text = SECOND_SCREEN_TITLE)
            Button(
                onClick = { navigateBack() },
                content = { Text(RETURN) }
            )
        }
    }
}
