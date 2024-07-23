package com.example.kmp_example

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.kmp_example.presentation.navigation.KMPExampleAppNavigation
import com.example.kmp_example.ui.theme.MyApplicationTheme
import org.koin.core.context.startKoin

@Composable
fun KMPExampleAppContainer() {
    MyApplicationTheme {
        val navController = rememberNavController()
        Scaffold { innerPadding ->
            KMPExampleAppNavigation(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}