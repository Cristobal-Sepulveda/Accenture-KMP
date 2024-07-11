package com.example.kmp_example.presentation.navigation

interface DeviceFeaturesAppDestination {
    val route: String
}

object HomeScreen : DeviceFeaturesAppDestination {
    override val route = "home"
}

object SecondScreen : DeviceFeaturesAppDestination {
    override val route = "second_screen"
}